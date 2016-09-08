// Zachary Gover
// JAV2 - 1609
// Employee

package com.gover.zachary.employeemanager.models;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {

	/**
	 * MARK: Global Properties
	 */

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
	 * MARK: Getter and Setters
	 */

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
