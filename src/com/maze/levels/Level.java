/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.levels;

import com.maze.game.ItemObject;
import java.util.HashMap;
import javax.swing.JComponent;

/**
 *
 * @author Thomas
 */


public class Level extends JComponent {
    
    final int ROWS = 10;
    final int COLUMNS = 15;
    
    public String[][] map = new String[ROWS][COLUMNS];
    private ItemObject[][] loadedMap;
    
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
    
}