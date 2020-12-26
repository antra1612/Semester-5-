<%@ page import="java.util.*,java.io.*,java.sql.*" %>
<%@ page import="javax.http.servlet.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
	<head>
		<title>Time and day</title>
	</head>
	<body>
		<%
			String color=(String)request.getParameter("backgroundColor");
		%>
		<center>
		<script>
			document.body.style.backgroundColor="<%= color%>";
		</script>
		<c:set var="now" value="<%= new java.util.Date()%>" />
		<center>
			Current Date and time:
			<fmt:formatDate type="both" value="${now}" /></br></br>
			<c:import url="Question2Footer.jsp" />
		</center>
	</body>
</html>