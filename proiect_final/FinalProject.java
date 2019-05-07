import logger.*;

import java.util.Vector;

class FinalProject {

    public static void main(String args[]) {

        Logger logger = Logger.getInstance();
        logger.logMessage("Opened Library!");

        Biblioteca biblioteca = new Biblioteca(6, 6, 6);

        Object floor = biblioteca.getIterator();

        while (floor != null) {
            System.out.println("Floor number:" + biblioteca.getFloorCategory(floor));
            System.out.println("Floor Category:" + biblioteca.getFloorNumber(floor));
            for (Shelf shelf : biblioteca.getFloorShelves(floor)) {

                System.out.println("--- Shelf index:" + shelf.index);
                for (Book book : shelf.getBooks()) {
                    System.out.println("------ Book name:" + book.name);
                    System.out.println("------ Book author:" + book.author);
                    System.out.println("------------------------------------");
                }

            }
            System.out.println("-------------------------");
            floor = biblioteca.nextFloor(floor);
        }

        logger.close();
    }
}