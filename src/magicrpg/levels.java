package magicrpg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Levels extends JPanel {
    Levels(JFrame frame) {
        setLayout(new GridLayout(2, 3, 10, 10)); // 2 rows, 3 columns, 10px gap
        setBackground(Color.BLACK);

        // Load and resize the level images
        ImageIcon level1 = resizeImage(new ImageIcon("level1.png"), 200, 200);
        ImageIcon level2 = resizeImage(new ImageIcon("level2.png"), 200, 200);
        ImageIcon level3 = resizeImage(new ImageIcon("level3.png"), 200, 200);
        ImageIcon level4 = resizeImage(new ImageIcon("level4.png"), 200, 200);
        ImageIcon level5 = resizeImage(new ImageIcon("level5.png"), 200, 200);
        ImageIcon level6 = resizeImage(new ImageIcon("level6.png"), 200, 200);

        // Create labels with the level images
        JLabel level1Label = new JLabel(level1);
        JLabel level2Label = new JLabel(level2);
        JLabel level3Label = new JLabel(level3);
        JLabel level4Label = new JLabel(level4);
        JLabel level5Label = new JLabel(level5);
        JLabel level6Label = new JLabel(level6);

        // Center the labels
        level1Label.setHorizontalAlignment(JLabel.CENTER);
        level1Label.setVerticalAlignment(JLabel.CENTER);
        level2Label.setHorizontalAlignment(JLabel.CENTER);
        level2Label.setVerticalAlignment(JLabel.CENTER);
        level3Label.setHorizontalAlignment(JLabel.CENTER);
        level3Label.setVerticalAlignment(JLabel.CENTER);
        level4Label.setHorizontalAlignment(JLabel.CENTER);
        level4Label.setVerticalAlignment(JLabel.CENTER);
        level5Label.setHorizontalAlignment(JLabel.CENTER);
        level5Label.setVerticalAlignment(JLabel.CENTER);
        level6Label.setHorizontalAlignment(JLabel.CENTER);
        level6Label.setVerticalAlignment(JLabel.CENTER);

        // Add MouseListeners to the level labels to start the game
        level1Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                startGame(frame, 1);
            }
        });
        level2Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                startGame(frame, 2);
            }
        });
        level3Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                startGame(frame, 3);
            }
        });
        level4Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                startGame(frame, 4);
            }
        });
        level5Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                startGame(frame, 5);
            }
        });
        level6Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                startGame(frame, 6);
            }
        });

        // Add the level labels to the panel
        add(level1Label);
        add(level2Label);
        add(level3Label);
        add(level4Label);
        add(level5Label);
        add(level6Label);
    }

    // Method to start the game with the specified level
    private void startGame(JFrame frame, int level) {
        frame.getContentPane().removeAll(); // Remove all components
        frame.getContentPane().add(new StartGame(level)); // Add the game panel with the specified level
        frame.revalidate(); // Refresh the frame
        frame.repaint(); // Repaint the frame
    }

    // Method to resize an image
    private ImageIcon resizeImage(ImageIcon originalImage, int width, int height) {
        Image image = originalImage.getImage(); // transform it
        Image newimg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH); // resize it
        return new ImageIcon(newimg); // transform it back
    }
}