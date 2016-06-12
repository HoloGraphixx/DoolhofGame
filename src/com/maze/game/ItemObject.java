/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;

/**
 *
 * @author Thomas
 */
public class ItemObject implements Cloneable {
   
    public Point position;
    public static final int SIZE = 50;
    
    private String image = "";
    private ImageIcon imageIcon;
    private boolean dot = false;
    protected int index = 0;
    
    public ImageIcon getImageIcon() {
        return new ImageIcon(this.image);
    }
    
    public void setImage(String url) {
       this.image = "src/com/maze/images/" + url;
    }  
    
    public boolean isDot() {
        return this.dot;
    }
    
    public void setDot(boolean dot) {
        this.dot = dot;
    }
    
    public Point getPosition() {
        return this.position;
    }
    
    public int getIndex() {
        return this.index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    public void draw(Graphics g) {
        //g.drawImage(this.imageIcon.getImage(), (int) this.position.getX() * SIZE, (int) this.position.getY() * SIZE, null);
        if (this.dot) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(Color.YELLOW);
            g2d.fillOval((int) this.position.getX() * SIZE + ((SIZE - 10) / 2), (int) this.position.getY() * SIZE + ((SIZE - 10) / 2), 10, 10);
        }
    }
}
