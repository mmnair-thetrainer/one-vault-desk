package com.onevault.desk;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class UserDashboard implements ActionListener, WindowListener {

    public JFrame dbFrame = new JFrame("OneVault 1.0 - Dashboard");

    public JButton passwordsBtn = new JButton("Passwords");
    public JButton addrBtn = new JButton("Addresses");
    public JButton notesBtn = new JButton("Notes");


    public JMenuBar dbMenubar = new JMenuBar();
    public JMenu fileMenu = new JMenu("File");
    public JMenu newFileMenuSub = new JMenu("New");
    public JMenu editFileMenuSub = new JMenu("Edit");
    public JMenu optFileMenuSub = new JMenu("Options");
    public JMenu helpMenu = new JMenu("Help");
    public JMenuItem newPasswordsMItem = new JMenuItem("Password");
    public JMenuItem newAddressesMItem = new JMenuItem("Address");
    public JMenuItem newNotesMItem = new JMenuItem("Notes");
    public JMenuItem aboutHelpMItem = new JMenuItem("About");

    public UserDashboard() {
        dbFrame.setSize(360, 150);
        dbFrame.setLayout(null);
        dbFrame.setVisible(true);
        dbFrame.setResizable(false);
        dbFrame.setLocation(500, 300);

        dbMenubar.add(fileMenu);
        dbMenubar.add(helpMenu);

        fileMenu.add(newFileMenuSub);
        fileMenu.add(editFileMenuSub);
        fileMenu.add(optFileMenuSub);

        newFileMenuSub.add(newPasswordsMItem);
        newPasswordsMItem.addActionListener(this);
        newFileMenuSub.add(newAddressesMItem);
        newAddressesMItem.addActionListener(this);
        newFileMenuSub.add(newNotesMItem);
        newNotesMItem.addActionListener(this);

        helpMenu.add(aboutHelpMItem);
        aboutHelpMItem.addActionListener(this);

        dbFrame.setJMenuBar(dbMenubar);

        passwordsBtn.setBounds(10, 30, 100, 60);
        passwordsBtn.addActionListener(this);
        dbFrame.add(passwordsBtn);

        addrBtn.setBounds(120, 30, 100, 60);
        addrBtn.addActionListener(this);
        dbFrame.add(addrBtn);

        notesBtn.setBounds(230, 30, 100, 60);
        notesBtn.addActionListener(this);
        dbFrame.add(notesBtn);


        dbFrame.addWindowListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aboutHelpMItem) {
            JOptionPane.showMessageDialog(dbFrame, "One Vault is a software developed by Reshmi Krishna (A CIS student) " +
                    "as a part of her research project. \n Copyright 2023 \n Version 1.0");
        } else if (e.getSource() == passwordsBtn) {
            // Navigate to the NewPassword page
            NewPassword newPassword = new NewPassword();
            dbFrame.dispose(); // Close the UserDashboard window
        } else if (e.getSource() == addrBtn) {
            // Navigate to the NewAddresses page
            NewAddresses newAddresses = new NewAddresses();
            dbFrame.dispose(); // Close the UserDashboard window
        } else if (e.getSource() == notesBtn) {
            // Navigate to the NewNotes page
            NewNotes newNotes = new NewNotes();
            dbFrame.dispose(); // Close the UserDashboard window
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
        SwingUtilities.invokeLater(() -> new UserDashboard());
    }

}
