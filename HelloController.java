package com.sumeet.studentController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
//		this below function is used when we don't want a field to be binded to an object variable
//		so in this case student Mobile won't be bound to studentMobile field in the student object 
		binder.setDisallowedFields(new String[] {"studentMobile"});
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy****MM****dd");
		binder.registerCustomEditor(Date.class,"studentDOB",new CustomDateEditor(dateFormat, false));
//		Creating a custom Proeprty Editor
		binder.registerCustomEditor(String.class,"studentName",new StudentNameEditor());
		
	}

	@RequestMapping(value = "/admission.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() throws Exception {
		String exceptionOccured = "Null_Pointer";
		if(exceptionOccured.equalsIgnoreCase("Null_Pointer")){
			throw new NullPointerException("Null Pointer Exception");
		}
		ModelAndView modelAndView = new ModelAndView("AdmissionForm");
//		modelAndView.addObject("headerMessage","Haldia Institite of Technology");
		return modelAndView;
	}

//	TO GET THE DATA USING REQUESTPARAM ANNOTATION
	
	/*@RequestMapping(value = "/submitAdmissionForm.html", method = RequestMethod.POST)
	protected ModelAndView submitAdmissionForm(@RequestParam(value = "studentName", defaultValue = "Mr. XYZ") String name,
			@RequestParam("studentHobby") String hobby) throws Exception {
		
		Student student = new Student();
		student.setStudentName(name);
		student.setStudentHobby(hobby);
		
		ModelAndView modelAndView = new ModelAndView("AdmissionSuccess");
		modelAndView.addObject("headerMessage","Haldia Institite of Technology");
		modelAndView.addObject("student",student);
		return modelAndView;
	}*/
	
	
//	TO GET THE DATA USING MODELATTRIBUTE ANNOTATION
//	IT automatically binds all request parameters or form elements submitted by the user with the corresponding 
//	properties of the student object.
//	Also in the corresponding jsp file, we can use the student object by simply referring the key 
//	NOTE : while using model attribute, the field names in the jsp page and the Object should be the same
	
	@RequestMapping(value = "/submitAdmissionForm.html", method = RequestMethod.POST)
	protected ModelAndView submitAdmissionForm(@Valid @ModelAttribute ("student") Student student, BindingResult result) throws Exception {
		
		if(result.hasErrors()){
			ModelAndView model1=new ModelAndView("AdmissionForm");
			return model1;
		}
		ModelAndView modelAndView = new ModelAndView("AdmissionSuccess");
//		modelAndView.addObject("headerMessage","Haldia Institite of Technology");
		return modelAndView;
	}
	
//	This method is used if we have some common objects or messages which we are using in more than one 
//	RequestHandler Methods. So instead of writing everywhere, we just need to write it only once in this method and it can be used 
//	in all methods.
	
//	NOTE : IF A CONTROLLER CLASS HAS A MODELATTRIBUTE METHOD THEN, SPRING MVC FRAMEWORK ALWAYS MAKES A CALL TO THAT METHOD FIRST
//		   BEFORE MAKING A CALL TO ANY OF ITS REQUEST HANDLER METHODS
	
	@ModelAttribute
	public void addingCommonObjects(Model model){
		model.addAttribute("headerMessage","Haldia Institite of Technology");
	}
	
//	@ExceptionHandler(value = NullPointerException.class)
//	public String handleNullPointerException(Exception e){
//		System.out.println("Null pointer occured : "+e);
//		return "NullPointerException";
//	}

}