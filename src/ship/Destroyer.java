package ship;

import grid.OceanGrid;
import util.ShipType;

/**
 * Represents a Destroyer Ship with a size of 2.
 *
 * Inherits all the members (fields, methods, and nested classes) from BaseShip.
 */
class Destroyer extends BaseShip {

//Constructor(s)-
    /**
     * Initializes Superclass fields before creating an instance of this class.
     *
     * @param oceanGrid reference variable.
     */
    Destroyer(OceanGrid oceanGrid) { super(ShipType.DESTROYER, oceanGrid); }

}//End of Class.
