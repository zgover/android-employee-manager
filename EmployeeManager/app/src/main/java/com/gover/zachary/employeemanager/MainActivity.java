// Zachary Gover
// JAV2 - 1609
// MainActivity

package com.gover.zachary.employeemanager;

import android.app.FragmentTransaction;
import android.app.Fragment;
import android.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.gover.zachary.employeemanager.fragments.*;

public class MainActivity extends AppCompatActivity {

	/**
	 * MARK: Global Properties
	 */

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

	/**
	 * MARK: Custom Methods
	 */

	public void showFrag(Fragment frag) {
		FragmentTransaction fragTrans = getFragmentManager().beginTransaction();

		fragTrans.add(R.id.frameLayout, frag);
		fragTrans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		fragTrans.hide(listViewFrag);
		fragTrans.addToBackStack(listViewFrag.getClass().getName());

		fragTrans.commit();
	}

}
