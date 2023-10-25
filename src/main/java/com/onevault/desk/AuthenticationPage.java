package com.onevault.desk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AuthenticationPage {
    private final JTextField userNameTxt = new JTextField();
    private final JPasswordField passwordTxt = new JPasswordField();
    private JTextField otpTxt = new JTextField();
    private final JComboBox<String> methodComboBox = new JComboBox<>();
    private JButton resendOtpBtn = new JButton("Resend OTP");
    private JButton submitBtn = new JButton("Submit");
    private JButton backButton = new JButton("Back");

    public AuthenticationPage() {
        JFrame frame = new JFrame("Authentication Page");
        frame.setSize(500, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel userNameLbl = new JLabel("Username:");
        userNameLbl.setBounds(20, 30, 80, 30);
        frame.add(userNameLbl);

        userNameTxt.setBounds(120, 30, 200, 30);
        frame.add(userNameTxt);

        JLabel passwordLbl = new JLabel("Password:");
        passwordLbl.setBounds(20, 70, 80, 30);
        frame.add(passwordLbl);

        passwordTxt.setBounds(120, 70, 200, 30);
        frame.add(passwordTxt);

        JLabel otpLbl = new JLabel("OTP:");
        otpLbl.setBounds(20, 110, 80, 30);
        frame.add(otpLbl);

        otpTxt.setBounds(120, 110, 200, 30);
        frame.add(otpTxt);

        JLabel methodLbl = new JLabel("Authentication Method:");
        methodLbl.setBounds(20, 150, 150, 30);
        frame.add(methodLbl);

        methodComboBox.addItem("Biometric");
        methodComboBox.addItem("SMS");
        methodComboBox.addItem("Email");
        methodComboBox.setBounds(180, 150, 140, 30);
        frame.add(methodComboBox);

        resendOtpBtn.setBounds(120, 190, 120, 30);
        frame.add(resendOtpBtn);

        submitBtn.setBounds(250, 190, 80, 30);
        frame.add(submitBtn);

        backButton.setBounds(20, 190, 80, 30);
        frame.add(backButton);

        submitBtn.addActionListener(e -> {
            String username = userNameTxt.getText();
            String password = new String(passwordTxt.getPassword());
            String otp = otpTxt.getText();
            String selectedMethod = (String) methodComboBox.getSelectedItem();

            if (authenticate(username, password, otp, selectedMethod)) {
                JOptionPane.showMessageDialog(null, "Authentication successful!");
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Authentication failed!");
            }
        });

        resendOtpBtn.addActionListener(e -> {
            String username = userNameTxt.getText();
            String password = new String(passwordTxt.getPassword());
            String selectedMethod = (String) methodComboBox.getSelectedItem();
            sendOtp(username, password, selectedMethod);
            JOptionPane.showMessageDialog(null, "OTP sent!");
        });

        backButton.addActionListener(e -> {
            new FeaturesDashboard(); // Navigate back to FeaturesDashboard
            frame.dispose(); // Close the current AuthenticationPage
        });

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }

    private boolean authenticate(String username, String password, String otp, String method) {
        String correctUsername = "user123";
        String correctPassword = "password123";
        String correctOtp = "123456";

        if (username.equals(correctUsername) && password.equals(correctPassword) && otp.equals(correctOtp)) {
            return true; // Authentication is successful
        } else {
            return false; // Authentication failed
        }
    }

    private void sendOtp(String username, String password, String method) {
        // Implement your OTP sending logic here (Simulated example)
        String otp = generateOtp();
        otpTxt.setText(otp); // Display generated OTP in the text field for demonstration purposes
    }

    private String generateOtp() {
        // Generate a random 6-digit OTP (Simulated example)
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            otp.append((int) (Math.random() * 10));
        }
        return otp.toString();
    }

    private void invoke() {
        SwingUtilities.invokeLater(() -> new AuthenticationPage());
    }
}
