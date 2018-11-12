package com.kuerkwitz.Lsystem.UI;

import java.awt.*;
import java.awt.geom.Line2D;
import javax.swing.*;

import static com.kuerkwitz.Lsystem.UI.Project2GUI.drawingLines;

public class DisplayGraphics extends JPanel {
    private Color[] lineColor = new Color[10];
    DisplayGraphics(){
        lineColor[0]= new Color(92, 40, 7);
        lineColor[1]= new Color(123, 53, 10);
        lineColor[2]= new Color(182, 79, 14);
        lineColor[3]= new Color(255, 153, 0);
        lineColor[4]= new Color(108, 133, 69);
        lineColor[5]= new Color(131, 161, 84);
        lineColor[6]= new Color(171, 210, 110);
        lineColor[7]= new Color(147, 241, 50);
        lineColor[8]= new Color(147, 241, 50);
        lineColor[9]= new Color(44, 218, 0);
    }
    @Override
    public void paint(Graphics g){
        // Call JPanel's Paint to take care of background and border.
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;

        // Initial Values for the lines
        g2.setColor(Color.black);
        g2.translate(Project2GUI.rootX, Project2GUI.rootY);

        // Loop through and draw every line
        if(drawingLines != null){
            int i = 0;
            for(Line2D.Double line : drawingLines){
                if(Project2GUI.colorsCheckBox.isSelected()) {
                    Color drawColor = Color.GREEN;
                    int colorValue = Project2GUI.drawingColors.get(i);
                    if (colorValue < 10) drawColor = lineColor[colorValue];
                    g2.setColor(drawColor);
                }
                g2.draw(line);
                i++;
            }
        }
        //Empty Memory values to prevent problems
        if(drawingLines != null) {
            Project2GUI.drawingLines.clear();
            Project2GUI.drawingColors.clear();
        }
    }
}