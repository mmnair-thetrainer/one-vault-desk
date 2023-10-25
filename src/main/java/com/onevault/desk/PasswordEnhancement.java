package com.onevault.desk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.HashMap;
public class PasswordEnhancement {
    private JTextField passwordTxt = new JTextField();
    private JTextField passwordLengthMinTxt = new JTextField();
    private JTextField passwordLengthMaxTxt = new JTextField();
    private JCheckBox complexityCheckBox = new JCheckBox("Enable Password Complexity");
    private JCheckBox capsCountCheckBox = new JCheckBox("Enable Caps Count");
    private JCheckBox specialCharCountCheckBox = new JCheckBox("Enable Special Character Count");
    private JCheckBox numericValuesCountCheckBox = new JCheckBox("Enable Numeric Values Count");
    private JButton generateBtn = new JButton("Generate");
    private JButton saveBtn = new JButton("Save");
    private JButton backButton = new JButton("Back"); // Added Back Button

    private Map<String, String> passwordMap = new HashMap<>();

    public PasswordEnhancement() {
        JFrame frame = new JFrame("Password Enhancement");
        frame.setSize(500, 350); // Increased height to fit the "Back" button
        frame.setLayout(new GridLayout(9, 2)); // Increased rows for the "Back" button
        frame.add(new JLabel("Password: "));
        frame.add(passwordTxt);
        frame.add(new JLabel("Password Length (Min): "));
        frame.add(passwordLengthMinTxt);
        frame.add(new JLabel("Password Length (Max): "));
        frame.add(passwordLengthMaxTxt);
        frame.add(new JLabel("")); // Empty label for spacing
        frame.add(complexityCheckBox);
        frame.add(new JLabel("")); // Empty label for spacing
        frame.add(capsCountCheckBox);
        frame.add(new JLabel("")); // Empty label for spacing
        frame.add(specialCharCountCheckBox);
        frame.add(new JLabel("")); // Empty label for spacing
        frame.add(numericValuesCountCheckBox);
        frame.add(generateBtn);
        frame.add(saveBtn);
        frame.add(backButton); // Added Back Button

        generateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generatePassword();
            }
        });

        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = passwordTxt.getText();

                if (password != null && !password.isEmpty()) {
                    passwordMap.put("Generated Password", password);
                    JOptionPane.showMessageDialog(null, "Password saved successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Please generate a password first!");
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FeaturesDashboard(); // Navigate back to FeaturesDashboard
                frame.dispose(); // Close the current PasswordEnhancement
            }
        });

        frame.setVisible(true);
    }

    private void generatePassword() {
        // Existing generatePassword method remains the same
        // ...
    }

    private void invoke() {
        SwingUtilities.invokeLater(() -> new PasswordEnhancement());
    }
}
