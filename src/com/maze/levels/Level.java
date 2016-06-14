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
import com.maze.game.QueueOrderer;
import com.maze.objects.Bazooka;
import com.maze.objects.Cheater;
import com.maze.objects.EmptyTile;
import com.maze.objects.Friend;
import com.maze.objects.Helper;
import com.maze.objects.Reset;
import com.maze.objects.Wall;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import javax.swing.JPanel;

/**
 *
 * @author Thomas
 */
public class Level extends JPanel implements ActionListener {

    final int ROWS = 15;
    final int COLUMNS = 21;

    public String name;
    public String[][] map = new String[ROWS][COLUMNS];
    public ItemObject[][] loadedMap = new ItemObject[ROWS][COLUMNS];
    public Player p;
    public Point position;
    public boolean started = false;
    public Menu menu;
    public LevelManager levelManager;

    private ArrayList<ItemObject> queue = new ArrayList<>();

    public Level() {
        setFocusable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void setLevelManager(LevelManager levelManager) {
        this.levelManager = levelManager;
    }

    public void Load(HashMap<String, ItemObject> objects) {
        loadedMap = new ItemObject[this.map.length][this.map[0].length];

        int rowsCount = 0;

        for (String[] row : this.map) {
            int colsCount = 0;

            for (String col : row) {
                // Beetje omslachtig, maar dit zorgt er voor dat X en Y gevuld kunnen worden.
                ItemObject object = objects.get(col);
                ItemObject finalObject = new ItemObject();

                if (object instanceof Wall) {
                    finalObject = new Wall();
                } else {
                    try {
                        finalObject = (ItemObject) object.clone();
                    } catch (Exception ex) {
                    }
                }

                Point point = new Point(colsCount, rowsCount);
                finalObject.position = point;

                this.loadedMap[rowsCount][colsCount] = finalObject;

                colsCount += 1;
            }
            rowsCount += 1;
        }

        System.out.println("Map: " + this.name + " loaded!");
    }

    public void queue(ItemObject obj) {
        queue.add(obj);
    }

    public ItemObject getGameObject(Point point) {
        return this.loadedMap[(int) point.getY()][(int) point.getX()];
    }

    public void drawQueue() {
        Graphics g = this.getGraphics();

        Collections.sort(queue, new QueueOrderer());
        for (ItemObject obj : queue) {

        }

        this.queue.clear();
    }

    public void clearDots() {
        for (ItemObject[] y : this.loadedMap) {
            for (ItemObject x : y) {
                if (x.isDot()) {
                    x.setDot(false);
                    this.queue(x);
                }
            }
        }
    }

    public void playerMove(Direction direction) {
        int x = p.getTileX();
        int y = p.getTileY();

        switch (direction) {
            case UP:
                p.setImage(Player.Direction.UP);
                
                if (this.isMovable(x, y - 1)) {
                    p.move(0, -1);
                    this.menu.addStep();
                }
                break;
            case DOWN:
                p.setImage(Player.Direction.DOWN);
                
                if (this.isMovable(x, y + 1)) {
                    p.move(0, 1);
                    this.menu.addStep();
                }
                break;
            case LEFT:
                p.setImage(Player.Direction.LEFT);
                
                if (this.isMovable(x - 1, y)) {
                    p.move(-1, 0);
                    this.menu.addStep();
                }
                break;
            case RIGHT:
                p.setImage(Player.Direction.RIGHT);
                
                if (this.isMovable(x + 1, y)) {
                    p.move(1, 0);
                    this.menu.addStep();
                }
                break;
        }
    }

    public void shootBazooka() {
        int x = p.getTileX();
        int y = p.getTileY();

        if (p.getBazookaShots() > 0) {
            switch (p.getDirection()) {
                case UP:
                    if (!this.isMovable(x, y - 1)) {
                        removeObject(x, y - 1);
                        p.lowerBazookaShots();
                        this.menu.shoot();
                    }
                    break;
                case DOWN:
                    if (!this.isMovable(x, y + 1)) {
                        removeObject(x, y + 1);
                        p.lowerBazookaShots();
                        this.menu.shoot();
                    }
                    break;
                case LEFT:
                    if (!this.isMovable(x - 1, y)) {
                        removeObject(x - 1, y);
                        p.lowerBazookaShots();
                        this.menu.shoot();
                    }
                    break;
                case RIGHT:
                    if (!this.isMovable(x + 1, y)) {
                        removeObject(x + 1, y);
                        p.lowerBazookaShots();
                        this.menu.shoot();
                    }
                    break;
            }
        }
    }

    public void checkEvents() {
        ItemObject object = getObject(p.getTileX(), p.getTileY());
        if (object instanceof Friend) {
            System.out.println("HIT OBJECT: FRIEND");
            removeObject(p.getTileX(), p.getTileY());
            this.levelManager.nextLevel();
        } else if (object instanceof Cheater) {
            System.out.println("HIT OBJECT: CHEATER");

            int temp = (Math.random() <= 0.5) ? 1 : 2;
            if (temp == 1) {
                this.menu.addSteps(-20);
            } else {
                this.menu.takeSeconds(20);
            }

            removeObject(p.getTileX(), p.getTileY());
        } else if (object instanceof Helper) {
            System.out.println("HIT OBJECT: HELPER");

            Helper helper = (Helper) getObject(p.getTileX(), p.getTileY());
            removeObject(p.getTileX(), p.getTileY());

            helper.setLevel(this);
            helper.setDirection(this);

            helper.use();
        } else if (object instanceof Bazooka) {
            System.out.println("HIT OBJECT: BAZOOKA");
            removeObject(p.getTileX(), p.getTileY());
            p.addBazookaShots(2);
            this.menu.addShots(2);
        } else if (object instanceof Reset) {
            System.out.println("HIT OBJECT: Reset");

            Reset reset = (Reset) getObject(p.getTileX(), p.getTileY());
            reset.setLevel(this);

            reset.use();

            removeObject(p.getTileX(), p.getTileY());
        }
    }

    private void removeObject(int x, int y) {
        this.loadedMap[y][x] = new EmptyTile();
        //this.level.repaint();
    }

    public boolean isMovable(int x, int y) {
        return (this.getObject(x, y).isMovable());
    }

    public ItemObject getObject(int x, int y) {
        ItemObject value = null;

        value = this.loadedMap[y][x];

        return value;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int rowsCount = 0;

        //System.out.println("PAINTING! " + this.loadedMap.length);
        //System.out.println("NAME: " + name);
        for (ItemObject[] row : this.loadedMap) {
            int colsCount = 0;

            for (ItemObject col : row) {
                g.drawImage(col.getImageIcon().getImage(), colsCount * 50, rowsCount * 50, null);
                col.draw(g);
                colsCount += 1;
            }

            rowsCount += 1;
        }

        g.drawImage(p.image, p.getTileX() * 50, p.getTileY() * 50, null);

        repaint();
        grabFocus();
        requestFocus();
    }

    public String getName() {
        return this.getClass().toString();
    }
}
