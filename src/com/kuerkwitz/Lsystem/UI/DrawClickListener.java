package com.kuerkwitz.Lsystem.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawClickListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,
                "Something is supposed to happen here",
                "Draw Button Clicked!",
                JOptionPane.WARNING_MESSAGE);
    }
}
