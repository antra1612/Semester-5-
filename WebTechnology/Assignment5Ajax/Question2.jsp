<%@ page import = "java.util.Date" %>
<%
	Date today  = new Date();
	int hours = today.getHours();
	if(hours <= 12 && hours >= 0)
		out.print("Good morning!");
	else if(hours <= 19 && hours >=13)
		out.print("Good afternoon!");
	else
		out.print("Good evening!");
%>