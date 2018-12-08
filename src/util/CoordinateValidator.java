package util;

import java.util.HashMap;
import java.util.Map;

/**
 * Helper class for validating user coordinate input.
 *
 * The class is marked final, cannot be extended.
 */
public final class CoordinateValidator {

//Variable(s)-
    private static Map<Integer, Integer> X_COORDINATE_MAP = null;
    private static Map<String, Integer> Y_COORDINATE_MAP = null;

//Static Block()-
    static {  //Static variable initializations.

        X_COORDINATE_MAP = new HashMap<>();
        X_COORDINATE_MAP.put(1, 1);
        X_COORDINATE_MAP.put(2, 2);
        X_COORDINATE_MAP.put(3, 3);
        X_COORDINATE_MAP.put(4, 4);
        X_COORDINATE_MAP.put(5, 5);
        X_COORDINATE_MAP.put(6, 6);
        X_COORDINATE_MAP.put(7, 7);
        X_COORDINATE_MAP.put(8, 8);
        X_COORDINATE_MAP.put(9, 9);
        X_COORDINATE_MAP.put(10, 10);

        Y_COORDINATE_MAP = new HashMap<>();
        Y_COORDINATE_MAP.put("A", 1);
        Y_COORDINATE_MAP.put("B", 2);
        Y_COORDINATE_MAP.put("C", 3);
        Y_COORDINATE_MAP.put("D", 4);
        Y_COORDINATE_MAP.put("E", 5);
        Y_COORDINATE_MAP.put("F", 6);
        Y_COORDINATE_MAP.put("G", 7);
        Y_COORDINATE_MAP.put("H", 8);
        Y_COORDINATE_MAP.put("I", 9);
        Y_COORDINATE_MAP.put("J", 10);
    }

//Constructor(s)-
    /**
     * CoordinateValidator is non-instantiable
     */
    private CoordinateValidator() {}

//Public Static Method(s)-
    /**
     * User coordinate validator.
     *
     * @param x value to validate.
     * @param y value to validate.
     * @return true if the maps contain the two keys, else false.
     */
    public static boolean validate(int x, String y) { return (X_COORDINATE_MAP.containsKey(x) && Y_COORDINATE_MAP.containsKey(y)); }

    /**
     * If map contains key value will be returned.
     *
     * @param key the key whose associated value is to be returned.
     * @return the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     */
    public static int getXMapValue(int key) { return X_COORDINATE_MAP.get(key); }

    /**
     * If map contains key value will be returned.
     *
     * @param key the key whose associated value is to be returned.
     * @return the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     */
    public static int getYMapValue(String key) { return Y_COORDINATE_MAP.get(key); }

}//End of Class.
