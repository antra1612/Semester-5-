package com.que9;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ConferenceRegistrationActivity extends Activity {
    /** Called when the activity is first created. */
    
	Button button1, button2, button3;
	EditText editText1, editText2, editText3, editText4;
	SQLiteDatabase mDatabase;
	TextView textView1;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        editText1 = (EditText) findViewById(R.id.editText1);
		editText2 = (EditText) findViewById(R.id.editText2);
		editText3 = (EditText) findViewById(R.id.editText3);
		editText4 = (EditText) findViewById(R.id.editText4);
		
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button3 = (Button) findViewById(R.id.button3);
		textView1 = (TextView) findViewById(R.id.textView1);
		
		mDatabase = openOrCreateDatabase("CoferenceDB.db",SQLiteDatabase.CREATE_IF_NECESSARY,null);
		
		final String DeleteRegTable = "DROP TABLE IF EXISTS regTable";
		final String CreateRegTable = "CREATE TABLE regTable ("
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT," + "name TEXT,"
				+ "email TEXT,"+"mobile NUMBER)";
		
		mDatabase.execSQL(DeleteRegTable);
		mDatabase.execSQL(CreateRegTable);
		
		//Insert Button
		button1.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				ContentValues values = new ContentValues();
				String num = editText1.getText().toString();
				int id = Integer.parseInt(num);
				values.put("id", id);
				
				values.put("name", editText2.getText().toString());
				
				values.put("email", editText3.getText().toString());
				
				String contact = editText4.getText().toString();
				long mobile = Long.parseLong(contact);
				values.put("mobile", mobile);
				
				mDatabase.insert("regTable", null, values);
				refreshRecords();
				
			}
		});
		
		//Update Button
		button2.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				ContentValues values = new ContentValues();
				String num = editText1.getText().toString();
				int id = Integer.parseInt(num);
				values.put("id", id);
				
				values.put("name", editText2.getText().toString());
				
				values.put("email", editText3.getText().toString());
				
				String contact = editText4.getText().toString();
				long mobile = Long.parseLong(contact);
				values.put("mobile", mobile);
				
				mDatabase.update("regTable", values, "id = ?", new String[] {num});
				refreshRecords();				
			}
		});
		
		//Delete Button
		button3.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				String num = editText1.getText().toString();
				mDatabase.delete("regTable", "id = ?", new String[] {num});
				refreshRecords();
			}
		});
		
    }
	public void refreshRecords(){
		final String getRecords = "SELECT * FROM regTable ";
		Cursor c = mDatabase.rawQuery(getRecords, null);
		c.moveToFirst();
		Toast.makeText(getApplicationContext(), "Hola", Toast.LENGTH_LONG).show();
		String rowResults = "";
		while(!c.isAfterLast()){
			rowResults = rowResults.concat(c.getInt(0) + "||"+ c.getString(1)+"||"+c.getString(2)+"||"+c.getLong(3)+"\n");
			Toast.makeText(getApplicationContext(), rowResults, Toast.LENGTH_LONG).show();
			c.moveToNext();
		}
		textView1.setText(rowResults);
	}
}