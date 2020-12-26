<%@ page import="java.util.*,java.io.*,java.sql.*" %>
<%@ page import="javax.http.servlet.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Customer Information</title>
	</head>
	<body>
		<%
			int id=(Integer.parseInt(request.getParameter("customer_id")));
		%>
		<center>
		<h3><i>
		<c:set var="id" value="<%= id%>" />
		<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/jstl" user="root" password="" />
			<sql:query dataSource="${db}" var="rs">
				Select * from Accounts where ID=?;
				<sql:param value="${id}" />
			</sql:query>
		<c:forEach var="table" items="${rs.rows}">
			<c:set var="Name" value="${table.Name}" />
			<c:if test="${Name != null}">
				<c:set var="flag" value="1" />
				<h2 >Customer Information </h2>
				Welcome <c:out value="${Name}" /> !<br />
				Your balance is <c:out value="${table.Balance}" /> <br />
				<c:set  var="balance" value="${table.Balance}" />
				<c:if test="${balance < 2000}">
					Your balance is less than minimum balance required .Kindly deposit money otherwise your account will get deactivated!
					<script>
						document.body.style.backgroundColor="red";
					</script>
				</c:if>
			</c:if>
		</c:forEach>
		<c:if test="${flag != '1'}">
			<c:out value="Sorry! wrong id" /></i>
			<c:import url="Question1Form.html" />
		</c:if>
		</h3>
		</center>
	</body>
</html>