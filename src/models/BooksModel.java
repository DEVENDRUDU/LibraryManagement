package models;

public class BooksModel {
	private int totalcopies;
	private String title;
	private String author;
	public int getTotalCopies() {
		return totalcopies;
	}
	public void setTotalCopies(int totalcopies) {
		this.totalcopies = totalcopies;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
