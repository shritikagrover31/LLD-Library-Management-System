import java.util.*;

public class Patron implements NotificationObserver {
    private final String id;
    private String name;
    private final List<Book> history;
    private final Set<String> currentBorrowedISBNs;

    public Patron(String id, String name) {
        this.id = id;
        this.name = name;
        this.history = new ArrayList<>();
        this.currentBorrowedISBNs = new HashSet<>();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public void addToHistory(Book book) { history.add(book); }
    public List<Book> getHistory() { return Collections.unmodifiableList(history); }

    public boolean hasBorrowed(String isbn) { return currentBorrowedISBNs.contains(isbn); }
    public void borrowBook(String isbn) { currentBorrowedISBNs.add(isbn); }
    public void returnBook(String isbn) { currentBorrowedISBNs.remove(isbn); }

    @Override
    public void notify(String message) {
        System.out.println("Notification for Patron " + name + ": " + message);
    }

    @Override
    public String toString() {
        return String.format("Patron[%s]: %s", id, name);
    }
}
