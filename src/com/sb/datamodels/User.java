package com.sb.datamodels;

public class User {
	private static int userIDCount = 10000;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String emailAddress;
	private int userID;
	
	
	public User(){
		this.userID = ++userIDCount;
	}
	
	public User(String firstName, String lastName, String emailAddress){
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.userID = ++userIDCount;
	}
	
	public User(String firstName, String lastName, String emailAddress, String phoneNumber){
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
		return lastName;
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
		this.lastName = lastName;
	}
	
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	
	public void setEmailAddress(String emailAddress){
		this.emailAddress = emailAddress;
	}

}
