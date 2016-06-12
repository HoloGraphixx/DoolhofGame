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
import com.maze.objects.Wall;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
  
    public Level() {
        setFocusable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void Load(HashMap<String, ItemObject> objects) {
        System.out.println("LOADING! " + this.map.length);
        loadedMap = new ItemObject[this.map.length][this.map[0].length];

        System.out.println("TEST: " + this.loadedMap.length);

        int rowsCount = 0;

        for (String[] row : this.map) {
            int colsCount = 0;

            for (String col : row) {
                if (objects.get(col).getClass() == new Wall().getClass()) {
                    this.loadedMap[rowsCount][colsCount] = new Wall();
                } else {
                    this.loadedMap[rowsCount][colsCount] = objects.get(col);
                }                
                
                colsCount += 1;
            }

            rowsCount += 1;
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
