package util;

import java.util.Scanner;

/**
 * Game Menu
 */
public final class GameMenu {

//Variable(s)-
    private static final int NUMBER_OF_CHOICES;

//Static Block()-
    static { //Static variable initializations.

        NUMBER_OF_CHOICES = 4;
    }

//Constructor(s)-
    /**
     * GameMenu is non-instantiable
     */
    GameMenu() {}

//Private Method(s)-
    /**
     * Will display the game menu.
     */
    private static void gameDescription() {

        System.out.printf("%n*************************************************%n");
        System.out.printf("*                  Battle Ship                  *%n");
        System.out.printf("*************************************************%n");
        System.out.printf("*                                               *%n");
        System.out.printf("* Option 1 - Simulation                         *%n");
        System.out.printf("* Option 2 - PlayerOne Vs. CPU                  *%n");
        System.out.printf("* Option 3 - PlayerOne Vs. PlayerOne            *%n");
        System.out.printf("* Option 4 - Quit                               *%n");
        System.out.printf("*                                               *%n");
        System.out.printf("*************************************************%n");
    }

    /**
     * Will execute player picked game mode.
     *
     * @param choice of game mode.
     */
    private static void executePlayerChoice(int choice) {

        switch (choice) {
            case 1: System.out.printf("%nSimulation%n");
                    fakeLoadingBar();
                    GameModeController.enterMode(GameModes.SIMULATION);
                break;
            case 2: System.out.printf("%nPlayer VS. CPU In-Development%n");
                break;
            case 3: System.out.printf("%nPlayer VS. PlayerOne In-Development%n");
                break;
            case 4: System.out.printf("%nThank-You For Playing, Bye!%n");
                break;
            default:
                break;
        }
    }

    /**
     * Will generate and display a fake loading bar.
     */
    private static void fakeLoadingBar() {

        StringBuilder stringBuilder = new StringBuilder("Loading[            ]");

        for (int i = 8; i < 20; i++) {

            stringBuilder.setCharAt(i, '*');
            System.out.printf("\r%s", stringBuilder.toString());
            GamePause.pause();
        }
        System.out.printf("%n");
    }

//Public Static Method(s)-
    /**
     * Will loop until player chooses valid game mode.
     */
    public static void gameMenuLoop() {

        Scanner cin = new Scanner(System.in);
        boolean exitMenu = false;
        boolean flag = true;
        int choice = 0;

        gameDescription();

        do {

            try {

                System.out.printf((flag) ? "%nEnter Game Choice: " : "%nInvalid Choice, Try Again: ");

                choice = Integer.parseInt(cin.next().trim());
                flag = (choice > 0 && choice <= NUMBER_OF_CHOICES);
                executePlayerChoice(choice);
                exitMenu = (choice == NUMBER_OF_CHOICES || choice == 1);

            } catch (NumberFormatException | NullPointerException e) {

                System.out.printf("%nDid not enter an integer, try again:");
            }
        } while (!exitMenu);
    }

}//End of Class.
