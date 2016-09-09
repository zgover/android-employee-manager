// Zachary Gover
// JAV2 - 1609
// EmployeeFormFragment

package com.gover.zachary.employeemanager.fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.gover.zachary.employeemanager.R;

public class EmployeeFormFragment extends Fragment {

	/**
	 * MARK: Class Initializer
	 */

	public EmployeeFormFragment(){}

	public static EmployeeFormFragment newInstance() {
		EmployeeFormFragment fragment = new EmployeeFormFragment();
		return fragment;
	}

	/**
	 * MARK: Default Methods
	 */

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the view
		View view = inflater.inflate(R.layout.employee_form_fragment, container, false);
		return view;
	}


	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}
}
