// Zachary Gover
// JAV2 - 1609
// Employee

package com.gover.zachary.employeemanager.models;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {

	/**
	 * MARK: Global Properties
	 */

	private int id;
	private String firstName;
	private String lastName;
	private int employeeNumber;
	private Date hireDate;
	private String employmentStatus;

	/**
	 * MARK: Class Initializer
	 */

	public Employee(){}

	/**
	 * MARK: Supers
	 */

	@Override
	public String toString() {
		return this.getName();
	}

	/**
	 * MARK: Getter and Setters
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.firstName + " " + this.lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public String getHireDateString(Context context){
		SharedPreferences defaultPrefs = PreferenceManager
											 .getDefaultSharedPreferences(context);
		String displayType = defaultPrefs.getString("DATE_FORMAT", "yyyy-MM-dd");

		// Setup the custom date display
		SimpleDateFormat dateFormat = new SimpleDateFormat(displayType);
		String newDate = dateFormat.format(this.hireDate).toString();

		return newDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getEmploymentStatus() {
		return employmentStatus;
	}

	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}
}
