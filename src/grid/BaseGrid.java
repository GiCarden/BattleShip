package grid;

/**
 * Package Private Abstract Generic BaseGrid Class.
 */
abstract class BaseGrid<T> {

//Variable(s)-
    private int width;
    private int height;
    private String gridTitle;
    private T[][] genericGrid;

//Constructor(s)-
    /**
     * Constructor initializes a generic multidimensional object array, Sets the dimensions for the grid.
     *
     * @param width for the grid.
     * @param height for the grid.
     * @param gridTitle title for grid.
     */
    BaseGrid(int width, int height, String gridTitle) {

        this.width = width;
        this.height = height;
        this.gridTitle = gridTitle;
        this.genericGrid = (T[][]) new Object[width][height];
    }

//Package Private Method(s)-
    /**
     * Prints the multidimensional object array in grid form.
     */
    void printGrid() {

        System.out.print("\n");
        System.out.printf("%s%n", this.gridTitle);
        for (int i = 0; i < this.width; i++) {

            System.out.printf("%-2s", "");
            for (int j = 0; j < this.height; j++) {

                System.out.printf("%-5s", this.genericGrid[i][j]);
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

//Public Method(s)-
    /**
     * Adds an object to the grid.
     *
     * @param x coordinate.
     * @param y coordinate.
     * @param object to add.
     */
    public void addObject(int x, int y, T object) { this.genericGrid[x][y] = (T) object; }

    /**
     * Returns an object from a specific coordinate point.
     *
     * @param x coordinate.
     * @param y coordinate.
     * @return object
     */
    public T getGridObjectAt(int x, int y) { return this.genericGrid[x][y]; }

}//End of Class.
