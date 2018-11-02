package com.kuerkwitz.Lsystem.UI;

import java.awt.*;
import javax.swing.*;

public class DisplayGraphics extends Canvas{


    public void paint(Graphics g) {
        try {
            //TODO Remove test code (next ~12 lines)
            g.drawLine(200, 200, 200, 40);
            Thread.sleep(200);
            g.drawLine(100, 100, 100, 40);
            Thread.sleep(200);
            g.drawLine(20, 20, 200, 40);
            Thread.sleep(200);
            g.drawLine(10, 10, 100, 40);
            Thread.sleep(200);
            g.drawLine(245, 329, 200, 40);
            Thread.sleep(200);
            g.drawLine(50, 60, 100, 40);
            Thread.sleep(200);
        }catch (Exception e) {
            //thread.sleep exception handling.
        }
    }
    public static void Start() {
        //Graphics drawing object.
        DisplayGraphics m=new DisplayGraphics();

        //Setup Main GUI
        JFrame f=new JFrame("LSystems - K. Uerkwitz");
        f.add(m);
        f.setSize(500,400);

        //Centering the window on screen, then displaying
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
        f.setVisible(true);

        // Setup Favicon for GUI Window
        final String faviconPath = "src/com/kuerkwitz/Lsystem/resources/favicon.png";
        final ImageIcon faviconIcon = new ImageIcon(faviconPath);
        final Image favicon = faviconIcon.getImage();
        f.setIconImage(favicon);

        // Message pop up to confirm window exit
        f.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(f,
                        "Are you sure you want to close this window?", "Close Window?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });

        //TODO Any other needed GUI elements
    }

    public static void main(String[] args){
        //TODO Delete test code, Main is not needed, only start is. Used to test the GUI Window
        System.out.println("Started Program");
        try{
            DisplayGraphics.Start();
        } catch (Exception e){
            System.out.println("Oops.");
        }
        System.out.println("Started Gui");
    }
}