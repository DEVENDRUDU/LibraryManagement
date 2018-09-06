package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Dao;
import models.StudentModel;

@WebServlet("/addstudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int sid=Integer.parseInt(request.getParameter("sid"));
		String sname=request.getParameter("sname");
		String course=request.getParameter("course");
		String password=request.getParameter("password1");
		String password2=request.getParameter("password2");
		if(password.equals(password2)) {
			
		StudentModel sm=new StudentModel();
		sm.setSid(sid);
		sm.setSname(sname);
		sm.setCourse(course);
		sm.setPassword(password);
		
		String sql="insert into Students values(?,?,?,?)";
		int i=Dao.addStudent(sm,sql);
		if(i!=0) {
			session.setAttribute("msg", "Student Added SuccessFully");
			getServletContext().getRequestDispatcher("/addstudent.jsp").include(request, response);
		} else {
			session.setAttribute("msg", "Student Added Failed");
			getServletContext().getRequestDispatcher("/addstudent.jsp").include(request, response);
		}
	  } else {
		  session.setAttribute("msg", "Passwords are not Matched");
			getServletContext().getRequestDispatcher("/addstudent.jsp").include(request, response);
		
	  }
	}

}
