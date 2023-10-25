package com.onevault.desk;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FeaturesDashboard implements ActionListener, WindowListener {

    private JFrame dbFrame = new JFrame("OneVault 1.0 - Features Dashboard");

    private JButton authenticationBtn = new JButton("Authentication Page");
    private JButton threatNotificationBtn = new JButton("Threat Notification");
    private JButton passwordInheritanceBtn = new JButton("Password Inheritance Page");
    private JButton inactivityCheckerBtn = new JButton("Inactivity Checker");
    private JButton passwordEnhancementBtn = new JButton("Password Enhancement");
    private JButton settingsBtn = new JButton("Settings Page");
    private JButton backButton = new JButton("Back");

    public FeaturesDashboard() {
        dbFrame.setSize(600, 150);
        dbFrame.setLayout(null);
        dbFrame.setVisible(true);
        dbFrame.setResizable(false);
        dbFrame.setLocation(500, 300);

        authenticationBtn.setBounds(10, 30, 150, 60);
        authenticationBtn.addActionListener(this);
        dbFrame.add(authenticationBtn);

        threatNotificationBtn.setBounds(170, 30, 150, 60);
        threatNotificationBtn.addActionListener(this);
        dbFrame.add(threatNotificationBtn);

        passwordInheritanceBtn.setBounds(330, 30, 150, 60);
        passwordInheritanceBtn.addActionListener(this);
        dbFrame.add(passwordInheritanceBtn);

        inactivityCheckerBtn.setBounds(490, 30, 150, 60);
        inactivityCheckerBtn.addActionListener(this);
        dbFrame.add(inactivityCheckerBtn);

        passwordEnhancementBtn.setBounds(10, 100, 150, 60);
        passwordEnhancementBtn.addActionListener(this);
        dbFrame.add(passwordEnhancementBtn);

        settingsBtn.setBounds(170, 100, 150, 60);
        settingsBtn.addActionListener(this);
        dbFrame.add(settingsBtn);

        backButton.setBounds(330, 100, 150, 60);
        backButton.addActionListener(this);
        dbFrame.add(backButton);

        dbFrame.addWindowListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == authenticationBtn) {
            new AuthenticationPage();
        } else if (e.getSource() == threatNotificationBtn) {
            new ThreatNotification();
        } else if (e.getSource() == passwordInheritanceBtn) {
            new PasswordInheritancePage();
        } else if (e.getSource() == inactivityCheckerBtn) {
            new InactivityChecker();
        } else if (e.getSource() == passwordEnhancementBtn) {
            new PasswordEnhancement();
        } else if (e.getSource() == settingsBtn) {
            new SettingsPage();
        } else if (e.getSource() == backButton) {
            // Navigate to the UserDashboard
            new UserDashboard();
            dbFrame.dispose(); // Close the current dashboard
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        dbFrame.dispose();
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

    private void invoke() {
        SwingUtilities.invokeLater(() -> new FeaturesDashboard());
    }
}
