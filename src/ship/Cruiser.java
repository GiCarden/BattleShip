package ship;

import grid.OceanGrid;
import util.ShipType;

/**
 * Represents a Cruiser Ship with a size of 3.
 *
 * Inherits all the members (fields, methods, and nested classes) from BaseShip.
 */
class Cruiser extends BaseShip {

//Constructor(s)-
    /**
     * Initializes Superclass fields before creating an instance of this class.
     *
     * @param oceanGrid reference variable.
     */
    Cruiser(OceanGrid oceanGrid) { super(ShipType.CRUISER, oceanGrid); }

}//End of Class.
