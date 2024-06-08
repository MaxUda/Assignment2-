package magicrpg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class StartGame extends JPanel {
    private Image backgroundImage;
    private Character character;
    private ArrayList<Enemy> enemies;

    StartGame() {
        // Load the background image
        backgroundImage = new ImageIcon("gameBG.png").getImage();

        setLayout(new BorderLayout()); // Use BorderLayout

        // Create a new panel
        JPanel panel1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel1.setLayout(null); // Use null layout to freely position the label
        panel1.setOpaque(false);

        // Character
        ImageIcon chara = new ImageIcon("character.png"); // Load the image
        Image image = chara.getImage(); // transform it
        Image newimg = image.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH); // resize
        chara = new ImageIcon(newimg);

        // Create a Character object and add it to the panel
        character = new Character(chara, 0, 0, 5, 5);
        panel1.add(character); // Add the character to the panel

        // Add panel1 to the StartGame panel
        add(panel1, BorderLayout.CENTER);

        // Load new enemy images
        ImageIcon enemyWhite = new ImageIcon("enemywhite.png");
        ImageIcon enemyGrey = new ImageIcon("enemygrey.png");

        Image imageWhite = enemyWhite.getImage();
        Image newImgWhite = imageWhite.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
        enemyWhite = new ImageIcon(newImgWhite);

        Image imageGrey = enemyGrey.getImage();
        Image newImgGrey = imageGrey.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
        enemyGrey = new ImageIcon(newImgGrey);

        // Create Enemy objects with the new images and add them to the panel
        enemies = new ArrayList<>();
        Enemy enemy1 = new Enemy(enemyWhite, 100, 100, 5, 5);
        Enemy enemy2 = new Enemy(enemyGrey, 200, 200, 5, 5);
        enemies.add(enemy1);
        enemies.add(enemy2);
        panel1.add(enemy1);
        panel1.add(enemy2);

        // Create a Timer to update the position of the enemies every 100 milliseconds
        Timer enemyTimer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Enemy enemy : enemies) {
                    enemy.position(panel1.getWidth(), panel1.getHeight());
                    enemy.moveRandomly();
                }
                panel1.repaint(); // Repaint the panel to update the enemies' positions
            }
        });
        enemyTimer.start(); // Start the Timer

        // Create a Timer to update the position of the character every 100 milliseconds
        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (character.direction) {
                    case "up":
                        character.moveUp();
                        break;
                    case "down":
                        character.moveDown();
                        break;
                    case "left":
                        character.moveLeft();
                        break;
                    case "right":
                        character.moveRight();
                        break;
                }
                panel1.repaint(); // Repaint the panel to update the character's position
            }
        });
        timer.start(); // Start the Timer

        // Add key bindings for character movement
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"), "moveUp");
        getActionMap().put("moveUp", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                character.moveUp();
            }
        });

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"), "moveDown");
        getActionMap().put("moveDown", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                character.moveDown();
            }
        });

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "moveLeft");
        getActionMap().put("moveLeft", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                character.moveLeft();
            }
        });

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "moveRight");
        getActionMap().put("moveRight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                character.moveRight();
            }
        });

        // Add key binding for removing enemies using Enter key
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ENTER"), "removeEnemy");
        getActionMap().put("removeEnemy", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < enemies.size(); i++) {
                    Enemy enemy = enemies.get(i);
                    // Calculate the distance between the centers of the character and the enemy
                    double dx = character.getX() + character.getWidth() / 2.0 - (enemy.getX() + enemy.getWidth() / 2.0);
                    double dy = character.getY() + character.getHeight() / 2.0 - (enemy.getY() + enemy.getHeight() / 2.0);
                    double distance = Math.sqrt(dx * dx + dy * dy);

                    // If the distance is less than a certain threshold, remove the enemy
                    if (distance < 50) { // Change this value to adjust the threshold
                        panel1.remove(enemy);
                        enemies.remove(i);
                        panel1.repaint();
                        break; // Exit the loop after removing an enemy to avoid ConcurrentModificationException
                    }
                }
            }
        });
    }
}