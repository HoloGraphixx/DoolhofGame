/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.game;

import com.maze.levels.Level;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Thomas
 */
public class KeyListener extends KeyAdapter {

    final private Level level;

    public KeyListener(Level level) {
        this.level = level;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Kijk of het level al gestart is, zo nee: negeer de keyInput
        if (this.level.isStarted() == false) {
            return;
        }

        int keycode = e.getKeyCode();

        // Bepaal welke kant de speler op wil en stuur het commando door naar het level
        if (keycode == KeyEvent.VK_W) {
            this.level.playerMove(Player.Direction.UP);
        } else if (keycode == KeyEvent.VK_A) {
            this.level.playerMove(Player.Direction.LEFT);
        } else if (keycode == KeyEvent.VK_S) {
            this.level.playerMove(Player.Direction.DOWN);
        } else if (keycode == KeyEvent.VK_D) {
            this.level.playerMove(Player.Direction.RIGHT);
        } else if (keycode == KeyEvent.VK_SPACE) {
            this.level.shootBazooka();
        }

        // Check voor collision wanneer de speler op de nieuwe tegel staat
        this.level.checkEvents();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
