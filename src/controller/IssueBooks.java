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
@WebServlet("/issuebooks")
public class IssueBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			int sid=Integer.parseInt(request.getParameter("sid"));
			int bid=Integer.parseInt(request.getParameter("bid"));
			String title=request.getParameter("title");
			HttpSession session=request.getSession();
			
			String sql1="select title from IssueBooks where sid="+sid+"and title='"+title+"'";
			ResultSet rs=Dao.getAllBook(sql1);
			try {
				if(rs.next()) {
					session.setAttribute("msg","Student already taken in this Title");
					getServletContext().getRequestDispatcher("/issuebooks.jsp").include(request, response);
					
				} else {
				
					String sql="insert into IssueBooks(sid,bid,title,issuedate) values(?,?,?,now())";
					int i=Dao.issueBook(sid,bid,title,sql);
				
					if(i!=0) {
						session.setAttribute("msg", "Issued SuccessFully");
						getServletContext().getRequestDispatcher("/issuebooks.jsp").forward(request, response);
					} else {
						session.setAttribute("msg", "Unable Issue Book");
						getServletContext().getRequestDispatcher("/issuebooks.jsp").include(request, response);
					}
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(NullPointerException e) {
				e.printStackTrace();
			}
	}
}
