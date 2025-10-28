package library;

public class LibrarianController {

	// GRASP Principle: Controller
	// Handles user requests like borrowing and returning books.
	// Delegates tasks to the appropriate objects.
	
	// TODO: implement functionality of Member class
	private Library library;
	
	public LibrarianController(Library library) {
		this.library = library; // gives controller access to book and member lists
	}
	
	public void borrowBook(Member m, Book b) {
		if(library.isAvailable(b)) { // check if book is available
			m.borrowBook(b); // delegate to member
			b.manageState(); // change book state
		}
		else
			System.out.println("Book unavailable");
	}
	
	public void returnBook(Member m, Book b) {
		m.returnBook(b);
		b.manageState();
	}

}
