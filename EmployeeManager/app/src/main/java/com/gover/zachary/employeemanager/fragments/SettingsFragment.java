// Zachary Gover
// JAV2 - 1609
// EmployeeDetailFragment

package com.gover.zachary.employeemanager.fragments;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import com.gover.zachary.employeemanager.R;

public class SettingsFragment extends PreferenceFragment {

	/**
	 * MARK: Class Initializer
	 */

	public SettingsFragment(){}

	public static SettingsFragment newInstance() {
		SettingsFragment fragment = new SettingsFragment();
		return fragment;
	}

	/**
	 * MARK: Default Methods
	 */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Load preferences
		this.addPreferencesFromResource(R.xml.settings);
	}

	@Override
	public void onActivityCreated(Bundle _savedInstanceState) {
		super.onActivityCreated(_savedInstanceState);

		// Set the click listener for the delete btn
		Preference pref = findPreference("DELETE_ALL");

		pref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
			@Override
			public boolean onPreferenceClick(Preference _pref) {
				// Do what you want
				return true;
			}
		});
	}
}
