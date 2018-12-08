package ship;

import grid.OceanGrid;
import util.ShipType;

/**
 * Represents a Submarine Ship with a size of 3.
 *
 * Inherits all the members (fields, methods, and nested classes) from BaseShip.
 */
class Submarine extends BaseShip {

//Constructor(s)-
    /**
     * Initializes Superclass fields before creating an instance of this class.
     *
     * @param oceanGrid reference variable.
     */
    Submarine(OceanGrid oceanGrid) { super(ShipType.SUBMARINE, oceanGrid); }

}//End of Class.
