package util;

/**
 * Sets all possible ship types and values.
 */
public enum ShipType {

//Enum Variable list(s)-
    BATTLESHIP("BattleShip", 4, GridIcons.BATTLESHIP),
    CARRIER("Carrier", 5, GridIcons.CARRIER),
    CRUISER("Cruiser", 3, GridIcons.CRUISER),
    DESTROYER("Destroyer", 2, GridIcons.DESTROYER),
    SUBMARINE("Submarine", 3, GridIcons.SUBMARINE);

//Variable(s)-
    private GridIcons shipIcon;
    private String type;
    private int size;

//Constructor(s)-
    ShipType(String type, int size, GridIcons shipIcon) {

        this.type = type;
        this.size = size;
        this.shipIcon = shipIcon;
    }

//Public Overridden Method(s)-
    @Override
    public String toString() { return String.format("%s - Size: %s", getType(), getSize()); }

//Getters(s)-
    public GridIcons getShipIcon() { return shipIcon; }

    public String getType() { return this.type; }

    public int getSize() { return this.size; }

}//End of enum.
