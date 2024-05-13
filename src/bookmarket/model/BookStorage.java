package bookmarket.model;

import java.util.ArrayList;

public class BookStorage {

	ArrayList<Book> bookList;

	public BookStorage() {
		bookList = new ArrayList<Book>();
	}

	public int getNumBooks() {
		return bookList.size();
	}

	public String getBookInfo(int i) {
		return bookList.get(i).toString();
	}
	
	public boolean isValidBook(int bookId) {
		for (Book book : bookList) {
			if (book.getBookId() == bookId)
				return true;
		}
		return false;
	}

	public Book getBookId(int bookId) {
		for (Book book : bookList) {
			if (book.getBookId() == bookId)
				return book;
		}
		return null;
	}

}
