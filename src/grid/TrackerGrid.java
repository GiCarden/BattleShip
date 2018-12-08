package grid;

import util.GridIcons;

/**
 * This Class represents a players tracker grid.
 */
public class TrackerGrid extends BaseGrid<String> {

//Variable(s)-
    private static final int ROWS = 11;
    private static final int COLS = 11;

//Constructor(s)-
    /**
     * Constructor initializes a newly created TrackerGrid object.
     */
    TrackerGrid(String gridTitle) {

        super(ROWS, COLS, gridTitle);
        initGridMarkers();
    }

//Private Method(s)-
    /**
     * Appends the coordinate system to the TrackerGrid grid.
     */
    private void initGridMarkers() {

        addObject(0, 0, String.valueOf(GridIcons.NUMBERS.getNumberIcons()[0]));

        for (int i = 1; i < ROWS; i++) { addObject(0, i, String.valueOf(i)); }

        for (int j = 1; j < COLS; j++) { addObject(j, 0, String.valueOf(GridIcons.LETTERS.getLetterIcons()[j-1])); }

        for (int i = 1; i < ROWS; i++) { for (int j = 1; j < COLS; j++) { addObject(i, j, GridIcons.UNCHECKED.getIcon()); } }
    }

//Public Method(s)-
    /**
     * Will print the TrackerGrid grid.
     */
    public void printGrid() { super.printGrid(); }

}//End of Class.

