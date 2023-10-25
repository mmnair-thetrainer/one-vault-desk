package com.onevault.desk;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Main implements ActionListener, WindowListener {
    public JTextField userNameTxt = new JTextField();
    public JPasswordField passwordTxt = new JPasswordField();
    public JButton loginBtn = new JButton("Login");
    public JButton clearBtn = new JButton("Clear");
    public JButton registerBtn = new JButton("Register Now");
    public JFrame loginFrame = new JFrame("OneVault 1.0");

    public JLabel msgLabel = new JLabel("");

    public static void main(String args[]){
        new Main();
    }

    private Main(){
        loginFrame.setSize(400,400);
        loginFrame.setLayout(null);
        loginFrame.setVisible(true);
        loginFrame.setResizable(false);
        loginFrame.setLocation(500,300);

        JLabel userNameLbl = new JLabel("User: ");
        userNameLbl.setBounds(20, 50, 100,30);
        loginFrame.add(userNameLbl);

        userNameTxt.setBounds(100, 50, 220,30);
        loginFrame.add(userNameTxt);
        JLabel passwordLbl = new JLabel("Password: ");
        passwordLbl.setBounds(20, 120, 100,30);
        loginFrame.add(passwordLbl);

        passwordTxt.setBounds(100, 120, 220,30);
        loginFrame.add(passwordTxt);

        msgLabel.setBounds(100, 160, 120, 30);
        loginFrame.add(msgLabel);

        loginBtn.setBounds(100, 200, 100,30);
        loginBtn.addActionListener(this);
        loginFrame.add(loginBtn);

        clearBtn.setBounds(220, 200, 100,30);
        clearBtn.addActionListener(this);
        loginFrame.add(clearBtn);

        JLabel registerLbl = new JLabel("Don't have an account?");
        registerLbl.setBounds(20, 260, 150,30);
        loginFrame.add(registerLbl);
        registerBtn.setBounds(180, 260, 150,30);
        registerBtn.addActionListener(this);
        loginFrame.add(registerBtn);

        loginFrame.addWindowListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginBtn) {
            String userName = userNameTxt.getText();
            String passwd = passwordTxt.getText();
            String dbPasswd = "";
            System.out.println("User: " + userName);
            System.out.println("Pwd: " + passwd);
            try {
                Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/one_vault", "root", "");

                String sql = "select password from users where user_name = '" + userName +"'";

                Statement st = myCon.createStatement();

                ResultSet rs = st.executeQuery(sql);

                while(rs.next()){
                    dbPasswd = rs.getString("password");
                }
                myCon.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            if(passwd.equalsIgnoreCase(dbPasswd)){
                loginFrame.dispose();
                new UserDashboard();
            }
            else{
                msgLabel.setForeground(Color.RED);
                msgLabel.setText("Wrong Password!");
            }
        }
        else if (e.getSource() == clearBtn){
            userNameTxt.setText("");
            passwordTxt.setText("");
        }

        else if (e.getSource() == registerBtn){
            loginFrame.dispose();
            new RegistrationForm();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        loginFrame.dispose();
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
