package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import models.AdminModel;
import models.BooksModel;
import models.LibrarianModel;
import models.StudentModel;

public class Dao {
	private static Connection connect() {
		Connection con=null;
			try {
				 Class.forName("org.postgresql.Driver");
				con=DriverManager.getConnection("jdbc:postgresql://localhost/library", "postgres","admin");
				
			} catch(SQLException se) {
				se.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return con;
		}
	public static ResultSet adminAuthentication(AdminModel am,String sql) {
		
		Connection con=connect();		
		ResultSet rs=null;
		try {
			PreparedStatement st1=con.prepareStatement(sql);
			st1.setInt(1, am.getAdminId());
			st1.setString(2, am.getPassword());
			rs=st1.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return rs;
	}
	public static int addLibrarian(LibrarianModel lm, String sql) {
		
		Connection con=connect();
		int i=0;
		try {
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, lm.getLId());
			st.setString(2, lm.getName());
			st.setString(3, lm.getQualification());
			st.setString(4, lm.getAddress());
			st.setString(5, lm.getPassword());
			i=st.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return i;
	}
	public static ResultSet getAllLibrarian(String sql) {
		Connection con=connect();
		ResultSet rs=null;
		try {
			PreparedStatement st=con.prepareStatement(sql);
			rs=st.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return rs;
	}
	public static int addBooks(BooksModel ab, String sql) {
		Connection con=connect();
		int i=0;
		try {
			PreparedStatement st=con.prepareStatement(sql);
			
			st.setString(1, ab.getTitle());
			st.setString(2, ab.getAuthor());
			st.setInt(3, ab.getTotalCopies());
			i=st.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return i;
	}
	public static ResultSet getAllBook(String sql) {
		Connection con=connect();
		ResultSet rs=null;
		try {
			PreparedStatement st=con.prepareStatement(sql);
			rs=st.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return rs;
	}
	public static int ModifyBook(String sql) {
		Connection con=connect();
		int i=0;
		try {
			PreparedStatement st=con.prepareStatement(sql);
			i=st.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return i;
	}
	public static int addStudent(StudentModel sm, String sql) {
		
		Connection con=connect();
		int i=0;
		try {
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, sm.getSid());
			st.setString(2, sm.getSname());
			st.setString(3, sm.getCourse());
			st.setString(4, sm.getPassword());
			i=st.executeUpdate();
			con.commit();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	public static ResultSet librarianLogin(LibrarianModel lm, String sql) {

		Connection con=connect();
		ResultSet rs=null;
		
		try {
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, lm.getLId());
			st.setString(2, lm.getPassword());
			rs=st.executeQuery();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return rs;
	}
	public static ResultSet getStudents(String sql) {
		Connection con=connect();
		ResultSet rs=null;
		try {
			PreparedStatement st=con.prepareStatement(sql);
			rs=st.executeQuery();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public static ResultSet getBookDetail(String title,String sql) {
		Connection con=connect();
		ResultSet rs=null;
		try {
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, title);
			rs=st.executeQuery();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public static int issueBook(int sid, int bid,String title, String sql) {
		
		Connection con=connect();
		int i=0;
		try {
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1,sid);
			st.setInt(2, bid);
			st.setString(3, title);
			i=st.executeUpdate();
			con.commit();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	public static ResultSet getIssuedBook(String sql) {
		Connection con=connect();
		ResultSet rs=null;
		try {
			PreparedStatement st=con.prepareStatement(sql);
			rs=st.executeQuery();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	public static ResultSet  getIssueHistory(String sql) {
		Connection con=connect();
		ResultSet rs=null;
		try {
			PreparedStatement st=con.prepareStatement(sql);
			rs=st.executeQuery();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public static int returnBook(int bid, String sql) {
		Connection con=connect();
		int i=0;
		
		try {
			PreparedStatement st=con.prepareStatement(sql);
			st.setTimestamp(1,new Timestamp(System.currentTimeMillis()) );
			st.setInt(2,bid);
			i=st.executeUpdate();
			String sql1="insert into IssueHistory select * from IssueBooks where bid="+bid+" ";
			String sql2="delete from issuebooks where bid="+bid+"";
					//st1.setInt(1, bid);
			PreparedStatement st1=con.prepareStatement(sql1);
					st1.executeUpdate();
			PreparedStatement st2=con.prepareStatement(sql2);
					st2.executeUpdate();
					con.commit();
				}catch(SQLException e)   {
					e.printStackTrace();
				}
				return i;
			}
	public static ResultSet studentLogin(StudentModel sm, String sql) {
		
		Connection con=connect();
		ResultSet rs=null;
		try {
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, sm.getSid());
			st.setString(2, sm.getPassword());
			rs=st.executeQuery();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public static ResultSet getMyBook(StudentModel sm, String sql) {
		Connection con=connect();
		ResultSet rs=null;
		try  {
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, sm.getSid());
			rs=st.executeQuery();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public static int modifyLibrarian(LibrarianModel lm, String sql) {
		
		Connection con=connect();
		int i=0;
		try {
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, lm.getLId());
			st.setString(2, lm.getName());
			st.setString(3, lm.getQualification());
			st.setString(4, lm.getAddress());
			st.setInt(5, lm.getLId());
			i=st.executeUpdate();
			con.commit();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	public static int deleteLibrarian(int lid, String sql) {

		Connection con=connect();
		int i=0;
		try {
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, lid);			
			i=st.executeUpdate();
			con.commit();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public static ResultSet getLib() {
		Connection con=connect();
		ResultSet rs=null;
		try {
			PreparedStatement st=con.prepareStatement("select * from Librarian");
			rs=st.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return rs;
	}
	public static int deleteStudent(int sid,String sql) {
		
		Connection con=connect();
		int i=0;
		try {
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, sid);
			i=st.executeUpdate();
			con.commit();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
				
}