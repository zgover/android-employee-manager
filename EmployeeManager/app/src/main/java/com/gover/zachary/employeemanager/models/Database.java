// Zachary Gover
// JAV2 - 1609
// Database

package com.gover.zachary.employeemanager.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Date;

public class Database extends SQLiteOpenHelper {

	/**
	 * MARK: Global Properties
	 */

	private ArrayList<Employee> employees;
	private static Database instance = null;
	private static final String DATABASE_FILE = "database.db";
	private static final int DATABASE_VERSION = 1;
	private static final String TABLE_NAME = "employee";
	private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME + " ";
	private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+
							" (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
							"first_name TEXT, last_name TEXT, emp_num INT, " +
							"emp_status TEXT, hire_date DATETIME)";

	/**
	 * MARK: Class Initializer
	 */

	protected Database(Context context) {
		super(context, DATABASE_FILE, null, DATABASE_VERSION);
	}

	public static Database newInstance(Context context) {
		if (instance != null) {
			return instance;
		}

		return new Database(context);
	}

	/**
	 * MARK: Default Methods
	 */

	@Override
	public void onCreate(SQLiteDatabase sqLiteDatabase) {
		sqLiteDatabase.execSQL(CREATE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
		sqLiteDatabase.execSQL(DROP_TABLE);
		onCreate(sqLiteDatabase);
	}

	/**
	 * MARK: Write Methods
	 */

	public void addEmployee(Employee emp) {
		SQLiteDatabase db = this.getWritableDatabase();

		// Build out the content value from the employee
		ContentValues cv = new ContentValues();
		cv.put("first_name", emp.getFirstName());
		cv.put("last_name", emp.getLastName());
		cv.put("emp_num", emp.getEmployeeNumber());
		cv.put("emp_status", emp.getEmploymentStatus());
		cv.put("hire_date", emp.getHireDate().getTime());

		db.insert(TABLE_NAME, null, cv);
	}

	/**
	 * MARK: Read Methods
	 */

	public ArrayList<Employee> getEmployees() {
		SQLiteDatabase db = this.getReadableDatabase();
		ArrayList<Employee> employees = new ArrayList<>();

		// Build out content values for what we wish to retrieve
		Cursor results = db.query(TABLE_NAME, null, null, null, null, null, "hire_date",
			null);

		if (results.moveToFirst()) {
			do {

				// Create the new employee
				Employee emp = new Employee();
				emp.setId(results.getInt(0));
				emp.setFirstName(results.getString(1));
				emp.setLastName(results.getString(2));
				emp.setEmployeeNumber(results.getInt(3));
				emp.setEmploymentStatus(results.getString(4));
				emp.setHireDate(new Date(results.getLong(5)));

				System.out.println(emp);

				employees.add(emp);

			} while(results.moveToNext());
		}

		// Set global employees for singular fetch
		this.employees = employees;

		return employees;
	}

	public Employee getEmployee(int position) {
		// Fetch all employees and get the item at the position
		if (position > this.employees.size() - 1) { return null; }

		return this.employees.get(position);
	}

	/**
	 * MARK: Delete Methods
	 */

	public void deleteEmployee(int position) {
		SQLiteDatabase db = this.getWritableDatabase();

		String where = "id='?'";
		String[] whereArgs = {Integer.toString(position)};

		db.delete(TABLE_NAME, where, whereArgs);
	}

	public void deleteAllEmployees() {
		SQLiteDatabase db = this.getWritableDatabase();

		db.delete(TABLE_NAME, null, null);
	}
}
