package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Dao;
import models.BooksModel;
@WebServlet("/addbooks")
public class AddBooks extends HttpServlet {
	
		private static final long serialVersionUID = 1L;

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session=request.getSession();
			if(session.getAttribute("value").equals(null)) {
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);	
			}
			String no=request.getParameter("total");
			String title=request.getParameter("title");		
			String author=request.getParameter("author");
			
			if(no==null || no.equals("") || title==null || title.equals("") || author==null || author.equals("") ) {
				session.setAttribute("msg","Title, Author and no.of copies  should not be empty");
				getServletContext().getRequestDispatcher("/addbooks.jsp").include(request, response);
			} else {
				int totalcopies=Integer.parseInt(no);
					BooksModel ab=new BooksModel();
					ab.setTitle(title);
					ab.setAuthor(author);
					ab.setTotalCopies(totalcopies);
							
					String sql="insert into Books(title,author,totalcopies) values(?,?,?)";
					int i=Dao.addBooks(ab,sql);
					if(i!=0)
					{
						session.setAttribute("msg", "Book added SuccessFully");
						getServletContext().getRequestDispatcher("/addbooks.jsp").forward(request, response);
					}else {
						session.setAttribute("msg", " Book is already added");
						getServletContext().getRequestDispatcher("/addbooks.jsp").include(request, response);
					}
			}
			

		}

	}
