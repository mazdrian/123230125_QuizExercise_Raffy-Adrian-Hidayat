/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizexercise;

import javax.swing.*;
import java.awt.*;

public class BookingFrame extends JFrame {
    private JTextField nameField, stayField;
    private JRadioButton male, female;
    private JComboBox<Integer> guestCount;
    private JButton bookButton, resetButton, backButton;
    private JLabel totalLabel;
    private int pricePerNight;
    
    public BookingFrame(String roomType, int pricePerNight, JFrame previousFrame) {
        this.pricePerNight = pricePerNight;
        setTitle("Pemesanan Hotel - " + roomType);
        setSize(350, 300);
        setLayout(new GridBagLayout());
        setLocationRelativeTo(null);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        addLabel("Nama:", gbc, 0, 0);
        nameField = new JTextField(15);
        addComponent(nameField, gbc, 1, 0);

        addLabel("Jenis Kelamin:", gbc, 0, 1);
        JPanel genderPanel = new JPanel();
        male = new JRadioButton("Laki-laki");
        female = new JRadioButton("Perempuan");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderPanel.add(male);
        genderPanel.add(female);
        addComponent(genderPanel, gbc, 1, 1);

        addLabel("Jumlah Tamu:", gbc, 0, 2);
        guestCount = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        addComponent(guestCount, gbc, 1, 2);

        addLabel("Lama Menginap:", gbc, 0, 3);
        stayField = new JTextField(5);
        addComponent(stayField, gbc, 1, 3);

        bookButton = new JButton("Pesan");
        resetButton = new JButton("Reset");
        backButton = new JButton("Kembali");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(bookButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(backButton);
        addComponent(buttonPanel, gbc, 0, 4, 2);

        totalLabel = new JLabel("Total: Rp0");
        addComponent(totalLabel, gbc, 0, 5, 2);

        bookButton.addActionListener(e -> bookRoom());
        resetButton.addActionListener(e -> resetFields());
        backButton.addActionListener(e -> {
            previousFrame.setVisible(true);
            dispose();
        });

        setVisible(true);
    }

    private void addLabel(String text, GridBagConstraints gbc, int x, int y) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 12));
        gbc.gridx = x;
        gbc.gridy = y;
        add(label, gbc);
    }

    private void addComponent(Component comp, GridBagConstraints gbc, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        add(comp, gbc);
    }

    private void addComponent(Component comp, GridBagConstraints gbc, int x, int y, int width) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        add(comp, gbc);
        gbc.gridwidth = 1;
    }

    private void bookRoom() {
        try {
            String name = nameField.getText();
            if (name.isEmpty()) throw new Exception("Nama tidak boleh kosong!");
            
            String gender = male.isSelected() ? "Laki-laki" : female.isSelected() ? "Perempuan" : "Tidak Dipilih";
            if (gender.equals("Tidak Dipilih")) throw new Exception("Pilih jenis kelamin!");
            
            int guests = (int) guestCount.getSelectedItem();
            int nights = Integer.parseInt(stayField.getText());
            if (nights <= 0) throw new Exception("Lama menginap minimal 1 malam!");
            
            int totalCost = nights * pricePerNight;
            
            JOptionPane.showMessageDialog(this, "Detail Pemesanan:\n" +
                    "Nama: " + name + "\n" +
                    "Jenis Kelamin: " + gender + "\n" +
                    "Jumlah Tamu: " + guests + "\n" +
                    "Lama Menginap: " + nights + " malam\n" +
                    "Total Biaya: Rp" + totalCost,
                    "Konfirmasi Pemesanan", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void resetFields() {
        nameField.setText("");
        stayField.setText("");
        male.setSelected(false);
        female.setSelected(false);
        guestCount.setSelectedIndex(0);
        totalLabel.setText("Total: Rp0");
    }
}
