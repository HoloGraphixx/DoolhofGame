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
    private int bazookaShots = 0;   
    private Direction currentDirection;
    
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
                this.setDirection(Direction.UP);
                break;
            case DOWN:
                imageIcon = this.down;    
                this.setDirection(Direction.DOWN);
                break;
            case LEFT:
                imageIcon = this.left;    
                this.setDirection(Direction.LEFT);
                break;
            case RIGHT:
                imageIcon = this.right;    
                this.setDirection(Direction.RIGHT);
                break;
            default: // FALLBACK
                imageIcon = this.down;
                this.setDirection(Direction.DOWN);
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
    
    public void addBazookaShots(int bazookaShots) {
        this.bazookaShots += bazookaShots;
    }
    
    public int getBazookaShots() {
        return this.bazookaShots;
    }
    
    public void lowerBazookaShots() {
        this.bazookaShots--;
    }
    
    public void resetBazookaShots() {
        this.bazookaShots = 0;
    }
    
    public void setDirection(Direction direction) {
        this.currentDirection = direction;
    }
    
    public Direction getDirection() {
        return this.currentDirection;
    }
    
    public void setPos(int x, int y) {
        this.tileX = x;
        this.tileY = y;
    }
    
}
