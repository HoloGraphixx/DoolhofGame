/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.game;

import com.maze.levels.*;
import com.maze.objects.*;

import java.applet.Applet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Thomas
 */
public class LevelGenerator extends Applet{
    
    private HashMap<String, ItemObject> objects = new HashMap<>();
    private ItemObject[][] currentMap;
    
    private JFrame frame = null;
             
    private Level currentLevel = null;
    
    
    private final List<Level> levels
        = new ArrayList<Level>(){{
            add(new Level001());
            add(new Level002());
            add(new Level003());
        }};
    
    public LevelGenerator(JFrame frame) {
        // Vul de frame
        this.frame = frame;
        
        // Vul de objecten lijst
        objects.put("w", new Bazooka());
        objects.put("", new EmptyTile());

        this.Load();
    }
    
    /// Laad de map in
    public void Load() {
        int rowsCount = 0;
        int colsCount = 0;
        
        for (String[] row : this.currentLevel.map) {
            for (String col : row) {
                this.currentMap[colsCount][rowsCount] = objects.get(col.toLowerCase());
                colsCount += 1;
            }
            
            rowsCount += 1;
        }
        
        this.Start();
    }
    
    public void Start() {
        this.frame.add(this.currentLevel);
    }
}
