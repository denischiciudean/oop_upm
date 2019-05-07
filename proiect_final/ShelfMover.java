import java.util.Vector;

public class ShelfMover extends Shelf {


    public static Integer defaultShelvesNumber = 5;
    private static Integer number_of_books_per_shelf = 5;

    ShelfMover(Integer _n, Integer books_per_shelf) {
        super(books_per_shelf);
        defaultShelvesNumber = _n;
        number_of_books_per_shelf = books_per_shelf;
    }

    public static Vector<Shelf> moveShelves() {

        Vector<Shelf> new_shelves = new Vector<>();

        for (Integer i = 0; i < defaultShelvesNumber; i++) {

            Shelf new_shelf = new Shelf(number_of_books_per_shelf);
            new_shelf.index = i;
            new_shelves.addElement(new_shelf);

        }
        return new_shelves;
    }

}
