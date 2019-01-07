package project5;

import java.util.ArrayList;
import project5.Square.HitStatus;

/**
 * A model template for the player's and computer's boards within the game.
 *
 * @author Chris S. Thacker
 */
public class BattleBoard {

    private int numberOfRows;
    private int numberOfColumns;
    private Square[][] squares;
    private int maximumNumberOfShips;
    private Ship[] ships;
    private int numberOfShips;
    private ArrayList<Ship> sunkenShips;

    /**
     * Constructor for BattleBoard; initializes the numberOfRows,
     * numberOfColumns, and maximumNumberOfShips
     *
     * @param numberOfRows The total number of rows in the board.
     * @param numberOfColumns The total number of columns in the board.
     * @param maximumNumberOfShips The maximum number of ships that can be
     * present on the board.
     */
    public BattleBoard(int numberOfRows, int numberOfColumns, int maximumNumberOfShips) {
        if (numberOfRows < 1 || numberOfColumns < 1 || maximumNumberOfShips < 0) {
            throw new IllegalArgumentException();
        }
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.squares = new Square[numberOfRows][numberOfColumns];
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                this.squares[i][j] = new Square();
            }
        }
        this.maximumNumberOfShips = maximumNumberOfShips;
        this.ships = new Ship[maximumNumberOfShips];
        this.numberOfShips = 0;
        this.sunkenShips = new ArrayList<>();
    }

    /**
     * Adds a ship to the board.
     *
     * @param length The length of the ship to be added.
     * @param isHorizontal The orientation of the ship; true if horizontal false
     * if not.
     * @param startRow The upper left corner of the ship within the row.
     * @param startCol The upper left corner of the ship within the column.
     * @return True if the ship was placed, false if not.
     */
    public boolean addShip(int length, boolean isHorizontal, int startRow, int startCol) {
        Ship ship = new Ship(length, isHorizontal, startRow, startCol);
        if (isHorizontal) {
            if (startCol + length - 1 < getNumberOfColumns()) {
                for (int i = 0; i < length; i++) {
                    if (this.squares[startRow][startCol + i].hasShip() || ships[ships.length - 1] != null) {
                        return false;
                    } else {
                        this.squares[startRow][startCol + i].addShip(ship);
                    }
                }
            } else {
                return false;
            }
        } else {
            if (startRow + length - 1 < getNumberOfRows()) {
                for (int i = 0; i < length; i++) {
                    if (this.squares[startRow + i][startCol].hasShip()) {
                        return false;
                    } else {
                        this.squares[startRow + i][startCol].addShip(ship);
                    }
                }

            } else {
                return false;
            }
        }
        for (int i = 0; i < ships.length; i++) { //can only get here if ship can be placed
            if (ships[i] == null) {
                ships[i] = ship;
                numberOfShips++;
                break;
            }
        }
        return true;
    }

    /**
     * Getter used to retrieve the number of ships on the board.
     *
     * @return The number of ships on the board.
     */
    public int getNumberOfShips() {
        return this.numberOfShips;
    }

    /**
     * Getter used to retrieve the specific ships on the board.
     *
     * @return The different ships on the board.
     */
    public Ship[] getShips() {
        return this.ships;
    }

    /**
     * Checks if the location can be fired at on the board; changes the
     * hitStatus of the square; checks if the ship has been sunk.
     *
     * @param row The row in which the square is located.
     * @param col The column in which the square is located.
     * @return True if the square has not been previously hit, false if
     * otherwise.
     */
    public boolean fireAtLocation(int row, int col) {
        boolean result = false;
        boolean isSunk = false;
        if (row < 0 || col < 0 || row >= numberOfRows || col >= numberOfColumns) {
            throw new IllegalArgumentException();
        } else {
            if (this.squares[row][col].getHitStatus() == Square.HitStatus.NOT_YET_HIT) {
                this.squares[row][col].fireAt();
                result = true;
            } else {
                return false;
            }
            if (this.squares[row][col].getHitStatus() == Square.HitStatus.HIT) {
                isSunk = this.squares[row][col].getShip().isSunk();
                if (isSunk) {
                    this.sunkenShips.add(0, this.squares[row][col].getShip());
                }
            }
        }
        return result;
    }

    /**
     * Returns the HitStatus of the square located at the specific row and
     * column.
     *
     * @param row The row of the square.
     * @param col The column of the square.
     * @return The HitStatus of the square.
     */
    public HitStatus getHitStatus(int row, int col) {
        HitStatus hitStatus = null;
        if (row < 0 || col < 0 || row >= numberOfRows || col >= numberOfColumns) {
            throw new IllegalArgumentException();
        } else {
            hitStatus = this.squares[row][col].getHitStatus();
        }
        return hitStatus;
    }

    /**
     * Checks if the ship is sunk.
     *
     * @param shipIndex The ship's location in the ships array.
     * @return True if the ship is sunk, false if otherwise.
     */
    public boolean isShipSunk(int shipIndex) {
        return this.ships[shipIndex].isSunk();
    }

    /**
     * Checks if all of the ships are sunk.
     *
     * @return True if all ships are sunk, false if otherwise.
     */
    public boolean areAllShipsSunk() {
        boolean allSunk = false;
        for (int i = 0; i < ships.length - 1; i++) {
            if (this.ships[i].isSunk()) {
                allSunk = true;
            } else {
                allSunk = false;
                break;
            }
        }
        return allSunk;
    }

    /**
     * Retrieves an ArrayList of all sunken ships.
     *
     * @return ArrayList of sunkenShips.
     */
    public ArrayList<Ship> getAllSunkenShips() {
        return this.sunkenShips;
    }

    /**
     * Returns the number of rows on the BattleBoard.
     *
     * @return Number of rows on the BattleBoard.
     */
    public int getNumberOfRows() {
        return this.numberOfRows;
    }

    /**
     * Returns the number of columns on the BattleBoard.
     *
     * @return The number of columns on the BattleBoard.
     */
    public int getNumberOfColumns() {
        return this.numberOfColumns;
    }

    /**
     * Constructs a readable string of the BattleBoard, with ship locations and
     * hit markers.
     *
     * @return String of BattleBoard layout.
     */
    @Override
    public String toString() {
        String battleBoard = "";
        for (int i = 0; i < this.numberOfRows; i++) {
            for (int j = 0; j < this.numberOfColumns; j++) {
                battleBoard += this.squares[i][j].toString() + " ";
            }
            battleBoard += "\n";
        }
        return battleBoard;
    }
}
