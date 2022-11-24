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

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String fname = req.getParameter("fname");
			String email = req.getParameter("email");
			String dob = req.getParameter("dob");
			String address = req.getParameter("address");
			String phone = req.getParameter("phone");
			String gender = req.getParameter("gender");
			String password = req.getParameter("password");
			String check = req.getParameter("check");

			Student st = new Student();
			st.setName(fname);
			st.setEmail(email);
			st.setDob(dob);
			st.setAddress(address);
			st.setPhone(phone);
			st.setGender(gender);
			st.setPassword(password);

			HttpSession session = req.getSession();
			if (check != null) {
			StudentDAOImpl dao = new StudentDAOImpl(DBConnect.getConnection());

			boolean f2 = dao.checkUser(email);
			if(f2)
			{
				boolean f = dao.studentRegister(st);
				if (f) {
					session.setAttribute("succMsg", "Registration Successfully..");
					resp.sendRedirect("index.jsp");

					// System.out.println("User Register Success..");
				} else {
					session.setAttribute("failedMsg", "Something wrong on server..");
					resp.sendRedirect("index.jsp");

					// System.out.println("Something wrong on server..");
				}
			}else {
				session.setAttribute("failedMsg", "User Already Exist Try Another Email id ");
				resp.sendRedirect("index.jsp");
			}
			
		} else {
			session.setAttribute("failedMsg", "Please check Agree & Terms Condition");
			resp.sendRedirect("index.jsp");

			// System.out.println("Please check Agree & Terms Condition");
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
}

}
