package ship;

import grid.OceanGrid;
import util.ShipDirection;
import util.GridPoint;
import util.ShipOrientation;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Maintains the coordinate positions for a BaseShip object.
 */
public class ShipCoordinates {

//Variable(s)-
    private final ArrayList<GridPoint> gridPoints;

//Constructor(s)-
    /**
     * Initializes class fields before creating an instance of this class.
     *
     * @param baseShip reference variable.
     * @param oceanGrid reference variable.
     */
    ShipCoordinates(BaseShip baseShip, OceanGrid oceanGrid) {

        gridPoints = new ArrayList<>(baseShip.getShipType().getSize());
        initShipCoordinates(baseShip, oceanGrid);
    }

//Private Method(s)-
    /**
     * A private method utilized inside the constructor,
     * responsible for determining the coordinate positions for the current BaseShip object.
     *
     * @param baseShip reference variable.
     * @param oceanGrid reference variable.
     */
    private void initShipCoordinates(BaseShip baseShip, OceanGrid oceanGrid) {

        boolean hasShipBeenPlaced = false;

        do {

            if (baseShip.getShipOrientation().equals(ShipOrientation.HORIZONTAL)) {

                hasShipBeenPlaced = (baseShip.getBuildDirection().equals(ShipDirection.LEFT)) ? buildLeft(baseShip, oceanGrid)
                        : buildRight(baseShip, oceanGrid);
            } else {

                hasShipBeenPlaced = (baseShip.getBuildDirection().equals(ShipDirection.UP)) ? buildUp(baseShip, oceanGrid)
                        : buildDown(baseShip, oceanGrid);
            }
        } while(!hasShipBeenPlaced);
    }

    /**
     * Randomly generates the root GridPoint for the current BaseShip object.
     *
     * @param oceanGrid reference variable.
     * @return Randomly generated root GridPoint.
     */
    private GridPoint initRootPoint(OceanGrid oceanGrid) {

        int x, y;

        do {

            x = ThreadLocalRandom.current().nextInt(1, 10 + 1);
            y = ThreadLocalRandom.current().nextInt(1, 10 + 1);
        } while (!oceanGrid.canShipBeAddedAt(new GridPoint(x, y)));

        return new GridPoint(x, y);
    }

    /**
     * Determines if the current BaseShip object can be located to the left of the root GridPoint
     * if so it generates GridPoints to the left of the root GridPoint for the current BaseShip coordinate positions.
     *
     * @param baseShip reference variable.
     * @param oceanGrid reference variable.
     * @return true if GridPoints for current BaseShip object where generated, else false.
     */
    private boolean buildLeft(BaseShip baseShip, OceanGrid oceanGrid) {

        boolean flag = true;
        GridPoint rooPoint = initRootPoint(oceanGrid);
        gridPoints.add(rooPoint);

        if (!(rooPoint.getY() - 1 >= baseShip.getShipType().getSize())) { gridPoints.clear(); return false; }

        for (int i = 1; i < baseShip.getShipType().getSize(); i++) {

            if (oceanGrid.canShipBeAddedAt(new GridPoint(rooPoint.getX(), rooPoint.getY()-i))) {

                gridPoints.add(new GridPoint(rooPoint.getX(), rooPoint.getY()-i));
            } else {

                flag = false;
                gridPoints.clear();
                break;
            }
        }
        return flag;
    }

    /**
     * Determines if the current BaseShip object can be located to the right of the root GridPoint
     * if so it generates GridPoints to the right of the root GridPoint for the current BaseShip coordinate positions.
     *
     * @param baseShip reference variable.
     * @param oceanGrid reference variable.
     * @return true if GridPoints for current BaseShip object where generated, else false.
     */
    private boolean buildRight(BaseShip baseShip, OceanGrid oceanGrid) {

        boolean flag = true;
        GridPoint rooPoint = initRootPoint(oceanGrid);
        gridPoints.add(rooPoint);

        if (!(10 - rooPoint.getY() >= baseShip.getShipType().getSize())) { gridPoints.clear(); return false; }

        for (int i = 1; i < baseShip.getShipType().getSize(); i++) {

            if (oceanGrid.canShipBeAddedAt(new GridPoint(rooPoint.getX(), rooPoint.getY()+i))) {

                gridPoints.add(new GridPoint(rooPoint.getX(), rooPoint.getY()+i));
            } else {

                flag = false;
                gridPoints.clear();
                break;
            }
        }
        return flag;
    }

    /**
     * Determines if the current BaseShip object can be located above the root GridPoint
     * if so it generates GridPoints above the root GridPoint for the current BaseShip coordinate positions.
     *
     * @param baseShip reference variable.
     * @param oceanGrid reference variable.
     * @return true if GridPoints for current BaseShip object where generated, else false.
     */
    private boolean buildUp(BaseShip baseShip, OceanGrid oceanGrid) {

        boolean flag = true;
        GridPoint rooPoint = initRootPoint(oceanGrid);
        gridPoints.add(rooPoint);

        if (!(rooPoint.getX() - 1 >= baseShip.getShipType().getSize())) { gridPoints.clear(); return false; }

        for (int i = 1; i < baseShip.getShipType().getSize(); i++) {

            if (oceanGrid.canShipBeAddedAt(new GridPoint(rooPoint.getX()-i, rooPoint.getY()))) {

                gridPoints.add(new GridPoint(rooPoint.getX()-i, rooPoint.getY()));
            } else {

                flag = false;
                gridPoints.clear();
                break;
            }
        }
        return flag;
    }

    /**
     * Determines if the current BaseShip object can be located under the root GridPoint
     * if so it generates GridPoints under the root GridPoint for the current BaseShip coordinate positions.
     *
     * @param baseShip reference variable.
     * @param oceanGrid reference variable.
     * @return true if GridPoints for current BaseShip object where generated, else false.
     */
    private boolean buildDown(BaseShip baseShip, OceanGrid oceanGrid) {

        boolean flag = true;
        GridPoint rooPoint = initRootPoint(oceanGrid);
        gridPoints.add(rooPoint);

        if (!(10 - rooPoint.getX() >= baseShip.getShipType().getSize())) { gridPoints.clear(); return false; }

        for (int i = 1; i < baseShip.getShipType().getSize(); i++) {

            if (oceanGrid.canShipBeAddedAt(new GridPoint(rooPoint.getX()+i, rooPoint.getY()))) {

                gridPoints.add(new GridPoint(rooPoint.getX()+i, rooPoint.getY()));
            } else {

                flag = false;
                gridPoints.clear();
                break;
            }
        }
        return flag;
    }

//Public Method(s)-
    /**
     * Determines if this objects ArrayList contains a matching GridPoint.
     *
     * @param gridPoint reference variable.
     * @return true if gridPoints arrayList contains passed gridPoint, else false.
     */
    public boolean contains(GridPoint gridPoint) {

        boolean flag = false;
        for (GridPoint point : gridPoints) { flag = point.equals(gridPoint); }
        return flag;
    }

//Public Overridden Method(s)-
    /**
     * Returns a string that "textually represents" this object.
     *
     * @return string representation of the this object.
     */
    @Override
    public String toString() { return gridPoints.toString(); }

//Getter(s)-
    /**
     * Getter for "this" objects gridPoints reference.
     *
     * @return "this" objects ArrayList "gridPoints" reference.
     */
    public ArrayList<GridPoint> getGridPoints() { return gridPoints; }

}//End of Class.
