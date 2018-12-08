package util;

/**
 * Used to pause the Main Thread.
 */
public class GamePause {

    /**
     * Will pause the Main Thread.
     */
    public static void pause() {

        try {

            Thread.sleep(1000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

}//End of Class.
