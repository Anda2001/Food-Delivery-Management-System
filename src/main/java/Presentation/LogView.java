package Presentation;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

import static java.awt.Color.*;

public class LogView extends JFrame {

    private JLabel titleLabel;
    private JLabel usernameLabel;
    private JLabel paswLabel;
    private JTextField usernameText;
    private JTextField paswText;
    private JButton logInButton;
    private JButton registerButton;
    private JComboBox roleBox;
    Font myFont = new Font("Times New Roman", Font.PLAIN, 22);


    public LogView() {
        super("Log in");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(500, 150, 500, 500);
        this.setBackground(pink);
        this.getContentPane().setBackground(pink);
        this.getContentPane().setLayout(null);


        logInButton = new JButton("LogIn");
        logInButton.setFont(myFont);
        logInButton.setBounds(100,300,100,50);
        logInButton.setBorder(new LineBorder(gray, 5));
        logInButton.setBackground(magenta);
        getContentPane().add(logInButton);

        registerButton = new JButton("Register");
        registerButton.setFont(myFont);
        registerButton.setBounds(300,300,100,50);
        registerButton.setBorder(new LineBorder(gray, 5));
        registerButton.setBackground(magenta);
        getContentPane().add(registerButton);


        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(50,50,150,50);
        usernameLabel.setFont(myFont);
        getContentPane().add(usernameLabel);

        paswLabel = new JLabel("Password");
        paswLabel.setBounds(50,100,150,50);
        paswLabel.setFont(myFont);
        getContentPane().add(paswLabel);

        usernameText = new JTextField();
        usernameText.setBounds(200,50,200,50);
        usernameText.setBackground(lightGray);
        getContentPane().add(usernameText);

        JLabel roleLabel = new JLabel("Role");
        roleLabel.setBounds(50,150,150,50);
        roleLabel.setFont(myFont);


        roleBox = new JComboBox();
        roleBox.addItem("Administrator");
        roleBox.addItem("Employee");
        roleBox.addItem("Client");
        roleBox.setBounds(200,150,200,50);
        roleBox.setBackground(lightGray);
        getContentPane().add(roleLabel);
        getContentPane().add(roleBox);


        paswText = new JTextField();
        paswText.setBounds(200,100,200,50);
        paswText.setBackground(lightGray);
        getContentPane().add(paswText);
    }


    public String getUsername() {
        return usernameText.getText();
    }

    public String getPassword(){
        return paswText.getText();
    }


    public void addRegisterButtonActionListener(ActionListener actionListener)
    {
        registerButton.addActionListener(actionListener);
    }

    public void addLogInButtonActionListener(ActionListener actionListener)
    {
        logInButton.addActionListener(actionListener);
    }

    public String getRole() {
        String role= (String) roleBox.getSelectedItem();
        assert role != null;
        return role;

        // return roleBox.toString();
    }

}
