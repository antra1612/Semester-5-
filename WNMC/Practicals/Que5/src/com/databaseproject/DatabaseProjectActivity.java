package com.databaseproject;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DatabaseProjectActivity extends Activity {
	/** Called when the activity is first created. */
	Button button1, button2, button3;
	EditText editText1, editText2;
	SQLiteDatabase mDatabase;
	TextView textView1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		editText1 = (EditText) findViewById(R.id.editText1);
		editText2 = (EditText) findViewById(R.id.editText2);
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button3 = (Button) findViewById(R.id.button3);
		textView1 = (TextView) findViewById(R.id.textView1);

		mDatabase = openOrCreateDatabase("library.db",
				SQLiteDatabase.CREATE_IF_NECESSARY, null);
		final String DELETE_AUTHOR_TABLE = "DROP TABLE IF EXISTS tbl_authors";
		final String CREATE_AUTHOR_TABLE = "CREATE TABLE tbl_authors ("
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT," + "firstname TEXT,"
				+ "lastname TEXT)";
		mDatabase.execSQL(DELETE_AUTHOR_TABLE);
		mDatabase.execSQL(CREATE_AUTHOR_TABLE);

		button1.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				ContentValues values = new ContentValues();
				values.put("firstname", editText1.getText().toString());
				values.put("lastname", editText2.getText().toString());
				mDatabase.insert("tbl_authors", null, values);
				refreshRecords();
			}
		});

		button2.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				ContentValues contentValues = new ContentValues();
				contentValues.put("lastname", editText2.getText().toString());
				mDatabase.update("tbl_authors", contentValues, "firstName=?",
						new String[] { editText1.getText().toString() });
				refreshRecords();
			}
		});

		button3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				mDatabase.delete("tbl_authors", "firstname=?",
						new String[] { editText1.getText().toString() });
				refreshRecords();
			}
		});
	}

	public void refreshRecords() {
		final String GET_AUTHOR_DETAILS = "SELECT firstname,lastname FROM tbl_authors";
		Cursor cursor = mDatabase.rawQuery(GET_AUTHOR_DETAILS, null);
		String authorRecordsString="";
		if (cursor != null) {
			if (cursor.moveToFirst()) {
				do {
					authorRecordsString += cursor.getString(0)+"\t"+cursor.getString(1)+"\n";
				} while (cursor.moveToNext());
			}
		}
		textView1.setText(authorRecordsString);
		
	}
}