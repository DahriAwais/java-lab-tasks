import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private String ISBN;
    private boolean isAvailable;
    private List<String> lendingHistory;

    // Constructor
    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isAvailable = true;
        this.lendingHistory = new ArrayList<>();
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public List<String> getLendingHistory() {
        return lendingHistory;
    }

    // Check out the book
    public void checkOutBook(String borrower) {
        if (isAvailable) {
            isAvailable = false;
            lendingHistory.add("Borrowed by: " + borrower);
            System.out.println("Book checked out successfully.");
        } else {
            System.out.println("Book is not available.");
        }
    }

    // Return the book
    public void returnBook(String returnDate) {
        if (!isAvailable) {
            isAvailable = true;
            lendingHistory.add("Returned on: " + returnDate);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("This book was not checked out.");
        }
    }

    // Display book details
    public void displayBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + ISBN);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
        System.out.println("Lending History: " + lendingHistory);
    }
}

class Library {
    private List<Book> books;

    // Constructor
    public Library() {
        this.books = new ArrayList<>();
    }

    // Add a book to the library
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added to the library.");
    }

    // Search for a book by title
    public Book searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        System.out.println("Book not found.");
        return null;
    }

    // Search for a book by ISBN
    public Book searchBookByISBN(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equalsIgnoreCase(ISBN)) {
                return book;
            }
        }
        System.out.println("Book not found.");
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Add sample books to the library
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084"));

        // Perform library operations
        boolean exit = false;
        while (!exit) {
            System.out.println("\nLibrary Operations:");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book by Title");
            System.out.println("3. Search Book by ISBN");
            System.out.println("4. Check Out Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String ISBN = scanner.nextLine();
                    library.addBook(new Book(title, author, ISBN));
                    break;
                case 2:
                    System.out.print("Enter book title to search: ");
                    title = scanner.nextLine();
                    Book foundBookByTitle = library.searchBookByTitle(title);
                    if (foundBookByTitle != null) {
                        foundBookByTitle.displayBookDetails();
                    }
                    break;
                case 3:
                    System.out.print("Enter book ISBN to search: ");
                    ISBN = scanner.nextLine();
                    Book foundBookByISBN = library.searchBookByISBN(ISBN);
                    if (foundBookByISBN != null) {
                        foundBookByISBN.displayBookDetails();
                    }
                    break;
                case 4:
                    System.out.print("Enter book title to check out: ");
                    title = scanner.nextLine();
                    Book bookToCheckOut = library.searchBookByTitle(title);
                    if (bookToCheckOut != null) {
                        System.out.print("Enter borrower name: ");
                        String borrower = scanner.nextLine();
                        bookToCheckOut.checkOutBook(borrower);
                    }
                    break;
                case 5:
                    System.out.print("Enter book title to return: ");
                    title = scanner.nextLine();
                    Book bookToReturn = library.searchBookByTitle(title);
                    if (bookToReturn != null) {
                        System.out.print("Enter return date: ");
                        String returnDate = scanner.nextLine();
                        bookToReturn.returnBook(returnDate);
                    }
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }

        scanner.close();
    }
}
