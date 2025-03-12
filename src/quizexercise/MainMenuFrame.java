/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizexercise;

import javax.swing.*;
import java.awt.*;

public class MainMenuFrame extends JFrame {
    public MainMenuFrame() {
        setTitle("Pemesanan Hotel - Menu Utama");
        setSize(350, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1, 5, 5));
        setLocationRelativeTo(null);

        JButton smallRoomButton = new JButton("Kamar Kecil - Rp500.000");
        JButton largeRoomButton = new JButton("Kamar Besar - Rp1.000.000");
        JButton backButton = new JButton("Kembali");

        add(smallRoomButton);
        add(largeRoomButton);
        add(backButton);

        smallRoomButton.addActionListener(e -> {
            new BookingFrame("Kecil", 500000, this);
            setVisible(false);
        });
        largeRoomButton.addActionListener(e -> {
            new BookingFrame("Besar", 1000000, this);
            setVisible(false);
        });
        backButton.addActionListener(e -> {
            new LoginFrame();
            dispose();
        });
        setVisible(true);
    }
}