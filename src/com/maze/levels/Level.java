/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.levels;

import javax.swing.JComponent;

/**
 *
 * @author Thomas
 */
public class Level extends JComponent {

    final int ROWS = 10;
    final int COLUMNS = 15;

    public String[][] map = new String[COLUMNS][ROWS];

}
