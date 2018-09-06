package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Dao;

@WebServlet("/booksmodifications")
public class BooksModifications extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int totalcopies=Integer.parseInt(request.getParameter("total"));
		String title=request.getParameter("title");
		String author=request.getParameter("author");
		HttpSession session=request.getSession();
		String str1=request.getParameter("update");
		String str2=request.getParameter("delete");
		if(str2!=null) {
			
			String sql="delete from Books where title='"+title+"'";
			int i=Dao.ModifyBook(sql);
			if(i!=0) {
				session.setAttribute("msg"," Deleted SuccessFully");
				getServletContext().getRequestDispatcher("/viewbooks.jsp").forward(request, response);
			}else {
				session.setAttribute("msg", "Failed To Deleted");
				getServletContext().getRequestDispatcher("/viewbooks.jsp").include(request, response);
			}
		}
		if(str1!=null) {
						
			String sql="update  Books set title='"+title+"',author='"+author+"',totalcopies="+totalcopies+" where bid="+title+"";
			int i=Dao.ModifyBook(sql);
			if(i!=0) {
				/*AddBooksModel ab=new AddBooksModel();
				ab.setBId(bid);
				ab.setTitle(title);
				ab.setAuthor(author);*/
				session.setAttribute("msg", "Updated SuccessFully");
				getServletContext().getRequestDispatcher("/viewbooks.jsp").forward(request, response);
			}else {
				session.setAttribute("msg", " Failed To Update");
				getServletContext().getRequestDispatcher("/viewbooks.jsp").include(request, response);
			}
		}
		
		}
		
	

}
