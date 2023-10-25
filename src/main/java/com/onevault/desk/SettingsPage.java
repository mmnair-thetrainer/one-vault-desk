package com.onevault.desk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SettingsPage implements ActionListener {
    private JTextField accountInfoTxt = new JTextField();
    private JPasswordField currentPasswordTxt = new JPasswordField();
    private JPasswordField newPasswordTxt = new JPasswordField();
    private JPasswordField confirmPasswordTxt = new JPasswordField();
    private JCheckBox enable2FAcheckbox = new JCheckBox("Enable 2FA");
    private JTextField secretKeyTxt = new JTextField();
    private JTextField backupCodesTxt = new JTextField();
    private JCheckBox emailNotificationCheckBox = new JCheckBox("Email Notifications");
    private JCheckBox pushNotificationCheckBox = new JCheckBox("Push Notifications");
    private JButton saveBtn = new JButton("Save");
    private JButton backBtn = new JButton("Back");
    private JFrame settingsFrame = new JFrame("Settings Page");

    public SettingsPage() {
        settingsFrame.setSize(800, 600);
        settingsFrame.setLayout(null);
        settingsFrame.setVisible(true);

        // Account Information
        JLabel accountInfoLbl = new JLabel("Account Information: ");
        accountInfoLbl.setBounds(20, 50, 150, 20);
        settingsFrame.add(accountInfoLbl);

        accountInfoTxt.setBounds(180, 50, 200, 20);
        settingsFrame.add(accountInfoTxt);

        // Password Change
        JLabel currentPasswordLbl = new JLabel("Current Password: ");
        currentPasswordLbl.setBounds(20, 90, 150, 20);
        settingsFrame.add(currentPasswordLbl);

        currentPasswordTxt.setBounds(180, 90, 200, 20);
        settingsFrame.add(currentPasswordTxt);

        JLabel newPasswordLbl = new JLabel("New Password: ");
        newPasswordLbl.setBounds(20, 130, 150, 20);
        settingsFrame.add(newPasswordLbl);

        newPasswordTxt.setBounds(180, 130, 200, 20);
        settingsFrame.add(newPasswordTxt);

        JLabel confirmPasswordLbl = new JLabel("Confirm Password: ");
        confirmPasswordLbl.setBounds(20, 170, 150, 20);
        settingsFrame.add(confirmPasswordLbl);

        confirmPasswordTxt.setBounds(180, 170, 200, 20);
        settingsFrame.add(confirmPasswordTxt);

        // Enable 2FA
        enable2FAcheckbox.setBounds(20, 210, 150, 20);
        settingsFrame.add(enable2FAcheckbox);

        // Secret Key
        JLabel secretKeyLbl = new JLabel("Secret Key: ");
        secretKeyLbl.setBounds(20, 250, 150, 20);
        settingsFrame.add(secretKeyLbl);

        secretKeyTxt.setBounds(180, 250, 200, 20);
        settingsFrame.add(secretKeyTxt);

        // Backup Codes
        JLabel backupCodesLbl = new JLabel("Backup Codes: ");
        backupCodesLbl.setBounds(20, 290, 150, 20);
        settingsFrame.add(backupCodesLbl);

        backupCodesTxt.setBounds(180, 290, 200, 20);
        settingsFrame.add(backupCodesTxt);

        // Email Notifications
        emailNotificationCheckBox.setBounds(20, 330, 150, 20);
        settingsFrame.add(emailNotificationCheckBox);

        // Push Notifications
        pushNotificationCheckBox.setBounds(20, 370, 150, 20);
        settingsFrame.add(pushNotificationCheckBox);

        // Save Button
        saveBtn.setBounds(50, 480, 100, 20);
        saveBtn.addActionListener(this);
        settingsFrame.add(saveBtn);

        // Back Button
        backBtn.setBounds(170, 480, 100, 20);
        backBtn.addActionListener(this);
        settingsFrame.add(backBtn);

        settingsFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    private void invoke() {
        SwingUtilities.invokeLater(() -> new SettingsPage());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveBtn) {
            // Handle saving settings (not implemented in this example)
            JOptionPane.showMessageDialog(null, "Settings saved successfully!");
        } else if (e.getSource() == backBtn) {
            // Handle going back to FeaturesDashboard
            settingsFrame.dispose(); // Close the current settings frame
            new FeaturesDashboard(); // Open the FeaturesDashboard
        }
    }
}
