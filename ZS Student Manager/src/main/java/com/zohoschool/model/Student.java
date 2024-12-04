package com.zohoschool.model;

public class Student {
	
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String gender;
	private String mobileNumber;
	private String emailId;
	private String department;
	private String yearOfPassout;
	private String location;
	
	public Student(String firstName, String lastName, String dateOfBirth, String gender, String mobileNumber,
			String emailId, String department, String yearOfPassout, String location) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.department = department;
		this.yearOfPassout = yearOfPassout;
		this.location = location;
	}
	
	
	public Student() {
		
	}


	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getYearOfPassout() {
		return yearOfPassout;
	}
	public void setYearOfPassout(String yearOfPassout) {
		this.yearOfPassout = yearOfPassout;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return firstName+" "+lastName;
	}
}
