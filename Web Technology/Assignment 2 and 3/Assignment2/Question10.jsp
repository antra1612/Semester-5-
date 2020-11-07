<%@ page import="java.util.Date" %>
<html>
	<head>
		<title>
			Welcome User
		</title>
	</head>
	<body>
		<h2><p align="center">
		<% 
			Date today = new Date();
			int hour = today.getHours();
			if(hour<=12){
				out.print("Good morning!");
			}
			else if(hour>12 && hour<=17){
				out.print("Good afternoon!");
			}
			else if(hour>17 && hour<=23){
				out.print("Good evening!");
			}
		%>
		</p>
	</body>
<html>