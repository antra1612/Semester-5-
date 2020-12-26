<%@ page errorPage="ErrorPage12.jsp" %>
<html>
	<head>
		<title>
			Divide by 5
		</title>
	</head>
	<body>
	<% 
			int number=Integer.parseInt((String)request.getParameter("number"));
			out.println(number/5);
	%>
	<p>
	</body>
<html>