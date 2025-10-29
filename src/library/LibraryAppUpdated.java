package library;
// Updated verion of Library Management System
// LibrarianController lc handles user requests
// Library library displays current state


public class LibraryAppUpdated {
  
public static void main(String[] args) {
	
	Library library = new Library();
	LibrarianController lc = new LibrarianController(library);
	
	Book book1 = new Book("Dune", "Frank Herbert");
	Book book2 = new Book("1984", "George Orwell");
	Book book3 = new Book("Moby Dick", "Herman Melville");
	
	Member member1 = new Member(1, "Alice");
	Member member2 = new Member(2, "Bob");
	
	// Adding books
	System.out.println("\n *** Adding \"Dune\" to the library:");
	library.addBook(book1);
	
	System.out.println("\n *** Adding \"1984\" to the library:");
	library.addBook(book2); 
	
	System.out.println("\n *** Adding \"Moby Dick\" to the library:");
    library.addBook(book3);
    
    // Show available books
    System.out.println("\n *** Show all books:");
    library.showAvailableBooks();

    // Adding members
    System.out.println("\n *** Adding \"Alice\" to the library members");
    library.addMember(member1);
    
    System.out.println("\n *** Adding \"Bob\" to the library members");
    library.addMember(member2);
    
    // Show members
    System.out.println("\n *** Show all members");
    library.showMembers();
    
    
    
    
    // Borrow a book
    System.out.println("\n *** Alice borrows Dune:");
    lc.borrowBook(member1, book1);

    // Show available books after borrowing
    System.out.println("\n *** Show all books:");
    library.showAvailableBooks();

    System.out.println("\n *** Bob borrows 1984:");
    lc.borrowBook(member2, book2);
    
    // Show available books after borrowing
    System.out.println("\n *** Show all books:");
    library.showAvailableBooks();
    
    System.out.println("\nBob borrows Dune:");
    lc.borrowBook(member2, book1);
    
    // Show available books after borrowing
    System.out.println("\n *** Show all books:");
    library.showAvailableBooks();
    
    
    // Return a book
    System.out.println("\n *** Alice returns Dune:");
    lc.returnBook(member1, book1);

    // Show available books after returning
    System.out.println("\n *** Show all books:");
    library.showAvailableBooks();

    System.out.println("\n *** Bob borrows Dune:") ;
    lc.borrowBook(member2, book1);
    
    // Show available books after borrowing
    System.out.println("\n *** Show all books:");
    library.showAvailableBooks();
	}
}