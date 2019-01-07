package project5;

/**
 * Represents a single ship within a fleet of ships.
 *
 * @author Chris S. Thacker
 */
public class Ship {

    private int length;
    private int timesHit;
    private boolean isHorizontal;
    private int startRow;
    private int startCol;

    /**
     * Ship constructor used to create new ships.
     *
     * @param length Length of the ship.
     * @param isHorizontal If the ship has an horizontal orientation or not.
     * @param startRow The top left corner of the ship within the row.
     * @param startCol The top left corner of the ship within the column.
     */
    public Ship(int length, boolean isHorizontal, int startRow, int startCol) {
        if (length < 1 || startRow < 0 || startCol < 0) {
            throw new IllegalArgumentException();
        } else {
            this.length = length;
            this.timesHit = 0;
            this.isHorizontal = isHorizontal;
            this.startRow = startRow;
            this.startCol = startCol;
        }
    }

    /**
     * A getter used to retrieve the length of a ship.
     *
     * @return The length of the ship.
     */
    public int getLength() {
        return this.length;
    }

    /**
     * A checker used to retrieve a boolean; true if the ship's orientation is
     * horizontal and false if it's vertical.
     *
     * @return True if horizontal, false if vertical.
     */
    public boolean isHorizontal() {
        return this.isHorizontal;
    }

    /**
     * A getter used to retrieve the top left corner of a ship within the row.
     *
     * @return The upper left corner of the ship in the row.
     */
    public int getStartRow() {
        return this.startRow;
    }

    /**
     * A getter used to retrieve the top left corner of a ship within the
     * column.
     *
     * @return The upper left corner of the ship in the column.
     */
    public int getStartCol() {
        return this.startCol;
    }

    /**
     * Modifies the timesHit field (+1, MAX: length) each time a ship is hit.
     */
    public void hit() {
        timesHit++;
    }

    /**
     * Checks if the ship is sunk based on a comparison of timesHit and the
     * ship's length.
     *
     * @return True if timesHit == length or false if not.
     */
    public boolean isSunk() {
        return timesHit == this.getLength();
    }

    /**
     * Builds a string in a readable format to display the length, location,
     * orientation, times hit, and sunk status of the ship.
     *
     * @return A string in this format: "Length [4], Location [1, 1],
     * IsHorizontal: [false], TimesHit[0], IsSunk: [false]"
     */
    @Override
    public String toString() {
        return "Length: [" + this.getLength() + "], Location: [" + this.getStartRow()
                + ", " + this.getStartCol() + "], IsHorizontal: [" + this.isHorizontal()
                + "], TimesHit: [" + this.timesHit + "], IsSunk: [" + this.isSunk() + "]";
    }
}
