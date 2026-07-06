import java.util.Arrays;
import java.util.Comparator;

public class LibrarySearch {

    public static Book linearSearchByTitle(Book[] books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearchByTitle(Book[] sortedBooks, String title) {
        int low = 0;
        int high = sortedBooks.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = sortedBooks[mid].getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return sortedBooks[mid];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book("B001", "The Pragmatic Programmer", "David Thomas"),
            new Book("B002", "Clean Code", "Robert Martin"),
            new Book("B003", "Introduction to Algorithms", "Thomas Cormen"),
            new Book("B004", "Design Patterns", "Erich Gamma"),
            new Book("B005", "Effective Java", "Joshua Bloch")
        };

        Book foundLinear = linearSearchByTitle(books, "Clean Code");
        System.out.println("Linear search result: " + foundLinear);

        Book[] sortedBooks = books.clone();
        Arrays.sort(sortedBooks, Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));

        Book foundBinary = binarySearchByTitle(sortedBooks, "Effective Java");
        System.out.println("Binary search result: " + foundBinary);
    }
}
