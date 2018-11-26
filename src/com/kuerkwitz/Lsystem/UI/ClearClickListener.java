package com.kuerkwitz.Lsystem.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static com.kuerkwitz.Lsystem.UI.Project2GUI.drawingLines;

/**
 * @author Kyle Uerkwitz
 * An action listener class for the "Clear" button in the canvas. Performs a simple
 * canvas repaint to clear any lines whenever the user desires.
 */
public class ClearClickListener implements ActionListener {
    DisplayGraphics canvas;

    /**
     * The constructor for when the "Clear" button is pressed.
     *
     * @param g     The graphics object passed by the main program. This allows direct manipulation
     *              of the canvas without import and allows calling .repaint()
     */
    public ClearClickListener(DisplayGraphics g){
        this.canvas = g;
    }

    /**
     *  The method invoked when the button is pressed. Uses the constructed DisplayGraphics object to directly
     *  manipulate the "canvas"
     *
     * @param e     The action being created by the button being clicked
     */
    public void actionPerformed(ActionEvent e) {
        Project2GUI.drawingLines.clear();
        Project2GUI.drawingColors.clear();
        canvas.repaint();
        //Empty Memory values to prevent problems
        if(drawingLines != null) {
            Project2GUI.drawingLines.clear();
            Project2GUI.drawingColors.clear();
        }
        System.gc();
        /*JOptionPane.showMessageDialog(null,
                "Canvas has been cleared.",
                "Clear Button Clicked",
                JOptionPane.WARNING_MESSAGE); */
    }
}
