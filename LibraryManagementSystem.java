import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private boolean isCheckedOut;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isCheckedOut = false; // Initially, book is available
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    @Override
    public String toString() {
        return "'" + title + "' by " + author + " - " + (isCheckedOut ? "Checked out" : "Available");
    }
}

class LibraryCatalog {
    private List<Book> books;

    public LibraryCatalog() {
        this.books = new ArrayList<>();
    }

    public void addBook(String title, String author) {
        Book newBook = new Book(title, author);
        books.add(newBook);
    }

    public Book searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; // Book not found
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public boolean checkOut(String title) {
        Book book = searchByTitle(title);
        if (book != null && !book.isCheckedOut()) {
            book.setCheckedOut(true);
            return true; // Successfully checked out
        }
        return false; // Book not found or already checked out
    }

    public boolean returnBook(String title) {
        Book book = searchByTitle(title);
        if (book != null && book.isCheckedOut()) {
            book.setCheckedOut(false);
            return true; // Successfully returned
        }
        return false; // Book not found or already available
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (!book.isCheckedOut()) {
                System.out.println(book);
            }
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryCatalog library = new LibraryCatalog();

        // Adding books to the library
        library.addBook("Kosala", "Bhalchandra Nemade");
        library.addBook("Shyamchi Aai", "Pandurang Sadashiv Sane");
        library.addBook("Swami", "Ranjit Desai");

        // Display available books
        library.displayAvailableBooks();

        // Checking out a book
        System.out.println("\nChecking out 'Kosala'...");
        boolean checkoutResult = library.checkOut("Kosala");
        if (checkoutResult) {
            System.out.println("Book checked out successfully.");
        } else {
            System.out.println("Sorry, the book is not available or already checked out.");
        }

        // Display available books after checkout
        System.out.println("\nAvailable Books after checkout:");
        library.displayAvailableBooks();

        // Returning a book
        System.out.println("\nReturning 'Kosala'...");
        boolean returnResult = library.returnBook("Kosala");
        if (returnResult) {
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Error: Book not found or already available.");
        }

        // Display available books after return
        System.out.println("\nAvailable Books after return:");
        library.displayAvailableBooks();
    }
}
