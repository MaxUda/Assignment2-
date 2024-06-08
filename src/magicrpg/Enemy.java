package magicrpg;

import javax.swing.*;
import java.awt.*;

class Enemy extends JLabel {
    int x, y; // position of the image
    int dx, dy; // direction of movement

    
    Enemy(ImageIcon enemy, int initialX, int initialY, int initialDx, int initialDy) {
        super(enemy); // Initialize the label with the image
        x = initialX;
        y = initialY;
        dx = initialDx;
        dy = initialDy;
        setBounds(x, y, 200, 200); // Set initial position and size of the label
    }

    // Method to update the position of the enemy
    public void position(int panelWidth, int panelHeight) {
        // Update the position of the enemy
        x += dx;
        y += dy;

        // If the enemy reaches the edge of the panel, reverse its direction
        if (x < 0 || x + getWidth() > panelWidth) 
        {
            dx = -dx;
            x += dx; // Move the enemy back inside the panel
        }
        if (y < 0 || y + getHeight() > panelHeight) 
        {
            dy = -dy;
            y += dy; // Move the enemy back inside the panel
        }

        setLocation(x, y); // Update the position of the label
    }

    // Method to move the enemy randomly
    public void moveRandomly() {
        // Generate a random direction
        double direction = Math.random() * 2 * Math.PI;
        dx = (int)(10 * Math.cos(direction));
        dy = (int)(10 * Math.sin(direction));
    }
    
    
}
