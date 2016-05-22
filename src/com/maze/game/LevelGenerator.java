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
    private int HEIGHT = 500;
    private int WIDTH = 750;

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

    public LevelGenerator(JFrame frame) {
        // Vul de frame
        this.frame = frame;
        // Vul de objecten lijst
        objects.put("B", new Bazooka());
        objects.put("", new EmptyTile());
        objects.put("W", new Wall());
        this.currentLevel = levels.get(0);

        this.Load();
    }

    /// Laad de map in
    public void Load() {
        this.currentLevel.Load(objects);

        this.Start();
    }

    public void Start() {
        if (this.frame != null) {
            this.frame.setSize(this.WIDTH, this.HEIGHT);
            this.frame.setLayout(new GridLayout(15, 10));
            this.frame.add(this.currentLevel);
            this.frame.setResizable(false);
            this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.frame.setVisible(true);
        }
    }
}
