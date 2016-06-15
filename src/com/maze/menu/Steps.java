/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.menu;

/**
 *
 * @author thomas_laptop
 */
public class Steps {
    
    private Integer steps = 0;

    public void setSteps(int i) {
        this.steps = i;
    }
    
    public void addStep() {
        this.steps++;
    }
    
    public void addSteps(int steps) {
        this.steps += steps;
    }
    
    public Integer getSteps() {
        return this.steps;
    }
    
    public void resetSteps() {
        this.steps = 0;
    }
}
