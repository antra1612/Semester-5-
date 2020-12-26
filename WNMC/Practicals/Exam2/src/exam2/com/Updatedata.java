package exam2.com;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Updatedata extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);
        final Button updatebtn=(Button) findViewById(R.id.upbtn);
        final EditText name=(EditText) findViewById(R.id.name);
        final EditText email=(EditText) findViewById(R.id.mail);
        final SQLiteDatabase db=openOrCreateDatabase("db6.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);
        updatebtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				db.execSQL("update hotel_data set email='"+email.getText().toString()+"' where name='"+name.getText().toString()+"';");
			}
		});
    }
}
