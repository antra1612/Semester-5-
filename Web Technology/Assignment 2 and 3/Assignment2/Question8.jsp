<html>
	<head>
		<title>
			Welcome User
		</title>
	</head>
	<body>
		<h2><p align="center">Welcome User<br />
		<% 
			String name = request.getParameter("name");
			if(name.equals(""))
			{
				out.println("You need to enter your name in textbox:");
		%>
		<%@ include file="Question8Form.html" %>
		
		<% 
			}
			else
				out.println("Hello "+name);
		%>
		</p>
	</body>
<html>