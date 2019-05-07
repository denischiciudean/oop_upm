import java.util.Vector;

public class Shelf extends BookWriter {

    Shelf(Integer _n) {
        super(_n);
        total_books = _n;
        moveBooks();
    }

    public Integer index;
    public Integer total_books = 0;

    private Vector<Book> books = new Vector<>();

    public void moveBooks() {
        books = writeBooks();
    }

    public Vector<Book> getBooks() {
        return books;
    }
}
