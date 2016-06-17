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
public class Level002 extends Level {

    public Level002() {
        String[][] tiles = {
            {"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W",},
            {"W", "B", "", "", "", "W", "", "W", "X", "W", "", "W", "W", "W", "W", "W", "", "", "W", "F", "W",},
            {"W", "W", "W", "W", "", "W", "", "W", "", "W", "", "W", "", "", "", "", "", "", "", "", "W",},
            {"W", "", "", "W", "", "W", "", "", "", "W", "", "W", "W", "W", "", "W", "W", "W", "W", "W", "W",},
            {"W", "", "", "W", "", "W", "", "W", "", "", "", "W", "", "W", "", "W", "W", "W", "W", "", "W",},
            {"W", "H", "", "W", "", "W", "", "W", "", "W", "", "W", "", "W", "", "W", "", "", "", "", "W",},
            {"W", "", "", "W", "", "W", "", "W", "", "W", "", "W", "W", "W", "", "W", "W", "", "W", "", "W",},
            {"W", "", "", "W", "", "W", "", "W", "", "W", "", "W", "C", "W", "", "W", "W", "", "W", "", "W",},
            {"W", "", "", "W", "", "W", "", "W", "", "W", "", "W", "", "W", "", "W", "W", "", "W", "", "W",},
            {"W", "W", "W", "W", "", "W", "W", "W", "", "W", "", "W", "W", "W", "", "W", "W", "", "W", "", "W",},
            {"W", "", "", "", "", "", "", "", "", "W", "", "W", "", "W", "", "W", "W", "", "W", "W", "W",},
            {"W", "", "W", "W", "W", "", "W", "W", "W", "W", "", "W", "", "W", "", "", "", "", "W", "", "W",},
            {"W", "", "W", "W", "W", "", "W", "W", "W", "W", "", "W", "", "W", "W", "W", "W", "", "W", "", "W",},
            {"W", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "W",},
            {"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W",}};

        super.map = tiles;
        super.setPosition(new Point(8, 2));
    }
}
