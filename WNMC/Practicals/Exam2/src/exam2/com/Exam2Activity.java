package exam2.com;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Exam2Activity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final EditText name=(EditText)findViewById(R.id.hotelname);
        final EditText address=(EditText)findViewById(R.id.hoteladdress);
        final EditText no=(EditText)findViewById(R.id.hotelcontactno);
        final EditText email=(EditText)findViewById(R.id.hotelemail);
        final EditText totaltooms=(EditText)findViewById(R.id.hotelrooms);
        final Button add=(Button) findViewById(R.id.hotelsignup);
        final Button update=(Button) findViewById(R.id.updatebtn);
        final Button delete=(Button) findViewById(R.id.deletebtn);
        final SQLiteDatabase db=openOrCreateDatabase("db6.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);
        db.execSQL("create table hotel_data(name Text, address Text, no Text, email Text, room Text);");
        add.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				String hname=name.getText().toString();
				String haddress=address.getText().toString();
				String hno=no.getText().toString();
				String hemail=email.getText().toString();
				String hroom=totaltooms.getText().toString();
				db.execSQL("insert into hotel_data(name,address,no,email,room) values('"+hname+"','"+haddress+"','"+hno+"','"+hemail+"','"+hroom+"');");
			}
		});
        delete.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				db.execSQL("Delete from hotel_data where name='"+name.getText().toString()+"';");
			}
		});
        update.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent i=new Intent(getApplicationContext(),Updatedata.class);
				startActivity(i);
			}
		});
    }
}