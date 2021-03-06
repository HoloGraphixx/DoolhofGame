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
import javax.swing.ImageIcon;

/**
 *
 * @author Thomas
 */
public class ItemObject implements Cloneable {

    public static final int SIZE = 50;

    private String imageLocation = "";
    private boolean dot = false;
    private boolean movable = true;
    private Point position;

    protected int index = 0;

    public ImageIcon getImageIcon() {
        return new ImageIcon(this.imageLocation);
    }

    public void setImage(String url) {
        this.imageLocation = "src/com/maze/images/" + url;
    }

    public Point getPosition() {
        return this.position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public boolean isDot() {
        return this.dot;
    }

    public void setDot(boolean dot) {
        this.dot = dot;
    }

    public boolean isMovable() {
        return this.movable;
    }

    public void setMovable(boolean movable) {
        this.movable = movable;
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
        if (this.dot) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.cyan);
            g2d.fillOval((int) this.position.getX() * SIZE + ((SIZE - 10) / 2), (int) this.position.getY() * SIZE + ((SIZE - 10) / 2), 10, 10);
        }
    }
}
