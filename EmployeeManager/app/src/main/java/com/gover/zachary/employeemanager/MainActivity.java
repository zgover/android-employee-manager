// Zachary Gover
// JAV2 - 1609
// MainActivity

package com.gover.zachary.employeemanager;

import android.app.FragmentTransaction;
import android.app.Fragment;
import android.app.ListFragment;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import com.gover.zachary.employeemanager.fragments.*;
import com.gover.zachary.employeemanager.models.Database;
import com.gover.zachary.employeemanager.models.Employee;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements ListViewFragment.ClickListener, SettingsFragment.SettingsListener{

	/**
	 * MARK: Global Properties
	 */

	public Database db;
	public ArrayAdapter adapter;

	/**
	 * MARK: Fragments
	 */

	public ListFragment listViewFrag;

	/**
	 * MARK: Default Methods
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Setup default properties and connections
		listViewFrag = ListViewFragment.newInstance();

		FragmentTransaction fragTrans = getFragmentManager().beginTransaction();
		fragTrans.add(R.id.frameLayout, listViewFrag);
		fragTrans.commit();

		// Setup db
		db = Database.newInstance(this);

		// Setup list adapter
		adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
									  db.getEmployees());
		listViewFrag.setListAdapter(adapter);
	}

	/**
	 * MARK: View Event Listeners
	 */

	public void openSettings(View view) {
		showFrag(SettingsFragment.newInstance());
	}

	public void openEmployeeForm(View view) {
		showFrag(EmployeeFormFragment.newInstance());
	}

	@Override
	public void openEmployeeDetail(int position) {
		// Get the selected employee
		Employee emp = db.getEmployee(position);
		System.out.println(emp);

		showFrag(EmployeeDetailFragment.newInstance());
	}

	@Override
	public void deleteAll() {
		AlertDialog.Builder alert = new AlertDialog.Builder(this);
		alert.setTitle("Are you sure?");
		alert.setMessage("Are you sure you would like to delete all employees?");
		alert.setPositiveButton("Cancel", null);
		alert.setNegativeButton("DELETE", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialogInterface, int i) {
				db.deleteAllEmployees();
				adapter.clear();
				adapter.notifyDataSetChanged();
				getFragmentManager().popBackStack();
			}
		});

		alert.show();
	}

	/**
	 * MARK: Custom Methods
	 */

	public void showFrag(Fragment frag) {
		FragmentTransaction fragTrans = getFragmentManager().beginTransaction();

		// Add the new fragment, hide the list and set the back stack so we may get
		// back to the listview
		fragTrans.add(R.id.frameLayout, frag);
		fragTrans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		fragTrans.hide(listViewFrag);
		fragTrans.addToBackStack(listViewFrag.getClass().getName());

		fragTrans.commit();
	}

	public void submitForm(View view) {
		// Get current values
		String fName = ((EditText) findViewById(R.id.firstName)).getText().toString().trim();
		String lName = ((EditText) findViewById(R.id.lastName)).getText().toString().trim();
		String empNum = ((EditText) findViewById(R.id.employeeNumber)).getText()
						   .toString().trim();
		String empStat = ((EditText) findViewById(R.id.employmentStatus)).getText()
							 .toString().trim();

		// Setup the date by grabbing the year, month, day and converting it to a calender
		// to get the date
		DatePicker picker = (DatePicker) findViewById(R.id.hireDate);
		int hireYear = picker.getYear();
		int hireMonth = picker.getMonth();
		int hireDay = picker.getDayOfMonth();

		Calendar cal = Calendar.getInstance();
		cal.set(hireYear, hireMonth, hireDay);

		Date hireDate = cal.getTime();

		// Make sure all fields are filled in
		if (fName.isEmpty() || lName.isEmpty() || empNum.isEmpty() || empStat.isEmpty() ||
				hireDate == null) {
			Toast.makeText(this, "Please finish the form", Toast.LENGTH_SHORT).show();

			return;
		}

		int empIntNum = Integer.parseInt(empNum);

		// Build out the new employee from the form
		Employee emp = new Employee();
		emp.setFirstName(fName);
		emp.setLastName(lName);
		emp.setEmployeeNumber(empIntNum);
		emp.setEmploymentStatus(empStat);
		emp.setHireDate(hireDate);

		// Add the employee to the db and pop back to the list view
		db.addEmployee(emp);
		adapter.clear();
		adapter.addAll(db.getEmployees());

		adapter.notifyDataSetChanged();

		getFragmentManager().popBackStack();
	}
}
