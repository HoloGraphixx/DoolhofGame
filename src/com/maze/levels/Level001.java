/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.levels;

/**
 *
 * @author Thomas
 */
public class Level001 extends Level {
    
    public Level001() {
        String[][] tiles = {    { "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W" },
                                    { "W", "B", "", "", "", "", "", "", "", "", "", "", "", "", "W" },
                                    { "W", "", "B", "", "", "", "", "", "", "", "", "", "", "", "W" },
                                    { "W", "", "", "B", "", "", "", "", "", "", "", "", "", "B", "W" },
                                    { "W", "", "", "", "B", "", "", "", "", "", "", "", "B", "", "W" },
                                    { "W", "", "", "", "", "B", "", "", "", "", "", "B", "", "", "W" },
                                    { "W", "", "", "", "", "", "B", "", "", "", "B", "", "", "", "W" },
                                    { "W", "", "", "", "", "", "", "B", "", "B", "", "", "", "", "W" },
                                    { "W", "", "", "", "", "", "", "", "B", "", "", "", "", "", "W" },
                                    { "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W" }
                                };
     
        super.map = tiles;
    }
}
