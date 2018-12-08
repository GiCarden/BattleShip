package util;

import grid.OceanGrid;
import player.PlayerOne;

/**
 * This Class will house and initiate all GameModes.
 */
class GameModeController {

//Constructor(s)-
    /**
     * CoordinateValidator is non-instantiable
     */
    private GameModeController() { }

//Private Static Method(s)-
    /**
     * This method will initiate the Simulation GameMode.
     */
    private static void initSim() {

        PlayerOne playerOne = (PlayerOne) PlayerOne.getPlayerOneInstance();

        Loop:
        do {

            playerOne.turnLoop();

            if (playerOne.hasWon() || playerOne.getShotsFiredCount() >= OceanGrid.getMaxNumberOfAvailableLocations()) {

                break Loop;
            }
        }while (true);

        System.out.printf("%nAll Enemy Ships Destroyed, Ending Simulation:%n");
    }

    /**
     * This method will initiate the Player Vs. CPU GameMode.
     */
    private static void initPlayerVsCpu() {}

    /**
     * This method will initiate the Player Vs. Player GameMode.
     */
    private static void initPlayerVsPlayer() {}

//Public Static Method(s)-
    static void enterMode(GameModes gameModes) {

        switch (gameModes) {
            case SIMULATION: initSim();
                break;
            case PLAYER_VS_CPU : initPlayerVsCpu();
                break;
            case PLAYER_VS_PLAYER: initPlayerVsPlayer();
                break;
             default:
                 break;
        }
    }

}//End of Class.
