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
import models.AdminModel;

@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int adminid=Integer.parseInt(request.getParameter("adminid"));
		String password=request.getParameter("password");
		
		AdminModel am=new AdminModel();
		am.setAdminId(adminid);
		am.setPassword(password);
		HttpSession session=request.getSession();
		String sql="select * from Admin where adminid=? and password=?";
		ResultSet rs=Dao.adminAuthentication(am,sql);
		try {
			if(rs.next())
			{
				
				session.setAttribute("value", "admin");
				session.setAttribute("msg", " ");
				getServletContext().getRequestDispatcher("/adminhome.jsp").forward(request, response);
			} else {
				session.setAttribute("msg", "Invalid Id / Password");
				getServletContext().getRequestDispatcher("/adminlogin.jsp").include(request, response);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
