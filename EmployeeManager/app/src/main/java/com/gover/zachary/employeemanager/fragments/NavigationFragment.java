// Zachary Gover
// JAV2 - 1609
// NavigationFragment

package com.gover.zachary.employeemanager.fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.gover.zachary.employeemanager.R;

public class NavigationFragment extends Fragment {

	/**
	 * MARK: Class Initializer
	 */

	public NavigationFragment(){}

	public static NavigationFragment newInstance() {
		NavigationFragment fragment = new NavigationFragment();
		return fragment;
	}

	/**
	 * MARK: Default Methods
	 */

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the view
		View view = inflater.inflate(R.layout.navigation_fragment, container, false);
		return view;
	}


	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

}
