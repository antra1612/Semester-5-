<html>
	<head>
		<title>
			Bill page
		</title>
	</head>
	<% 
			String product = (String)request.getParameter("product");
			Integer quantity = Integer.parseInt(request.getParameter("quantity"));
			Integer price=0;
			if(product.equals("notebook")){
				price = quantity * 50;
			}
			else if(product.equals("pen")){
				price = quantity * 30;
			}
			else if(product.equals("colorpencils")){
				price = quantity * 150;
			}
			String color;
			if(price<=200)
			{
				color="white";
			}
			else{
				color="green";
			}
		%>
	<body bgcolor="<%= color%>"><h2>
	<center><i><u>Your bill:</u></i><br />
		<table width="50%" height="50%">
			<tr>
				<th>Product name</th>
				<th>Quantity:</th>
				<th>Total</th>
			</tr>
			<tr>
				<th><%out.print(product);%></th>
				<th><%out.print(quantity);%></th>
				<th><%out.print(price);%></th>
			</tr>
		</table>
		
	</body>
<html>
