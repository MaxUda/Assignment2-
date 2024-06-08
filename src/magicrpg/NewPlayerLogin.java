package magicrpg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NewPlayerLogin extends JFrame {
    public NewPlayerLogin(JFrame mainFrame) {
        setTitle("New Player Registration");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Load and resize images
        ImageIcon welcomeIcon = new ImageIcon("welcome.png");
        ImageIcon nameIcon = new ImageIcon("name.png");
        ImageIcon passwordIcon = new ImageIcon("password.png");
        ImageIcon startIcon = new ImageIcon("startgame.png");

        welcomeIcon = resizeImage(welcomeIcon, 200, 50);
        nameIcon = resizeImage(nameIcon, 200, 50);
        passwordIcon = resizeImage(passwordIcon, 200, 50);
        startIcon = resizeImage(startIcon, 200, 50);

        // Create labels with images
        JLabel welcome = new JLabel(welcomeIcon);
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel nameLabel = new JLabel(nameIcon);
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel passwordLabel = new JLabel(passwordIcon);
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel start = new JLabel(startIcon);
        start.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Create text fields for name and password
        JTextField nameField = new JTextField(15);
        nameField.setMaximumSize(new Dimension(200, 30));
        nameField.setBackground(Color.BLACK);
        nameField.setForeground(Color.WHITE);
        nameField.setCaretColor(Color.WHITE);
        nameField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPasswordField passwordField = new JPasswordField(15);
        passwordField.setMaximumSize(new Dimension(200, 30));
        passwordField.setBackground(Color.BLACK);
        passwordField.setForeground(Color.WHITE);
        passwordField.setCaretColor(Color.WHITE);
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add MouseListener to the start label
        start.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainFrame.getContentPane().removeAll();
                mainFrame.getContentPane().add(new Levels(mainFrame));
                mainFrame.validate();
                mainFrame.repaint();
                dispose();
            }
        });

        // Add components to the panel with vertical spacing and centering
        add(Box.createVerticalGlue());
        add(welcome);
        add(Box.createVerticalStrut(20));
        add(nameLabel);
        add(nameField);
        add(Box.createVerticalStrut(20));
        add(passwordLabel);
        add(passwordField);
        add(Box.createVerticalStrut(20));
        add(start);
        add(Box.createVerticalGlue());

        setVisible(true);
    }

    private static ImageIcon resizeImage(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newImage);
    }
}
