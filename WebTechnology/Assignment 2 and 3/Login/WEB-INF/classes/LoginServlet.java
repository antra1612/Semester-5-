package login;

import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 


public class LoginServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		  
		 LoginBean bean = new LoginBean();
		 bean.setUsername(username);
		 bean.setPassword(password);
		  
		 request.setAttribute("Login",bean);
		  
		 boolean status = bean.validateUser();
		  
		  if(status){
			  RequestDispatcher request_dispatcher = request.getRequestDispatcher("LoginSuccess.jsp");
			  request_dispatcher.forward(request,response);
		  }
		  else
		  {
			RequestDispatcher request_dispatcher = request.getRequestDispatcher("LoginError.jsp");
			request_dispatcher.forward(request,response);  
		  }
	 }
	  protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}