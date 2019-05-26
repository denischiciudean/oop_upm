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

    private JFrame shelfFrame;

    private JFrame bookFrame;

    private Integer currentPageNumber;

    private Page currentPage;

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
            Logger.LogStaticMessage("LIFT MOVING -- " + i);
        }


        call_lift_button.setBounds(0, 75, 75, 35);
        call_lift_button.addActionListener(e -> {

            if (userCurrentFloor == lift.currentFloor) {
//                call_lift_button.setVisible(false);

                call_lift(floors);

            } else {

                Thread call = new Thread(() -> lift.callLift(userCurrentFloor));
                Thread updateLiftLabel = new Thread(() -> {
                    while (call.isAlive()) {
                        liftCurrentFloorLabel.setText("Lift on floor : " + lift.currentFloor.toString());
                    }
                    call_lift(floors);
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

    private void call_lift(Integer[] floors) {
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

        if (shelfFrame != null){
            shelfFrame.setVisible(false);
        }

        JFrame frame = new JFrame("Shelf no: " + shelf.index.toString());
        frame.setSize(500,500);
        frame.setLayout(new FlowLayout());

        for (Book book : shelf.getBooks()) {
            JButton book_btn = new JButton("<html> "+book.name+" <br> "+book.author+"</html>");
            book_btn.setSize(50, 50);
            book_btn.addActionListener(e -> readBook(book));
            frame.add(book_btn);
        }

        shelfFrame = frame;
        shelfFrame.setVisible(true);

    }

    private void readBook(Book book){

        if(bookFrame != null){
            bookFrame.setVisible(false);
        }

        JFrame frame = new JFrame(book.name);
        frame.setSize(500,500);
        frame.setLayout(new CardLayout());

        currentPage = book.pages.firstElement();
        currentPageNumber = 0;

        JPanel pane = new JPanel();
        pane.setSize(250,250);
        JTextArea content = new JTextArea(currentPage.getPage_content());
        content.setEditable(false);

        content.setLineWrap(true);
        content.setPreferredSize(new Dimension(500,250));

        JLabel pageNr = new JLabel(currentPage.getPageNumber().toString());


        JButton next = new JButton("next page");
        next.addActionListener(e -> {
            if(currentPageNumber < 9){
                this.currentPage = book.pages.elementAt(currentPageNumber+1);
                this.currentPageNumber += 1;
                content.setText(currentPage.getPage_content());
                pageNr.setText(currentPage.getPageNumber().toString());
                frame.revalidate();
            }
        });

        JButton prev = new JButton("prev page");
        prev.addActionListener(e -> {
            if(currentPageNumber > 0){
                this.currentPage = book.pages.elementAt(currentPageNumber-1);
                this.currentPageNumber -= 1;
                content.setText(currentPage.getPage_content());
                pageNr.setText(currentPage.getPageNumber().toString());
                frame.revalidate();
            }
        });

        pane.add(content);

        pane.add(prev);
        pane.add(pageNr);

        next.setSize(100,100);
        pane.add(next);
        frame.add(pane);

        bookFrame = frame;
        bookFrame.setVisible(true);

    }

    public static void main(String args[]) {

        FinalProject main = new FinalProject();

        Logger logger = Logger.getInstance();
        logger.logMessage("Opened Library!");

        Logger.LogStaticMessage("statically");

        logger.close();
    }


}
