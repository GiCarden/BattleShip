package ship;

import grid.OceanGrid;
import util.GamePause;

import java.util.ArrayList;

/**
 * Represents a formation of warships, such as BattleShips, Carriers, Cruisers, Destroyers, and Submarines.
 */
public class ShipFleet {

//Variable(s)-
    private ArrayList<BaseShip> baseShipFleetArrayList;

//Constructor(s)-
    /**
     * Initializes class fields before creating an instance of this class.
     *
     * @param oceanGrid reference variable.
     */
    public ShipFleet(OceanGrid oceanGrid) { initFleet(oceanGrid); }

//Private Method(s)-
    /**
     * A private method utilized inside the constructor to initialize a class field,
     * initializes a ArrayList for BaseShip type objects.
     *
     * @param oceanGrid reference variable.
     */
    private void initFleet(OceanGrid oceanGrid) {

        this.baseShipFleetArrayList = new ArrayList<>();
        this.baseShipFleetArrayList.add(new BattleShip(oceanGrid));
        this.baseShipFleetArrayList.add(new Carrier(oceanGrid));
        this.baseShipFleetArrayList.add(new Cruiser(oceanGrid));
        this.baseShipFleetArrayList.add(new Destroyer(oceanGrid));
        this.baseShipFleetArrayList.add(new Submarine(oceanGrid));
    }

    /**
     * Identifies and removes a ship from the fleet when it has been destroyed.
     */
    private void updateFleet() {

        for (int i = 0; i < this.baseShipFleetArrayList.size(); i++) {

            if (this.baseShipFleetArrayList.get(i).getHealth() <= 0) {

                System.out.printf("%n%s has been destroyed%n", baseShipFleetArrayList.get(i).getShipType().getType());
                this.baseShipFleetArrayList.remove(i);
                GamePause.pause();
                break;
            }
        }
    }

//Public Method(s)-
    /**
     * Identifies and applies damage to the appropriate ship in the fleet.
     *
     * @param s ships GridIcons string representation.
     */
    public void identifyHitShip(String s) {

        for (BaseShip baseShip: baseShipFleetArrayList) {

            if (baseShip.getShipType().getShipIcon().getIcon().equals(s)) {

                baseShip.calculateDamage(); updateFleet(); break;
            }
        }
    }

    /**
     * @return true if fleet is destroyed, else false.
     */
    public boolean isFleetDestroyed() { return baseShipFleetArrayList.isEmpty(); }

    /**
     * Prints the status of all active fleet vessels.
     */
    public void printFleetStatus() {

        System.out.print("\n");
        for (BaseShip baseShip : this.baseShipFleetArrayList) { System.out.println(baseShip); }
    }

}//End of Class.
