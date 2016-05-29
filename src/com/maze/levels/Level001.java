/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.levels;

import com.maze.game.LevelManager;
import com.maze.game.Menu;

/**
 *
 * @author Thomas
 */
public class Level001 extends Level {
    
    public Level001(Menu menu, LevelManager levelManager) {
        String[][] tiles = 
        {
            { "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W",},
            { "W", "", "", "", "", "", "", "W", "", "", "", "", "", "", "", "W", "", "", "", "", "W",},
            { "W", "", "W", "W", "W", "W", "W", "W", "", "", "W", "W", "", "W", "W", "W", "", "", "W", "", "W",},
            { "W", "", "W", "", "", "W", "B", "W", "", "", "W", "", "", "", "", "W", "W", "", "W", "", "W",},
            { "W", "", "", "", "", "W", "", "W", "", "", "W", "W", "W", "W", "", "W", "", "", "W", "", "W",},
            { "W", "", "W", "", "", "", "", "W", "W", "", "W", "", "", "", "", "W", "", "W", "W", "", "W",},
            { "W", "", "W", "W", "W", "W", "", "W", "", "", "W", "", "W", "", "W", "W", "", "", "W", "", "W",},
            { "W", "", "W", "", "", "", "", "W", "", "W", "W", "", "", "", "", "W", "", "", "W", "", "W",},
            { "W", "", "W", "", "W", "W", "W", "W", "", "", "W", "W", "W", "", "W", "W", "", "", "W", "", "W",},
            { "W", "", "W", "", "", "", "", "W", "", "", "W", "", "", "", "", "W", "", "", "W", "", "W",},
            { "W", "", "W", "W", "W", "", "W", "W", "W", "", "W", "W", "W", "", "W", "W", "W", "", "W", "", "W",},
            { "W", "", "", "", "W", "", "", "", "", "", "", "W", "", "", "", "W", "", "", "W", "", "W",},
            { "W", "", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "", "W", "W", "", "W", "W", "", "W",},
            { "W", "", "", "", "", "", "", "", "", "", "", "", "W", "", "", "", "", "", "W", "F", "W",},
            { "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W",},
        };
     
        super.map = tiles;
        super.levelManager = levelManager;
        super.menu = menu;
    }
}
