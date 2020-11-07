<%@ page import="login.LoginBean"%>
<p>You have successfully logged in!
<% LoginBean bean = (LoginBean)request.getAttribute("Login"); 
out.println("Welcome!"+bean.getUsername());
%>