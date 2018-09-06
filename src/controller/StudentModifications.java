package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Dao;

@WebServlet("/studentmodifications")
public class StudentModifications extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String str1=request.getParameter("update");
		String str2=request.getParameter("delete");
		
		int  sid=Integer.parseInt(request.getParameter("sid"));
		String sname=request.getParameter("name");
		String course=request.getParameter("course");
		String password=request.getParameter("password");
		HttpSession session=request.getSession();
			
			/*StudentModel sm=new StudentModel();
			sm.setSid(sid);
			sm.setSname(sname);
			sm.setCourse(course);*/
			
			String sql="delete from Students where sid=?";
			int i=Dao.deleteStudent(sid,sql);
			if(i!=0) {
				session.setAttribute("msg", "Delete SuccessFully");
				getServletContext().getRequestDispatcher("/viewstudents.jsp").forward(request, response);
			} else {
				session.setAttribute("msg", "Unable to Delete this Student have some pendings is there So unable to delete please clear all pending actions");
				getServletContext().getRequestDispatcher("/viewstudents.jsp").include(request, response);
			}
		 
	}

}
