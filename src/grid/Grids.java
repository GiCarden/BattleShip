package grid;

/**
 * Bill Pugh Singleton Implementation.
 *
 * When the singleton class is loaded, the inner classes are not loaded and hence doesn’t create an object when loading
 * the class. The inner classes are created only when getInstance() method is called. So it may seem like eager
 * initialization but it is lazy initialization.
 */
public class Grids {

//Constructor(s)-
    /**
     * CoordinateValidator is non-instantiable
     */
    private Grids() { }

//Private Static Inner Class(s)-
    private static class PlayerOneGrid {

        private static final OceanGrid PLAYER_ONE_OCEAN_GRID_INSTANCE = new OceanGrid("PlayerOne #1 OceanGrid");
    }

    private static class PlayerOneTrackerGrid {

        private static final TrackerGrid PLAYER_ONE_TRACKER_GRID_INSTANCE = new TrackerGrid("PlayerOne #1 TrackerGrid");
    }

    private static class PlayerTwoGrid {

        private static final OceanGrid PLAYER_TWO_OCEAN_GRID_INSTANCE = new OceanGrid("PlayerOne #2 OceanGrid");
    }

    private static class PlayerTwoTrackerGrid {

        private static final TrackerGrid PLAYER_TWO_TRACKER_GRID_INSTANCE = new TrackerGrid("PlayerOne #2 TrackerGrid");
    }

//Getter(s)-
    /**
     * Getter for "this" objects PLAYER_ONE_OCEAN_GRID_INSTANCE reference.
     *
     * @return "this" objects PLAYER_ONE_OCEAN_GRID_INSTANCE reference.
     */
    public static OceanGrid getFleetGridOneInstance() { return PlayerOneGrid.PLAYER_ONE_OCEAN_GRID_INSTANCE; }

    /**
     * Getter for "this" objects PLAYER_TWO_OCEAN_GRID_INSTANCE reference.
     *
     * @return "this" objects PLAYER_TWO_OCEAN_GRID_INSTANCE reference.
     */
    public static OceanGrid getFleetGridTwoInstance() { return PlayerTwoGrid.PLAYER_TWO_OCEAN_GRID_INSTANCE; }

    /**
     * Getter for "this" objects PLAYER_ONE_TRACKER_GRID_INSTANCE reference.
     *
     * @return "this" objects PLAYER_ONE_TRACKER_GRID_INSTANCE reference.
     */
    public static TrackerGrid getTrackerGridOneInstance() { return PlayerOneTrackerGrid.PLAYER_ONE_TRACKER_GRID_INSTANCE; }

    /**
     * Getter for "this" objects PLAYER_TWO_TRACKER_GRID_INSTANCE reference.
     *
     * @return "this" objects PLAYER_TWO_TRACKER_GRID_INSTANCE reference.
     */
    public static TrackerGrid getTrackerGridTwoInstance() { return PlayerTwoTrackerGrid.PLAYER_TWO_TRACKER_GRID_INSTANCE; }

}//End of Class.
