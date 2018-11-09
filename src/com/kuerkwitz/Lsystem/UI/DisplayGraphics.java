package com.kuerkwitz.Lsystem.UI;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class DisplayGraphics extends JPanel {

    @Override
    public void paint(Graphics g){

        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;

        // Initial Values
        g2.setColor(Color.black);
        g2.translate(Project2GUI.rootX, Project2GUI.rootY);

        // Loop through and draw every line
        if(Project2GUI.drawingLines != null) for(Line2D.Double line : Project2GUI.drawingLines){
            g2.draw(line);
        }

        //TODO Remove test:
        g2.setFont(new Font("Arial", Font.PLAIN, 20));
        g2.drawString("Test", 0,0);
    }
}