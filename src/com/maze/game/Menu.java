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

    private Timer t = new Timer();
    private int bazookaShots = 0;

    private Steps steps = new Steps();
    private Time time = new Time();

    private JLabel jLabelTime = new JLabel("Time: 00:00:00,");
    private JLabel jLabelSteps = new JLabel("Steps: 0,");
    private JLabel jLabelShots = new JLabel("Bazooka shots: " + bazookaShots);
    private JButton jButtonStart = new JButton("Start");

    final private LevelManager levelManager;

    public Menu(LevelManager lm) {
        this.levelManager = lm;

        JButton jButtonRestart = new JButton("Restart");

        this.add(jButtonStart);
        jButtonStart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                levelManager.currentLevel.setStarted(true);
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void removeStartButton() {
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
        if ((this.steps.getSteps() + i) < 0) {
            this.steps.setSteps(0);
        } else {
            this.steps.addSteps(i);
        }
        
        this.setSteps();
    }
    
    public void addSeconds(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.time.addSecond();
        }
    }
    
    public void takeSeconds(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.time.takeSecond();
        }
    }

    public void timerStop() {
        this.t.cancel();
    }

    public void timerStart() {
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

        System.out.println("Level reset");
    }
}
