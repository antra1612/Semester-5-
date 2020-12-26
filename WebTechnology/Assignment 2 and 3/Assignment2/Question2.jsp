<html>
	<head>
		<title>
			User paramters
		</title>
	</head>
	<body>
		<h2><p align="center">User parameters<br />
		<% 
			out.println("Parameter1:"+request.getParameter("Parameter1"));
		%><br />
		<%
			out.println("Parameter2:"+request.getParameter("Parameter2"));
		%><br />
		<%
			out.println("Paramater3:"+request.getParameter("Parameter3"));
		%><br />
		</p>
	</body>
<html>