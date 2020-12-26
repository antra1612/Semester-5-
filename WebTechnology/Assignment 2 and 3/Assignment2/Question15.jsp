<%@ page errorPage="ErrorPage15.jsp" contentType="application/vnd.ms-excel" %>
<html>
	<head>
		<title>
			Journey
		</title>
	</head>
	<body>
	<table>
	<tr>
		<th><%out.println("Distance");%></th>
		<th><%out.println("Time");%></th>
		<th><%out.println("Speed");%></th>
	</tr>
	<% 
		int distance=Integer.parseInt((String)request.getParameter("distance_a_b"));
		int time=Integer.parseInt((String)request.getParameter("time_a_b"));
		int speed=distance/time;
	%>
	<tr>
		<td><%out.print(distance);%></td>
		<td><%out.print(time);%></td>
		<td><%out.print(speed);%></td>
	</tr>
	<%
		distance=Integer.parseInt((String)request.getParameter("distance_b_c"));
		time=Integer.parseInt((String)request.getParameter("time_b_c"));
		speed=distance/time;
	%>
	<tr>
		<td><%out.print(distance);%></td>
		<td><%out.print(time);%></td>
		<td><%out.print(speed);%></td>
	</tr>
	<%
		distance=Integer.parseInt((String)request.getParameter("distance_c_d"));
		time=Integer.parseInt((String)request.getParameter("time_c_d"));
		speed=distance/time;
	%>
	<tr>
		<td><%out.print(distance);%></td>
		<td><%out.print(time);%></td>
		<td><%out.print(speed);%></td>
	</tr>
	</table>
	</body>
<html>