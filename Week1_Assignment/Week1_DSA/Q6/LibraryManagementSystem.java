import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Book {
    private int bookId;
    private String title;
    private String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

class Library {
    public static Book linearSearchByTitle(List<Book> books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearchByTitle(List<Book> books, String title) {
        // Ensure the list is sorted by title
        Collections.sort(books, Comparator.comparing(Book::getTitle));

        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Book midBook = books.get(mid);
            int comparison = midBook.getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return midBook;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "Effective Java", "Joshua Bloch"));
        books.add(new Book(2, "Clean Code", "Robert C. Martin"));
        books.add(new Book(3, "Java Concurrency in Practice", "Brian Goetz"));

        // Linear Search Example
        Book foundBook = Library.linearSearchByTitle(books, "Clean Code");
        System.out.println(foundBook);

        // Binary Search Example
        foundBook = Library.binarySearchByTitle(books, "Java Concurrency in Practice");
        System.out.println(foundBook);
    }
}
