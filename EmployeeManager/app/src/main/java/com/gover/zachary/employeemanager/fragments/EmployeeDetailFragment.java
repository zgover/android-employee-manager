// Zachary Gover
// JAV2 - 1609
// EmployeeDetailFragment

package com.gover.zachary.employeemanager.fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.gover.zachary.employeemanager.R;

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
	}
}
