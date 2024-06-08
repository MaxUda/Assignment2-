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
                startGame(frame);
            }
        });
        level2Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                startGame(frame);
            }
        });
        level3Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                startGame(frame);
            }
        });
        level4Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                startGame(frame);
            }
        });
        level5Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                startGame(frame);
            }
        });
        level6Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                startGame(frame);
            }
        });

        // Add the labels to the panel
        add(level1Label);
        add(level2Label);
        add(level3Label);
        add(level4Label);
        add(level5Label);
        add(level6Label);
    }

    private static ImageIcon resizeImage(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newImage);
    }

    private void startGame(JFrame frame) {
        frame.getContentPane().removeAll();
        StartGame startGame = new StartGame();
        frame.add(startGame);
        frame.validate();
        startGame.requestFocusInWindow();
    }
}
