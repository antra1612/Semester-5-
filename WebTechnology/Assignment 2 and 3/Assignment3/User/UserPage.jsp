<html>
	<head>
		<title>
			User welcome
		</title>
	</head>
	<body>
	<jsp:useBean id="user1" class="user.UserBean" />
	<jsp:setProperty property="*" name="user1" />
	<body bgcolor="<jsp:getProperty name='user1' property='backgroundcolor' />" text="forecolor:<jsp:getProperty name='user1' property='foregroundcolor' />">
	Welcome!<jsp:getProperty name='user1' property='username' />
	</body>
<html>
