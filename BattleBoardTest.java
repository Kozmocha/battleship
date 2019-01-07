package project5;

import static org.junit.Assert.*;
import org.junit.*;
import project5.Square.HitStatus;

public class BattleBoardTest {

    public static final int ROWS = 8;
    public static final int COLS = 8;
    public static final int NUMBER_OF_SHIPS = 4;

    /**
     * A private copy of the BattleBoard
     */
    private BattleBoard board;

    @Before
    public void BattleBoardTest() {
        board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);
    }
    
    /**
     * Test of BattleBoard
     */
    @Test (expected = IllegalArgumentException.class)
    public void testInvalidBattleBoard() {
        board = new BattleBoard(0, 0, -1);
    }

    /**
     * Tests BattleBoard.addShip() method
     */
    @Test
    public void testAddHorizontalShip() {
        board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);

        //Test adding a Ship at a valid location
        boolean expectedOutput = true;
        boolean actualOutput = board.addShip(1, true, 3, 5);
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Tests BattleBoard.addShip() method
     */
    @Test
    public void testAddHorizontalShipArrayHasLengthOne() {
        board = new BattleBoard(ROWS, COLS, 1);
        boolean expectedOutput = true;
        boolean actualOutput = board.addShip(1, true, 0, 3);
        assertEquals(expectedOutput, actualOutput);
    }
    
    /**
     * Tests BattleBoard.addShip() method
     */
    @Test
    public void testAddVerticalShipArrayHasLengthOne() {
        board = new BattleBoard(ROWS, COLS, 1);
        boolean expectedOutput = true;
        boolean actualOutput = board.addShip(1, false, 0, 3);
        assertEquals(expectedOutput, actualOutput);
    }
    
    /**
     * Tests BattleBoard.addShip() method
     */
    @Test
    public void testAddVerticalShipArrayHasLengthTwo() {
        board = new BattleBoard(ROWS, COLS, 2);
        boolean expectedOutput = true;
        boolean actualOutput = board.addShip(1, false, 0, 3);
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Tests BattleBoard.addShip() method
     */
    @Test
    public void testAddHorizontalShipArrayHasOneShip() {
        board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);
        board.addShip(1, true, 0, 0);
        boolean expectedOutput = true;
        boolean actualOutput = board.addShip(1, true, 0, 3);
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Tests BattleBoard.addShip() method
     */
    @Test
    public void testAddHorizontalShipArrayHasTwoShips() {
        board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);
        board.addShip(1, true, 0, 0);
        board.addShip(1, true, 0, 1);
        boolean expectedOutput = true;
        boolean actualOutput = board.addShip(1, true, 0, 3);
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Tests BattleBoard.addShip() method
     */
    @Test
    public void testAddShipHasHorizontalShip() {
        board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);
        board.addShip(1, true, 0, 0);
        board.addShip(1, true, 0, 1);
        board.addShip(1, true, 0, 2);
        boolean expectedOutput = false;
        boolean actualOutput = board.addShip(1, true, 0, 1);
        assertEquals(expectedOutput, actualOutput);
    }
    
    /**
     * Tests BattleBoard.addShip() method
     */
    @Test
    public void testAddVerticalShipArrayHasOneShip() {
        board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);
        board.addShip(1, false, 0, 0);
        boolean expectedOutput = true;
        boolean actualOutput = board.addShip(1, false, 0, 3);
        assertEquals(expectedOutput, actualOutput);
    }
    
    /**
     * Tests BattleBoard.addShip() method
     */
    @Test
    public void testAddVerticalShipArrayHasTwoShips() {
        board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);
        board.addShip(1, false, 0, 0);
        board.addShip(1, false, 0, 1);
        boolean expectedOutput = true;
        boolean actualOutput = board.addShip(1, false, 0, 3);
        assertEquals(expectedOutput, actualOutput);
    }
    
    /**
     * Tests BattleBoard.addShip() method
     */
    @Test
    public void testAddVerticalShipArrayHasThreeShips() {
        board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);
        board.addShip(1, false, 0, 0);
        board.addShip(1, false, 0, 1);
        board.addShip(1, false, 0, 3);
        boolean expectedOutput = true;
        boolean actualOutput = board.addShip(1, false, 0, 4);
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Tests BattleBoard.addShip() method
     */
    @Test
    public void testAddShipHasVerticalShip() {
        board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);
        board.addShip(1, true, 0, 0);
        board.addShip(1, false, 0, 1);
        board.addShip(1, true, 0, 2);
        boolean expectedOutput = false;
        boolean actualOutput = board.addShip(1, false, 0, 1);
        assertEquals(expectedOutput, actualOutput);
    }
    
    /**
     * Tests BattleBoard.addShip() method
     */
    @Test
    public void testAddHorizontalShipHasVerticalShip() {
        board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);
        board.addShip(1, true, 0, 0);
        board.addShip(1, false, 0, 1);
        board.addShip(1, true, 0, 2);
        boolean expectedOutput = false;
        boolean actualOutput = board.addShip(1, true, 0, 1);
        assertEquals(expectedOutput, actualOutput);
    }
    
    /**
     * Tests BattleBoard.addShip() method
     */
    @Test
    public void testAddVerticalShipHasHorizontalShip() {
        board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);
        board.addShip(1, true, 0, 0);
        board.addShip(1, true, 0, 1);
        board.addShip(1, true, 0, 2);
        boolean expectedOutput = false;
        boolean actualOutput = board.addShip(1, false, 0, 1);
        assertEquals(expectedOutput, actualOutput);
    }
    
    /**
     * Tests BattleBoard.addShip() method
     */
    @Test
    public void testAddInvalidHorizontalShip() {
        board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);

        boolean expectedOutput = false;
        boolean actualOutput = board.addShip(4, true, 7, 7);
        assertEquals(expectedOutput, actualOutput);
    }
    
    /**
     * Tests BattleBoard.addShip() method
     */
    @Test
    public void testAddInvalidVerticalShip() {
        board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);

        boolean expectedOutput = false;
        boolean actualOutput = board.addShip(4, false, 7, 7);
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Tests BattleBoard.addShip() method
     */
    @Test
    public void testAddVerticalShip() {
        board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);

        boolean expectedOutput = true;
        boolean actualOutput = board.addShip(4, false, 1, 1);
        assertEquals(expectedOutput, actualOutput);
    }
    
    /**
     * Tests BattleBoard.addShip() method
     */
    @Test
    public void testAddShipFullArrayHorizontalShip() {
        board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);
        board.addShip(1, true, 0, 0);
        board.addShip(1, true, 0, 1);
        board.addShip(1, true, 0, 2);
        board.addShip(1, true, 0, 3);
        boolean expectedOutput = false;
        boolean actualOutput = board.addShip(4, true, 5, 1);
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Tests BattleBoard.addShip() method
     */
    @Test
    public void testAddShipFullArrayVerticalShip() {
        board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);
        board.addShip(1, true, 0, 0);
        board.addShip(1, true, 0, 1);
        board.addShip(1, true, 0, 2);
        board.addShip(1, true, 0, 3);
        boolean expectedOutput = false;
        boolean actualOutput = board.addShip(4, false, 5, 1);
        assertEquals(expectedOutput, actualOutput);
    }
    
    /**
     * Tests BattleBoard.addShip() method
     */
    @Test
    public void testAddHorizontalShipAgainstBoundary() {
        board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);

        boolean expectedOutput = false;
        boolean actualOutput = board.addShip(3, true, 5, 6);
        assertEquals(expectedOutput, actualOutput);
    }
    
    /**
     * Tests BattleBoard.addShip() method
     */
    @Test
    public void testAddVerticalShipAgainstBoundary() {
        board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);

        boolean expectedOutput = false;
        boolean actualOutput = board.addShip(3, false, 6, 6);
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Tests BattleBoard.getNumberOfShips() method
     */
    @Test
    public void testGetNumberOfShips() {
        board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);

        //Test that there are no Ships when a BattleBoard is initially created
        int expectedOutput = 0;
        int actualOutput = board.getNumberOfShips();
        //System.out.printf("Expected: %8d   Actual: %8d\n", expectedOutput, actualOutput);
        assertEquals(expectedOutput, actualOutput);

        //Test the number of Ships after adding a Ship
        board.addShip(3, true, 7, 1);
        expectedOutput = 1;
        actualOutput = board.getNumberOfShips();
        //System.out.printf("Expected: %8d   Actual: %8d\n\n", expectedOutput, actualOutput);
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Tests BattleBoard.getShips() method
     */
    @Test
    public void testGetShips() {
        board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);

        //Test that all Ships are null when a BattleBoard is first created
        Ship[] ships = board.getShips();
        for (int i = 0; i < ships.length; i++) {
            assertNull(ships[i]);
        }
    }

    /**
     * Tests BattleBoard.fireAtLocation() method
     */
    @Test
    public void testFireAtLocation() {
        board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);

        //Test firing at a location that has never been fired at before
        boolean expectedOutput = true;
        boolean actualOutput = board.fireAtLocation(0, 0);
        //System.out.printf("Expected: %8s   Actual: %8s\n", expectedOutput, actualOutput);
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Tests BattleBoard.fireAtLocation() method
     */
    @Test
    public void testFireAtLocationHasBeenHit() {
        board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);
        board.fireAtLocation(0, 0);
        //Test firing at a location that has never been fired at before
        boolean expectedOutput = false;
        boolean actualOutput = board.fireAtLocation(0, 0);
        //System.out.printf("Expected: %8s   Actual: %8s\n", expectedOutput, actualOutput);
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Tests BattleBoard.fireAtLocation() method
     */
    @Test(expected = IllegalArgumentException.class)
    public void testFireAtLocationInvalidRow() {
        board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);

        //Test firing at a location that has never been fired at before
        boolean expectedOutput = false;
        boolean actualOutput = board.fireAtLocation(-1, 0);
        //System.out.printf("Expected: %8s   Actual: %8s\n", expectedOutput, actualOutput);
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Tests BattleBoard.fireAtLocation() method
     */
    @Test(expected = IllegalArgumentException.class)
    public void testFireAtLocationInvalidCol() {
        board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);

        //Test firing at a location that has never been fired at before
        boolean expectedOutput = false;
        boolean actualOutput = board.fireAtLocation(0, -1);
        //System.out.printf("Expected: %8s   Actual: %8s\n", expectedOutput, actualOutput);
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Tests BattleBoard.fireAtLocation() method
     */
    @Test(expected = IllegalArgumentException.class)
    public void testFireAtLocationHigherRow() {
        board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);

        //Test firing at a location that has never been fired at before
        boolean expectedOutput = false;
        boolean actualOutput = board.fireAtLocation(8, 0);
        //System.out.printf("Expected: %8s   Actual: %8s\n", expectedOutput, actualOutput);
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Tests BattleBoard.fireAtLocation() method
     */
    @Test(expected = IllegalArgumentException.class)
    public void testFireAtLocationHigherCol() {
        board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);

        //Test firing at a location that has never been fired at before
        boolean expectedOutput = false;
        boolean actualOutput = board.fireAtLocation(0, 8);
        //System.out.printf("Expected: %8s   Actual: %8s\n", expectedOutput, actualOutput);
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Tests BattleBoard.hasBeenHit() method
     */
    @Test
    public void testHasNotBeenHit() {
        board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);

        //Test to ensure a location that has never been fired at really hasn't been fired at
        HitStatus expectedOutput = HitStatus.NOT_YET_HIT;
        HitStatus actualOutput = board.getHitStatus(0, 0);
        //System.out.printf("Expected: %8s   Actual: %8s\n", expectedOutput, actualOutput);
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Tests BattleBoard.hasBeenHit() method
     */
    @Test
    public void testHasBeenHit() {
        board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);

        board.fireAtLocation(0, 0);
        HitStatus expectedOutput = HitStatus.MISSED;
        HitStatus actualOutput = board.getHitStatus(0, 0);
        //System.out.printf("Expected: %8s   Actual: %8s\n", expectedOutput, actualOutput);
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Tests BattleBoard.hasBeenHit() method
     */
    @Test
    public void testHasBeenHitWithShip() {
        board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);

        board.addShip(1, true, 0, 0);
        board.fireAtLocation(0, 0);
        HitStatus expectedOutput = HitStatus.HIT;
        HitStatus actualOutput = board.getHitStatus(0, 0);
        //System.out.printf("Expected: %8s   Actual: %8s\n", expectedOutput, actualOutput);
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Tests BattleBoard.hasBeenHit() method
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetHitStatusNegativeRow() {
        board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);

        HitStatus expectedOutput = HitStatus.NOT_YET_HIT;
        HitStatus actualOutput = board.getHitStatus(-1, 0);
        //System.out.printf("Expected: %8s   Actual: %8s\n", expectedOutput, actualOutput);
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Tests BattleBoard.hasBeenHit() method
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetHitStatusNegativeCol() {
        board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);

        HitStatus expectedOutput = HitStatus.NOT_YET_HIT;
        HitStatus actualOutput = board.getHitStatus(0, -1);
        //System.out.printf("Expected: %8s   Actual: %8s\n", expectedOutput, actualOutput);
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Tests BattleBoard.hasBeenHit() method
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetHitStatusHigherRow() {
        board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);

        HitStatus expectedOutput = HitStatus.NOT_YET_HIT;
        HitStatus actualOutput = board.getHitStatus(10, 0);
        //System.out.printf("Expected: %8s   Actual: %8s\n", expectedOutput, actualOutput);
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Tests BattleBoard.hasBeenHit() method
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetHitStatusHigherCol() {
        board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);

        HitStatus expectedOutput = HitStatus.NOT_YET_HIT;
        HitStatus actualOutput = board.getHitStatus(0, 10);
        //System.out.printf("Expected: %8s   Actual: %8s\n", expectedOutput, actualOutput);
        assertEquals(expectedOutput, actualOutput);
    }
    
    /**
     * Tests BattleBoard.isShipSunk() method
     */
    @Test
    public void testIsShipSunk() {
        board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);

        board.addShip(1, true, 0, 0);
        board.fireAtLocation(0, 0);
        boolean expectedOutput = true;
        boolean actualOutput = board.isShipSunk(0);
        assertEquals(expectedOutput, actualOutput);

    }

    /**
     * Tests BattleBoard.areAllShipsSunk() method
     */
    @Test
    public void testAreAllShipsSunk() {
        board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);

        //Test that the provided ship isn't sunk after being hit once
        board.addShip(2, true, 0, 0);
        board.fireAtLocation(0, 0);
        boolean expectedOutput = false;
        boolean actualOutput = board.areAllShipsSunk();
        //System.out.printf("Expected: %8s   Actual: %8s\n\n", expectedOutput, actualOutput);
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Tests BattleBoard.areAllShipsSunk() method
     */
    @Test
    public void testAreAllShipsSunk2() {
        board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);

        //Test that the provided ship isn't sunk after being hit once
        board.addShip(1, true, 0, 0);
        board.addShip(1, true, 0, 1);
        board.addShip(1, true, 0, 2);
        board.addShip(1, true, 0, 3);
        board.fireAtLocation(0, 0);
        board.fireAtLocation(0, 1);
        board.fireAtLocation(0, 2);
        board.fireAtLocation(0, 3);
        boolean expectedOutput = true;
        boolean actualOutput = board.areAllShipsSunk();
        //System.out.printf("Expected: %8s   Actual: %8s\n\n", expectedOutput, actualOutput);
        assertEquals(expectedOutput, actualOutput);
    }
    
    /**
     * Tests BattleBoard.getAllSunkenShips() method
     */
    public void testGetAllSunkenShips() {
        board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);
        
        board.addShip(1, true, 0, 0);
        board.fireAtLocation(0, 0);
        
    }
    
    /**
     * Tests BattleBoard.toString() method
     */
    @Test
    public void testToString() {
        board = new BattleBoard(8, 8, NUMBER_OF_SHIPS);
        String expectedOutput = "- - - - - - - - \n"
                + "- - - - - - - - \n"
                + "- - - - - - - - \n"
                + "- - - - - - - - \n"
                + "- - - - - - - - \n"
                + "- - - - - - - - \n"
                + "- - - - - - - - \n"
                + "- - - - - - - - \n";
        String actualOutput = board.toString();
        assertEquals(expectedOutput, actualOutput);
    }
}
