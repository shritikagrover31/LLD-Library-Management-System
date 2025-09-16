import java.util.*;

public class PatronManager {
    private final Map<String, Patron> patrons;

    public PatronManager() {
        patrons = new HashMap<>();
    }

    public void addPatron(Patron patron) {
        patrons.put(patron.getId(), patron);
    }

    public void updatePatron(String id, String name) {
        Patron p = patrons.get(id);
        if (p != null) {
            p.setName(name);
        }
    }

    public Patron getPatron(String id) {
        return patrons.get(id);
    }

    public Collection<Patron> listAllPatrons() {
        return Collections.unmodifiableCollection(patrons.values());
    }
}
