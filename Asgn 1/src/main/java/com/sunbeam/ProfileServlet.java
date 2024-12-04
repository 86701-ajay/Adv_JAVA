package com.sunbeam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet{
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title> Info </title>");
		out.println("</head>");
		out.println("<body bgcolor ='pink'>");
		out.println("<h1> first name : ajay </h1>");
		out.println("<h1> last name : barsale </h1>");
		out.println("<h1>  qualification : graduation </h1>");
		out.println("<h1> college : diems </h1>");
		out.println("<h1> birth date : 14/05/2000 </h1>");
		out.println("</body>");
		out.println("</html>");
	}


	
}
