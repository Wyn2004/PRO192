package Module;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Book implements Comparable<Book>{

	private String bookID;
	private String bookTitle;
	private String author;
	private Date datePublic;
	
	public Book(String bookID, String bookTitle, String author, Date datePublic) {

		this.bookID = bookID;
		this.bookTitle = bookTitle;
		this.author = author;
		this.datePublic = datePublic;
	}

	public Book() {

	}

	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getDatePublic() {
		return datePublic;
	}

	public void setDatePublic(Date datePublic) {
		this.datePublic = datePublic;
	}

	public String toString() {
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		return "Book{"+bookID + " - " + bookTitle + " - " + author + " - " + formatDate.format(datePublic) + "}";
	}

	@Override
	public int compareTo(Book o) {

		return bookTitle.compareTo(o.getBookTitle());
	}
	
	
}
