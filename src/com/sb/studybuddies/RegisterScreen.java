package com.sb.studybuddies;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseQuery;
import com.parse.SaveCallback; 
import com.parse.Parse;
import com.parse.ParseException;
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
            	EditText input_firstname = (EditText)findViewById(R.id.reg_firstname);
            	EditText input_lastname = (EditText)findViewById(R.id.reg_lastname);
            	EditText input_password = (EditText)findViewById(R.id.reg_password);
            	EditText input_email = (EditText)findViewById(R.id.reg_email);
            	String user_firstname = input_firstname.getText().toString();
            	String user_lastname = input_lastname.getText().toString();
            	String user_password = input_password.getText().toString();
            	String user_email = input_email.getText().toString();
            	String fullname = user_firstname + user_lastname;
            	String username = fullname;
            	
            	ParseQuery<ParseObject> query_sameName = ParseQuery.getQuery("Account");
            	query_sameName.whereEqualTo("fullname", fullname);
            	try {
					int count = query_sameName.count();
					if (count != 0) {
						username = username + count;
					}
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            	ParseQuery<ParseObject> query_sameEmail = ParseQuery.getQuery("Account");
            	query_sameEmail.whereEqualTo("email", user_email);
            	try {
					List<ParseObject> exists = query_sameEmail.find();
					if (exists.size() != 0) {
						AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(RegisterScreen.this);

						// set title
						alertDialogBuilder.setTitle("Error");

						// set dialog message
						alertDialogBuilder.setMessage("Sorry, it looks like " + user_email + 
								" belongs to an existing account.\nPlease enter another email address.")
								.setCancelable(false);
						
						// set dismiss button
						alertDialogBuilder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
					           public void onClick(DialogInterface dialog, int id) {
					                dialog.dismiss();
					           }
					     });

						// create alert dialog
						AlertDialog alertDialog = alertDialogBuilder.create();

						// show it
						alertDialog.show();
					}
					else {
						// Registers information into database.
		            	newAccount.put("firstname", user_firstname);
		            	newAccount.put("lastname", user_lastname);
		            	newAccount.put("password", user_password);
		            	newAccount.put("email", user_email);
		            	newAccount.put("username", username);
		            	newAccount.put("fullname", fullname);
		            	
		            	newAccount.saveInBackground(new SaveCallback() {
		            		public void done(ParseException e) {
		            			if (e == null) {
		            				// Registration was successful!
		            				Context context = getApplicationContext();
		            				CharSequence text = "Registration Successful!";
		            				int duration = Toast.LENGTH_LONG;
		            				
		            	            // Send user back to Login Screen.
		            	            Intent i = new Intent(RegisterScreen.this, LoginScreen.class);
		            	            startActivity(i);
		            	            
		            	            // Display notification.
		            				Toast toast = Toast.makeText(context, text, duration);
		            				toast.show();
		            	 
		            	            // Close this activity.
		            	            finish();    	            
		            			} else {
		            				// Sign up didn't succeed. Look at the ParseException
		            				// to figure out what went wrong
		            			}
		            		}
		            	});
					}
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
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