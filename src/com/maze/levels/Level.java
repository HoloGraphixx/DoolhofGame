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
import java.util.Comparator;
import java.util.HashMap;
import javax.swing.JPanel;

/**
 *
 * @author Tony
 */
public class Level extends JPanel implements ActionListener {

    private final int ROWS = 15;
    private final int COLUMNS = 21;

    protected String[][] map = new String[ROWS][COLUMNS];
    private ItemObject[][] loadedMap = new ItemObject[ROWS][COLUMNS];
    private Player player;
    private Point position;
    private boolean started = false;
    private Menu menu;
    private LevelManager levelManager;

    private ArrayList<ItemObject> quickestRoute = new ArrayList<>();

    public Level() {
        setFocusable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Point getPosition() {
        return this.position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void setLevelManager(LevelManager levelManager) {
        this.levelManager = levelManager;
    }

    public boolean isStarted() {
        return this.started;
    }

    public void setStarted(boolean started) {
        this.started = started;
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
                finalObject.setPosition(point);

                this.loadedMap[rowsCount][colsCount] = finalObject;

                colsCount += 1;
            }
            rowsCount += 1;
        }

        System.out.println("Map: " + this.getName() + " loaded!");
    }

    public void queue(ItemObject obj) {
        quickestRoute.add(obj);
    }

    public ItemObject getGameObject(Point point) {
        return this.loadedMap[(int) point.getY()][(int) point.getX()];
    }

    public void drawQuickestRoute() {
        Graphics g = this.getGraphics();

        Collections.sort(quickestRoute, new QueueOrderer());
        for (ItemObject obj : quickestRoute) {

        }

        this.quickestRoute.clear();
    }

    public void clearQuickestRoute() {
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
        int x = player.getTileX();
        int y = player.getTileY();

        switch (direction) {
            case UP:
                player.setImage(Player.Direction.UP);

                if (this.isMovable(x, y - 1)) {
                    player.move(0, -1);
                    this.menu.addStep();
                }
                break;
            case DOWN:
                player.setImage(Player.Direction.DOWN);

                if (this.isMovable(x, y + 1)) {
                    player.move(0, 1);
                    this.menu.addStep();
                }
                break;
            case LEFT:
                player.setImage(Player.Direction.LEFT);

                if (this.isMovable(x - 1, y)) {
                    player.move(-1, 0);
                    this.menu.addStep();
                }
                break;
            case RIGHT:
                player.setImage(Player.Direction.RIGHT);

                if (this.isMovable(x + 1, y)) {
                    player.move(1, 0);
                    this.menu.addStep();
                }
                break;
        }
    }

    public void shootBazooka() {
        int x = player.getTileX();
        int y = player.getTileY();

        if (player.getBazookaShots() > 0) {
            switch (player.getDirection()) {
                case UP:
                    if (!this.isMovable(x, y - 1)) {

                        for (int i = 0; i < player.getTileY(); i++) {

                            if (this.getObject(x, y - i) instanceof Wall) {

                                removeObject(x, y - i);
                            }
                        }
                        player.lowerBazookaShots();
                        this.menu.shoot();
                    }
                    break;
                case DOWN:
                    if (!this.isMovable(x, y + 1)) {

                        for (int i = 0; i < (this.ROWS - 1) - this.player.getTileY(); i++) {

                            if (this.getObject(x, y + i) instanceof Wall) {

                                removeObject(x, y + i);
                            }
                        }

                        player.lowerBazookaShots();
                        this.menu.shoot();
                    }
                    break;
                case LEFT:
                    if (!this.isMovable(x - 1, y)) {

                        for (int i = 0; i < this.player.getTileX(); i++) {

                            if (this.getObject(x - i, y) instanceof Wall) {

                                removeObject(x - i, y);
                            }
                        }

                        player.lowerBazookaShots();
                        this.menu.shoot();
                    }
                    break;
                case RIGHT:
                    if (!this.isMovable(x + 1, y)) {

                        for (int i = 0; i < (this.COLUMNS - 1) - this.player.getTileX(); i++) {

                            if (this.getObject(x + i, y) instanceof Wall) {

                                removeObject(x + i, y);
                            }
                        }

                        player.lowerBazookaShots();
                        this.menu.shoot();
                    }
                    break;
            }
        }
    }

    public void checkEvents() {
        ItemObject object = getObject(player.getTileX(), player.getTileY());
        if (object instanceof Friend) {
            System.out.println("HIT OBJECT: FRIEND");
            removeObject(player.getTileX(), player.getTileY());
            this.levelManager.nextLevel();
        } else if (object instanceof Cheater) {
            System.out.println("HIT OBJECT: CHEATER");

            int temp = (Math.random() <= 0.5) ? 1 : 2;
            if (temp == 1) {
                this.menu.addSteps(-20);
            } else {
                this.menu.takeSeconds(20);
            }

            removeObject(player.getTileX(), player.getTileY());
        } else if (object instanceof Helper) {
            System.out.println("HIT OBJECT: HELPER");

            Helper helper = (Helper) getObject(player.getTileX(), player.getTileY());
            removeObject(player.getTileX(), player.getTileY());

            helper.setLevel(this);
            helper.setDirection(this);

            helper.use();
        } else if (object instanceof Bazooka) {
            System.out.println("HIT OBJECT: BAZOOKA");
            removeObject(player.getTileX(), player.getTileY());
            player.addBazookaShots(2);
            this.menu.addShots(2);
        } else if (object instanceof Reset) {
            System.out.println("HIT OBJECT: Reset");

            Reset reset = (Reset) getObject(player.getTileX(), player.getTileY());
            reset.setLevel(this);

            reset.use();

            removeObject(player.getTileX(), player.getTileY());
        }
    }

    private void removeObject(int x, int y) {
        this.loadedMap[y][x] = new EmptyTile();
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

        g.drawImage(player.getImage(), player.getTileX() * 50, player.getTileY() * 50, null);

        repaint();
        grabFocus();
        requestFocus();
    }

    public String getName() {
        return this.getClass().toString();
    }

    private class QueueOrderer implements Comparator<ItemObject> {

        @Override
        public int compare(ItemObject object1, ItemObject object2) {
            return object1.getIndex() - object2.getIndex();
        }s
    }
}
