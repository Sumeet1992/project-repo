package com.sumeet.studentController;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

// If you want only those properties be included which are not null
@JsonInclude(JsonInclude.Include.NON_NULL)
// If we want some property to not be included in the json response
@JsonIgnoreProperties({"studentSkills"})
// If we want the key value pairs to be displayed i a certain order in the json file response
@JsonPropertyOrder({"studentDOB","student_name","studentHobby","studentMobile","studentSkills","studentAddress"})
public class Student {
	
	@Pattern(regexp="[^0-9]*")
//	if we want the student name field to be displayed differently in the json file response we use below annotation
	@JsonProperty("student_name")
	private String studentName;
	
//	USED FOR BEAN VALIDATIONS. ALSO, @VALID HAS TO BE ADDED IN THE REQUEST HANDLER
//	METHOD PARAMETER FOR THE VALIDATION ANNOTATIONS TO BE ENABLED
//	@IsValidHobby is a custom form validation annotation
	
	@Size(min=2,max=30) @IsValidHobby(listOfValidHobbies = "Music|Football|Cricket|Hockey")
	private String studentHobby;
	
//	if you want the value to be less than or equal to 2222
	@Max(2222)
	private Long studentMobile;
	
//	For the date to not be in the future
	@Past
	private Date studentDOB;
	private ArrayList<String> studentSkills;
	private Address studentAddress;
	
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentHobby() {
		return studentHobby;
	}
	public void setStudentHobby(String studentHobby) {
		this.studentHobby = studentHobby;
	}
	public Long getStudentMobile() {
		return studentMobile;
	}
	public void setStudentMobile(Long studentMobile) {
		this.studentMobile = studentMobile;
	}
	public Date getStudentDOB() {
		return studentDOB;
	}
	public void setStudentDOB(Date studentDOB) {
		this.studentDOB = studentDOB;
	}
	public ArrayList<String> getStudentSkills() {
		return studentSkills;
	}
	public void setStudentSkills(ArrayList<String> studentSkills) {
		this.studentSkills = studentSkills;
	}
	public Address getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}
	
	

}