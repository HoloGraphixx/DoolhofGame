/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.objects;

import com.maze.game.ItemObject;
import java.util.Random;

/**
 *
 * @author Tony
 */
public class Wall extends ItemObject {

    public Wall() {
        Random random = new Random();
        int randomInt = random.nextInt(6) + 1;
        this.setImage("tree" + randomInt + ".png");       
        this.setMovable(false);
    }

}
