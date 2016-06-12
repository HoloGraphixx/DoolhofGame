/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.game;

import com.maze.levels.Level;
import com.maze.objects.Bazooka;
import com.maze.objects.Cheater;
import com.maze.objects.EmptyTile;
import com.maze.objects.Friend;
import com.maze.objects.Helper;
import com.maze.objects.Reset;
import com.maze.objects.Wall;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Thomas
 */
    public class KeyListener extends KeyAdapter {

        private Player p;
        private Menu menu;
        private Level level;
        private LevelManager lm;
        
        public KeyListener(LevelManager lm) {
            this.p = lm.player;
            this.level = lm.currentLevel;
            this.menu = lm.menu;
            this.lm = lm;
        }
        
        @Override
        public void keyPressed(KeyEvent e) {
            if (this.level.started == false) {
                return;
            }
            
            int keycode = e.getKeyCode();

            int x = p.getTileX();
            int y = p.getTileY();
            
            if (keycode == KeyEvent.VK_W) {
                p.setImage(Player.Direction.UP);
                if (!this.getWallCollision(x, y - 1)) {
                    p.move(0, -1);
                    menu.addStep();
                }
            } else if (keycode == KeyEvent.VK_A) {
                p.setImage(Player.Direction.LEFT);
                if (!this.getWallCollision(x - 1, y)) {
                    p.move(-1, 0);
                    menu.addStep();
                }
            } else if (keycode == KeyEvent.VK_S) {
                p.setImage(Player.Direction.DOWN);
                if (!this.getWallCollision(x, y + 1)) {
                    p.move(0, 1);
                    menu.addStep();
                }
            } else if (keycode == KeyEvent.VK_D) {
                p.setImage(Player.Direction.RIGHT);
                if (!this.getWallCollision(x + 1, y)) {
                    p.move(1, 0);
                    menu.addStep();
                }
            } else if (keycode == KeyEvent.VK_SPACE) {
                if (p.getBazookaShots() > 0) {
                    switch (p.getDirection()) {
                        case UP:
                            if (this.getWallCollision(x, y - 1)) {
                                removeObject(x, y - 1);
                                p.lowerBazookaShots();
                                this.menu.shoot();
                            }
                            break;
                        case DOWN:
                            if (this.getWallCollision(x, y + 1)) {
                                removeObject(x, y + 1);
                                p.lowerBazookaShots();
                                this.menu.shoot();
                            }
                            break;
                        case LEFT:
                            if (this.getWallCollision(x - 1, y)) {
                                removeObject(x - 1, y);
                                p.lowerBazookaShots();
                                this.menu.shoot();
                            }
                            break;
                        case RIGHT:
                            if (this.getWallCollision(x + 1, y)) {
                                removeObject(x + 1, y);
                                p.lowerBazookaShots();
                                this.menu.shoot();
                            }
                            break;
                    }
                }
            }
            
            checkEvents();
        }
        
        public void checkEvents() {
             ItemObject object = getObject(p.getTileX(), p.getTileY());
            if (object instanceof Friend) {
                System.out.println("HIT OBJECT: FRIEND");
                removeObject(p.getTileX(), p.getTileY());
                this.lm.nextLevel();
            } else if (object instanceof Cheater) {
                System.out.println("HIT OBJECT: CHEATER");
                
                int temp = (Math.random() <= 0.5) ? 1 : 2;
                if(temp == 1){    
                    this.menu.addSteps(20);
                } else {                    
                    this.menu.time.add20CheatSeconds();
                }
                
                removeObject(p.getTileX(), p.getTileY());
            } else if (object instanceof Helper) {
                System.out.println("HIT OBJECT: HELPER");
                
                Helper helper = (Helper) getObject(p.getTileX(), p.getTileY());
                removeObject(p.getTileX(), p.getTileY());
                
                helper.setLevel(this.level);
                helper.setDirection(this.level);
                
                helper.use();                
            } else if (object instanceof Bazooka) {
                System.out.println("HIT OBJECT: BAZOOKA");
                removeObject(p.getTileX(), p.getTileY());
                p.addBazookaShots(2);
                this.menu.addShots(2);
            } else if (object instanceof Reset) {
                System.out.println("HIT OBJECT: Reset");
                
                Reset reset = (Reset) getObject(p.getTileX(), p.getTileY());
                reset.setLevel(this.level);
                
                reset.use();
                
                removeObject(p.getTileX(), p.getTileY());
            }
        }

        private void removeObject(int x, int y) {
            this.level.loadedMap[y][x] = new EmptyTile();
            //this.level.repaint();
        }
        
        public void keyReleased(KeyEvent e) {
        }

        public void keyTyped(KeyEvent e) {
        }
        
        public boolean getWallCollision(int x, int y) {
            return (this.getObject(x, y) instanceof Wall);
        }
        
        public ItemObject getObject(int x, int y) {
            ItemObject value = null;

            value = this.level.loadedMap[y][x];

            return value;
        }
}