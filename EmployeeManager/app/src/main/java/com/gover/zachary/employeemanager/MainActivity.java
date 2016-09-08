// Zachary Gover
// JAV2 - 1609
// MainActivity

package com.gover.zachary.employeemanager;

import android.app.FragmentTransaction;
import android.preference.PreferenceFragment;
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

	public PreferenceFragment settingsFrag;
	public ListFragment listViewFrag;
	public Fragment navigationFrag;
	public Fragment emplDetailFrag;
	public Fragment emplFormFrag;

	/**
	 * MARK: Default Methods
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Setup default properties and connections
		settingsFrag = SettingsFragment.newInstance();
		listViewFrag = ListViewFragment.newInstance();
		navigationFrag = NavigationFragment.newInstance();
		emplDetailFrag = EmployeeDetailFragment.newInstance();
		emplFormFrag = EmployeeFormFragment.newInstance();
	}

	/**
	 * MARK: View Event Listeners
	 */

	public void openSettings(View view) {
		showFrag(settingsFrag);
	}

	public void openEmployeeForm(View view) {
		showFrag(emplFormFrag);
	}

	/**
	 * MARK: Custom Methods
	 */

	public void showFrag(Fragment frag) {
		FragmentTransaction fragTrans = getFragmentManager().beginTransaction();
		Fragment[] fragments = {
			settingsFrag, listViewFrag, navigationFrag, emplDetailFrag, emplFormFrag
		};

		// Loop through all frags and identify which we should show AND hide
		for(int i = 0; i < fragments.length; i++) {
			Fragment current = fragments[i];

			if (current.equals(frag)) {
				fragTrans.show(current);
			} else {
				fragTrans.hide(current);
			}
		}

		fragTrans.commit();
	}
}
