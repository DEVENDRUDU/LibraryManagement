package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Dao;
import models.StudentModel;

@WebServlet("/studentlogin")
public class StudentLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int sid=Integer.parseInt(request.getParameter("sid"));
		String password=request.getParameter("password");
		
		StudentModel sm=new StudentModel();
		sm.setSid(sid);
		sm.setPassword(password);	
		HttpSession session=request.getSession();
		String sql="select * from Students where sid=? and password=?";
		ResultSet rs=Dao.studentLogin(sm,sql);
		try {
			if(rs.next()) {
				
				session.setAttribute("value", "student");
				session.setAttribute("sid", sid);
				session.setAttribute("msg", "Logged successfully");
				getServletContext().getRequestDispatcher("/studenthome.jsp").forward(request, response);
			} else {
				session.setAttribute("msg", "Invalid Id / Password");
				getServletContext().getRequestDispatcher("/studentlogin.jsp").include(request, response);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
