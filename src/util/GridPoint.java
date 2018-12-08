package util;

/**
 * Represents an precise location on a two-dimensional plane.
 */
public class GridPoint {

//Variable(s)-
    private int x;
    private int y;

//Constructor(s)-
    /**
     * Initializes class fields before creating an instance of a GridPoint.
     *
     * @param x point x value.
     * @param y point y vale.
     */
    public GridPoint(int x, int y) { this.x = x; this.y = y; }

//Public Overridden Method(s)-
    /**
     * Tests GridPoint objects for matching values.
     *
     * @param obj to test values against.
     * @return true if the objects contain the same values, else false.
     */
    @Override
    public boolean equals(Object obj) {

        boolean flag = false;

        if (obj instanceof GridPoint) {

            GridPoint gridPoint = (GridPoint) obj;

            flag = (this.x == gridPoint.getX() && this.y == gridPoint.getY());
        }
        return flag;
    }

    /**
     * Returns a string that "textually represents" this object.
     *
     * @return string representation of the this object.
     */
    @Override
    public String toString() { return  String.format("(%s, %s)", x, y); }

//Getters(s)-
    /**
     * Getter for "this" objects x value.
     *
     * @return "this" objects x value.
     */
    public int getX() { return this.x; }

    /**
     * Getter for "this" objects y value.
     *
     * @return "this" objects y value.
     */
    public int getY() { return this.y; }

}//End of Class.
