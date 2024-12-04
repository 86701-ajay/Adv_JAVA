package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.Candidate;
import com.sunbeam.entities.User;

@WebServlet("/add")
public class CandidateServlet extends HttpServlet {

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
		String name = req.getParameter("name");
		String party = req.getParameter("party");
		String votes = req.getParameter("votes");
		int vote = Integer.parseInt(votes);
		String role = req.getParameter("role");
		Candidate c =new Candidate(vote, name, party, vote);
		try(CandidateDao candidateDao = new CandidateDaoImpl() ){
			candidateDao.save(c);
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Save</title>");
			out.println("</head>");
			
			// get app color from ctx param and display it
			ServletContext app2 = this.getServletContext();
			String appColor = app2.getInitParameter("app.color");
			
			out.printf("<body style='background-color:%s;'>",appColor);
			
			
			out.println("<h2>Candidate added successfully!!!</h2>");
			out.println("<p><a href='result'>Result Servlet</a></p>");
			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			e.printStackTrace();
		throw new ServletException(e);
		}
	}
	}
