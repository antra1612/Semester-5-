package com.que6;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class ExamActivity extends Activity {
	/** Called when the activity is first created. */
	TextView result;
	Button add;
	Button dlt;
	Button modify;
	EditText sname;
	EditText std;
	CheckBox gujrati, hindi, english, marathi;
	RadioButton male, female;

	SQLiteDatabase mDatabase;
	String Language, Gender;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Language = "";
		Gender = "";

		gujrati = (CheckBox) findViewById(R.id.chkGujarati);
		hindi = (CheckBox) findViewById(R.id.chkHindi);
		english = (CheckBox) findViewById(R.id.chkenglish);
		marathi = (CheckBox) findViewById(R.id.chkMarathi);
		male = (RadioButton) findViewById(R.id.rdmale);
		female = (RadioButton) findViewById(R.id.rdfemale);

		final SQLiteDatabase mDatabase;
		mDatabase = openOrCreateDatabase("set4.db",
				SQLiteDatabase.CREATE_IF_NECESSARY, null);
		mDatabase
				.execSQL("create table if not exists student(Sname text,Std text,language text,gender text);");

		add = (Button) findViewById(R.id.btnInsert);
		dlt = (Button) findViewById(R.id.btndlt);
		modify = (Button) findViewById(R.id.btnUpdate);
		result = (TextView) findViewById(R.id.tvdisplay);
		sname = (EditText) findViewById(R.id.edname);
		std = (EditText) findViewById(R.id.edstd);
		
		gujrati.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (gujrati.isChecked() == true) {
					Language += gujrati.getText().toString() + " ";

				}
			}
		});
		hindi.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (hindi.isChecked() == true) {
					Language += hindi.getText().toString() + " ";
				}
			}
		});
		english.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (english.isChecked() == true) {
					Language += english.getText().toString() + " ";
				}
			}
		});
		marathi.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (marathi.isChecked() == true) {
					Language += marathi.getText().toString() + " ";
				}
			}
		});
		male.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (male.isChecked() == true) {
					Gender = male.getText().toString();
				}
			}
		});
		female.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (female.isChecked() == true) {
					Gender = female.getText().toString();
				}
			}
		});

		add.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub

				ContentValues values = new ContentValues();
				values.put("Sname", sname.getText().toString());
				values.put("Std", std.getText().toString());
				values.put("language", Language);
				values.put("gender", Gender);
				result.setText(sname.getText().toString() + " "
						+ std.getText().toString() + " " + Language + " "
						+ Gender);
				mDatabase.insert("student", null, values);

				Language = "";
				Gender = "";
				gujrati.setChecked(false);
				hindi.setChecked(false);
				english.setChecked(false);
				marathi.setChecked(false);
				male.setChecked(false);
				female.setChecked(false);
				sname.setText("");
				std.setText("");
				
				final String get_details = "SELECT * FROM student"; 
				Cursor cursor =mDatabase.rawQuery(get_details, null); cursor.moveToFirst();
				
				String student_data=""; 
				if (cursor != null) { 
					if(cursor.moveToFirst()) { 
						do { 
							student_data += cursor.getString(0)+"\t"
											 +cursor.getString(1)+"\t"
											 +cursor.getString(2)+"\t"+
											 cursor.getString(3)+"\n";
						} while (cursor.moveToNext()); } 
					}
					result.setText(student_data);
					
				} 
		});
	}
}