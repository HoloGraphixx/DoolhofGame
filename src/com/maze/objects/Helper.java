/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.objects;

import com.maze.game.Direction;
import com.maze.game.ItemObject;
import com.maze.levels.Level;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

/**
 *
 * @author Tony
 */
public class Helper extends ItemObject {

    private Level level;
    private Direction dir;
    private Integer[] directions = new Integer[]{KeyEvent.VK_UP, KeyEvent.VK_RIGHT, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT};
    private ArrayList<Stack<ItemObject>> stacks = new ArrayList<>();

    public Helper() {
        this.setImage("Helper.png");
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void setDirection(Level level) {
        this.dir = new Direction(level);
    }

    public void draw(Graphics g) {
        g.drawImage(this.getImageIcon().getImage(), (int) this.getPosition().getX() * SIZE, (int) this.getPosition().getY() * SIZE, null);
    }

    public void use() {
        this.showRoute();
        //this.dissapear();
    }

    public void showRoute() {
        Stack<ItemObject> stack = new Stack<>();
        this.stacks = new ArrayList<>();
        Stack<ItemObject> finalStack = this.findRoute(this, stack, 0);
        if (finalStack != null) {
            for (ItemObject road : finalStack) {
                road.setDot(true);
                level.queue(road);
            }
        }

        this.level.drawQuickestRoute();
    }

    public Stack<ItemObject> findRoute(ItemObject obj, Stack<ItemObject> stack, int index) {
        stack.add(obj);

        for (int key : directions) {
            ItemObject next = dir.getNext(obj.getPosition(), key);
            if (!stack.contains(next) && !(next instanceof Wall) && !(next instanceof Friend) && next != null) {
                findRoute(next, (Stack<ItemObject>) stack.clone(), index + 1);
            } else if (next instanceof Friend) {
                this.stacks.add(stack);
            }
        }

        if (index == 0) {
            Collections.sort(this.stacks, new Comparator<Stack<ItemObject>>() {
                @Override
                public int compare(Stack<ItemObject> t, Stack<ItemObject> t1) {
                    return t.size() - t1.size();
                }

            });
            return this.stacks.get(0);
        } else {
            return null;
        }
    }
}
