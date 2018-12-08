package player;

import grid.OceanGrid;
import grid.Grids;
import grid.TrackerGrid;
import util.CoordinateValidator;
import util.GamePause;
import util.GridIcons;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * This singleton class represents player one for BattleShip.
 */
public class PlayerOne extends BasePlayer {

//Variable(s)-
    private static OceanGrid myOceanGrid = Grids.getFleetGridOneInstance();
    private static TrackerGrid myTrackerGrid = Grids.getTrackerGridOneInstance();
    private static OceanGrid enemyOceanGrid = Grids.getFleetGridTwoInstance();

    private static BasePlayer playerOne = null;

//Constructor(s)-
    /**
     * PlayerOne is non-instantiable.
     */
    private PlayerOne() { super(); }

//Private Method(s)-
    /**
     * Will call grid print methods.
     */
    private void displayGrids() {

        myOceanGrid.printGridAndShipInfo();
        enemyOceanGrid.printGridAndShipInfo();
        myTrackerGrid.printGrid();
    }

    /**
     * This method is responsible for player input.
     */
    private void enterCoordinates() {

        Scanner cin = new Scanner(System.in);
        StringTokenizer holder;
        int x;
        String y;
        boolean flag = true;

        Loop:
        do {

            do {

                System.out.printf((flag) ? "%nEnter Grid Coordinates, with a Space in between. : " :
                        "%nRe-Enter Grid Coordinates. : ");
                holder = new StringTokenizer(cin.nextLine().trim());
                flag = false;
            } while (holder.countTokens() != 2);

            try {

                y = holder.nextToken().toUpperCase();
                x = Integer.parseInt(String.valueOf(holder.nextToken()));
            } catch (NumberFormatException e) {

                System.out.printf("%nCoordinate Format Mismatch (Letter, Number), Try Again.");
                continue Loop;
            }

            if (areCoordinatesValid(x, y)) { break Loop; } else { continue Loop; }

        } while (true);

        fireShot(x, y);
    }

    /**
     * This method is responsible for verifying player coordinates.
     *
     * @param x coordinate.
     * @param y coordinate.
     * @return true if coordinates are valid, else false.
     */
    private boolean areCoordinatesValid(int x, String y) {

        boolean flag = false;

        if (CoordinateValidator.validate(x, y)) {

            if (myTrackerGrid.getGridObjectAt(CoordinateValidator.getYMapValue(y), CoordinateValidator.getXMapValue(x)).equals(GridIcons.UNCHECKED.getIcon())) {

                flag = true;
            } else {

                System.out.printf("%nCoordinate has already been accessed, Try Again.");
            }
        }
        return flag;
    }

    /**
     * This method will fire at the specified coordinate position.
     *
     * @param x coordinate.
     * @param y coordinate.
     */
    private void fireShot(int x, String y) {

        if (enemyOceanGrid.getGridObjectAt(CoordinateValidator.getYMapValue(y), CoordinateValidator.getXMapValue(x)).equals(GridIcons.UNCHECKED.getIcon())) {

            myTrackerGrid.addObject(CoordinateValidator.getYMapValue(y), CoordinateValidator.getXMapValue(x), GridIcons.MISSED.getIcon());
            System.out.printf("%nMissed%n");
            GamePause.pause();
        } else {

            myTrackerGrid.addObject(CoordinateValidator.getYMapValue(y), CoordinateValidator.getXMapValue(x), GridIcons.HIT.getIcon());
            System.out.printf("%nHit%n");
            enemyOceanGrid.identifyHitShip(enemyOceanGrid.getGridObjectAt(CoordinateValidator.getYMapValue(y), CoordinateValidator.getXMapValue(x)));
            GamePause.pause();
        }
    }

//Public Method(s)-
    /**
     * This method will indicate if "this" players fleet is destroyed.
     *
     * @return true if fleet is destroyed, else false.
     */
    public boolean hasLost() { return myOceanGrid.isFleetDestroyed(); }

    /**
     * This method will indicate if enemies fleet is destroyed.
     *
     * @return true if fleet is destroyed, else false.
     */
    public boolean hasWon() { return enemyOceanGrid.isFleetDestroyed(); }

//Public Overridden Method(s)-
    /**
     * This method will call necessary methods for a players turn.
     */
    @Override
    public void turnLoop() {

        displayGrids();
        enterCoordinates();
    }

//Getters(s)-
    /**
     * Allow only one instance of "this" class.
     *
     * @return PlayerOne instance.
     */
    public static BasePlayer getPlayerOneInstance() {

        if ((playerOne == null)) { playerOne = new PlayerOne(); }

        return playerOne;
    }

}//End of Class.
