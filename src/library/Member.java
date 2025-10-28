package library;

import java.util.ArrayList;
import java.util.List;

/**
 * A Member class with GRASP Principles
 * @author kedithwuensche
 */
public class Member {

	// GRASP Principle: Information Expert and Low Coupling
	// Can borrow and return books.
	private final int memberId;
	private String name;
	private final List<Book> borrowedBooks;
	
	public Member(int memberId, String name){
		this.memberId = memberId;
		this.name = name;
		this.borrowedBooks = new ArrayList<>();
	}
	
	// TODO: implement functionality of Member class
	
	//Information Expert 
	
	//Borrow
	public boolean borrowBook(Book book) {
		if(book == null) {
			return false;
		}
		
		if(borrowedBooks.contains(book)) { // check if book exists in list
			return false;
		}else {
			return borrowedBooks.add(book);
		}
	}
	
	//Return
	public boolean returnBook(Book book){
		if(book == null) {
			return false;
		}else {
			return borrowedBooks.remove(book); 
		}
	}
	
	//Check if Member has book
	public boolean hasBorrowed(Book book) {
		if(book == null) {
			return false;
		}else {
			return borrowedBooks.contains(book);
		}
	}
	
	//Check members amount of books
	public int borrowedCount() {
		if(borrowedBooks.isEmpty()) {
			return 0;
		}else {
			return borrowedBooks.size();
		}
	}
	
	
	//Setters(Update if needed)
	public void setName(String name) {
		this.name = name;
	}



	//Getters
	public String getName() {
		return name;
	}
	
	
	public int getMemberId() {
		return memberId;
	}
	
	//Read members borrowed books
	public List<Book> getBorrowedBooks() {
		return new ArrayList<>(borrowedBooks);
	}

	
	
	
}
