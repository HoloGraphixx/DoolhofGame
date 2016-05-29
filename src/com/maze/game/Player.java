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
    
    private ImageIcon up, right, left, down;
    
    public Player(int xPos, int yPos) {
        this.up = new ImageIcon("src/com/maze/images/player_up.png");
        this.down = new ImageIcon("src/com/maze/images/player_down.png");
        this.right = new ImageIcon("src/com/maze/images/player_right.png");
        this.left = new ImageIcon("src/com/maze/images/player_left.png");
        
        this.setImage(Direction.DOWN);
        
        // Start position
        this.tileX = xPos;
        this.tileY = yPos;
    }
    
    public void setImage(Direction direction) {
        ImageIcon imageIcon;
        
        switch (direction) {
            case UP:
                imageIcon = this.up;
                break;
            case DOWN:
                imageIcon = this.down;    
                break;
            case LEFT:
                imageIcon = this.left;    
                break;
            case RIGHT:
                imageIcon = this.right;    
                break;
            default: // FALLBACK
                imageIcon = this.down;
                break;
        }
    
        this.image = imageIcon.getImage();
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
    
    public enum Direction {
        UP, DOWN, RIGHT, LEFT
    }
    
}
