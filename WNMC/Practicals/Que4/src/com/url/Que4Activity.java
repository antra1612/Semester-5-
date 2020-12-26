package com.url;

import com.url.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class Que4Activity extends Activity {
    /** Called when the activity is first created. */
	EditText editText;
    Button button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
            editText = (EditText) findViewById(R.id.editText1);
            button = (Button) findViewById(R.id.button1);
            button.setOnClickListener(new View.OnClickListener() {
    			
    			public void onClick(View v) {
    				String urlString = editText.getText().toString();
    				WebView webView = new WebView(getApplicationContext());
    				webView.loadUrl(urlString);
    				LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout1);
    				linearLayout.addView(webView);
    			}
    		});
        }
}