/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.objects;

import com.maze.game.ItemObject;
import com.maze.levels.Level;

/**
 *
 * @author Thomas
 */
public class Reset extends ItemObject {
    
    private Level level;
    
    public Reset() {
        this.setImage("Grass.png");
    }
    
    public void setLevel(Level level) {
        this.level = level;
    }
    
    public void use() {
        level.clearQuickestRoute();
    }
    
}
