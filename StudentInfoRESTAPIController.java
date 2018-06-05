package com.sumeet.studentController;

import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


// this just indicates spring framework that whatever methods we have included inside such a controller class, all such 
// methods are related to REST API
// When we write this annotatn, we don't need to specify ResponseBody Annotatn in each method
@RestController
public class StudentInfoRESTAPIController {

//	***********Retrieving all student records***********
	
//	purpose of response body annotation is to instruct the spring mvc to not look for any view technology to prepare the final response
//	Instead , whatever that controller method is returning, simply convert that to the desired format and send that directly to the client.
	
//	@ResponseBody
	
//	using the produces forces spring mvc that this REST api controller method must support only one format i.e. only Xml and not json 
	@RequestMapping(value = "/students", method = RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
	public ArrayList<Student> getStudentList(){
		Student student1 = new Student();
		student1.setStudentName("Sumeet");
		
		Student student2 = new Student();
		student2.setStudentName("Nitish");
		
		Student student3 = new Student();
		student3.setStudentName("Priya");
		
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
		
		return studentList;
	}
//	WE USE GET IF THE CLIENT WANTS TO JUST THE READ THE DATA ON THE SERVER
//	***********Retrieving a student record***********
//	@ResponseBody
	@RequestMapping(value = "/students/{name}", method = RequestMethod.GET)
	public Student getStudentList(@PathVariable("name") String studentName){
		
//		fetch the student's record using "studentName" from DB
		Student student1 = new Student();
		student1.setStudentName(studentName);
		student1.setStudentHobby("IT");
		
		return student1;
	}	
	
//	WE USE PUT METHOD IF THE CLIENT WANTS TO UPDATE SOME DATA ON THE SERVER
//	*****************Updating a student record****************
//	using consumes argument, it restricts this method to accept only xml type data. Same way we can change to to json or any other
	@RequestMapping(value="/students/{name}", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_XML_VALUE)
	public boolean updateStudent(@PathVariable("name") String studentName, @RequestBody Student student){
	 System.out.println("Student Name : "+studentName);
	 System.out.println("Student Name :"+ student.getStudentName() +" Student Hobby : "+ student.getStudentHobby());
	 
//	 find the matching student record using "studentName" from the DB
//	 update the matching student record with the information of student sent by the client
	 
//	 return true if update is successfully done and false if update is not done successfully
	 return true;
	} 
	
	

}
