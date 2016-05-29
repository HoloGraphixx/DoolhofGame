/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.levels;

import com.maze.game.ItemObject;
import com.maze.game.LevelManager;
import com.maze.game.Menu;
import com.maze.game.Player;
import com.maze.game.Player.Direction;
import com.maze.objects.Cheater;
import com.maze.objects.Friend;
import com.maze.objects.Wall;
import com.maze.objects.Bazooka;
import com.maze.objects.EmptyTile;
import com.maze.objects.Helper;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import javax.swing.JPanel;

/**
 *
 * @author Thomas
 */
public class Level extends JPanel implements ActionListener {

    final int ROWS = 15;
    final int COLUMNS = 21;

    public String[][] map = new String[ROWS][COLUMNS];
    public ItemObject[][] loadedMap = new ItemObject[ROWS][COLUMNS];

    private Player p = new Player(6, 1);
    
    public LevelManager levelManager;
    public Menu menu;
  
    public Level() {
        addKeyListener(new Al());
        setFocusable(true);
    }

    public ItemObject getObject(int x, int y) {
        ItemObject value;

        value = this.loadedMap[y][x];

        return value;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void Load(HashMap<String, ItemObject> objects) {
        int rowsCount = 0;

        for (String[] row : this.map) {
            int colsCount = 0;

            for (String col : row) {
                if (objects.get(col).getClass() == new Wall().getClass()) {
                    this.loadedMap[rowsCount][colsCount] = new Wall();
                } else {
                    this.loadedMap[rowsCount][colsCount] = objects.get(col);
                }                
                
                colsCount += 1;
            }

            rowsCount += 1;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int rowsCount = 0;

        for (ItemObject[] row : this.loadedMap) {
            int colsCount = 0;

            for (ItemObject col : row) {
                g.drawImage(col.getImageIcon().getImage(), colsCount * 50, rowsCount * 50, null);
                colsCount += 1;
            }

            rowsCount += 1;
        }

        g.drawImage(p.image, p.getTileX() * 50, p.getTileY() * 50, null);

        repaint();
    }

    public class Al extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {            
            Bazooka bazooka = new Bazooka();
            Helper helper = new Helper();
            Wall wall = new Wall();
            Cheater cheater = new Cheater();
            Friend friend = new Friend();

            int keycode = e.getKeyCode();

            if (keycode == KeyEvent.VK_W) {
                p.setImage(Direction.UP);
                if (!getObject(p.getTileX(), p.getTileY() - 1).getClass().equals(wall.getClass())) {
                    p.move(0, -1);
                    menu.setSteps();
                }
            } else if (keycode == KeyEvent.VK_A) {
                p.setImage(Direction.LEFT);
                if (!getObject(p.getTileX() - 1, p.getTileY()).getClass().equals(wall.getClass())) {
                    p.move(-1, 0);
                    menu.setSteps();
                }
            } else if (keycode == KeyEvent.VK_S) {
                p.setImage(Direction.DOWN);
                if (!getObject(p.getTileX(), p.getTileY() + 1).getClass().equals(wall.getClass())) {
                    p.move(0, 1);
                    menu.setSteps();
                }
            } else if (keycode == KeyEvent.VK_D) {
                p.setImage(Direction.RIGHT);
                if (!getObject(p.getTileX() + 1, p.getTileY()).getClass().equals(wall.getClass())) {
                    p.move(1, 0);
                    menu.setSteps();
                }
            }

            Class object = getObject(p.getTileX(), p.getTileY()).getClass();
            if (object == friend.getClass()) {
                System.out.println("FRIEND HITTED");
                removeObject(p.getTileX(), p.getTileY());
                levelManager.nextLevel();
            } else if (object == cheater.getClass()) {
                System.out.println("CHEATER HITTED");
                removeObject(p.getTileX(), p.getTileY());
                
            } else if (object == helper.getClass()) {
                System.out.println("HELPER HITTED");
                removeObject(p.getTileX(), p.getTileY());
                
            } else if (object == bazooka.getClass()) {
                System.out.println("BAZOOKA HITTED");
                removeObject(p.getTileX(), p.getTileY());
            }            
        }

        private void removeObject(int x, int y) {
            loadedMap[y][x] = new EmptyTile();
            repaint();
        }
        
        public void keyReleased(KeyEvent e) {
        }

        public void keyTyped(KeyEvent e) {
        }

    }
}
