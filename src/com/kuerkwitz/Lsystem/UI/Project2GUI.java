package com.kuerkwitz.Lsystem.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * @author Kyle Uerkwitz
 * The Main class for the GUI. This class contains the setup for the user interface,
 * creating the rule for the system to use, and the action listener for the draw buttom.
 */


public class Project2GUI extends JFrame implements ActionListener {

    private JTextField angle, startSymbol, initialAngle, lineLength;
    private JTextArea rulesField;
    private JButton drawButton, clearButton;
    private JSpinner iterationSpinner;
    private JLabel angleLabel, initialAngleLabel, startLabel, iterationsLabel, lineLengthLabel, rulesLabel;
    private ButtonGroup rootSelection;
    private JRadioButton drawRootBottom, drawRootCorner, drawRootCenter;
    static JCheckBox colorsCheckBox;
    private DisplayGraphics canvasPanel;
    static List<Line2D.Double> drawingLines;
    static List<Byte> drawingColors;
    static int rootX = 450;
    static int rootY = 750;

    /**
     * The constructor for the GUI window. Sets up some values and configures
     * the window by calling this.add( buildGUI() );
     */
    private Project2GUI () {
        //Declare drawing lines to use
        drawingLines = new ArrayList<>();
        drawingColors = new ArrayList<>();
        //Initialize Window
        this.setTitle("L-Systems, K. Uerkwitz");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(buildGUI());
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }

    /**
     *
     * @return
     */
    private JPanel buildGUI() {
        // Create Master JPanel
        JPanel masterGUI = new JPanel();

        //Create Element JPanels
        JPanel ButtonsPane = new JPanel();
        JPanel RightMasterPane = new JPanel();
        JPanel LeftMasterPane = new JPanel();

        // Setup Layout Managers
        BorderLayout masterLayoutManager = new BorderLayout(3, 0);
        masterGUI.setLayout(masterLayoutManager);
        // Layout Manager for Right Hand Side
        BoxLayout layoutManagerRight = new BoxLayout(RightMasterPane, BoxLayout.Y_AXIS);
        RightMasterPane.setLayout(layoutManagerRight);
        // Layout Manager for Left Hand Side
        BorderLayout layoutManagerLeft = new BorderLayout(0, 10);
        LeftMasterPane.setLayout(layoutManagerLeft);


        //Create Buttons and Fields
            //Radio Buttons:
        rootSelection = new ButtonGroup();
        rootSelection.add(drawRootBottom = new JRadioButton("Bottom"));
        rootSelection.add(drawRootCenter = new JRadioButton("Center"));
        rootSelection.add(drawRootCorner = new JRadioButton("Corner"));

            //Labels and Buttons
        initialAngleLabel = new JLabel ("Initial Angle: ");
        initialAngle = new JTextField(4);
        lineLengthLabel = new JLabel ("Line Length ");
        lineLength = new JTextField(4);
        angleLabel = new JLabel ("Angle: ");
        angle = new JTextField (4);
        startLabel = new JLabel ("Start Symbol: ");
        startSymbol = new JTextField(2);
        drawButton = new JButton ("Draw");
        clearButton = new JButton("Clear");
        rulesField = new JTextArea(6, 8);
        rulesLabel = new JLabel("Rules: ");

            //Iterations Spinner
        iterationsLabel = new JLabel("Iterations: ");
        iterationSpinner = new JSpinner(new SpinnerNumberModel(1,1,100,1));


        //Setup Canvas to use, uses DisplayGraphics class
        canvasPanel = new DisplayGraphics();
        canvasPanel.setBackground(Color.white);
        canvasPanel.setPreferredSize(new Dimension(900, 750));
        canvasPanel.setBorder(new LineBorder(Color.BLACK));

        //Create Button Listeners
        drawButton.addActionListener(this);
        clearButton.addActionListener(new ClearClickListener(canvasPanel));

        //Setup Button and Rules Pane
        ButtonsPane.setPreferredSize(new Dimension(900, 30));
        ButtonsPane.setMaximumSize(new Dimension(900, 50));
        rulesLabel.setPreferredSize(new Dimension(100, 30));
        LeftMasterPane.setPreferredSize(new Dimension(150, 200));
        LeftMasterPane.setMaximumSize(new Dimension(150, 200));


        //Add Buttons and Features to Button Pane
        ButtonsPane.add(initialAngleLabel);
        ButtonsPane.add(initialAngle);
        ButtonsPane.add(lineLengthLabel);
        ButtonsPane.add(lineLength);
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
        ButtonsPane.add(clearButton);

        // Content Setup for Rules Panel
        Box.Filler filler1 = new Box.Filler(new Dimension(150, 320),
                                            new Dimension(150, 320),
                                            new Dimension(150,320));
        Box.Filler filler2 = new Box.Filler(new Dimension(150, 300),
                                            new Dimension(150, 300),
                                            new Dimension(150,300));

        JPanel rulesContentPanel = new JPanel();
        colorsCheckBox = new JCheckBox("Use Colors?");

        BorderLayout rulesContentManager = new BorderLayout();
        rulesField.setPreferredSize(new Dimension(150, 100));
        rulesContentPanel.setLayout(rulesContentManager);
        rulesContentPanel.add(rulesLabel, rulesContentManager.PAGE_START);
        rulesLabel.setHorizontalAlignment(SwingConstants.CENTER);
        rulesContentPanel.add(rulesField, rulesContentManager.CENTER);
        rulesContentPanel.add(colorsCheckBox, rulesContentManager.PAGE_END);
        rulesField.setBorder(new LineBorder(Color.BLACK));
        LeftMasterPane.add(filler1, layoutManagerLeft.NORTH);
        LeftMasterPane.add(rulesContentPanel, layoutManagerLeft.CENTER);
        LeftMasterPane.add(filler2, layoutManagerLeft.SOUTH);


        masterGUI.add(LeftMasterPane, masterLayoutManager.WEST);
        RightMasterPane.add(canvasPanel);
        RightMasterPane.add(ButtonsPane);
        masterGUI.add(RightMasterPane, masterLayoutManager.EAST);

        return masterGUI;
    }

