package com.que13;

import com.que13.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class Que13Activity extends Activity {
	DatePicker dpDateOfBirth;
	Button button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        dpDateOfBirth = (DatePicker) findViewById(R.id.datePicker1);
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), dpDateOfBirth.getDayOfMonth() + "-"
						+ (dpDateOfBirth.getMonth()+1) + "-"
						+ dpDateOfBirth.getYear(), Toast.LENGTH_LONG).show();
				
			}
		});
    }
}