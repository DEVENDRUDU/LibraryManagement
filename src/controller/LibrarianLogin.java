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
import models.LibrarianModel;

@WebServlet("/librarianlogin")
public class LibrarianLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			int lid=Integer.parseInt(request.getParameter("lid"));
			String password=request.getParameter("password");
			
			LibrarianModel lm=new LibrarianModel();
			lm.setLId(lid);
			lm.setPassword(password);
			HttpSession session=request.getSession();
	
			String sql="select * from Librarian where lid=? and password=?";
			ResultSet rs=Dao.librarianLogin(lm,sql);
			try {
			if(rs.next()) {				
				session.setAttribute("value", "librarian");
				session.setAttribute("msg", "Logged successfully");
				getServletContext().getRequestDispatcher("/librarianhome.jsp").forward(request, response);
			} else {
				session.setAttribute("msg", "Invalid Id / Password");
				getServletContext().getRequestDispatcher("/librarianlogin.jsp").include(request, response);
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}			
	}

}
