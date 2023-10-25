package com.onevault.desk;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RegistrationForm implements ActionListener, WindowListener {

    private JTextField userNameTxt = new JTextField();
    private final JTextField mailIdTxt = new JTextField();
    private JPasswordField passwordTxt = new JPasswordField();
    private JPasswordField confirmPasswordTxt = new JPasswordField();
    private JComboBox<String> countryCombo = new JComboBox<>(new String[]{"Select a country...", "USA", "Canada", "UK", "France", "Germany", "India", "China"});
    private JTextField dateOfBirthCalendar = new JTextField();
    private JRadioButton maleRadioBtn = new JRadioButton("Male");
    private JRadioButton femaleRadioBtn = new JRadioButton("Female");
    private JRadioButton otherRadioBtn = new JRadioButton("Other");
    private ButtonGroup genderGroup = new ButtonGroup();
    private JButton registerBtn = new JButton("Register");
    private JButton clearBtn = new JButton("Clear");
    private JFrame registrationFrame = new JFrame("Registration Form");

    private JLabel msgLabel = new JLabel("");
    private JCheckBox termsCheckBox = new JCheckBox("I accept the terms and conditions");

    private void invoke() {
        SwingUtilities.invokeLater(() -> new RegistrationForm());
    }

    public RegistrationForm() {
        registrationFrame.setSize(600, 400);
        registrationFrame.setLayout(null);
        registrationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel userNameLbl = new JLabel("User Name: ");
        userNameLbl.setBounds(20, 50, 100, 20);
        registrationFrame.add(userNameLbl);

        userNameTxt.setBounds(120, 50, 100, 20);
        registrationFrame.add(userNameTxt);

        JLabel mailIdLbl = new JLabel("Mail Id: ");
        mailIdLbl.setBounds(240, 50, 100, 20);
        registrationFrame.add(mailIdLbl);

        mailIdTxt.setBounds(360, 50, 100, 20);
        registrationFrame.add(mailIdTxt);

        JLabel passwordLbl = new JLabel("Password: ");
        passwordLbl.setBounds(20, 90, 100, 20);
        registrationFrame.add(passwordLbl);

        passwordTxt.setBounds(120, 90, 100, 20);
        registrationFrame.add(passwordTxt);

        JLabel confirmPasswordLbl = new JLabel("Confirm Password: ");
        confirmPasswordLbl.setBounds(240, 90, 130, 20);
        registrationFrame.add(confirmPasswordLbl);

        confirmPasswordTxt.setBounds(360, 90, 100, 20);
        registrationFrame.add(confirmPasswordTxt);

        JLabel countryLbl = new JLabel("Country: ");
        countryLbl.setBounds(20, 130, 100, 20);
        registrationFrame.add(countryLbl);

        countryCombo.setBounds(120, 130, 100, 20);
        registrationFrame.add(countryCombo);

        JLabel dateofbirthLbl = new JLabel("Date of Birth: ");
        dateofbirthLbl.setBounds(20, 170, 100, 20);
        registrationFrame.add(dateofbirthLbl);

        dateOfBirthCalendar.setBounds(120, 170, 200, 150);
        registrationFrame.add(dateOfBirthCalendar);

        // Gender Radio Buttons
        maleRadioBtn.setBounds(240, 130, 60, 20);
        femaleRadioBtn.setBounds(310, 130, 80, 20);
        otherRadioBtn.setBounds(390, 130, 80, 20);
        registrationFrame.add(maleRadioBtn);
        registrationFrame.add(femaleRadioBtn);
        registrationFrame.add(otherRadioBtn);
        genderGroup.add(maleRadioBtn);
        genderGroup.add(femaleRadioBtn);
        genderGroup.add(otherRadioBtn);

        // Message Label
        msgLabel.setBounds(120, 320, 300, 20);
        registrationFrame.add(msgLabel);

        // Register Button
        registerBtn.setBounds(120, 350, 100, 30);
        registerBtn.addActionListener(this);
        registrationFrame.add(registerBtn);

        // Clear Button
        clearBtn.setBounds(240, 350, 100, 30);
        clearBtn.addActionListener(this);
        registrationFrame.add(clearBtn);

        // Terms and Conditions Check Box
        termsCheckBox.setBounds(120, 280, 300, 20);
        registrationFrame.add(termsCheckBox);

        registrationFrame.setVisible(true);
        registrationFrame.addWindowListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerBtn) {
            String userName = userNameTxt.getText();
            String mailId = mailIdTxt.getText();
            String passwd = new String(passwordTxt.getPassword());
            String confirmPasswd = new String(confirmPasswordTxt.getPassword());
            String country = (String) countryCombo.getSelectedItem();
            Date selectedDate =  new Date(dateOfBirthCalendar.getText());
            String dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").format(selectedDate);
            String gender = "";

            if (maleRadioBtn.isSelected()) {
                gender = "M";
            } else if (femaleRadioBtn.isSelected()) {
                gender = "F";
            } else if (otherRadioBtn.isSelected()) {
                gender = "O";
            }

            if (!termsCheckBox.isSelected()) {
                msgLabel.setForeground(Color.RED);
                msgLabel.setText("Please accept the terms and conditions.");
                return;
            }

            if (userName.isEmpty() || mailId.isEmpty() || passwd.isEmpty() || confirmPasswd.isEmpty() || country.equals("Select a country...")) {
                msgLabel.setForeground(Color.RED);
                msgLabel.setText("Please fill all the required fields.");
                return;
            }

            if (!passwd.equals(confirmPasswd)) {
                msgLabel.setForeground(Color.RED);
                msgLabel.setText("Passwords do not match!");
                return;
            }

            try {
                Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/one_vault", "root", "");
                Statement st = myCon.createStatement();

                String sql = "INSERT INTO users (user_name, password, email, gender, country, date_of_birth) VALUES ('" +
                        userName + "', '" + passwd + "', '" + mailId + "', '" + gender + "', '" + country + "', '" + dateOfBirth + "')";

                int status = st.executeUpdate(sql);

                if (status == 1) {
                    msgLabel.setForeground(Color.BLUE);
                    msgLabel.setText("User created successfully");
                    registrationFrame.dispose();
                    new MasterPage();
                } else {
                    msgLabel.setForeground(Color.RED);
                    msgLabel.setText("It seems like the user already exists");
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
                msgLabel.setForeground(Color.RED);
                msgLabel.setText("Error occurred while registering the user.");
            }
        } else if (e.getSource() == clearBtn) {
            userNameTxt.setText("");
            mailIdTxt.setText("");
            passwordTxt.setText("");
            confirmPasswordTxt.setText("");
            countryCombo.setSelectedIndex(0);
            dateOfBirthCalendar.setText(null);
            genderGroup.clearSelection();
            msgLabel.setText("");
            termsCheckBox.setSelected(false);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        registrationFrame.dispose();
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
}
