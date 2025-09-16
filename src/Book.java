public class Book {
    private final String isbn;
    private String title;
    private String author;
    private int publicationYear;
    private boolean available;

    public Book(String isbn, String title, String author, int publicationYear) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.available = true;
    }

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPublicationYear() { return publicationYear; }
    public boolean isAvailable() { return available; }

    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setPublicationYear(int year) { this.publicationYear = year; }

    public void markBorrowed() { this.available = false; }
    public void markReturned() { this.available = true; }

    @Override
    public String toString() {
        return String.format("Book[%s]: %s by %s (%d) [%s]",
                isbn, title, author, publicationYear, available ? "Available" : "Borrowed");
    }
}

