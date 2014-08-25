package com.sb.datamodels;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Account")
public class Account extends ParseObject {
	private static int userIDCount = 10000;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String emailAddress;
	private int userID;
	
	public Account(){
		//this.userID = ++userIDCount;
		super("Account"); 
	}
	
	public Account(String firstName, String lastName, String emailAddress){
		super("Account");
		this.put("firstName", firstName);
		this.put("lastName", lastName);
		this.put("email", emailAddress);
		//this.userID = ++userIDCount;
	}
	
	public Account(String firstName, String lastName, String emailAddress, String phoneNumber){
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.userID = ++userIDCount;
	}
	
	public String getFullName(){
		return firstName + " " + lastName;
	}

	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return this.getString("Last Name");
	}
	
	public String getEmailAddress(){
		return emailAddress;
	}
	
	public String getPhoneNumber(){
		return phoneNumber;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName){
		this.put("Last Name", lastName);
	}
	
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	
	public void setEmailAddress(String emailAddress){
		this.emailAddress = emailAddress;
	}

}
