<%@page import="java.util.Date" %>
<html>
	<head>
		<title>
			Current date and Time
		</title>
	</head>
	<body>
		<h2><p align="center">Current date and time:<br />
		<% 
			Date today = new Date();
			out.println(today.toString());
		%>
	</body>
<html>