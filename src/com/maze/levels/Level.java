/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.levels;

import com.maze.game.ItemObject;
import com.maze.game.LevelManager;
import com.maze.game.Menu;
import com.maze.game.Player;
import com.maze.game.QueueOrderer;
import com.maze.objects.Cheater;
import com.maze.objects.Wall;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import javax.swing.JPanel;

/**
 *
 * @author Thomas
 */
public class Level extends JPanel implements ActionListener {

    final int ROWS = 15;
    final int COLUMNS = 21;

    public String name;
    public String[][] map = new String[ROWS][COLUMNS];
    public ItemObject[][] loadedMap = new ItemObject[ROWS][COLUMNS];
    public LevelManager levelManager;
    public Menu menu;
    public Player p;
    public int x, y;
    public boolean started = false;
    
    private ArrayList<ItemObject> queue = new ArrayList<>();
    
    public Level() {
        setFocusable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
        
    public void Load(HashMap<String, ItemObject> objects) {
        loadedMap = new ItemObject[this.map.length][this.map[0].length];

        int rowsCount = 0;

        for (String[] row : this.map) {
            int colsCount = 0;

            for (String col : row) {
                // Beetje omslachtig, maar dit zorgt er voor dat X en Y gevuld kunnen worden.
                ItemObject object = objects.get(col);
                ItemObject finalObject = new ItemObject();
                
                if (object instanceof Wall) {
                    finalObject = new Wall();
                } else {             
                    try {
                        finalObject = (ItemObject) object.clone();
                    } catch (Exception ex) {}
                }
                
                Point point = new Point(colsCount, rowsCount);
                finalObject.position = point;
                
                this.loadedMap[rowsCount][colsCount] = finalObject;
                    
                colsCount += 1;
            }
            rowsCount += 1;
        }
        
        System.out.println("Map: " +  this.name + " loaded!");
    }
    
    public void queue(ItemObject obj) {
        queue.add(obj);
    }
    
    public ItemObject getGameObject(Point point) {
        return this.loadedMap[(int)point.getY()][(int)point.getX()];
    }
    
    public void drawQueue() {
        Graphics g = this.levelManager.currentLevel.getGraphics();
        
        Collections.sort(queue, new QueueOrderer());
        for(ItemObject obj : queue) {
            
        }
        
        this.queue.clear();
    }
    
    public void clearDots() {
        for(ItemObject[] y : this.loadedMap) {
            for(ItemObject x : y) {
                if(x.isDot()) {
                    x.setDot(false);
                    this.queue(x);
                }
            }
        }
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int rowsCount = 0;

        //System.out.println("PAINTING! " + this.loadedMap.length);
        //System.out.println("NAME: " + name);

        for (ItemObject[] row : this.loadedMap) {
            int colsCount = 0;

            for (ItemObject col : row) {
                g.drawImage(col.getImageIcon().getImage(), colsCount * 50, rowsCount * 50, null);
                col.draw(g);
                colsCount += 1;
            }

            rowsCount += 1;
        }

        g.drawImage(p.image, p.getTileX() * 50, p.getTileY() * 50, null);

        repaint();
        grabFocus();
        requestFocus();
    }
}
