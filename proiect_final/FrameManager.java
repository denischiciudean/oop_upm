//import frames.MainFrame;

import javax.swing.*;

class FrameManager {

    Biblioteca biblioteca = null;

    class MainFrame extends JFrame {

        private JLabel mainHeader = new JLabel("");

        MainFrame() {
            this.setTitle("Bibliothek - Main Frame");
            this.setBounds(700, 700, 1000, 1000);

            this.mainHeader.setBounds(400, 200, 200, 200);
            this.mainHeader.setText("Welcome to the library!");

            this.mainHeader.setVisible(true);
            this.setLayout(null);
            this.add(this.mainHeader);
            this.setVisible(true);
        }
    }

    JFrame mainFrame = new JFrame("Bibliothek - Main Frame");

    FrameManager() {


//        liftFrame = new JFrame("Bibliothek - Lift Frame");
//        liftFrame.setBounds(1000, 1000, 1000, 1000);
//
//        floorFrame = new JFrame("Bibliothek - Floor Frame");
//        floorFrame.setBounds(1000, 1000, 1000, 1000);
//
//        shelfFrame = new JFrame("Bibliothek - Shelf Frame");
//        shelfFrame.setBounds(1000, 1000, 1000, 1000);
//
//        bookFrame = new JFrame("Bibliothek - Book Frame");
//        bookFrame.setBounds(1000, 1000, 1000, 1000);
//
//        pageFrame = new JFrame("Bibliothek - Page Frame");
//        pageFrame.setBounds(1000, 1000, 1000, 1000);
    }


}
