package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.StudentDAOImpl;
import com.DB.DBConnect;
import com.entity.Student;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			StudentDAOImpl  dao = new StudentDAOImpl(DBConnect.getConnection());
			HttpSession session = req.getSession();

			String email = req.getParameter("email");
			String password = req.getParameter("password");

			Student st = dao.login(email, password);
			if (st != null) {
				session.setAttribute("userobj", st);
				resp.sendRedirect("document.jsp");
			} else {
				session.setAttribute("failedMsg", "Email & Password Invalid");
				resp.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
