<html>
	<head>
		<title>
			Hit count
		</title>
	</head>
	<body>
		<%
			Integer hit_counter = (Integer)application.getAttribute("hitCount");
			if(hit_counter==null || hit_counter==0){
				out.println("First time visit.Welcome!");
				hit_counter=1;
			}
			else
			{
				hit_counter+=1;
			}
			application.setAttribute("hitCount",hit_counter);
		%>
		<h2 align="center">Total number of visits:<% out.print(hit_counter);%>
	</body>
</html>