<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="WEB-INF/myTags.tld" prefix="t" %>
<html>
	<head>
		<title>user input</title>
	</head>
	<body>
		<center>
			<%
				Integer num = Integer.parseInt(request.getParameter("num"));
				Integer lim = Integer.parseInt(request.getParameter("lim"));
			%>
			<c:set var="n" value="<%= num %>" />
			<c:set var="l" value="<%= lim%>" />
			Table :<br />
			<t:generateTable number="<%= num %>" limit="<%= lim%>"/>
	</body>
</html>
