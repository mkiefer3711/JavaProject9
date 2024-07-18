//@author Maddison Kiefer

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Period;
import java.time.LocalDate;

// Creating the BirthDateApplication class that extends JFrame and implements ActionListener
public class BirthDateApplication extends JFrame implements ActionListener {
    // Declaring the instance variables
    private final JTextField birthdateField;
    private final JButton calculateAgeButton;
    private final JLabel ageLabel;
    
    // Constructor for the class
    public BirthDateApplication() {
        // Sets the title and size for the frame
        setTitle("Age Calculator Application");
        setSize(300, 150);
        // Exits the frame when the 'x' is clicked
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Centers the frame on the screen
        setLocationRelativeTo(null);
        
        // Creating the panel to hold the components
        JPanel panel = new JPanel();
        
        // Creating the birthdateField, setting the size of the text field, and adding to the panel
        birthdateField = new JTextField("YYYY-MM-DD");
        birthdateField.setPreferredSize(new Dimension(150, 30));
        panel.add(birthdateField);
        
        // Creating the calculateAge button, adding an action listener, and adding to the panel
        calculateAgeButton = new JButton("Calculate Age");
        calculateAgeButton.addActionListener(this);
        panel.add(calculateAgeButton);
        
        // Creating the age label and adding to the panel
        ageLabel = new JLabel("Age: ");
        panel.add(ageLabel);
        
        // Adding the panel to the frame
        add(panel);
        // Setting the frame to be visible
        setVisible(true);
    }
    
    // Implementing the ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        // If the calculate age button is clicked
        if (e.getSource() == calculateAgeButton) {
            // Asks user for an input
            String birthdateString = birthdateField.getText();
            try {
                // Attempts to parse into a LocalDate object
                LocalDate birthdate = LocalDate.parse(birthdateString);
                // Gets the current date
                LocalDate currentDate = LocalDate.now();
                // Calculates the time between the birthdate and the current date
                Period period = Period.between(birthdate, currentDate);
                // Gets years from the period, which is the age
                int age = period.getYears();
                // Displays the calculated age to the label
                ageLabel.setText("Age: " + age);
            } catch (Exception ex) {
                // Handles if the input is not in the expected format
                JOptionPane.showMessageDialog(this, "Please enter a valid date in the format YYYY-MM-DD.");
            }
        }
    }
    
    // Main method to start the application
    public static void main(String[] args) {
        new BirthDateApplication();
    }
}
