package grid;

import ship.BaseShip;
import util.GridIcons;
import util.GridPoint;
import ship.ShipCoordinates;
import ship.ShipFleet;

/**
 * This Class represents a players ocean grid.
 */
public class OceanGrid extends BaseGrid<String> {

//Variable(s)-
    private static final int ROWS = 11;
    private static final int COLS = 11;
    private static final int MAX_NUMBER_OF_AVAILABLE_LOCATIONS = 100;

    private ShipFleet shipFleet;

//Constructor(s)-
    /**
     * Constructor initializes a newly created OceanGrid object.
     */
    OceanGrid(String gridTitle) {

        super(ROWS, COLS, gridTitle);
        initGridMarkers();
        initShipFleet();
    }

//Private Method(s)-
    /**
     * Appends the coordinate system to the battleship grid.
     */
    private void initGridMarkers() {

        addObject(0, 0, String.valueOf(GridIcons.NUMBERS.getNumberIcons()[0]));

        for (int i = 1; i < ROWS; i++) { addObject(0, i, String.valueOf(i)); }

        for (int j = 1; j < COLS; j++) { addObject(j, 0, String.valueOf(GridIcons.LETTERS.getLetterIcons()[j-1])); }

        for (int i = 1; i < ROWS; i++) { for (int j = 1; j < COLS; j++) { addObject(i, j, GridIcons.UNCHECKED.getIcon()); } }
    }

    /**
     * Instantiates new instance of the shipFleet class.
     */
    private void initShipFleet() { this.shipFleet = new ShipFleet(this); }

//Public Method(s)-
    /**
     * Tests if a ship can be stored on a specific coordinate point.
     *
     * @param gridPoint reference variable.
     * @return true if ship can be added, else false.
     */
    public boolean canShipBeAddedAt(GridPoint gridPoint) {

        return getGridObjectAt(gridPoint.getX(), gridPoint.getY()).equals(GridIcons.UNCHECKED.getIcon());
    }

    /**
     * Will insert the ship Icon at a specific coordinate point.
     *
     * @param shipCoordinates reference variable.
     */
    public void addShipIconToGrid(BaseShip baseShip, ShipCoordinates shipCoordinates) {

        for (GridPoint gridPoint : shipCoordinates.getGridPoints()) {

            addObject(gridPoint.getX(), gridPoint.getY(), baseShip.getShipIcon().getIcon());
        }
    }

    /**
     * Will print the battleship grid.
     */
    public void printGrid() { super.printGrid(); }

    /**
     * Will print the ship fleet info and battleship grid.
     */
    public void printGridAndShipInfo() { this.shipFleet.printFleetStatus(); super.printGrid(); }

    /**
     * Will call the updateFleet method in the shipFleet class.
     */
    public void identifyHitShip(String s) { shipFleet.identifyHitShip(s); }

    /**
     *
     * @return true if fleet is destroyed else false.
     */
    public boolean isFleetDestroyed() { return shipFleet.isFleetDestroyed(); }

//Getters(s)-
    /**
     * Getter for MAX_NUMBER_OF_AVAILABLE_LOCATIONS.
     *
     * @return max number of playable coordinate points.
     */
    public static int getMaxNumberOfAvailableLocations() { return MAX_NUMBER_OF_AVAILABLE_LOCATIONS; }

}//End of Class.
