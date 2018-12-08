package ship;

import grid.OceanGrid;
import util.GridIcons;
import util.ShipDirection;
import util.ShipOrientation;
import util.ShipType;

import java.util.concurrent.ThreadLocalRandom;

/**
 * BaseShip is an abstract base class for any game vessel, which cannot be instantiated.
 *
 * A BaseShip object encapsulates the state information needed for any vessel that the BattleShip
 * Board Game may support.
 */
public abstract class BaseShip {

//Variable(s)-
    private int health;
    private ShipType shipType;
    private ShipOrientation shipOrientation;
    private ShipDirection buildDirection;
    private ShipCoordinates shipCoordinates;

//Constructor(s)-
    /**
     * Initializes class fields before creating an instance of a subclass.
     *
     * @param shipType enum type with specific ship constants.
     * @param oceanGrid oceanGrid reference variable.
     */
    BaseShip(ShipType shipType, OceanGrid oceanGrid) {

        this.shipType = shipType;
        this.health = this.shipType.getSize();
        this.shipOrientation = initShipOrientation();
        this.buildDirection = initBuildDirection();
        this.shipCoordinates = new ShipCoordinates(this, oceanGrid);
        oceanGrid.addShipIconToGrid(this, this.shipCoordinates);
    }

//Private Method(s)-
    /**
     * A private method utilized inside the constructor to initialize a class field,
     * Returns a random ShipOrientation enum type value.
     *
     * @return HORIZONTAL or VERTICAL.
     */
    private ShipOrientation initShipOrientation() {

        return ShipOrientation.values()[ThreadLocalRandom.current().nextInt(0, 1 + 1)];
    }

    /**
     * A private method utilized inside the constructor to initialize a class field,
     * Returns a random ShipDirection enum type value.
     *
     * @return UP, DOWN, LEFT, RIGHT.
     */
    private ShipDirection initBuildDirection() {

        return (shipOrientation.equals(ShipOrientation.HORIZONTAL))
                ? ShipDirection.values()[ThreadLocalRandom.current().nextInt(2, 3 + 1)]
                : ShipDirection.values()[ThreadLocalRandom.current().nextInt(0, 1 + 1)];
    }

//Public Method(s)-
    public void calculateDamage() { health--; }

//Public Overridden Method(s)-
    /**
     * Returns a string that "textually represents" this object.
     *
     * @return string representation of the this object.
     */
    @Override
    public String toString() {

        return String.format("%s - BaseShip Health: %s - Orientation: %s - Build Direction: %s - BaseShip Coordinates: %s",
            this.shipType, this.health, this.shipOrientation, this.buildDirection, this.shipCoordinates);
    }

//Getters(s)-
    /**
     * Getter for "this" objects health.
     *
     * @return "this" objects health.
     */
    public int getHealth() { return health; }

    /**
     * Getter for "this" objects ShipType reference.
     *
     * @return "this" objects ShipType reference.
     */
    public ShipType getShipType() { return shipType; }

    /**
     * Getter for "this" objects ShipOrientation reference.
     *
     * @return "this" objects ShipOrientation reference.
     */
    public ShipOrientation getShipOrientation() { return shipOrientation; }

    /**
     * Getter for "this" objects ShipDirection reference.
     *
     * @return "this" objects ShipDirection reference.
     */
    public ShipDirection getBuildDirection() { return buildDirection; }

    /**
     * Getter for "this" objects getShipIcon.
     *
     * @return "this" objects ShipIcon reference.
     */
    public GridIcons getShipIcon() { return this.shipType.getShipIcon(); }

}//End of Class.
