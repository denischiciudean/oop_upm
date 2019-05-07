import java.util.Random;
import java.util.Vector;

public class Biblioteca extends ShelfMover {

    Biblioteca(Integer _number_of_shelves_per_floor, Integer _number_of_floors, Integer _number_of_books_per_shelf) {
        super(_number_of_shelves_per_floor, _number_of_books_per_shelf);
        number_of_floors = _number_of_floors;

        categories.addElement("Fantasy");
        categories.addElement("Drama");
        categories.addElement("Adventure");
        categories.addElement("Cop");
        categories.addElement("Kids");

        /* Build Library */

        buildFloors();

        /* Move Empty Shelves*/

        for (Floor floor : floors) {
            floor.shelves = ShelfMover.moveShelves();
        }
    }

    private Integer number_of_floors;

    public Integer getNumber_of_floors() {
        return number_of_floors;
    }

    private void setFloors(Vector<Floor> floors) {
        this.floors = floors;
    }

    /*
      Clasa Imbricata
     */
    private class Floor {

        private Integer number;
        private String category;

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        private Vector<Shelf> shelves;

        public Vector<Shelf> getShelves() {
            return shelves;
        }
    }

    private Vector<String> categories = new Vector<>();

    private void buildFloors() {
        Random random = new Random();

        Vector<Floor> new_floors = new Vector<>();

        for (Integer i = 0; i < number_of_floors; i++) {
            Floor new_floor = new Floor();
            new_floor.setCategory(categories.elementAt(random.nextInt(5)));
            new_floor.setNumber((i + 1));
            new_floors.addElement(new_floor);
        }
        this.setFloors(new_floors);
    }

    private Vector<Floor> floors;

    public String getFloorNumber(Object floor) {
        return ((Floor) floor).getCategory();
    }

    public Integer getFloorCategory(Object floor) {
        return ((Floor) floor).getNumber();
    }

    public Object getIterator() {
        return floors.firstElement();
    }

    public Vector<Shelf> getFloorShelves(Object floor) {
        return ((Floor) floor).getShelves();
    }

    public Object nextFloor(Object current) {
        return (floors.indexOf(((Floor) current)) + 1 < floors.size()) ? floors.elementAt(floors.indexOf(((Floor) current)) + 1) : null;
    }

}
