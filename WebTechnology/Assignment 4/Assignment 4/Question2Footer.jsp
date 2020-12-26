<%@ page import="java.util.*,java.io.*,java.sql.*" %>
<%@ page import="javax.http.servlet.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
	<head>
		<title>Footer</title>
	</head>
	<body>
		<%
			String count=(String)application.getAttribute("visitor_number");
			if(count==null)
			{
				application.setAttribute("visitor_number","1");
				count=(String)application.getAttribute("visitor_number");
			}
			else
			{
				int counter=Integer.parseInt(count);
				counter=counter+1;
				application.setAttribute("visitor_number",counter+"");
				count=(String)application.getAttribute("visitor_number");
			}
			out.print("Visitor number:"+count);
		%>
		<center>
		</center>
	</body>
</html>