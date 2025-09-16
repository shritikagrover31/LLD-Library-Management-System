import java.util.*;

public class ReservationManager extends NotificationSubject {
    private final Map<String, List<Patron>> reservationMap;

    public ReservationManager() {
        this.reservationMap = new HashMap<>();
    }

    public void reserveBook(String isbn, Patron patron) {
        reservationMap.computeIfAbsent(isbn, k -> new ArrayList<>()).add(patron);
    }

    public void notifyAvailability(String isbn) {
        List<Patron> patrons = reservationMap.getOrDefault(isbn, new ArrayList<>());
        for (Patron p : patrons) {
            p.notify("Book with ISBN " + isbn + " is now available!");
        }
        reservationMap.remove(isbn);
    }
}
