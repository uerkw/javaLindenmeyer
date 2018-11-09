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

        g2.setColor(Color.white);
        g2.translate(Project2GUI.rootX, Project2GUI.rootY);
        Line2D line = new Line2D.Double(0,0,399,-399);
        g2.draw(line);
        line = new Line2D.Double(0,-399,399,0);
        g2.draw(line);
        g2.drawString("Test", 0,-100);
    }
}