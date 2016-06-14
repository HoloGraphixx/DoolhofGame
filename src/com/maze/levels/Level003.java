/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.levels;

import java.awt.Point;

/**
 *
 * @author Thomas
 */
public class Level003 extends Level {
    
    public Level003() {
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
        
        super.map = tiles;
        super.position = new Point(6, 1);
    }
}
