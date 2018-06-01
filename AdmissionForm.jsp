<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>

<body>
<a href ="/SpringMVCSecondProject/admission.html?siteLanguage=en">English</a> | <a href ="/SpringMVCSecondProject/admission.html?siteLanguage=fr">French</a>
<h1>${headerMessage }</h1>
	<h2>STUDENT APPLICATION FORM FOR ENGINEERIN COURSES</h2>
	<form:errors path="student.*"/>
	<form action="/SpringMVCSecondProject/submitAdmissionForm.html" method="post">
		<p>
		<!--Using the message instead of hardcoded values for internationalization  -->
			<spring:message code="label.studentName"/>  : <input type="text" name="studentName"/>
		</p>
		<p>
			<spring:message code="label.studentHobby"/> : <input type="text" name="studentHobby"/>
		</p>
		<p>
			<spring:message code="label.studentMobile"/> : <input type="text" name="studentMobile"/>
		</p>
		<p>
			<spring:message code="label.studentDOB"/> : <input type="text" name="studentDOB"/>
		</p>
		<p>
			<spring:message code="label.studentSkills"/> : <select name="studentSkills" multiple="multiple">
									<option value="Core java">Core java</option>
									<option value="Spring core">Spring core</option>
									<option value="Spring mvc">Spring mvc</option>
									</select>
		</p>
		<p>Student's country : <input type="text" name="studentAddress.country"/></p>
		<p>Student's city : <input type="text" name="studentAddress.city"/></p>
		<p>Student's street : <input type="text" name="studentAddress.street"/></p>
		<p>Student's pincode : <input type="text" name="studentAddress.pincode"/></p>
		
		<input type="submit" value="Click Here to Submit Form"/>
	</form>
</body>
</html>