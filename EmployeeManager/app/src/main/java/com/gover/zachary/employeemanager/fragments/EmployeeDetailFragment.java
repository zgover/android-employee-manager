// Zachary Gover
// JAV2 - 1609
// EmployeeDetailFragment

package com.gover.zachary.employeemanager.fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.gover.zachary.employeemanager.R;

import java.util.ArrayList;

public class EmployeeDetailFragment extends Fragment {

	public static final String TAG = "EmployeeDetailFragment";

	/**
	 * MARK: Class Initializer
	 */

	public EmployeeDetailFragment(){}

	public static EmployeeDetailFragment newInstance() {
		EmployeeDetailFragment fragment = new EmployeeDetailFragment();
		return fragment;
	}

	/**
	 * MARK: Default Methods
	 */

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the view
		View view = inflater.inflate(R.layout.employee_detail_fragment, container, false);

		return view;
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		View view = getView();
		Bundle args = getArguments();

		String fname = args.getString("fname");
		String lname = args.getString("lname");
		String empNum = args.getString("emp_num");
		String empStat = args.getString("emp_stat");
		String hireDate = args.getString("hire_date");

		// Setup view
		((TextView) view.findViewById(R.id.firstName)).setText(fname);
		((TextView) view.findViewById(R.id.lastName)).setText(lname);
		((TextView) view.findViewById(R.id.employeeNumber)).setText(empNum);
		((TextView) view.findViewById(R.id.employmentStatus)).setText(empStat);
		((TextView) view.findViewById(R.id.hireDate)).setText(hireDate);
	}
}
