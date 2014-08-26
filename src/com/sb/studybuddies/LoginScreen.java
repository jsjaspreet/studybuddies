package com.sb.studybuddies;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
 
public class LoginScreen extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setting default screen to login.xml
        setContentView(R.layout.login);
 
        TextView registerScreen = (TextView) findViewById(R.id.link_to_register);
        
        // Listening to Register New Account button
        final Button button = (Button) findViewById(R.id.btnLogin);
        button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// Go to Main Page after successful login
				Intent i = new Intent(LoginScreen.this, MainActivity.class);
                startActivity(i);
 
                // close this activity
                finish();
			}
        	
        });
 
        // Listening to register new account link
        registerScreen.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View v) {
                // Switching to Register screen
                Intent i = new Intent(getApplicationContext(), RegisterScreen.class);
                startActivity(i);
            }
        });
    }
}