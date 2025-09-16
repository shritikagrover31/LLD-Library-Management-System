import java.util.*;
import java.util.logging.*;

public class LendingManager {
    private final InventoryManager inventory;
    private final PatronManager patronManager;
    private final Logger logger;

    public LendingManager(InventoryManager inventory, PatronManager patronManager, Logger logger) {
        this.inventory = inventory;
        this.patronManager = patronManager;
        this.logger = logger;
    }

    public boolean checkoutBook(String isbn, String patronId) {
        Book book = inventory.getBook(isbn);
        Patron patron = patronManager.getPatron(patronId);
        if (book != null && patron != null && book.isAvailable()) {
            book.markBorrowed();
            patron.borrowBook(isbn);
            logger.info("Book checked out: " + book + " by " + patron);
            return true;
        }
        return false;
    }

    public boolean returnBook(String isbn, String patronId) {
        Book book = inventory.getBook(isbn);
        Patron patron = patronManager.getPatron(patronId);
        if (book != null && patron != null && !book.isAvailable() && patron.hasBorrowed(isbn)) {
            book.markReturned();
            patron.returnBook(isbn);
            patron.addToHistory(book);
            logger.info("Book returned: " + book + " by " + patron);
            return true;
        }
        return false;
    }
}
