package suncertify.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.logging.Logger;

import javax.swing.*;

/**
 * 
 */
public class UIBuilder {

    private static final Logger LOG = Logger
            .getLogger(SimpleSwingApplication.class.getName());
    private static final String WINDOW_TITLE = "URLyBird Room Bookings";

    public JFrame buildUserInterface() {
        // Create and set up the window.
        JFrame frame = new URLyBirdFrame(WINDOW_TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set up the content pane.
        addComponentsToPane(frame.getContentPane());

        // Use the content pane's default BorderLayout. No need for
        // setLayout(new BorderLayout());
        // Display the window.
        frame.pack();
        frame.setVisible(true);

        return frame;
    }

    public void addComponentsToPane(Container pane) {

        // Center is the JTable
        JScrollPane scrollPane = new JScrollPane(buildTable());
        pane.add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * @return
     */
    private JTable buildTable() {
        String[] columnNames = { "Hotel Name", "Location", "Size",
                "Smoking Allowed", "Room Rate", "Booking Date", "Owner" };

        Object[][] data = new Object[10][7];
        for (int i = 0; i < data.length; i++) {
            data[i] = new Object[] { "Name " + i, "Brighton", i, "No", "20.00",
                    "12/12/2012", "B. Fawlty" };
        }

        JTable table = new JTable(data, columnNames);

        table.setFillsViewportHeight(true);
        table.setColumnSelectionAllowed(false);
        // table.setCellSelectionEnabled(false);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setAutoCreateRowSorter(true);

        return table;
    }

    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);

        final UIBuilder builder = new UIBuilder();

        // Schedule a job for the event dispatch thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                builder.buildUserInterface();
            }
        });
    }
}
