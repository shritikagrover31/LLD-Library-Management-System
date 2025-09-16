import java.util.*;
import java.util.logging.*;

public class InventoryManager {
    private final Map<String, Book> books;
    private final Logger logger;

    public InventoryManager(Logger logger) {
        this.books = new HashMap<>();
        this.logger = logger;
    }

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
        logger.info("Added book: " + book);
    }

    public void removeBook(String isbn) {
        Book removed = books.remove(isbn);
        logger.info("Removed book: " + removed);
    }

    public void updateBookInfo(String isbn, String newTitle, String newAuthor, int newYear) {
        Book book = books.get(isbn);
        if (book != null) {
            book.setTitle(newTitle);
            book.setAuthor(newAuthor);
            book.setPublicationYear(newYear);
            logger.info("Updated book: " + book);
        }
    }

    public Book getBook(String isbn) { return books.get(isbn); }

    public List<Book> searchByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book b : books.values())
            if (b.getTitle().toLowerCase().contains(title.toLowerCase())) result.add(b);
        return result;
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book b : books.values())
            if (b.getAuthor().toLowerCase().contains(author.toLowerCase())) result.add(b);
        return result;
    }

    public Book searchByISBN(String isbn) {
        return books.get(isbn);
    }

    public Collection<Book> listAllBooks() {
        return Collections.unmodifiableCollection(books.values());
    }
}
