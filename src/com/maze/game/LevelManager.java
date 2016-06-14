/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.game;

import com.maze.levels.*;
import com.maze.objects.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Thomas
 */
public final class LevelManager extends JFrame {

    final private HashMap<String, ItemObject> objects = new HashMap<>();
    final private int HEIGHT = 809;
    final private int WIDTH = 1056;

    public JFrame frame = null;
    public Level currentLevel = null;
    public int level = 0;
    public Menu menu = new Menu(this);
    public Player player;
    public LevelManager levelManager = this;

    private final List<Level> levels = new ArrayList<Level>() {
        {
            add(new Level001());
            add(new Level002());
            add(new Level003());
        }
    };

    public LevelManager(JFrame frame) {
        // Vul de frame
        this.frame = frame;
        this.player = new Player(6, 1);
       
        this.currentLevel = levels.get(0);
        this.currentLevel.p = this.player;
        this.currentLevel.addKeyListener(new KeyListener(this.currentLevel));
        this.currentLevel.setMenu(this.menu);
        this.currentLevel.setLevelManager(this);
        this.level = 0;
        
        // Vul de objecten lijst
        objects.put("B", new Bazooka());
        objects.put("", new EmptyTile());
        objects.put("W", new Wall());
        objects.put("F", new Friend());
        objects.put("C", new Cheater());
        objects.put("H", new Helper());
        objects.put("R", new Reset());

        this.load();
    }

    /// Laad de map in
    public void load() {
        this.currentLevel.Load(objects);
        
        this.start();
    }

    public void start() {
        if (this.frame != null) {            
            this.frame.setTitle("Doolhof");
            this.frame.setSize(this.WIDTH, this.HEIGHT);
            this.menu.setBackground(Color.BLACK);
            this.frame.add(this.menu, BorderLayout.NORTH);
            this.frame.add(this.currentLevel, BorderLayout.CENTER);
            this.frame.setResizable(false);
            this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.frame.setVisible(true);
            
            this.currentLevel.requestFocus();
        }
    }
    
    public void nextLevel() {
        frame.remove(this.currentLevel);
        if (this.level < 2) {
            this.level++;
            this.currentLevel = this.levels.get(this.level);
            this.currentLevel.p = this.player;
            this.currentLevel.addKeyListener(new KeyListener(this.currentLevel));
            this.player.setPos(new Point(this.currentLevel.position.x, this.currentLevel.position.y));
            
            this.player.resetBazookaShots();
            this.menu.reset();
            this.currentLevel.setMenu(this.menu);
            this.currentLevel.setLevelManager(this);
                        
            this.currentLevel.Load(objects);
            this.currentLevel.repaint();
            this.currentLevel.started = true;
            frame.add(this.currentLevel);
        } else {
            // Spel uitgespeeld
            JOptionPane.showMessageDialog(this.frame, "Gefeliciteerd, je hebt het spel uitgespeeld!", "Uitgespeeld!", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        }
    }
    
    public void resetLevel() {
        frame.remove(this.currentLevel);
        this.player.resetBazookaShots();
        this.menu.reset();      
        this.player.setPos(new Point(this.currentLevel.position.x, this.currentLevel.position.y));
        this.currentLevel.Load(objects);
        this.currentLevel.repaint();
        frame.add(this.currentLevel);
        
        System.out.println("Reset map: " + this.currentLevel.name);
    }
}
