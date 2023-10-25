package com.onevault.desk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ThreatNotification implements ActionListener {
    private JTextField deviceTxt = new JTextField();
    private JTextField thiefTxt = new JTextField();
    private JComboBox<String> priorityComboBox;
    private JButton attachBtn = new JButton("Attach File");
    private JTextField contactTxt = new JTextField();
    private JTextArea descriptionTxt = new JTextArea();
    private JButton saveBtn = new JButton("Save");
    private JButton backBtn = new JButton("Back");
    private JFrame threatFrame = new JFrame("Threat Notification");
    private JEditorPane mapPanel = new JEditorPane();

    public ThreatNotification() {
        threatFrame.setSize(800, 600);
        threatFrame.setLayout(null);
        threatFrame.setVisible(true);

        JLabel deviceLbl = new JLabel("Device: ");
        deviceLbl.setBounds(20, 50, 100, 20);
        threatFrame.add(deviceLbl);

        deviceTxt.setBounds(120, 50, 100, 20);
        threatFrame.add(deviceTxt);

        JLabel thiefLbl = new JLabel("Thief: ");
        thiefLbl.setBounds(240, 50, 100, 20);
        threatFrame.add(thiefLbl);

        thiefTxt.setBounds(360, 50, 100, 20);
        threatFrame.add(thiefTxt);

        JLabel priorityLbl = new JLabel("Priority: ");
        priorityLbl.setBounds(20, 90, 100, 20);
        threatFrame.add(priorityLbl);

        String[] priorities = {"Low", "Medium", "High"};
        priorityComboBox = new JComboBox<>(priorities);
        priorityComboBox.setBounds(120, 90, 100, 20);
        threatFrame.add(priorityComboBox);

        JLabel attachLbl = new JLabel("Attachment: ");
        attachLbl.setBounds(20, 130, 100, 20);
        threatFrame.add(attachLbl);

        attachBtn.setBounds(120, 130, 120, 20);
        attachBtn.addActionListener(this);
        threatFrame.add(attachBtn);

        JLabel contactLbl = new JLabel("Contact Info: ");
        contactLbl.setBounds(20, 170, 100, 20);
        threatFrame.add(contactLbl);

        contactTxt.setBounds(120, 170, 340, 20);
        threatFrame.add(contactTxt);

        JLabel descriptionLbl = new JLabel("Description: ");
        descriptionLbl.setBounds(20, 210, 100, 20);
        threatFrame.add(descriptionLbl);

        descriptionTxt.setBounds(120, 210, 340, 250);
        threatFrame.add(descriptionTxt);

        JScrollPane mapScrollPane = new JScrollPane(mapPanel);
        mapScrollPane.setBounds(480, 50, 280, 410);
        threatFrame.add(mapScrollPane);

        saveBtn.setBounds(50, 480, 100, 20);
        saveBtn.addActionListener(this);
        threatFrame.add(saveBtn);

        backBtn.setBounds(170, 480, 100, 20);
        backBtn.addActionListener(this);
        threatFrame.add(backBtn);

        threatFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        mapPanel.setEditable(false);
        mapPanel.setContentType("text/html");
        mapPanel.setText("<html><body><iframe width=\"100%\" height=\"100%\" src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3056...\"></iframe></body></html>");
    }

    private void invoke() {
        SwingUtilities.invokeLater(() -> new ThreatNotification());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn) {
            // Handle going back to FeaturesDashboard
            threatFrame.dispose(); // Close the current ThreatNotification frame
            new FeaturesDashboard(); // Open the FeaturesDashboard
        }
        // Handle other button clicks or actions
    }
}