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

@WebServlet("/librarianmodification")
public class LibrarianModification extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String str1=request.getParameter("update");
		String str2=request.getParameter("delete");
		HttpSession session=request.getSession();
		if(str1!=null) { 
			String lid1=request.getParameter("lid");
			String name=request.getParameter("name");
			String qualification=request.getParameter("qualification");
			String address=request.getParameter("address");
			if(lid1==null ||lid1.equals("") || name==null || name.equals("") || qualification==null || qualification.equals("")|| address==null || address.equals("")) {
				session.setAttribute("msg", "values cannot be empty");
				getServletContext().getRequestDispatcher("/viewlibrarians1.jsp").include(request, response);	
			} else {
					int lid=Integer.parseInt(request.getParameter("lid"));
				LibrarianModel lm=new LibrarianModel();
				lm.setLId(lid);
				lm.setName(name);
				lm.setQualification(qualification);
				lm.setAddress(address);
				
				String sql="update Librarian set lid=?,name=?,qualification=?,address=? where lid=?";
				int i=Dao.modifyLibrarian(lm,sql);
				 	if(i!=0) { 
				 		session.setAttribute("msg", "Updated SuccessFully");
				 		getServletContext().getRequestDispatcher("/viewlibrarians1.jsp").forward(request, response);
				 	} else {
				 		session.setAttribute("msg", "Update Fail ");
				 		getServletContext().getRequestDispatcher("/viewlibrarians1.jsp").include(request, response);
				 	}
				}
		}
		
		if(str2!=null) {
			int lid=Integer.parseInt(request.getParameter("lid"));
			
			String sql="delete from Librarian where lid=?";
			int i=Dao.deleteLibrarian(lid,sql);
			 	if(i!=0) {
			 		session.setAttribute("msg", "Deleted SuccessFully");
			 		getServletContext().getRequestDispatcher("/viewlibrarians1.jsp").forward(request, response);
			 	} else {
			 		session.setAttribute("msg", " Failed to Delete ");
			 		getServletContext().getRequestDispatcher("/viewlibrarians1.jsp").include(request, response);
			 	}
			}
	}
}