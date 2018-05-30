<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
	<h1>STUDENT APPLICATION FORM FOR ENGINEERIN COURSES</h1>
	
	<form action="/SpringMVCSecondProject/submitAdmissionForm.html" method="post">
		<p>
			Student's Name  : <input type="text" name="studentName"/>
		</p>
		<p>
			Student's Hobby : <input type="text" name="studentHobby"/>
		</p>
		<input type="submit" value="Click Here to Submit Form"/>
	</form>
</body>
</html>