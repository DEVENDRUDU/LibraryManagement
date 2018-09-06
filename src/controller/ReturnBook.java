package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Dao;

@WebServlet("/returnbook")
public class ReturnBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				  	
		  	int bid=Integer.parseInt(request.getParameter("bid"));
			/*int sid=Integer.parseInt(request.getParameter("sid"));
			String title=request.getParameter("title");	
			String issuedate=request.getParameter("issuedate");
			*/
		  	HttpSession session=request.getSession();
			String sql="update IssueBooks set returndate=? where bid=?";
			int i=Dao.returnBook(bid,sql);
			if(i!=0) {
					session.setAttribute("msg", "Return Book  SuccessFully");
					response.sendRedirect("http://localhost:8765/LibraryManagement/returnbooks.jsp");
			} else {
					session.setAttribute("msg", "Failed to Return a Book");
					getServletContext().getRequestDispatcher("/returnbooks.jsp").include(request, response);
			}
	}

}
