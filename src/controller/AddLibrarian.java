package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Dao;
import models.LibrarianModel;

/**
 * Servlet implementation class AddLibrarian
 */
@WebServlet("/addlibrarian")
public class AddLibrarian extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		
		int lid=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String  qualification=request.getParameter("qualification");
		String address=request.getParameter("address");
		String password=request.getParameter("password1");
		String password2=request.getParameter("password2");
		if(password.equals(password2)) {
				
		
		
		LibrarianModel lm=new LibrarianModel();
		lm.setLId(lid);
		lm.setName(name);
		lm.setQualification(qualification);
		lm.setAddress(address);
		lm.setPassword(password);
		
		String sql="insert into Librarian values(?,?,?,?,?)";
		int i=Dao.addLibrarian(lm,sql);
		
		if(i!=0)
		{
			session.setAttribute("msg", "Added SuccessFully");
			getServletContext().getRequestDispatcher("/addlibrarian.jsp").include(request, response);
		}else {
			session.setAttribute("msg", "Failed to Add Librarian");
			getServletContext().getRequestDispatcher("/addlibrarian.jsp").include(request, response);
		}
		}
		else {
			session.setAttribute("msg", "passwords should not be Matched");
			getServletContext().getRequestDispatcher("/addlibrarian.jsp").include(request, response);
			
		}
	}
}
