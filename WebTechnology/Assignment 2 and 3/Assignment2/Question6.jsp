<html>
	<head>
		<title>
			User paramters
		</title>
	</head>
	<body>
		<h2><p align="center">Sum of 34 and 56 is:<br />
		<%! 
			int sum(int number1,int number2)
			{
				return number1+number2;
			}
		%>
		<%
			out.println(sum(34,56));
		%><br />
		</p>
	</body>
<html>