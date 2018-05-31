package com.sumeet.studentController;

import java.beans.PropertyEditorSupport;

public class StudentNameEditor extends PropertyEditorSupport {

//	when you will submit the admission form , 
//	spring MVC will run setAsText function of this class.
//	before performing data binding task for studentName property of student object
	
	@Override
	public void setAsText(String studentName)throws IllegalArgumentException{
		if(studentName.contains("Mr.") || studentName.contains("Ms.")){
			setValue(studentName);
		}
		else{
			studentName = "Ms." + studentName;
			setValue(studentName); //what every value you will provide to setvalue, Spring MVC will use the same value to 
									//perform data binding task for student Name property
		}
			
	}
	public StudentNameEditor() {
		// TODO Auto-generated constructor stub
	}

}
