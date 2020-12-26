<html>
	<head>
		<title>
			Student details
		</title>
	</head>
	<body>
	<center><h2>
		<jsp:useBean id="student" class="student.StudentData" />
		<jsp:setProperty name="student" property="*" />
		<b><u>Student details:</u></b><br /><br />
		First name:<jsp:getProperty name="student" property="fname" /><br />
		Last name:<jsp:getProperty name="student" property="lname" /><br />
		Address:<jsp:getProperty name="student" property="address" /><br />
		Age:<jsp:getProperty name="student" property="age" /><br />
	</center>
	</body>
</html>
