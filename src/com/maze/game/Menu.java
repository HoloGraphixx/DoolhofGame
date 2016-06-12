/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.game;

import com.maze.menu.Steps;
import com.maze.menu.Time;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author thomas_laptop
 */
public final class Menu extends JPanel implements ActionListener {
       
    public Timer t = new Timer();
    private int bazookaShots = 0;
    
    public Steps steps = new Steps();    
    public boolean timerState = false;
    public final Time time = new Time();
        
    final JLabel jLabelTime = new JLabel("Time: 00:00:00,");
    final JLabel jLabelSteps = new JLabel("Steps: 0,");
    final JLabel jLabelShots = new JLabel("Bazooka shots: " + bazookaShots);
    final JButton jButtonStart = new JButton("Start");
    
    final LevelManager levelManager;
    
    public Menu(LevelManager lm) {
        this.levelManager = lm;
        
        JButton jButtonRestart = new JButton("Restart");

        this.add(jButtonStart);
        jButtonStart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                levelManager.currentLevel.started = true;
                removeStartButton();
                timerStart();
            }
        });
        
        this.add(jButtonRestart);
        jButtonRestart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (levelManager != null) {
                    levelManager.resetLevel();
                }
            }
        });
        
        jLabelTime.setForeground(Color.WHITE);
        jLabelSteps.setForeground(Color.WHITE);
        jLabelShots.setForeground(Color.WHITE);
        
        this.add(jLabelTime);
        this.add(jLabelSteps);
        this.add(jLabelShots);
        
        //this.timerStart();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    public void removeStartButton(){
        this.remove(jButtonStart);
        this.repaint();
    }
    
    public void addShots(int shots) {
        this.bazookaShots += shots;
        this.setBazookaShots();
    }
    
    public void shoot() {
        this.bazookaShots--;
        this.setBazookaShots();
    }
    
    public void setBazookaShots() {
        this.jLabelShots.setText("Bazooka shots: " + this.bazookaShots);
    }
        
    public void setSteps() {        
        this.jLabelSteps.setText("Steps: " + this.steps.getSteps() + ",");
    }
    
    public void addStep() {
        this.steps.addStep();
        this.setSteps();
    }
    
    public void addSteps(int i) {
        this.steps.addSteps(i);
        this.setSteps();
    }
    
    public void timerStop() {
        this.t.cancel();
        this.timerState = false;
    }
    
    public void timerStart() {
        this.timerState = true;
        this.t = new Timer();
        
        t.schedule(new TimerTask() {

            @Override
            public void run() {
                time.addSecond();  
                jLabelTime.setText(time.getTime());
            }
        }, 0, 1000);
    }
    
    public void reset() {
        this.steps.resetSteps();
        this.time.resetTime();
        this.bazookaShots = 0;
        
        this.setBazookaShots();
        this.setSteps();
        jLabelTime.setText(time.getTime());
        
        System.out.println("Menu reset");
    }
}