    /**
     * A method to quickly generate a new window with the default Java error symbol with a given message.
     * @param message   String to be displayed by the error popup.
     */
    private static void errorDialog(String message){
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
        } catch(InstantiationException e){
            System.err.println("Could not instantiate the look and feel");
            System.err.println("Using the default look and feel.");
        }catch (IllegalAccessException e) {
            System.err.println("Illegal access to look and feel.");
            System.err.println("Using the default look and feel.");
        }
        Project2GUI GUIBuild = new Project2GUI();
    }

    /**
     * A method to expand an initial rule string based on the rules defined by
     * user inputs.
     * @param initialString     The starting point for the expansion of the program
     * @param iterations        The number of times to expand the string
     * @param rules             The rules provided for the program to follow and expand each variable by if needed
     * @return                  The final queue used to provide instructions to the line construction.
     */
    private String expandRule(String initialString, int iterations, List<RuleSet> rules){

        Queue<Character> expansionQueue = new LinkedList<Character>();


        for(char character : initialString.toCharArray()){
            expansionQueue.add(character);
        }

        for(int i = 0; i < iterations; i++){

            int queueSize = expansionQueue.size();
            try {

            mainLoop:

            for(int j = 0; j < queueSize; j++){

                char currentSymbol = expansionQueue.remove();

                for(RuleSet rule : rules) {

                    if (rule.getVariable() == currentSymbol) {

                        for(char character: rule.getRules().toCharArray() ){
                            expansionQueue.add(character);
                        }
                        continue mainLoop;
                    }
                }

                if (currentSymbol != 'F' && currentSymbol != '+' && currentSymbol != '-' && currentSymbol != '['
                        && currentSymbol != ']'){
                    errorDialog("Expansion error. Start value or rules contain an undefined variable.");
                    return null;
                }
                    expansionQueue.add(currentSymbol);
                }

            } catch(OutOfMemoryError outOfMemoryError){

                // Handle if the user inputs too many iterations and the JAVA heap space limit is reached

                expansionQueue = null;

                errorDialog("Java could not allocate enough heap space to the expansion task. \n Please reduce " +
                    "the iterations and try again.");
                return null;
            }
        }
        StringBuilder stringBuild = new StringBuilder();
        while(!expansionQueue.isEmpty()){
            stringBuild.append(expansionQueue.remove());
        }

        return stringBuild.toString();

    }

    /**
     *
     * @param expanded              The expanded queue passed to calculate lines and angles
     * @param angle                 The angle to move left or right by for each angle operator
     * @param initAngle             The starting angle for the origin point of the lines drawn
     * @param lineSize              The size to draw each line at. Used to calculate final point values.
     * @throws OutOfMemoryError     Thrown when the Java heap space limit is reached, prevents errors from
     *                              overloading the iterations possible for the system to handle.
     */
    private void createLines(String expanded, double angle, double initAngle, double lineSize) throws OutOfMemoryError{
        //Clear any old lines from list
        drawingLines.clear();
        drawingColors.clear();

        //Starting values
        double posX = 0;
        double posY = 0;
        double currentAngle = initAngle;
        byte colorValue = 0;

        //Make a stack of position holding values
        Stack<LineVector> posStack = new Stack<>();

        //Iterate through every string value
        for (int i = 0; i < expanded.length(); i++) {

            char operation = expanded.charAt(i);

            if(operation == '-') currentAngle -= angle;

            else if (operation == '+') currentAngle += angle;

            else if (operation == '[') {
                posStack.push(new LineVector(posX, posY, currentAngle));

                colorValue++;
            }

            else if (operation == ']') {
                LineVector newDraw = posStack.pop();

                posX = newDraw.getPosX();
                posY = newDraw.getPosY();
                currentAngle = newDraw.getAngle();

                colorValue--;
            }

            else if (operation == 'F'){
                double newXPos = posX + lineSize * Math.cos(Math.toRadians(currentAngle));

                double newYPos = posY + lineSize * Math.sin(Math.toRadians(currentAngle));

                drawingLines.add(new Line2D.Double(posX, -posY, newXPos, -newYPos));
                drawingColors.add(colorValue);

                posX = newXPos;
                posY = newYPos;
            }
        }
    }

    /**
     * The event handler for the 'Draw' Button being clicked. This method performs the checking of fields and
     * grabs the data to be used. Then, it calls the respective computation components and repaints the canvas so
     * lines are displayed
     * @param arg0  The actionEvent being created by the event of the Draw button click
     */
    public void actionPerformed(ActionEvent arg0) {
        //Empty Memory values to prevent problems
        if(drawingLines != null) {
            Project2GUI.drawingLines.clear();
            Project2GUI.drawingColors.clear();
        }

        // Get the Angle value from UI
        String angleText = angle.getText();
        double angle;
        try {
            angle = Double.parseDouble(angleText);
        } catch (NumberFormatException e) {
            errorDialog("Angle field must be a decimal formatted number.");
            return;
        }

        // Get the Line Length value
        double lineLengthValue;
        try {
            lineLengthValue = Double.parseDouble(lineLength.getText());
        } catch (NumberFormatException e) {
            errorDialog("Line length field must be a decimal formatted number.");
            return;
        }

        // Get the Initial Angle value
        double initialAngleValue;
        try {
            initialAngleValue = Double.parseDouble(initialAngle.getText());
        } catch (NumberFormatException e) {
            errorDialog("Initial angle field must be a decimal formatted number.");
            return;
        }

        // Get the Iterations value
        int iterationsValue;
        iterationsValue = (int)iterationSpinner.getValue();

        // Get the Start Symbol Value
        String startSymbolValue = startSymbol.getText();
        if (startSymbolValue.isEmpty()) {
            errorDialog("Start symbol cannot be empty.");
            return;
        }

        // Get the origin position from the radio buttons,
        rootX = drawRootCorner.isSelected() ? 5   : 450;
        rootY = drawRootCenter.isSelected() ? 375 : 745;

        // Get the rules, check there is at least one.
        String rulesText = rulesField.getText();
        if (rulesText.isEmpty()) {
            errorDialog("The specified rules cannot be empty.");
            return;
        }

        //Format the Rules
        String[] rulesSplit = rulesText.split("\n");
        List<RuleSet> rules = new ArrayList<>();

        for (int i = 0; i < rulesSplit.length; i++) {
            String rule = rulesSplit[i];
            int equalsSign = rule.indexOf("=");
            if (equalsSign == -1) {
                errorDialog("Rule " + (i + 1) + " does not assign a rule");
                return;
            }
            String variable = rule.substring(0, equalsSign);

            if (variable.length() != 1) {
                errorDialog("Starting variable in rule" + (i + 1) + " must be 1 character.");
                return;
            }

            String value = rule.substring(equalsSign + 1);
            rules.add(new RuleSet(variable.charAt(0), value));
        }

        // Expand the String
        String expansion = expandRule(startSymbolValue, iterationsValue, rules);

        if (expansion != null) {
            try{
                createLines(expansion, angle, initialAngleValue, lineLengthValue);
            } catch (OutOfMemoryError OoME){
                errorDialog("Java could not allocate enough heap space to creating the\n" +
                        "lines of the given L-system. Please reduce iterations\n" +
                        "and try again.");
            }
        }

        // Repaint the canvas
        canvasPanel.repaint();

        //Empty Memory values to prevent problems
        expansion = null;
        System.gc();
    }
}