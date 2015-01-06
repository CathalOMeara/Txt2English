package com.text.speak.translator;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE="com.text.speak.translator";
	private EditText smsSource;//sms app
	
	public void sendSMS(View view){
		
		String smsMessage = smsSource.getText().toString();
		Intent smsIntent = new Intent(Intent.ACTION_VIEW);
		smsIntent.setData(Uri.parse("sms:"));
		smsIntent.putExtra("sms_body", smsMessage);
		startActivity(smsIntent);
		
		
	}
	  
	public void sendToText(View view){

		// edit text object that takes the user input
		EditText englishSource = (EditText) findViewById(R.id.edit_message_input);
		String message = Message.engToText(englishSource.getText().toString());
		//sends translated output to 2nd edit text view
		EditText textOutput = (EditText) findViewById(R.id.editText1);
		textOutput.setText(message);
	}

	public void sendToEnglish(View view){

		// edit text object that takes the user input
		EditText textSource = (EditText) findViewById(R.id.edit_message_input);
		String message = Message.textToEng(textSource.getText().toString());
		//sends translated output to 2nd edit text view
		EditText textOutput = (EditText) findViewById(R.id.editText1);
		textOutput.setText(message);
	}
	
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        smsSource =(EditText) findViewById(R.id.editText1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
