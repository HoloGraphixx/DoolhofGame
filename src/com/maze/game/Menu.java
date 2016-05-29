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
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author thomas_laptop
 */
public final class Menu extends JPanel implements ActionListener {
       
    private final Time time = new Time();
    private Timer t = new Timer();
    
    public Steps steps = new Steps();
    
    public boolean timerState = false;
        
    final JLabel jLabelTime = new JLabel("Time: 00:00:00");
    final JLabel jLabelSteps = new JLabel("Steps: 0");
    
    public Menu() {
        jLabelTime.setForeground(Color.WHITE);
        jLabelSteps.setForeground(Color.WHITE);
        
        this.add(jLabelTime);
        this.add(jLabelSteps);
        
        this.timerStart();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    public void setSteps() {
        this.steps.addStep();
        
        this.jLabelSteps.setText("Stappen: " + this.steps.getSteps());
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
}
