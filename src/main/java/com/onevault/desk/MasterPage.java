package com.onevault.desk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MasterPage extends JFrame implements ActionListener, WindowListener {

    private JPasswordField passwordField;
    private JCheckBox showPasswordCheckBox;
    private JLabel passwordStrengthLabel;
    private JButton continueButton;

    private void invoke() {
        SwingUtilities.invokeLater(() -> new MasterPage());
    }

    public MasterPage() {
        setTitle("Create Master Password");
        setSize(400, 200);
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 10, 5, 10);

        JLabel passwordLabel = new JLabel("Enter Master Password:");
        passwordField = new JPasswordField(20);
        showPasswordCheckBox = new JCheckBox("Show Password");
        passwordStrengthLabel = new JLabel();
        passwordStrengthLabel.setHorizontalAlignment(SwingConstants.CENTER);
        continueButton = new JButton("Continue");
        continueButton.setEnabled(false);

        showPasswordCheckBox.addActionListener(e -> {
            JCheckBox checkBox = (JCheckBox) e.getSource();
            char echoChar = checkBox.isSelected() ? '\u0000' : '*';
            passwordField.setEchoChar(echoChar);
        });

        passwordField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                updatePasswordStrength();
            }

            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                updatePasswordStrength();
            }

            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                updatePasswordStrength();
            }
        });

        continueButton.addActionListener(e -> {
            char[] enteredPasswordChars = passwordField.getPassword();
            String enteredPassword = new String(enteredPasswordChars);
            int passwordStrength = calculatePasswordStrength(enteredPassword);
            String dbPasswd = fetchPasswordFromDatabase(" "); // Replace with the actual username

            if (enteredPassword.equals(dbPasswd)) {
                JOptionPane.showMessageDialog(MasterPage.this, "Master Password is strong! Proceed to Login.");
                dispose(); // Close the current frame
                // Open the Login page
                new LoginForm().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(MasterPage.this, "Password does not match the criteria!\nPlease use a stronger password.");
            }
            passwordField.setText(""); // Clear the password field after processing
        });

        constraints.gridx = 0;
        constraints.gridy = 0;
        add(passwordLabel, constraints);

        constraints.gridy = 1;
        add(passwordField, constraints);

        constraints.gridy = 2;
        add(showPasswordCheckBox, constraints);

        constraints.gridy = 3;
        add(passwordStrengthLabel, constraints);

        constraints.gridy = 4;
        add(continueButton, constraints);

        addWindowListener(this);

        setVisible(true);
    }

    private void updatePasswordStrength() {
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);
        int passwordStrength = calculatePasswordStrength(password);
        String strengthText = getPasswordStrengthText(passwordStrength);
        passwordStrengthLabel.setText(strengthText);
        continueButton.setEnabled(passwordStrength >= 3);
    }

    private int calculatePasswordStrength(String password) {
        int strength = 0;
        if (password.length() > 8) {
            strength++;
        }
        if (containsSpecialCharacter(password)) {
            strength++;
        }
        if (containsCapitalLetter(password)) {
            strength++;
        }
        if (containsNumber(password)) {
            strength++;
        }
        return strength;
    }

    private boolean containsSpecialCharacter(String password) {
        Pattern pattern = Pattern.compile("[!@#$%^&*(),.?\":{}|<>]");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    private boolean containsCapitalLetter(String password) {
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    private boolean containsNumber(String password) {
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    private String getPasswordStrengthText(int passwordStrength) {
        switch (passwordStrength) {
            case 0:
                return "Password Strength: Weak";
            case 1:
                return "Password Strength: Medium";
            case 2:
                return "Password Strength: Strong";
            case 3:
                return "Password Strength: Very Strong";
            default:
                return "Password Strength: Unknown";
        }
    }

    private String fetchPasswordFromDatabase(String userName) {
        String dbPasswd = "";
        try {
            Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "root", "your_password");
            String sql = "select password from users where user_name = '" + userName +"'";

            Statement st = myCon.createStatement();

            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                dbPasswd = rs.getString("password");
            }

            myCon.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return dbPasswd;
    }

    public static class LoginForm extends JFrame {
        // Implement your LoginFrame class here
        // This class should handle the login functionality
        // ...
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button actions if needed
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        dispose();
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
