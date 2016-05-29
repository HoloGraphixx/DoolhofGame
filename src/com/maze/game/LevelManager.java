/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.game;

import com.maze.levels.*;
import com.maze.objects.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Thomas
 */
public final class LevelManager extends JFrame {

    private HashMap<String, ItemObject> objects = new HashMap<>();
    private int HEIGHT = 809;
    private int WIDTH = 1056;

    public JFrame frame = null;
    public Level currentLevel = null;
    
    public Menu menu = new Menu();

    private final List<Level> levels
            = new ArrayList<Level>() {
                {
                    add(new Level001());
                    add(new Level002());
                    add(new Level003());
                }
            };

    public LevelManager(JFrame frame) {
        // Vul de frame
        this.frame = frame;
        
        // Vul de objecten lijst
        objects.put("B", new Bazooka());
        objects.put("", new EmptyTile());
        objects.put("W", new Wall());
        objects.put("F", new Friend());
        objects.put("C", new Cheater());
        objects.put("H", new Helper());
        this.currentLevel = levels.get(0);

        this.load();
    }

    /// Laad de map in
    public void load() {
        this.currentLevel.Load(objects);

        this.start();
    }

    public void start() {
            JButton jButtonStart = new JButton("Start");
            JButton jButtonRestart = new JButton("Restart");
            
            this.menu.add(jButtonStart);
            this.menu.add(jButtonRestart);
            jButtonRestart.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (menu.timerState) {
                        menu.timerStop();
                        
                    } else {
                        menu.timerStart();
                       
                    }
                }
            });
                        
        if (this.frame != null) {            
            this.frame.setTitle("Doolhof");
            this.frame.setSize(this.WIDTH, this.HEIGHT);
            this.frame.add(this.menu, BorderLayout.NORTH);
            this.frame.add(this.currentLevel, BorderLayout.CENTER);
            this.frame.setResizable(false);
            this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.frame.setVisible(true);
            
            this.currentLevel.requestFocus();
        }
    }
}
