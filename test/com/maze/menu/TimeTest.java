/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.menu;

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
public class TimeTest {
    
    public TimeTest() {
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
     * Test of getTime method, of class Time.
     */
    @Test
    public void testGetTime() {
        System.out.println("Testing the method getTime");
        Time instance = new Time();
        String expResult = "Tijd: 00:00:00,";
        String result = instance.getTime();
        assertEquals(expResult, result);
        System.out.println("Expected: "+expResult +" result: "+ result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of addSecond method, of class Time.
     */
    @Test
    public void testAddSecond() {
        System.out.println("addSecond");
        Time instance = new Time();
        instance.addSecond();
        String expResult = "Tijd: 00:00:01,";
        String result = instance.getTime();
        assertEquals(expResult, result);
        System.out.println("Expected: "+expResult +" result: "+ result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of add20Seconds method, of class Time.
     */
    @Test
    public void testAdd20Seconds() {
        System.out.println("add20Seconds");
        Time instance = new Time();
        instance.add20CheatSeconds();
        String expResult = "Tijd: 00:00:20,";
        String result = instance.getTime();
        assertEquals(expResult, result);
        System.out.println("Expected: "+expResult +" result: "+ result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
