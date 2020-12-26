<html>
	<head>
		<title>
			Home Page
		</title>
	</head>
	<body>
		<%
			Integer hit_counter = (Integer)application.getAttribute("HomePage");
			if(hit_counter==null || hit_counter==0){
				out.println("First time visit.Welcome!");
				hit_counter=1;
			}
			else
			{
				hit_counter+=1;
			}
			application.setAttribute("HomePage",hit_counter);
		%>
		<center><h2>Number of visits:<% out.println(hit_counter); %>
		<a href="Question14Page2.jsp">Go to Page2</a>
	</body>
</html>