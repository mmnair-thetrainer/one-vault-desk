package com.onevault.desk;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class NewPassword implements ActionListener, WindowListener {
    public JTextField urlTxt = new JTextField("https://");
    public JTextField usernameTxt = new JTextField();
    public JPasswordField passwordTxt = new JPasswordField();

    public JButton saveBtn = new JButton("Save");
    public JButton clearBtn = new JButton("Clear");
    public JButton backBtn = new JButton("Back"); // Back button

    public JFrame createPasswordFrame = new JFrame("Create Password Form");

    public JRadioButton useridRadioBtn = new JRadioButton("Userid");
    public JRadioButton emailidRadioBtn = new JRadioButton("Email");
    public JRadioButton mobilenumberRadioBtn = new JRadioButton("Mobile");
    public ButtonGroup userGroup = new ButtonGroup();

    public JLabel urlLabel = new JLabel("URL");
    public JLabel userLbl = new JLabel("User Name ");
    public JLabel passwordLabel = new JLabel("Password ");

    public NewPassword() {
        createPasswordFrame.setSize(500, 300);
        createPasswordFrame.setLayout(null);
        createPasswordFrame.setVisible(true);

        urlLabel.setBounds(20, 50, 100, 20);
        createPasswordFrame.add(urlLabel);
        urlTxt.setBounds(130, 50, 300, 20);
        createPasswordFrame.add(urlTxt);

        userLbl.setBounds(20, 80, 100, 20);
        createPasswordFrame.add(userLbl);
        usernameTxt.setBounds(130, 80, 100, 20);
        createPasswordFrame.add(usernameTxt);

        passwordLabel.setBounds(240, 80, 100, 20);
        createPasswordFrame.add(passwordLabel);
        passwordTxt.setBounds(350, 80, 100, 20);
        createPasswordFrame.add(passwordTxt);

        useridRadioBtn.setBounds(130, 110, 100, 20);
        createPasswordFrame.add(useridRadioBtn);

        emailidRadioBtn.setBounds(240, 110, 100, 20);
        createPasswordFrame.add(emailidRadioBtn);

        mobilenumberRadioBtn.setBounds(350, 110, 100, 20);
        createPasswordFrame.add(mobilenumberRadioBtn);

        userGroup.add(useridRadioBtn);
        userGroup.add(emailidRadioBtn);
        userGroup.add(mobilenumberRadioBtn);

        saveBtn.setBounds(80, 140, 100, 20);
        saveBtn.addActionListener(this);
        createPasswordFrame.add(saveBtn);

        clearBtn.setBounds(190, 140, 100, 20);
        clearBtn.addActionListener(this);
        createPasswordFrame.add(clearBtn);

        backBtn.setBounds(300, 140, 100, 20); // Back button
        backBtn.addActionListener(this); // Add ActionListener
        createPasswordFrame.add(backBtn); // Add the Back button
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveBtn) {
            // ... Save functionality here ...
        } else if (e.getSource() == clearBtn) {
            // ... Clear functionality here ...
        } else if (e.getSource() == backBtn) {
            createPasswordFrame.dispose(); // Close the NewPassword window
            new UserDashboard(); // Navigate back to the UserDashboard
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        createPasswordFrame.dispose();
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
        SwingUtilities.invokeLater(() -> new NewPassword());
    }
}
