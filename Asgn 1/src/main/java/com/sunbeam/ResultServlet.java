package com.sunbeam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {

	private ArrayList<Marks> result;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);	
		result = new ArrayList<Marks>();
		result.add(new  Marks("java",80));
		result.add(new  Marks("dbt",95));
		result.add(new  Marks("wbt",75));
		result.add(new  Marks("cpp",68));
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		for (Marks m : result) {
			out.println("<tr>");
			out.printf("<td>%s</td>\r\n",m.getSubject());
			out.printf("<td>%.2f</td>\r\n",m.getMarks());
			out.println("</tr> <br> <br>");
		}
	}
}
