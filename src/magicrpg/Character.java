package magicrpg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



class Character extends JLabel {
    int x, y; // position of the image
    int dx, dy; // direction of movement
    String direction = "";

    Character(ImageIcon chara, int initialX, int initialY, int initialDx, int initialDy) {
        super(chara); // Initialize the label with the image
        x = initialX;
        y = initialY;
        dx = initialDx;
        dy = initialDy;
        setBounds(x, y, 200, 200); // Set initial position and size of the label
    }

    // Method to update the position of the character
    public void updatePosition(int panelWidth, int panelHeight) {
        // Update the position of the character
        x += dx;
        y += dy;

        // If the character reaches the edge of the panel, reverse its direction
        if (x < 0 || x + getWidth() > panelWidth) {
            dx = -dx;
        }
        if (y < 0 || y + getHeight() > panelHeight) {
            dy = -dy;
        }

        setLocation(x, y); // Update the position of the label
    }

    // Method to move the character up
    public void moveUp() {
    if (y - 5 >= 5) { // Check if the character is within the boundary
        y -= 5;
        setLocation(x, y); // Update the position of the label
        direction = "up";
    }
    }
    
     // Method to move the character down
    public void moveDown() {
        if (y + getHeight() + 5 <= getParent().getHeight() - 5) { // Check if the character is within the boundary
            y += 5;
            setLocation(x, y); // Update the position of the label
            direction = "down";
        }
    }

    // Method to move the character left
    public void moveLeft() {
        if (x - 5 >= 5) { // Check if the character is within the boundary
            x -= 5;
            setLocation(x, y); // Update the position of the label
            direction = "left";
        }
    }

    // Method to move the character right
    public void moveRight() {
        if (x + getWidth() + 5 <= getParent().getWidth() - 5) { // Check if the character is within the boundary
            x += 5;
            setLocation(x, y); // Update the position of the label
            direction = "right";
        }
    }

    
}