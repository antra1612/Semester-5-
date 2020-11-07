<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>
			Student Information
		</title>
	</head>
	<body>
		<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/jstl" user="root" password=""/>
		<sql:update dataSource="${db}" var="updateData">
			Insert into Student values(6,"Kruti Mistry",378);
		</sql:update>
		<sql:query dataSource="${db}" var="rs">
			Select * from Student
		</sql:query>
		<center><h2>Student Information
		<table width="50%" height="50%">
			<tr>
				<th>Roll no</th>
				<th>Name</th>
				<th>Marks</th>
			</tr>
			<c:forEach var="table" items="${rs.rows}">
				<tr>
					<td align="center"><c:out value="${table.Roll_no}" /></td>
					<td align="center"><c:out value="${table.Name}" /></td>
					<td align="center"><c:out value="${table.Marks}" /></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>

