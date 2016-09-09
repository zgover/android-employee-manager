// Zachary Gover
// JAV2 - 1609
// ListViewFragment

package com.gover.zachary.employeemanager.fragments;

import android.os.Bundle;
import android.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.gover.zachary.employeemanager.R;

import java.util.ArrayList;

public class ListViewFragment extends ListFragment {

	public static final String TAG = "ListViewFragment.TAG";

	/**
	 * MARK: Class Initializer
	 */

	public ListViewFragment(){}

	public static ListViewFragment newInstance() {
		ListViewFragment fragment = new ListViewFragment();
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the view
		View view = inflater.inflate(R.layout.list_view_fragment, container, false);
		return view;
	}

	/**
	 * MARK: Default Methods
	 */

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		// Setup the adapter
		Bundle args = getArguments();

		if (args != null && args.containsKey("list_data")) {
			ArrayList<String> list = getArguments().getStringArrayList("list_data");
			ArrayAdapter adapter = new ArrayAdapter(getActivity(),
													   android.R.layout.simple_list_item_1,
													   list);

			this.setListAdapter(adapter);
		}
	}

	/**
	 * MARK: Click Listener
	 */

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
	}
}
