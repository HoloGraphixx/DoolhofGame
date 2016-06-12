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
public class Level003 extends Level {
    
    public Level003(String name, Menu menu, LevelManager levelManager) {
        String[][] tiles = {    { "F", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W" },
                                    { "W", "", "W", "", "", "", "", "", "", "", "", "", "", "", "W" },
                                    { "W", "C", "W", "", "", "W", "W", "W", "", "W", "W", "W", "W", "", "W" },
                                    { "W", "", "W", "", "", "W", "", "", "", "", "", "", "W", "", "W" },
                                    { "W", "", "", "", "", "W", "", "", "", "F", "B", "", "W", "", "W" },
                                    { "W", "H", "W", "", "", "W", "", "", "", "", "", "", "W", "", "W" },
                                    { "W", "", "W", "", "", "W", "", "", "", "", "", "", "W", "", "W" },
                                    { "W", "", "W", "", "", "W", "W", "W", "W", "W", "W", "W", "W", "", "W" },
                                    { "W", "", "W", "", "", "", "", "", "", "", "", "", "", "", "W" },
                                    { "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W" }
                                };

        super.name = name;

        super.map = tiles;
        super.menu = menu;

        super.levelManager = levelManager;
        
        super.x = 6;
        super.y = 1;
    }
    
}
