package magicrpg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Layout {
    public static void GUI() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.BLACK);

        // Load and resize images
        ImageIcon startIcon = new ImageIcon("start.png");
        ImageIcon exitIcon = new ImageIcon("exit.png");
        ImageIcon helpIcon = new ImageIcon("help.png");
        ImageIcon rankingIcon = new ImageIcon("rank.png");

        startIcon = resizeImage(startIcon, 120, 100);
        exitIcon = resizeImage(exitIcon, 120, 100);
        helpIcon = resizeImage(helpIcon, 120, 100);
        rankingIcon = resizeImage(rankingIcon, 120, 100);

        // Create labels with images
        JLabel start = new JLabel(startIcon);
        start.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel exit = new JLabel(exitIcon);
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel help = new JLabel(helpIcon);
        help.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel ranking = new JLabel(rankingIcon);
        ranking.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add MouseListeners to the labels
        start.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Login(frame);  // Show the Login dialog
            }
        });

        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
            }
        });

        help.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Code for help
            }
        });

        ranking.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Code for ranking
            }
        });

        // Add labels to the panel with vertical spacing and centering
        panel.add(Box.createVerticalGlue());
        panel.add(start);
        panel.add(Box.createVerticalStrut(10));
        panel.add(ranking);
        panel.add(Box.createVerticalStrut(10));
        panel.add(help);
        panel.add(Box.createVerticalStrut(10));
        panel.add(exit);
        panel.add(Box.createVerticalGlue());

        frame.setSize(600, 600);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static ImageIcon resizeImage(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newImage);
    }
}
