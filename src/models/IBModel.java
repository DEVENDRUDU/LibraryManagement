package models;

public class IBModel {
	private int sid;
	private int bid;
	private String title;
	private String issuedate;
	private String returndate;
	public String getReturnDate() {
		return returndate;
	}
	public void setReturnDate(String returndate) {
		this.returndate = returndate;
	}
	public int getSId() {
		return sid;
	}
	public void setSId(int sid) {
		this.sid = sid;
	}
	public int getBId() {
		return bid;
	}
	public void setBId(int bid) {
		this.bid = bid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIssueDate() {
		return issuedate;
	}
	public void setIssueDate(String issuedate) {
		this.issuedate = issuedate;
	}
	
}
