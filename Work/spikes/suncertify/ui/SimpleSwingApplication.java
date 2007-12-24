package suncertify.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * 
 */
public class SimpleSwingApplication {

    private static final Logger LOG = Logger
            .getLogger(SimpleSwingApplication.class.getName());
    private static final String WINDOW_TITLE = "Hotel Bookings";

    public static void addComponentsToPane(Container pane) {

        // Page-start is the toolbar
        JToolBar toolBar = buildToolBar(pane);
        pane.add(toolBar, BorderLayout.PAGE_START);

        // Center is the JTable
        JScrollPane scrollPane = new JScrollPane(buildTable());
        pane.add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * @return
     */
    private static JTable buildTable() {
        String[] columnNames = { "Hotel Name", "Location", "Size",
                "Smoking Allowed", "Room Rate", "Booking Date", "Owner" };

        Object[][] data = new Object[10][7];
        for (int i = 0; i < data.length; i++) {
            data[i] = new Object[] { "Name " + i, "Brighton", i, "No", "20.00",
                    "12/12/2012", "B. Fawlty" };
        }

        JTable table;
        try {
            table = new JTable(new HotelTableModel());
        } catch (IOException e) {
            table = new JTable();
        }

        table.setFillsViewportHeight(true);
        table.setColumnSelectionAllowed(false);
        // table.setCellSelectionEnabled(false);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setAutoCreateRowSorter(true);

        return table;
    }

    /**
     * @param frame
     *                TODO
     * @return
     */
    private static JToolBar buildToolBar(final Container pane) {
        JToolBar toolBar = new JToolBar(JToolBar.HORIZONTAL);
        toolBar.setFloatable(false);

        Button button = new Button("Previous");
        toolBar.add(button);

        button = new Button("Next");
        toolBar.add(button);
        button = new Button("First");
        toolBar.add(button);
        button = new Button("Last");
        toolBar.add(button);
        toolBar.addSeparator();
        button = new Button("Book");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent arg0) {
                String owner = JOptionPane.showInputDialog(pane,
                        "What is the name for the booking?", "Booking",
                        JOptionPane.YES_NO_OPTION);

                if (owner == null) {
                    LOG.info("Booking cancelled");
                } else if (owner.trim().equals("")) {
                    JOptionPane.showMessageDialog(pane,
                            "The name was empty.\nBooking Cancelled");
                } else {
                    LOG.info("Chosen Owner is: " + owner);
                }
            }
        });
        toolBar.add(button);
        toolBar.addSeparator();
        button = new Button("Help");
        toolBar.add(button);

        return toolBar;
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event dispatch thread.
     */
    private static void createAndShowGUI() {

        // Create and set up the window.
        JFrame frame = new JFrame(WINDOW_TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set up the content pane.
        addComponentsToPane(frame.getContentPane());

        // Use the content pane's default BorderLayout. No need for
        // setLayout(new BorderLayout());
        // Display the window.
        frame.pack();
        frame.setVisible(true);
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

        // Schedule a job for the event dispatch thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
