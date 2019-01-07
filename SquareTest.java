/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project5;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test suite of Square.java
 * 
 * @author Chris S. Thacker
 */
public class SquareTest {

    public SquareTest() {
    }

    /**
     * Test of hasBeenHit method, of class Square.
     */
    @Test
    public void testHasBeenHit() {
        Square instance = new Square();
        boolean expResult = false;
        boolean result = instance.hasBeenHit();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHitStatus method, of class Square.
     */
    @Test
    public void testGetHitStatus() {
        Square instance = new Square();
        Square.HitStatus expResult = Square.HitStatus.NOT_YET_HIT;
        Square.HitStatus result = instance.getHitStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of getShip method, of class Square.
     */
    @Test
    public void testGetShip() {
        Square instance = new Square();
        Ship expResult = null;
        Ship result = instance.getShip();
        assertEquals(expResult, result);

    }

    /**
     * Test of fireAt method, of class Square.
     */
    @Test
    public void testFireAtNoShip() {
        Square instance = new Square();
        instance.fireAt();
        Square.HitStatus expResult = Square.HitStatus.MISSED;
        Square.HitStatus result = instance.getHitStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of fireAt method, of class Square.
     */
    @Test
    public void testFireAtWithShip() {
        Ship ship = new Ship(1, true, 0, 0);
        Square instance = new Square();
        instance.addShip(ship);
        instance.fireAt();
        Square.HitStatus expResult = Square.HitStatus.HIT;
        Square.HitStatus result = instance.getHitStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasShip method, of class Square.
     */
    @Test
    public void testHasNoShip() {
        Square instance = new Square();
        boolean expResult = false;
        boolean result = instance.hasShip();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasShip method, of class Square.
     */
    @Test
    public void testHasShip() {
        Ship ship = new Ship(1, true, 0, 0);
        Square instance = new Square();
        instance.addShip(ship);
        boolean expResult = true;
        boolean result = instance.hasShip();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Square.
     */
    @Test
    public void testToStringNoShipNotHit() {
        Square instance = new Square();
        instance.hasShip();
        instance.hasBeenHit();
        String expResult = "-";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Square.
     */
    @Test
    public void testToStringNoShipHit() {
        Square instance = new Square();
        instance.hasShip();
        instance.fireAt();
        instance.hasBeenHit();
        String expResult = "W";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Square.
     */
    @Test
    public void testToStringShipHit() {
        Ship ship = new Ship(1, true, 0, 0);
        Square instance = new Square();
        instance.addShip(ship);
        instance.hasShip();
        instance.fireAt();
        instance.hasBeenHit();
        String expResult = "R";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Square.
     */
    @Test
    public void testToStringShip1NotHit() {
        Ship ship = new Ship(1, true, 0, 0);
        Square instance = new Square();
        instance.addShip(ship);
        instance.hasShip();
        instance.hasBeenHit();
        String expResult = "1";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Square.
     */
    @Test
    public void testToStringShip2NotHit() {
        Ship ship = new Ship(2, true, 0, 0);
        Square instance = new Square();
        instance.addShip(ship);
        instance.hasShip();
        instance.hasBeenHit();
        String expResult = "2";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Square.
     */
    @Test
    public void testToStringShip3NotHit() {
        Ship ship = new Ship(3, true, 0, 0);
        Square instance = new Square();
        instance.addShip(ship);
        instance.hasShip();
        instance.hasBeenHit();
        String expResult = "3";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Square.
     */
    @Test
    public void testToStringShip4NotHit() {
        Ship ship = new Ship(4, true, 0, 0);
        Square instance = new Square();
        instance.addShip(ship);
        instance.hasShip();
        instance.hasBeenHit();
        String expResult = "4";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Square.
     */
    @Test
    public void testToStringNoShipHitConditional() {
        Ship ship = new Ship(1, true, 0, 0);
        Square instance = new Square();
        instance.fireAt();
        boolean expResult = true;
        boolean result = !instance.hasShip() && instance.hasBeenHit();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Square.
     */
    @Test
    public void testToStringShipHitConditional() {
        Ship ship = new Ship(1, true, 0, 0);
        Square instance = new Square();
        instance.addShip(ship);
        instance.fireAt();
        boolean expResult = true;
        boolean result = instance.hasShip() && instance.hasBeenHit();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Square.
     */
    @Test
    public void testToStringShipNotHitConditional() {
        Ship ship = new Ship(1, true, 0, 0);
        Square instance = new Square();
        instance.addShip(ship);
        boolean expResult = true;
        boolean result = instance.hasShip() && !instance.hasBeenHit();
        assertEquals(expResult, result);
    }
}
