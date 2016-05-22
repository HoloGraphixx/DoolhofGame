/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.game;

import com.maze.levels.*;
import com.maze.objects.*;

import java.applet.Applet;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Thomas
 */
public final class LevelGenerator extends JFrame {

    private HashMap<String, ItemObject> objects = new HashMap<>();
    private ItemObject[][] currentMap;
    private int HEIGHT = 320;
    private int WIDHT = 480;

    public JFrame frame = null;

    public Level currentLevel = null;

    private final List<Level> levels
            = new ArrayList<Level>() {
                {
                    add(new Level001());
                    add(new Level002());
                    add(new Level003());
                }
            };

    public LevelGenerator() {
        // Vul de frame
        //this.frame = frame;
        // Vul de objecten lijst
        //objects.put("B", new Bazooka());
        objects.put("", new EmptyTile());
        objects.put("W", new Wall());
        this.currentLevel = levels.get(0);
        currentMap = new ItemObject[15][10];
        
        
        this.Load();
    }

    /// Laad de map in
    public void Load() {
        int rowsCount = 0;
        int colsCount = 0;
        
        for (String[] row : this.currentLevel.map) {
            for (String col : row) {
                this.currentMap[colsCount][rowsCount] = objects.get(col);
                colsCount += 1;
            }

            rowsCount += 1;
        }

        this.Start();
    }

    public void Start() {

        this.frame.setSize(this.HEIGHT, this.WIDHT);
        this.frame.setLayout(new GridLayout(15, 10));
        this.frame.add(this.currentLevel);
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);

    }
}
