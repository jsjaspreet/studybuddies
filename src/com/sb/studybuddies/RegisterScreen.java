package com.sb.studybuddies;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.Parse;
import com.parse.ParseObject;
import com.sb.datamodels.Account;
 
public class RegisterScreen extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ParseObject.registerSubclass(Account.class);
        Parse.initialize(this, "e0Gw6N6WofJjHBY6OWADObIHkI7LPr7dsVVDuEqu", "F7k07avyfqMf9nARMpWke0sneZfSEgvge7SLBulB");
        
        // Set View to register.xml
        setContentView(R.layout.register);
 
        TextView loginScreen = (TextView) findViewById(R.id.link_to_login);
      
        // Listening to Register New Account button
        final Button button = (Button) findViewById(R.id.btnRegister);
        button.setOnClickListener(new View.OnClickListener() {
        	@Override
			public void onClick(View v) {
            	Account newAccount = new Account();
            	EditText input_username = (EditText)findViewById(R.id.reg_fullname);
            	EditText input_password = (EditText)findViewById(R.id.reg_password);
            	EditText input_email = (EditText)findViewById(R.id.reg_email);
            	
            	newAccount.put("username", input_username.getText().toString());
            	newAccount.put("password", input_password.getText().toString());
            	newAccount.put("email", input_email.getText().toString());
            	newAccount.saveInBackground();
			}
        });
        
        // Listening to Login Screen link
        loginScreen.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View arg0) {
                // Closing registration screen
                // Switching to Login Screen/closing register screen
                finish();
            }
        });
    }
}