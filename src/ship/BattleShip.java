package ship;

import grid.OceanGrid;
import util.ShipType;

/**
 * Represents a Battle Ship with a size of 4.
 *
 * Inherits all the members (fields, methods, and nested classes) from BaseShip.
 */
class BattleShip extends BaseShip {

//Constructor(s)-
    /**
     * Initializes Superclass fields before creating an instance of this class.
     *
     * @param oceanGrid reference variable.
     */
    BattleShip(OceanGrid oceanGrid) { super(ShipType.BATTLESHIP, oceanGrid); }

}//End of Class.
