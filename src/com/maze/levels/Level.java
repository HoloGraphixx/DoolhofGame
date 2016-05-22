/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.levels;

import com.maze.game.ItemObject;
import java.awt.Color;
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
    
    final int ROWS = 10;
    final int COLUMNS = 15;
    
    public String[][] map = new String[ROWS][COLUMNS];
    public ItemObject[][] loadedMap = new ItemObject[ROWS][COLUMNS];
    
    public void Load(HashMap<String, ItemObject> objects) {
        int rowsCount = 0;

        for (String[] row : this.map) {
            int colsCount = 0;

            for (String col : row) {
                this.loadedMap[rowsCount][colsCount] = objects.get(col);
                colsCount += 1;
            }

            rowsCount += 1;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        int rowsCount = 0;

        for (ItemObject[] row : this.loadedMap) {
            int colsCount = 0;

            for (ItemObject col : row) {
                g.drawImage(col.getImageIcon().getImage(), colsCount * 50, rowsCount * 50, null);
                colsCount += 1;
            }

            rowsCount += 1;
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}