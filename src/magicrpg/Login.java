package magicrpg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {
    public Login(JFrame mainFrame) {
        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);

        // Change to GridLayout
        setLayout(new GridLayout(2, 1));

        // Load and resize images
        ImageIcon oldPlayerIcon = new ImageIcon("oldplayer.png");
        ImageIcon newPlayerIcon = new ImageIcon("newplayer.png");

        oldPlayerIcon = resizeImage(oldPlayerIcon, 200, 50);
        newPlayerIcon = resizeImage(newPlayerIcon, 200, 50);

        // Create labels with images
        JLabel oldPlayer = new JLabel(oldPlayerIcon);
        oldPlayer.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel newPlayer = new JLabel(newPlayerIcon);
        newPlayer.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add MouseListeners to the labels
        oldPlayer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new OldPlayerLogin(mainFrame);
                dispose();
            }
        });

        newPlayer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new NewPlayerLogin(mainFrame);
                dispose();
            }
        });

        add(oldPlayer);
        add(newPlayer);

        setVisible(true);
    }

    private static ImageIcon resizeImage(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newImage);
    }
}
