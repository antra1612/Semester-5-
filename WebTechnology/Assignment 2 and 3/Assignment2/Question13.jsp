<%@ page contentType="application/vnd.ms-excel" import="java.util.Random" %>
<%! 
	Random random = new Random();
	boolean check(int number){
		if(number % 2 == 0)
			return true;
		else
			return false;
	}
%>
<%
	for(int i =0;i<10;i++){
		int number = random.nextInt(10);
		if(check(number)){
			out.println(number+"\t"+"Even Number");
		}
		else{
			out.println(number+"\t"+"Odd Number");
		}
	}
%>