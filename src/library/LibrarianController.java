package library;

public class LibrarianController {

	// GRASP Principle: Controller
	// Handles user requests like borrowing and returning books.
	// Delegates tasks to the appropriate objects (each object updates its own attributes):
	// - book updates isAvailable
	// - library updates availableBooks list and memberBorrowedBooks map
	// - member updates borrowedBooks
	
	// TODO: implement functionality of Member class
	private Library library;
	
	public LibrarianController(Library library) {
		this.library = library; // gives controller access to book and member lists
	}
	
	public void borrowBook(Member m, Book b) { // check if book is available
		b.borrow(); // book state changes	
		library.borrowBook(b, m); // library updates
		m.borrowBook(b); // member book list updates
	}
	
	public void returnBook(Member m, Book b) {
		b.returnBook();
		library.returnBook(b, m);
		m.returnBook(b);
	}

}
