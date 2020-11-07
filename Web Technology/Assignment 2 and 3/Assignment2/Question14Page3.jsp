<html>
	<head>
		<title>
			Home Page
		</title>
	</head>
	<body>
		<%
			Integer hit_counter = (Integer)application.getAttribute("Page3");
			if(hit_counter==null || hit_counter==0){
				out.println("First time visit.Welcome!");
				hit_counter=1;
			}
			else
			{
				hit_counter+=1;
			}
			application.setAttribute("Page3",hit_counter);
		%>
		<center><h2>Number of visits:<% out.println(hit_counter); %>
		<a href="Question14Page4.jsp">Go to Page4</a>
	</body>
</html>