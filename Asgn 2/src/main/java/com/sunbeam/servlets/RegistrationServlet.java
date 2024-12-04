package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processReuest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processReuest(req, resp);
	}

	protected void processReuest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		String password = req.getParameter("passwd");
		String dob = req.getParameter("dob");
		Date db = Date.valueOf(dob);
		String status = req.getParameter("status");
		int st = Integer.parseInt(status);
		String role = req.getParameter("role");
		User u = new User(0, firstName, lastName, email, password, db, st, role);
		try(UserDao userDao = new UserDaoImpl() ){
			userDao.save(u);
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Save</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h2>User added successfully!!!</h2>");
			out.println("<p><a href='index.html'>Login Again</a></p>");
			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			e.printStackTrace();
		throw new ServletException(e);
		}
	}
}
