package library;

import java.util.ArrayList;
import java.util.HashMap;

public class Library {
	
	//  GRASP Principles: Creator, Controller
	//	Manage the catalog of books and members.
	//	Track which books are borrowed and available
	
	
	// Attributes:
	// private catalog (list of Book) 
	// private members (list of Members)

	// TODO: implement functionality of Member class
	 private ArrayList<Book> availableBooks = new ArrayList<>();
	 private HashMap<Member, ArrayList<Book>> memberBorrowedBooks = new HashMap<>();
	 
	 public void addBook(Book book) {
	     availableBooks.add(book);
	     System.out.println(book + " has been added to the catalog.");
	 }

	 // Adds a new member to the library (without a separate class)
	 public void addMember(Member member) {
	     if (!memberBorrowedBooks.containsKey(member)) {
	         memberBorrowedBooks.put(member, new ArrayList<>());
	         System.out.println("Member " + member + " has been added.");
	     } else {
	         System.out.println("Member " + member + " already exists.");
	     }
	 }
	 
	 // Show the available books in the library
	 public void showAvailableBooks() {
	     System.out.println("Available Books:");
	     for (Book book : availableBooks) {
	         System.out.println(book);
	     }
	 }

	//Show members of in the library
	public void showMembers() {
	   System.out.println("Library members:");
	   for (Member member : memberBorrowedBooks.keySet()) {
	       System.out.println(member);
	   }
	}

	//Find member by name
	public Member findMemberByName(String name){
		if(name == null){
			return null;
		}
		for(Member member : memberBorrowedBooks.keySet()){
			if(member.getName() != null && member.getName().equals(name)){
				return member;
			}
		}
		return null;
	}

	//Find book by title
	public Book findBookByTitle(String title){
		if(title == null){
			return null;
		}
		for(Book book : availableBooks){
			if(book.getTitle() != null && book.getTitle().equals(title)){
				return book;
			}
		}
		return null;
	}
	
	 // Borrow a book from the library
	public void borrowBook(Book b, Member m) {
	    if (!memberBorrowedBooks.containsKey(m)) {
	        System.out.println("Member " + m + " not found.");
	        return;
	    }
	    if (availableBooks.contains(b)) {
	        availableBooks.remove(b);
	        memberBorrowedBooks.get(m).add(b);
	        System.out.println(m + " has successfully borrowed " + b);
	    } else {
	        System.out.println(b + " is either already borrowed or not available.");
	    }
	}
	
	 // Return a book to the library
	 public void returnBook(Book b, Member m) {
	     if (!memberBorrowedBooks.containsKey(m)) {
	         System.out.println("Member " + m + " not found.");
	         return;
	     }

	     if (memberBorrowedBooks.get(m).contains(b)) {
	         memberBorrowedBooks.get(m).remove(b);
	         availableBooks.add(b);
	         System.out.println(m + " has successfully returned " + b);
	     } else {
	         System.out.println(m + " didn't borrow " + b);
	     }
	 }
}
