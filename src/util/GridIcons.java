package util;

/**
 * Sets all possible grid icons.
 */
public enum GridIcons {

//Enum Variable list(s)-
    UNCHECKED("."),
    HIT("X"), MISSED("O"),
    BATTLESHIP("BS"), CARRIER("CA"), CRUISER("CR"), DESTROYER("DE"), SUBMARINE("SU"),
    LETTERS("A", "B", "C", "D", "E", "F", "G", "H", "I", "J"),
    NUMBERS(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

//Variable(s)-
    private String icon;
    private String[] letterIcons;
    private int[] numberIcons;

//Constructor(s)-
    GridIcons(String icon) { this.icon = icon; }

    GridIcons(String... icons) { this.letterIcons = icons; }

    GridIcons(int... icons) { this.numberIcons = icons; }

//Getters(s)-
    public String getIcon() { return this.icon; }

    public String[] getLetterIcons() { return this.letterIcons; }

    public int[] getNumberIcons() { return this.numberIcons; }

}//End of enum.
