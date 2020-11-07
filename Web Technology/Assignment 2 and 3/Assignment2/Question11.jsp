<%@ page import="java.util.Random" %>
<html>
	<head>
		<title>
			Change Background color
		</title>
	</head>
	<body>
	<% 
			Random random = new Random();
			int i = random.nextInt(500);
	%>
	<p>Random number generated is : =<% out.print(i);%>
	</body>
<html>