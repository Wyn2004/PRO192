package Module;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

public class Library {

	private List<Book> listBook = new ArrayList<>();

	public Library(List<Book> listBook) {

		this.listBook = listBook;
	}

	public Library() {
		try {
			loadData();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Book> getListBook() {
		return listBook;
	}

	public void setListBook(List<Book> listBook) {
		this.listBook = listBook;
	}

	public void loadData() throws FileNotFoundException {

		FileReader fr = new FileReader("lib.txt");
		try (BufferedReader reader = new BufferedReader(fr)) {
			String line;
			while ((line = reader.readLine()) != null) {

				String[] tokens = line.split(", ");
				String bookID = tokens[0].trim();
				String bookTitile = tokens[1].trim();
				String author = tokens[2].trim();
				Date dob = Validator.parseDate(tokens[3].trim());
				Book book = new Book(bookID, bookTitile, author, dob);
				this.listBook.add(book);
				Collections.sort(this.listBook);
			}
			Collections.sort(listBook);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void displayLibrary(List<Book> list) {
		if (!listBook.isEmpty()) {
			System.out.println("List of books");
			System.out.println("---------------------------------------------------------------");
			for (Book book : list) {
				System.out.println(book.toString());
			}
			System.out.println("---------------------------------------------------------------");
			System.out.println("Total : " + list.size());
		} else
			System.err.println("List book is empty!!!");
	}

	public void add() {
		String bookID = Validator.inputString("Enter book ID: ").toUpperCase();
		String bookTitle = Validator.inputString("Enter book title: ");
		String autthor = Validator.inputString("Enter author: ");
		Date datePublic = Validator.inputDate("Enter date public: ");
		Book newBook = new Book(bookID, bookTitle, autthor, datePublic);
		this.listBook.add(newBook);
		Collections.sort(this.listBook);
		System.out.println("Donee !!!");
	}

	public void searchBook(Predicate<Book> p) {
		List<Book> bookSearch = new ArrayList<>();
		for (Book book : listBook)	{
			if (p.test(book))
				bookSearch.add(book);
		}
		displayLibrary(bookSearch);
	}

}
