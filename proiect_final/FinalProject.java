import lift.Lift;
import logger.*;
import pages.Page;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class FinalProject {


    private Integer userCurrentFloor = 0;

    private Integer maxFloors = 5;

    private Lift lift = new Lift(maxFloors);

    private Biblioteca biblioteca = new Biblioteca(6, maxFloors, 10);

    private JFrame mainFrame = new JFrame("Bibliothek");

    private JPanel liftPanel = new JPanel(null);

    private JLabel label = new JLabel();
    private JLabel liftUserCurrentFloorLabel = new JLabel("Your floor : " + userCurrentFloor.toString());
    private JLabel liftCurrentFloorLabel = new JLabel("Lift on floor : " + lift.currentFloor.toString());
    private JButton call_lift_button = new JButton("Call");
    private JDialog operateLift = new JDialog();
    private JPanel currentFloorView;


    FinalProject() {
        prepareGui();
    }

    public void prepareGui() {

        mainFrame.setSize(750, 500);

        mainFrame.setLayout(null);

        label.setText("Welcome to the library");
        label.setBounds(mainFrame.getWidth() / 4, mainFrame.getHeight() / 400, 250, 250);

        liftPanel.setSize(500, 500);

        liftCurrentFloorLabel.setBounds(0, 0, 100, 35);
        liftCurrentFloorLabel.setVisible(true);

        liftUserCurrentFloorLabel.setBounds(0, 35, 100, 35);
        liftUserCurrentFloorLabel.setVisible(true);

        operateLift.setSize(350, 350);

        Integer[] floors = new Integer[biblioteca.getNumber_of_floors() + 1];

        floors[0] = 0;

        System.out.println(floors.length);

        for (int i = 1; i < biblioteca.getNumber_of_floors(); i++) {
            floors[i] = biblioteca.getFloorNumber(biblioteca.getFloor(i));
        }


        call_lift_button.setBounds(0, 75, 75, 35);
        call_lift_button.addActionListener(e -> {

            if (userCurrentFloor == lift.currentFloor) {
//                call_lift_button.setVisible(false);

                Thread moveLift = new Thread(() -> {
                    Object selected = JOptionPane.showInputDialog(operateLift, "Where to?", "Selection", JOptionPane.PLAIN_MESSAGE, null, floors, "0");
                    if (selected != null) {
                        Thread gotoFloor = new Thread(() -> {
                            lift.goToFloor((Integer) selected);
                        });
                        Thread updateLabels = new Thread(() -> {
                            while (gotoFloor.isAlive()) {
                                liftCurrentFloorLabel.setText("Lift on floor : " + lift.currentFloor.toString());
                                liftUserCurrentFloorLabel.setText("Your floor : " + lift.currentFloor.toString());
                                userCurrentFloor = lift.currentFloor;
                            }
                            liftCurrentFloorLabel.setText("Lift on floor : " + lift.currentFloor.toString());
                            liftUserCurrentFloorLabel.setText("Your floor : " + lift.currentFloor.toString());
                            if ((Integer) selected != 0) {
                                displayFloor();
                            } else {
                                currentFloorView = null;
                                mainFrame.revalidate();
                            }
                        });
                        gotoFloor.start();
                        updateLabels.start();
                    }
                });

                moveLift.start();

            } else {

                Thread call = new Thread(() -> lift.callLift(userCurrentFloor));
                Thread updateLiftLabel = new Thread(() -> {
                    while (call.isAlive()) {
                        liftCurrentFloorLabel.setText("Lift on floor : " + lift.currentFloor.toString());
                    }
                    Thread moveLift = new Thread(() -> {
                        Object selected = JOptionPane.showInputDialog(operateLift, "Where to?", "Selection", JOptionPane.PLAIN_MESSAGE, null, floors, "0");
                        if (selected != null) {
                            Thread gotoFloor = new Thread(() -> {
                                lift.goToFloor((Integer) selected);
                            });
                            Thread updateLabels = new Thread(() -> {
                                while (gotoFloor.isAlive()) {
                                    liftCurrentFloorLabel.setText("Lift on floor : " + lift.currentFloor.toString());
                                    liftUserCurrentFloorLabel.setText("Your floor : " + lift.currentFloor.toString());
                                    userCurrentFloor = lift.currentFloor;
                                }
                                liftCurrentFloorLabel.setText("Lift on floor : " + lift.currentFloor.toString());
                                liftUserCurrentFloorLabel.setText("Your floor : " + lift.currentFloor.toString());
                                if ((Integer) selected != 0) {
                                    displayFloor();
                                } else {
                                    currentFloorView = null;
                                    mainFrame.revalidate();
                                }
                            });
                            gotoFloor.start();
                            updateLabels.start();
                        }
                    });
                    moveLift.start();
                });

                call.start();
                updateLiftLabel.start();

            }

        });

        /*
        ADD COMPONENTS TO FRAME
         */

        liftPanel.add(liftUserCurrentFloorLabel);
        liftPanel.add(liftCurrentFloorLabel);
        liftPanel.add(call_lift_button);

        mainFrame.add(liftPanel);

        mainFrame.setLayout(new BorderLayout());
        mainFrame.setVisible(true);
    }

    private void displayFloor() {

        if (currentFloorView != null) {
            mainFrame.remove(currentFloorView);
        }

        System.out.println(userCurrentFloor);
        Object floor = biblioteca.getFloor(userCurrentFloor);

        JPanel floorView = new JPanel();
        floorView.setLayout(new FlowLayout());

        JLabel label = new JLabel("Shelves on current floor:");
        JLabel floorCategoryLabel = new JLabel(biblioteca.getFloorCategory(floor).toString());

        floorView.add(label);
        floorView.add(floorCategoryLabel);

        mainFrame.setLayout(new GridLayout());
        for (Shelf shelf : biblioteca.getFloorShelves(floor)) {
            JButton btn = new JButton("INDEX : " + shelf.index.toString() + " Books : " + shelf.total_books);
            btn.addActionListener(e -> displayBooks(shelf));
            floorView.add(btn);
        }

        currentFloorView = floorView;

        mainFrame.add(currentFloorView);
        mainFrame.revalidate();
    }

    private void displayBooks(Shelf shelf) {

        for (Book book : shelf.getBooks()) {
            System.out.println(book.name);
        }

    }


    public static void main(String args[]) {

        FinalProject main = new FinalProject();

        Logger logger = Logger.getInstance();
        logger.logMessage("Opened Library!");


//        Object floor = main.biblioteca.getIterator();
//        while (floor != null) {
//            System.out.println("Floor number:" + main.biblioteca.getFloorCategory(floor));
//            System.out.println("Floor Category:" + main.biblioteca.getFloorNumber(floor));
//            for (Shelf shelf : main.biblioteca.getFloorShelves(floor)) {
//
//                System.out.println("--- Shelf index:" + shelf.index);
//                for (Book book : shelf.getBooks()) {
//                    System.out.println("------ Book name:" + book.name);
//                    System.out.println("------ Book author:" + book.author);
//                    System.out.println("------------------------------------");
//                }
//
//            }
//            System.out.println("-------------------------");
//            floor = main.biblioteca.nextFloor(floor);
//        }

        logger.close();
    }


}
