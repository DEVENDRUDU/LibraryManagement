package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.Dao;

public class DispModel {
	public static List getLibrarians()
	{
		List l=new ArrayList();
		String sql="select * from Librarian";
		ResultSet rs=Dao.getAllLibrarian(sql);
		try {
			while(rs.next()) {
				LibrarianModel lm=new LibrarianModel();
				lm.setLId(rs.getInt(1));
				lm.setName(rs.getString(2));
				lm.setQualification(rs.getString(3));
				lm.setAddress(rs.getString(4));
				l.add(lm);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}	
		return l;
	}
	
	public static List getBooks()
	{
		List l=new ArrayList();
		String sql="select * from Books";
		ResultSet rs=Dao.getAllBook(sql);
		try {
			while(rs.next()) {
				BooksModel bm=new BooksModel();
				
				bm.setTitle(rs.getString(1));
				bm.setAuthor(rs.getString(2));
				bm.setTotalCopies(rs.getInt(3));
				l.add(bm);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return l;
	}
	public  static List getStudent()
	{
		List l=new ArrayList();
		String sql="select * from Students";
		ResultSet rs=Dao.getStudents(sql);
		try {
			while(rs.next())
			{
				StudentModel sm=new StudentModel();
				sm.setSid(rs.getInt(1));
				sm.setSname(rs.getString(2));
				sm.setCourse(rs.getString(3));
				l.add(sm);
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return l;
		}

	public static List getBookDetails(String title) {
		List l=new ArrayList();
		String sql="select * from BookDetails where title=?";
		ResultSet rs=Dao.getBookDetail(title,sql);
		try {
			while(rs.next())
			{
				BookIdModel b=new BookIdModel();
				b.setBId(rs.getInt(1));
				l.add(b);				
			}			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return l;
	}
	
	public static List getIssuedBooks() {
		List l=new ArrayList();
		String sql="select sid,bid,title,issuedate from issuebooks";
		ResultSet rs=Dao.getIssuedBook(sql);
		try {
			while(rs.next()) {
				IBModel im=new IBModel();
				im.setSId(rs.getInt(1));
				im.setBId(rs.getInt(2));
				im.setTitle(rs.getString(3));
				im.setIssueDate(rs.getString(4));
				l.add(im);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		return l;
	}
public static List getIssueHistory() {
		List l=new ArrayList();
		String sql="select * from issuehistory";
		ResultSet rs=Dao.getIssuedBook(sql);
		try {
			while(rs.next()) {
				IBModel im=new IBModel();
				im.setSId(rs.getInt(1));
				im.setBId(rs.getInt(2));
				im.setTitle(rs.getString(3));
				im.setIssueDate(rs.getString(4));
				im.setReturnDate(rs.getString(5));
				l.add(im);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		return l;
	}
	public static List getMyBooks(StudentModel sm) {
	
		List l=new ArrayList();
		
		String sql="select * from IssueBooks where sid=?";
		ResultSet rs=Dao.getMyBook(sm,sql);
		try {
			while(rs.next()) {
				IBModel im=new IBModel();
				im.setSId(rs.getInt(1));
				im.setBId(rs.getInt(2));
				im.setTitle(rs.getString(3));
				im.setIssueDate(rs.getString(4));
				l.add(im);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return l;
	}
}
