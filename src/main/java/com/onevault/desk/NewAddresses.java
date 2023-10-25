package com.onevault.desk;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class NewAddresses implements ActionListener, WindowListener {
    public JTextField titleTxt = new JTextField();
    public JTextField addressTxt = new JTextField();
    public JFrame createAddressesFrame = new JFrame("Create Address Form");
    public JButton saveBtn = new JButton("Save");
    public JButton clearBtn = new JButton("Clear");
    public JButton backBtn = new JButton("Back"); // Back button

    public JLabel titleLbl = new JLabel("Title ");
    public JLabel addressLabel = new JLabel("Address ");

    public NewAddresses() {
        createAddressesFrame.setSize(500, 300);
        createAddressesFrame.setLayout(null);
        createAddressesFrame.setVisible(true);

        titleLbl.setBounds(20, 80, 100, 20);
        createAddressesFrame.add(titleLbl);
        titleTxt.setBounds(130, 80, 100, 20);
        createAddressesFrame.add(titleTxt);

        addressLabel.setBounds(240, 80, 100, 20);
        createAddressesFrame.add(addressLabel);
        addressTxt.setBounds(350, 80, 100, 20);
        createAddressesFrame.add(addressTxt);

        saveBtn.setBounds(80, 140, 100, 20);
        saveBtn.addActionListener(this);
        createAddressesFrame.add(saveBtn);

        clearBtn.setBounds(190, 140, 100, 20);
        clearBtn.addActionListener(this);
        createAddressesFrame.add(clearBtn);

        backBtn.setBounds(300, 140, 100, 20); // Back button
        backBtn.addActionListener(this); // Add ActionListener
        createAddressesFrame.add(backBtn); // Add the Back button
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveBtn) {
            // ... Save functionality here ...
        } else if (e.getSource() == clearBtn) {
            // ... Clear functionality here ...
        } else if (e.getSource() == backBtn) {
            createAddressesFrame.dispose(); // Close the NewAddresses window
            new UserDashboard(); // Navigate back to the UserDashboard
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        createAddressesFrame.dispose();
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
        SwingUtilities.invokeLater(() -> new NewAddresses());
    }
}
