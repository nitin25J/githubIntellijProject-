package task;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.*;

// ================= MAIN CLASS =================
class Main {

    public static void main(String[] args) {
        IDandPasswords idandPasswords = new IDandPasswords();
        new LoginPage(idandPasswords.getLoginInfo());
    }
}

// ================= DATA CLASS =================
class IDandPasswords {

    private HashMap<String, String> logininfo = new HashMap<>();

    IDandPasswords() {
        logininfo.put("Bro", "pizza");
        logininfo.put("Brometheus", "PASSWORD");
        logininfo.put("BroCode", "abc123");
    }

    public HashMap<String, String> getLoginInfo() {
        return logininfo;
    }
}

// ================= LOGIN PAGE =================
class LoginPage implements ActionListener {

    JFrame frame = new JFrame("Login");
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("User ID:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel messageLabel = new JLabel();

    HashMap<String, String> logininfo;

    LoginPage(HashMap<String, String> logininfo) {

        this.logininfo = logininfo;

        userIDLabel.setBounds(50, 100, 75, 25);
        userPasswordLabel.setBounds(50, 150, 75, 25);

        userIDField.setBounds(125, 100, 200, 25);
        userPasswordField.setBounds(125, 150, 200, 25);

        loginButton.setBounds(125, 200, 100, 25);
        resetButton.setBounds(225, 200, 100, 25);

        messageLabel.setBounds(125, 250, 250, 35);
        messageLabel.setFont(new Font(null, Font.BOLD, 18));

        loginButton.addActionListener(this);
        resetButton.addActionListener(this);

        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(messageLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
        }

        if (e.getSource() == loginButton) {

            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            if (logininfo.containsKey(userID)) {
                if (logininfo.get(userID).equals(password)) {
                    messageLabel.setForeground(Color.GREEN);
                    messageLabel.setText("Login Successful");
                    frame.dispose();
                    new WelcomePage(userID);
                } else {
                    messageLabel.setForeground(Color.RED);
                    messageLabel.setText("Wrong Password");
                }
            } else {
                messageLabel.setForeground(Color.RED);
                messageLabel.setText("User not found");
            }
        }
    }
}

// ================= WELCOME PAGE =================
class WelcomePage {

    JFrame frame = new JFrame("Welcome");
    JLabel welcomeLabel = new JLabel();

    WelcomePage(String userID) {

        welcomeLabel.setBounds(50, 100, 300, 35);
        welcomeLabel.setFont(new Font(null, Font.PLAIN, 25));
        welcomeLabel.setText("Hello " + userID);

        frame.add(welcomeLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}