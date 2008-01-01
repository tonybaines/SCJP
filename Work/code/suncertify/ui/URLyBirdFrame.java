package suncertify.ui;

import javax.swing.JFrame;

/**
 * 
 */
public class URLyBirdFrame extends JFrame {

    /**
     * @param windowTitle
     */
    public URLyBirdFrame(String windowTitle) {
        super(windowTitle);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Use the content pane's default BorderLayout. No need for
        // setLayout(new BorderLayout());
        // Display the window.
        this.pack();
        this.setVisible(true);
    }

}
