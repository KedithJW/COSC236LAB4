package library;

import java.util.ArrayList;

/*
 * Library class implementing GRASP principles:
 * Creator and Controller.
 * 
 * Responsibilities:
 * - Manage the catalog of books and members.
 * - Track which books are borrowed and available.
 *
 *  @author dylancassid-y
 */

public class Library {

    // Attributes
    private ArrayList<Book> catalogue;
    private ArrayList<Member> members;

    public Library() {
        catalogue = new ArrayList<>();
        members = new ArrayList<>();
    }

    // Add a new Book to the catalogue
    public void addBook(String title, String author) {
        Book b = new Book(title, author);
        catalogue.add(b);
    }

    // Register a new Member
    public void registerMember(int memberID, String name) {
        Member m = new Member(memberID, name);
        members.add(m);
    }

    // Find Book by title (Information Expert)
    public Book findBookByTitle(String title) {
        for (Book b : catalogue) {
            if (b.getTitle().equals(title)) {
                return b;
            }
        }
        return null;
    }

    // Find Member by ID
    public Member findMemberByID(int id) {
        for (Member m : members) {
            if (m.getMemberId() == id) {
                return m;
            }
        }
        return null;
    }

    // CONTROLLER: Handles borrow and return requests
    public boolean borrowBook(int memberID, String title) {
        Member member = findMemberByID(memberID);
        Book book = findBookByTitle(title);

        if (member == null || book == null) {
            System.out.println("Invalid member or book.");
            return false;
        }

        if (book.isAvailable()) {
            if (member.borrowBook(book)) {
                book.borrow();
                System.out.println(member.getName() + " borrowed " + title);
                return true;
            }
        }else{
        	System.out.println("Book " + title + " is not available.");
        }
        return false;
    }

    public boolean returnBook(int memberID, String title) {
        Member member = findMemberByID(memberID);
        Book book = findBookByTitle(title);

        if (member == null || book == null) {
            System.out.println("Invalid member or book.");
            return false;
        }

        if (member.returnBook(book)) {
            book.returnBook();
            System.out.println(member.getName() + " returned " + title);
            return true;
        }
        return false;
    }

    // Display functions (High Cohesion)
    public void displayCatalogue() {
        System.out.println("=== Library Catalogue ===");
        for (Book b : catalogue) {
			if(isAvailable(b)){
            	System.out.println("- " + b.getTitle() + " (Available)");
			}else{
				System.out.println("- " + b.getTitle() + " (Borrowed)");	
        	}
		}
    }

    public void displayMembers() {
        System.out.println("=== Registered Members ===");
        for (Member m : members) {
            System.out.println("ID: " + m.getMemberId() + " | Name: " + m.getName());
        }
    }

	// Helper for controller
    public boolean isAvailable(Book b) {
        return catalogue.contains(b) && b.isAvailable();
    }
}
