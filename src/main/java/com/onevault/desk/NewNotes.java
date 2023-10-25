package com.onevault.desk;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class NewNotes implements ActionListener, WindowListener {
    public JTextField titleTxt = new JTextField();
    public JTextField notesTxt = new JTextField();
    public JFrame createNotesFrame = new JFrame("Create Notes Form");
    public JButton saveBtn = new JButton("Save");
    public JButton clearBtn = new JButton("Clear");
    public JButton backBtn = new JButton("Back"); // Back button

    public JLabel titleLbl = new JLabel("Title ");
    public JLabel notesLabel = new JLabel("Notes ");

    public NewNotes() {
        createNotesFrame.setSize(500, 300);
        createNotesFrame.setLayout(null);
        createNotesFrame.setVisible(true);

        titleLbl.setBounds(20, 80, 100, 20);
        createNotesFrame.add(titleLbl);
        titleTxt.setBounds(130, 80, 100, 20);
        createNotesFrame.add(titleTxt);

        notesLabel.setBounds(240, 80, 100, 20);
        createNotesFrame.add(notesLabel);
        notesTxt.setBounds(350, 80, 500, 70);
        createNotesFrame.add(notesTxt);

        saveBtn.setBounds(80, 140, 100, 20);
        saveBtn.addActionListener(this);
        createNotesFrame.add(saveBtn);

        clearBtn.setBounds(190, 140, 100, 20);
        clearBtn.addActionListener(this);
        createNotesFrame.add(clearBtn);

        backBtn.setBounds(300, 140, 100, 20); // Back button
        backBtn.addActionListener(this); // Add ActionListener
        createNotesFrame.add(backBtn); // Add the Back button
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveBtn) {
            // ... Save functionality here ...
        } else if (e.getSource() == clearBtn) {
            // ... Clear functionality here ...
        } else if (e.getSource() == backBtn) {
            createNotesFrame.dispose(); // Close the NewNotes window
            new UserDashboard(); // Navigate back to the UserDashboard
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        createNotesFrame.dispose();
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
        SwingUtilities.invokeLater(() -> new NewNotes());
    }
}
