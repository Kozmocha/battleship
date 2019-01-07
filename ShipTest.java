package project5;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test suite of Ship.java
 * 
 * @author Chris S. Thacker
 */
public class ShipTest {

    public ShipTest() {
    }

    /**
     * Test of getLength method, of class Ship.
     */
    @Test
    public void testGetLength() {
        Ship ship = new Ship(4, true, 1, 1);
        int expResult = 4;
        int result = ship.getLength();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLength method, of class Ship.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetLength0() {
        Ship ship = new Ship(0, true, 1, 1);
    }

    /**
     * Test of isHorizontal method, of class Ship.
     */
    @Test
    public void testIsHorizontal() {
        Ship ship = new Ship(4, true, 1, 1);
        boolean expResult = true;
        boolean result = ship.isHorizontal();
        assertEquals(expResult, result);
    }

    /**
     * Test of isHorizontal method, of class Ship.
     */
    @Test
    public void testIsHorizontalFalse() {
        Ship ship = new Ship(4, false, 1, 1);
        boolean expResult = false;
        boolean result = ship.isHorizontal();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStartRow method, of class Ship.
     */
    @Test
    public void testGetStartRow() {
        Ship ship = new Ship(4, false, 1, 1);
        int expResult = 1;
        int result = ship.getStartRow();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStartRow method, of class Ship.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetStartRowNegative() {
        Ship ship = new Ship(4, false, -1, 1);
    }

    /**
     * Test of getStartCol method, of class Ship.
     */
    @Test
    public void testGetStartCol() {
        Ship ship = new Ship(4, false, 1, 1);
        int expResult = 1;
        int result = ship.getStartCol();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStartCol method, of class Ship.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetStartColNegative() {
        Ship ship = new Ship(4, false, 1, -1);
    }

    /**
     * Test of isSunk method, of class Ship.
     */
    @Test
    public void testIsSunk() {
        Ship ship = new Ship(4, false, 1, 1);
        for (int i = 0; i < 4; i++) {
            ship.hit();
        }
        boolean expResult = true;
        boolean result = ship.isSunk();
        assertEquals(expResult, result);
    }

    /**
     * Test of isSunk method, of class Ship.
     */
    @Test
    public void testIsNotSunk() {
        Ship ship = new Ship(4, false, 1, 1);
        for (int i = 0; i < 3; i++) {
            ship.hit();
        }
        boolean expResult = false;
        boolean result = ship.isSunk();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Ship.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Ship ship = new Ship(4, false, 1, 1);
        String expResult = "Length: [4], Location: [1, 1], IsHorizontal: [false], TimesHit: [0], IsSunk: [false]";
        String result = ship.toString();
        assertEquals(expResult, result);
    }

}
