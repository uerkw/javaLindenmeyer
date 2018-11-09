package com.kuerkwitz.Lsystem.UI;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class Project2GUI extends JFrame implements ActionListener {

    JTextField lhs[], rhs[], angle, startSymbol;
    JButton drawButton;
    JSpinner iterationSpinner;
    JLabel ruleLabels[], angleLabel, startLabel, spinnerLabel, iterationsLabel;
    ButtonGroup rootSelection;
    JRadioButton drawRootBottom, drawRootCorner, drawRootCenter;
    DisplayGraphics canvasPanel;
    static int rootX;
    static int rootY;

    public Project2GUI () {
        this.setTitle("L-Systems, K. Uerkwitz");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(buildGUI());
        this.pack();
        this.setVisible(true);
    }

    private JPanel buildGUI() {
        // Create Master JPanel
        JPanel ourGUI = new JPanel();

        //Create Element JPanels
        JPanel ButtonsPane = new JPanel();
        JPanel RulesPane = new JPanel();
        JPanel DrawPane = new JPanel();

        //Setup Layout Manager
        BoxLayout layoutManager = new BoxLayout(ourGUI, BoxLayout.Y_AXIS);
        ourGUI.setLayout(layoutManager);

        //Create Buttons and Fields
            //Radio Buttons:
        rootSelection = new ButtonGroup();
        rootSelection.add(drawRootBottom = new JRadioButton("Bottom"));
        rootSelection.add(drawRootCenter = new JRadioButton("Center"));
        rootSelection.add(drawRootCorner = new JRadioButton("Corner"));
            //Labels and Buttons
        angleLabel = new JLabel ("Angle: ");
        angle = new JTextField (4);
        startLabel = new JLabel ("Start Symbol: ");
        startSymbol = new JTextField(2);
        drawButton = new JButton ("Draw");
            //Iterations Spinner
        iterationsLabel = new JLabel("Iterations: ");
        iterationSpinner = new JSpinner(new SpinnerNumberModel(1,1,10,1));

        //Create Button Listener
        drawButton.addActionListener(this);

        //Setup Canvas to use, uses DisplayGraphics class
        canvasPanel = new DisplayGraphics();
        canvasPanel.setBackground(Color.white);
        canvasPanel.setPreferredSize(new Dimension(900, 750));
        canvasPanel.setBorder(new LineBorder(Color.BLACK));

        //Setup Button and Rules Pane
        ButtonsPane.setPreferredSize(new Dimension(550, 30));
        ButtonsPane.setMaximumSize(new Dimension(550, 50));
        RulesPane.setPreferredSize(new Dimension(900, 30));
        RulesPane.setMaximumSize(new Dimension(900, 50));

        //Add Buttons and Features to panes
        ButtonsPane.add(drawRootBottom);
        ButtonsPane.add(drawRootCenter);
        ButtonsPane.add(drawRootCorner);
        ButtonsPane.add(angleLabel);
        ButtonsPane.add(angle);
        ButtonsPane.add(startLabel);
        ButtonsPane.add(startSymbol);
        ButtonsPane.add(iterationsLabel);
        ButtonsPane.add(iterationSpinner);
        ButtonsPane.add(drawButton);


        DrawPane.add(canvasPanel);

        //Populate the Rules bar
        lhs = new JTextField[5];
        rhs = new JTextField[5];
        ruleLabels = new JLabel[5];

        for (int i = 0; i < 5; i++) {
            ruleLabels[i] = new JLabel("Rule "+i+" : ");
            RulesPane.add(ruleLabels[i]);
            lhs[i] = new JTextField(2);
            RulesPane.add(lhs[i]);
            rhs[i] = new JTextField(10);
            RulesPane.add(rhs[i]);
        }
        ourGUI.add(RulesPane);
        ourGUI.add(DrawPane);
        ourGUI.add(ButtonsPane);


        rootX = 900/2;
        rootY = 750;
        return ourGUI;
    }

    public void actionPerformed(ActionEvent arg0) {
        //TODO flesh out action listener to invoke the drawing process
        errorDialog("Something is supposed to happen here.");
    }
    private void errorDialog(String message){
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            System.err.println("Couldn't find class for specified look and feel");
            System.err.println("Using the default look and feel.");
        } catch (UnsupportedLookAndFeelException e) {
            System.err.println("Can't use the specified look and feel on this platform.");
            System.err.println("Using the default look and feel.");
            e.printStackTrace();
        } catch(InstantiationException e){
            System.err.println("Could not instantiate the look and feel");
            System.err.println("Using the default look and feel.");
        }catch (IllegalAccessException e) {
            System.err.println("Illegal access to look and feel.");
            System.err.println("Using the default look and feel.");
        }
        Project2GUI project2 = new Project2GUI();
    }

}