/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizexercise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginFrame() {
        setTitle("Pemesanan Hotel - Login");
        setSize(300, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setLocationRelativeTo(null);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel userLabel = new JLabel("Username:");
        gbc.gridx = 0; gbc.gridy = 0; add(userLabel, gbc);
        usernameField = new JTextField(15);
        gbc.gridx = 1; add(usernameField, gbc);

        JLabel passLabel = new JLabel("Password:");
        gbc.gridx = 0; gbc.gridy = 1; add(passLabel, gbc);
        passwordField = new JPasswordField(15);
        gbc.gridx = 1; add(passwordField, gbc);

        loginButton = new JButton("Masuk");
        gbc.gridx = 1; gbc.gridy = 2; add(loginButton, gbc);

        loginButton.addActionListener((ActionEvent e) -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (username.equals("adm") && password.equals("adm")) {
                new MainMenuFrame();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Username atau password salah!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }
        });
        setVisible(true);
    }
}