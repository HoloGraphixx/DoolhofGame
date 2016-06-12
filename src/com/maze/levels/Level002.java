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
public class Level002 extends Level {
 
    public Level002(String name, Menu menu, LevelManager levelManager) {
        String[][] tiles = {    { "", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W" },
                                    { "W", "", "W", "", "", "", "", "", "", "", "", "", "", "", "W" },
                                    { "W", "C", "W", "", "", "W", "W", "W", "", "W", "W", "W", "W", "", "W" },
                                    { "W", "W", "W", "", "", "W", "", "", "", "", "", "", "W", "", "W" },
                                    { "W", "W", "", "", "", "W", "", "", "", "F", "B", "", "W", "", "W" },
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
        
        super.x = 8;
        super.y = 2;
    }
    
    
}
