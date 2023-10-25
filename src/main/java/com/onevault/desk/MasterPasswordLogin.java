package com.onevault.desk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MasterPasswordLogin extends WindowAdapter implements ActionListener {
    private JPasswordField masterPasswordTxt = new JPasswordField();
    private JPasswordField confirmPasswordTxt = new JPasswordField();
    private JButton continueBtn = new JButton("Continue");
    private JFrame loginFrame = new JFrame("Master Password Login");

    private JLabel msgLabel = new JLabel("");

    private void invoke() {
        SwingUtilities.invokeLater(MasterPasswordLogin::new);
    }

    private MasterPasswordLogin() {
        loginFrame.setSize(400, 300);
        loginFrame.setLayout(null);
        loginFrame.setVisible(true);
        loginFrame.setResizable(false);
        loginFrame.setLocation(500, 300);

        JLabel masterPasswordLbl = new JLabel("Enter Your Master Password:");
        masterPasswordLbl.setBounds(20, 50, 200, 30);
        loginFrame.add(masterPasswordLbl);

        masterPasswordTxt.setBounds(220, 50, 150, 30);
        loginFrame.add(masterPasswordTxt);

        JLabel confirmPasswordLbl = new JLabel("Type Your Master Password Again:");
        confirmPasswordLbl.setBounds(20, 100, 220, 30);
        loginFrame.add(confirmPasswordLbl);

        confirmPasswordTxt.setBounds(220, 100, 150, 30);
        loginFrame.add(confirmPasswordTxt);

        msgLabel.setBounds(100, 160, 200, 30);
        loginFrame.add(msgLabel);

        continueBtn.setBounds(150, 200, 100, 30);
        continueBtn.addActionListener(this);
        loginFrame.add(continueBtn);

        loginFrame.addWindowListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == continueBtn) {
            char[] masterPasswordChars = masterPasswordTxt.getPassword();
            char[] confirmPasswordChars = confirmPasswordTxt.getPassword();
            String masterPassword = new String(masterPasswordChars);
            String confirmPassword = new String(confirmPasswordChars);

            if (!masterPassword.equals(confirmPassword)) {
                msgLabel.setForeground(Color.RED);
                msgLabel.setText("Master Passwords do not match!");
                return;
            }

            // Validate the master password and perform necessary actions
            if (isValidMasterPassword(masterPassword)) {
                loginFrame.dispose();
                new UserDashboard();
            } else {
                msgLabel.setForeground(Color.RED);
                msgLabel.setText("Invalid Master Password!");
            }
        }
    }

    private boolean isValidMasterPassword(String password) {
        // Implement your master password validation logic here
        // For demonstration purposes, return true if the password is not empty
        return !password.isEmpty();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        loginFrame.dispose();
        System.exit(0);
    }
}
