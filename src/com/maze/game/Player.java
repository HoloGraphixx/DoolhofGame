/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.game;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Thomas
 */
public class Player {

    public Image image;
    
    private int tileX, tileY;
    
    public Player(int xPos, int yPos) {
        ImageIcon imageIcon = new ImageIcon("src/com/maze/images/Rock.png");
        this.image = imageIcon.getImage();
        
        // Start position
        this.tileX = xPos;
        this.tileY = yPos;
    }
    
    public int getTileX() {
        return this.tileX;
    }
    
    public int getTileY() {
        return this.tileY;
    }
    
    public void move(int dx, int dy) {        
        tileX += dx;
        tileY += dy;
    }
    
}
