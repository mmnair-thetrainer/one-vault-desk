package com.onevault.desk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InactivityChecker {
    private JTextField lastLoginTimeTxt = new JTextField();
    private JTable table;
    private JButton saveButton = new JButton("Save");
    private JButton backButton = new JButton("Back");

    private String[] columnNames = {"Assets", "Last Active", "Block", "Action"};
    private Object[][] data = {}; // You can initialize this with actual data if needed

    public InactivityChecker() {
        JFrame frame = new JFrame("Vault Inactivity Checker");
        frame.setSize(800, 400);
        frame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new GridLayout(2, 2));
        topPanel.add(new JLabel("Last Login Time: "));
        topPanel.add(lastLoginTimeTxt);
        topPanel.add(new JLabel("")); // Empty label for spacing
        topPanel.add(new JLabel("")); // Empty label for spacing

        frame.add(topPanel, BorderLayout.NORTH);

        table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);
        buttonPanel.add(backButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lastLoginTime = lastLoginTimeTxt.getText();

                // Save the data to your data structures or database here
                // For demonstration purposes, we'll just display a message

                if (!lastLoginTime.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Data Saved Successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Please fill in all the fields!");
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FeaturesDashboard(); // Navigate back to FeaturesDashboard
                frame.dispose(); // Close the current InactivityChecker
            }
        });

        frame.setVisible(true);
    }

    private void invoke() {
        SwingUtilities.invokeLater(() -> new InactivityChecker());
    }
}
