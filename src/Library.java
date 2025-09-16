import java.util.*;

public class Library {
    private final InventoryManager inventoryManager;
    private final PatronManager patronManager;
    private final LendingManager lendingManager;
    private final ReservationManager reservationManager;

    public Library() {
        var logger = LoggerConfig.getLogger();
        this.inventoryManager = new InventoryManager(logger);
        this.patronManager = new PatronManager();
        this.lendingManager = new LendingManager(inventoryManager, patronManager, logger);
        this.reservationManager = new ReservationManager();
    }

    // Public APIs to add, update, search, checkout, reserve, etc.
    // Sample demonstration can be coded in a main() method.

    public static void main(String[] args) {
        Library lib = new Library();

        // Add books and patrons
        Book b1 = BookFactory.createBook("1", "Clean Code", "Robert C. Martin", 2008);
        lib.inventoryManager.addBook(b1);

        Patron p1 = new Patron("100", "Alice");
        lib.patronManager.addPatron(p1);

        Patron p2 = new Patron("101", "Jane");
        lib.patronManager.addPatron(p2);

        // Checkout and return book
        lib.lendingManager.checkoutBook("1", "100");
        lib.lendingManager.returnBook("1", "100");

        // Reservation and notification example
        lib.reservationManager.reserveBook("1", p2);
        lib.reservationManager.notifyAvailability("1");
    }
}
