package com.kuerkwitz.Lsystem.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.kuerkwitz.Lsystem.UI.Project2GUI.drawingLines;

public class ClearClickListener implements ActionListener {
    DisplayGraphics canvas;
    public ClearClickListener(DisplayGraphics g){
        this.canvas = g;
    }
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
