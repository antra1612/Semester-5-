<html>
	<head>
		<title>
			Change Background color
		</title>
	</head>
	<% 
			String color = request.getParameter("color");
			if(color.equals(""))
				color="red";
	%>
	<body bgcolor="<%= color %>">
	<p>Background color =<% out.print(color);%>
	</body>
<html>