/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.game;

import java.util.Comparator;

/**
 *
 * @author Liam Hubers
 */
public class QueueOrderer implements Comparator<ItemObject> {

    @Override
    public int compare(ItemObject o1, ItemObject o2) {
        return o1.getIndex() - o2.getIndex();
    }
}
