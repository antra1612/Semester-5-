<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.*" %>
<html>
	<head>
		<title>user input</title>
	</head>
	<body>
		<center>
			<%
				InputStream ins = application.getResourceAsStream("/WEB-INF/File1.txt");
				BufferedReader br = new BufferedReader(new InputStreamReader(ins));
				String line;
				while((line=br.readLine()) != null){	
				Thread.sleep(3000);
				
			%>
				<c:set var="content" value="<%= line%>" /><br />
				<c:out value="${content}" />
			<%
				out.flush();
				}
			%>
		</body>
</html>
