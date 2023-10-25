package com.onevault.desk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class PasswordInheritancePage {
    private JTextField passwordTxt = new JTextField();
    private JTextField entryTxt = new JTextField();
    private JComboBox<String> inheritFromComboBox = new JComboBox<>();
    private JComboBox<String> inheritToComboBox = new JComboBox<>();
    private JButton inheritBtn = new JButton("Inherit");
    private JButton setBtn = new JButton("Set");
    private JButton entriesBtn = new JButton("Entries");
    private JButton backBtn = new JButton("Back");

    private Map<String, String> passwordMap = new HashMap<>();
    private Map<String, String> inheritanceMap = new HashMap<>();

    public PasswordInheritancePage() {
        JFrame frame = new JFrame("Password Inheritance Page");
        frame.setSize(500, 300);
        frame.setLayout(new GridLayout(5, 2));
        frame.add(new JLabel("Password: "));
        frame.add(passwordTxt);
        frame.add(new JLabel("Entry: "));
        frame.add(entryTxt);
        frame.add(new JLabel("Inherit From: "));
        frame.add(inheritFromComboBox);
        frame.add(new JLabel("Inherit To: "));
        frame.add(inheritToComboBox);
        frame.add(inheritBtn);
        frame.add(setBtn);
        frame.add(entriesBtn);
        frame.add(backBtn);

        inheritBtn.addActionListener(e -> {
            String entry = entryTxt.getText();
            String inheritFrom = (String) inheritFromComboBox.getSelectedItem();
            String inheritTo = (String) inheritToComboBox.getSelectedItem();

            if (entry != null && inheritFrom != null && inheritTo != null) {
                if (!inheritFrom.equals(inheritTo)) {
                    inheritanceMap.put(entry, inheritTo);
                    JOptionPane.showMessageDialog(null, "Inheritance set successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot inherit to the same entry!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please fill in all the fields!");
            }
        });

        setBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String entry = entryTxt.getText();
                String password = passwordTxt.getText();

                if (entry != null && password != null) {
                    passwordMap.put(entry, password);
                    JOptionPane.showMessageDialog(null, "Password set successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Please fill in all the fields!");
                }
            }
        });

        entriesBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder entries = new StringBuilder();
                for (Map.Entry<String, String> entry : passwordMap.entrySet()) {
                    entries.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
                }
                JOptionPane.showMessageDialog(null, "Entries:\n" + entries.toString());
            }
        });

        backBtn.addActionListener(e -> {
            frame.dispose(); // Close the current frame
            SwingUtilities.invokeLater(() -> new FeaturesDashboard()); // Navigate back to FeaturesDashboard
        });

        frame.setVisible(true);
    }

    private void invoke() {
        SwingUtilities.invokeLater(() -> new PasswordInheritancePage());
    }
}
