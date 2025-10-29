package library;


public class Book {
    private String title;
    private String author;
    private boolean isAvailable;

   public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public boolean borrow() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        } else {
            return false;
        }
    }


    public boolean returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "\"" + title + "\" by " + author + " [" + 
               (isAvailable ? "Available" : "Borrowed") + "]";
    }
}
