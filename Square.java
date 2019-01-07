package project5;

/**
 * Represents a location/square on the BattleBoard grid.
 *
 * @author Chris S. Thacker
 */
public class Square {

    private boolean hasBeenHit;
    private Ship ship;
    private HitStatus hitStatus;

    /**
     * The hit status of the square (hit, missed, not yet hit).
     */
    public enum HitStatus {
        HIT, //hit and occupied
        MISSED, //hit and unoccupied
        NOT_YET_HIT //not yet hit
    }

    /**
     * Sets the square hit status to NOT_YET_HIT; called only when the square is
     * created with the grid; default constructor for Square.
     */
    public Square() {
        this.hitStatus = HitStatus.NOT_YET_HIT;
    }

    /**
     * Checks if the square has been hit.
     *
     * @return True of the square has been hit, false if not.
     */
    public boolean hasBeenHit() {
        return this.hasBeenHit;
    }

    /**
     * Getter used to retrieve the hit status of the square.
     *
     * @return The hit status of the square.
     */
    public HitStatus getHitStatus() {
        return this.hitStatus;
    }

    /**
     * Checks if the ship exists within the square then returns the ship
     * instance.
     *
     * @return The ship being retrieved.
     */
    public Ship getShip() {
        if (hasShip()) {
            return this.ship;
        } else {
            return null;
        }
    }

    /**
     * Updates hasBeenHit to true and the hit status of the square to
     * HitStatus.MISSED, then checks if the square contains a ship; if it does,
     * the hitStatus becomes HitStatus.HIT.
     */
    public void fireAt() {
        this.hasBeenHit = true;
        hitStatus = HitStatus.MISSED;
        if (hasShip()) {
            hitStatus = HitStatus.HIT;
            getShip().hit();
        }
    }

    /**
     * Checks if the square contains a ship.
     *
     * @return True if the square contains a ship, false if otherwise.
     */
    public boolean hasShip() {
        return this.ship != null;
    }

    /**
     * Adds the given ship to the square.
     *
     * @param ship The ship to be added to the square.
     */
    public void addShip(Ship ship) {
        this.ship = ship;
    }

    /**
     * Builds a readable, formatted string of one character to indicate the
     * status of the square, eventually creating a grid of squares and their
     * statuses.
     *
     * @return "-" if square contains no ship and has not been hit; "W" if
     * square contains no ship and has been hit; "R" if square does contain ship
     * and has been hit; or the length of the ship ("1", "2", "3", or "4") if
     * the square has not been hit.
     */
    @Override
    public String toString() {
        String output = null;
        if (!hasShip() && !hasBeenHit()) {
            output = "-";
        }
        if (!hasShip() && hasBeenHit()) {
            output = "W";
        }
        if (hasShip() && hasBeenHit()) {
            output = "R";
        }
        if (hasShip() && !hasBeenHit()) {
            output = "" + getShip().getLength();
        }
        return output;
    }
}
