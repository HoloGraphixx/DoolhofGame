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
import com.maze.objects.Bazooka;
import com.maze.objects.Cheater;
import com.maze.objects.EmptyTile;
import com.maze.objects.Friend;
import com.maze.objects.Helper;
import com.maze.objects.Reset;
import com.maze.objects.Wall;
import java.awt.Point;
import java.util.HashMap;
import javax.swing.JFrame;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thomas
 */
public class Level001Test {

    final private HashMap<String, ItemObject> objects = new HashMap<>();
    Player player = new Player(1, 1);
    LevelManager lm = new LevelManager(new JFrame());
    
    public Level001Test() {
        Level level = new Level001Testt();
        Menu menu = new Menu(lm);
        
        lm.currentLevel = level;
        lm.currentLevel.setPlayer(this.player);
        lm.currentLevel.setMenu(menu);
        lm.currentLevel.setLevelManager(lm);
        lm.level = 0;
        
        // Vul de objecten lijst
        objects.put("B", new Bazooka());
        objects.put("", new EmptyTile());
        objects.put("W", new Wall());
        objects.put("F", new Friend());
        objects.put("C", new Cheater());
        objects.put("H", new Helper());
        objects.put("R", new Reset());
        //this.setPlayer(this.player);
        
        lm.currentLevel.Load(objects);
        lm.currentLevel.setStarted(true);
    }

    @Test
    public void TestOne() {
        // Testen of speler op tegel (1, 2) beland.
        this.lm.currentLevel.playerMove(Player.Direction.DOWN);
        Point expResult = new Point(1, 2);
        Point result = new Point(this.player.getTileX(), this.player.getTileY());
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void TestTwo() {
        // We laten de speler naar links lopen, daar is een muur.
        // De speler zou moeten blijven staan op (1, 1).
        this.lm.currentLevel.playerMove(Player.Direction.LEFT);
        Point expResult = new Point(1, 1);
        Point result = new Point(this.player.getTileX(), this.player.getTileY());
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void TestThree() {
        // We laten de speler naar rechts lopen, daar is een muur.
        // De muur schieten wij kapot.
        
        //We geven de spelen bazooka kogels:
        this.player.addBazookaShots(1);
        
        this.lm.currentLevel.playerMove(Player.Direction.RIGHT);
        this.lm.currentLevel.shootBazooka();
        
        int expResult = 0;
        int result = this.player.getBazookaShots();
        
        assertEquals(expResult, result);
    }
    
        @Test
    public void TestFour() {
        // We laten de speler de speler staan, hij kijkt tegen een lege tegel aan
        // We schieten met de bazooka. De bazooka moet niet afgegaan zijn, aangezien we niet met ons gezicht naar een muur staan.
        
        //We geven de spelen bazooka kogels:
        this.player.addBazookaShots(1);
        
        this.lm.currentLevel.shootBazooka();
        
        int expResult = 1;
        int result = this.player.getBazookaShots();
        
        assertEquals(expResult, result);
    }
    
    
    public class Level001Testt extends Level{
        public Level001Testt() {
            String[][] tiles = 
            {
                { "W", "W", "W", "W", "W", "W", "W", "W", "W", },
                { "W", "", "W", "", "", "", "", "W", "W", },
                { "W", "", "", "", "W", "W", "", "F", "W", },
                { "W", "", "W", "", "", "", "", "W", "W", },
                { "W", "W", "W", "W", "W", "W", "W", "W", "W", },
            };

            super.map = tiles;
            super.setPosition(new Point(6, 1));
        }
    }
}
