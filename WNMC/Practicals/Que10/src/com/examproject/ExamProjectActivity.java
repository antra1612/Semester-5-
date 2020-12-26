package com.examproject;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ExamProjectActivity extends Activity {
	/** Called when the activity is first created. */
	Spinner spinner;
	EditText etFirstName, etLastName, etPhoneNumber, etQualification,
			etExperience;
	DatePicker dpDateOfBirth;
	Button button;
	SQLiteDatabase sqLiteDatabase;
	TextView textView1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		sqLiteDatabase = openOrCreateDatabase("job_registration.db",
				SQLiteDatabase.CREATE_IF_NECESSARY, null);
		final String DELETE_REGISTRATION_TABLE = "DROP TABLE IF EXISTS tbl_registration";
		final String CREATE_REGISTRATION_TABLE = "CREATE TABLE tbl_registration ("
				+ "position TEXT,"
				+ "firstname TEXT,"
				+ "lastname TEXT,"
				+ "dateofbirth TEXT,"
				+ "phone TEXT,"
				+ "qualification TEXT,"
				+ "experience INT)";
		sqLiteDatabase.execSQL(DELETE_REGISTRATION_TABLE);
		sqLiteDatabase.execSQL(CREATE_REGISTRATION_TABLE);

		textView1 = (TextView) findViewById(R.id.textView1);
		etFirstName = (EditText) findViewById(R.id.editText1);
		etLastName = (EditText) findViewById(R.id.editText2);
		etPhoneNumber = (EditText) findViewById(R.id.editText4);
		etQualification = (EditText) findViewById(R.id.editText5);
		etExperience = (EditText) findViewById(R.id.editText7);
		dpDateOfBirth = (DatePicker) findViewById(R.id.datePicker1);
		button = (Button) findViewById(R.id.button1);

		String[] positions = { "Software Developer", "Database Administrator",
				"Business Analyst" };
		spinner = (Spinner) findViewById(R.id.spinner1);
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, positions);
		arrayAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(arrayAdapter);

		button.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				ContentValues values = new ContentValues();
				values.put("position", spinner.getSelectedItem().toString());
				values.put("firstname", etFirstName.getText().toString());
				values.put("lastname", etLastName.getText().toString());
				values.put(
						"dateofbirth",
						dpDateOfBirth.getDayOfMonth() + "-"
								+ dpDateOfBirth.getMonth() + "-"
								+ dpDateOfBirth.getYear());
				values.put("phone", etPhoneNumber.getText().toString());
				values.put("qualification", etQualification.getText()
						.toString());
				values.put("experience", etExperience.getText().toString());
				sqLiteDatabase.insert("tbl_registration", null, values);
				refreshRecords();
			}
		});
	}

	public void refreshRecords() {
		final String GET_REGISTRATION_DETAILS = "SELECT * FROM tbl_registration";
		Cursor cursor = sqLiteDatabase.rawQuery(GET_REGISTRATION_DETAILS, null);
		cursor.moveToFirst();
		String registrationRecordsString = "";
		if (cursor != null) {
			if (cursor.moveToFirst()) {
				do {
					registrationRecordsString += cursor.getString(0) + "\t"
							+ cursor.getString(0) + "\t" + cursor.getString(1)
							+"\t"+cursor.getString(2)+"\t"+cursor.getString(3)
							+"\t"+cursor.getString(4)+"\t"+cursor.getString(5)
							+"\t"+cursor.getInt(6);
				} while (cursor.moveToNext());
			}
		}
		textView1.setText(registrationRecordsString);

	}
}