package com.sumeet.studentController;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(value = "/admission.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() throws Exception {
		ModelAndView modelAndView = new ModelAndView("AdmissionForm");
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
//	NOTE : while using model attribute, the field names in the jsp page and the Object should be the same
	
	@RequestMapping(value = "/submitAdmissionForm.html", method = RequestMethod.POST)
	protected ModelAndView submitAdmissionForm(@ModelAttribute ("student") Student student) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView("AdmissionSuccess");
		modelAndView.addObject("headerMessage","Haldia Institite of Technology");
		return modelAndView;
	}

}
