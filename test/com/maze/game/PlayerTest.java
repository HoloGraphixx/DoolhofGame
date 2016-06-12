/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.game;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tony
 */
public class PlayerTest {
    
    public PlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTileX method, of class Player.
     */
    @Test
    public void testGetTileX() {
        System.out.println("getTileX");
        Player instance = null;
        int expResult = 0;
        int result = instance.getTileX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        System.out.println("Expected = " + expResult +  " .. result = " + result);
    }

    /**
     * Test of getTileY method, of class Player.
     */
    @Test
    public void testGetTileY() {
        System.out.println("getTileY");
        Player instance = null;
        int expResult = 0;
        int result = instance.getTileY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of move method, of class Player.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        int dx = 0;
        int dy = 0;
        Player instance = null;
        instance.move(dx, dy);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBazookaShots method, of class Player.
     */
    @Test
    public void testSetBazookaShots() {
        System.out.println("setBazookaShots");
        int bazookaShots = 0;
        Player instance = null;
        instance.addBazookaShots(20);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBazookaShots method, of class Player.
     */
    @Test
    public void testGetBazookaShots() {
        System.out.println("getBazookaShots");
        Player instance = null;
        int expResult = 0;
        int result = instance.getBazookaShots();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lowerBazookaShots method, of class Player.
     */
    @Test
    public void testLowerBazookaShots() {
        System.out.println("lowerBazookaShots");
        Player instance = null;
        instance.lowerBazookaShots();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDirection method, of class Player.
     */
    @Test
    public void testSetDirection() {
        System.out.println("setDirection");
        Player.Direction direction = null;
        Player instance = null;
        instance.setDirection(direction);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDirection method, of class Player.
     */
    @Test
    public void testGetDirection() {
        System.out.println("getDirection");
        Player instance = null;
        Player.Direction expResult = null;
        Player.Direction result = instance.getDirection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPos method, of class Player.
     */
    @Test
    public void testSetPos() {
        System.out.println("setPos");
        int x = 0;
        int y = 0;
        Player instance = null;
        instance.setPos(x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
