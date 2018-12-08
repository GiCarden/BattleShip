package ship;

import grid.OceanGrid;
import util.ShipType;

/**
 * Represents a Carrier Ship with a size of 5.
 *
 * Inherits all the members (fields, methods, and nested classes) from BaseShip.
 */
class Carrier extends BaseShip {

//Constructor(s)-
    /**
     * Initializes Superclass fields before creating an instance of this class.
     *
     * @param oceanGrid reference variable.
     */
    Carrier(OceanGrid oceanGrid) { super(ShipType.CARRIER, oceanGrid); }

}//End of Class.
