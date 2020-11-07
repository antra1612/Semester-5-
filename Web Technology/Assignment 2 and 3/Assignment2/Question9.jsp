<%@ page import="java.util.Random" %>
<html>
	<head>
		<title>
			Change Background color
		</title>
	</head>
	<% 
			String color = request.getParameter("color");
			if(color.equals(""))
			{
				Random random = new Random();
				String[] colors={"AliceBlue","light salmon","AntiqueWhite","Beige"};
				int i = random.nextInt(4);
				color=colors[i];
			}
				
	%>
	<body bgcolor="<%= color %>">
	<p>Background color =<% out.print(color);%>
	</body>
<html>