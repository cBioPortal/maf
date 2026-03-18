package org.mskcc.cbio.maf;

/**
 * Utility methods for detecting and converting simple scalar value types.
 */
public class ValueTypeUtil {

    private ValueTypeUtil() {
        throw new IllegalStateException("This is a utility class. Do not instantiate.");
    }

    /**
     * Checks whether the supplied string can be parsed as an integer.
     *
     * @param value the value to inspect
     * @return {@code true} when the value parses as an integer
     */
    public static boolean isInt(String value) {
        if (value == null) {
            return false;
        }
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * Checks whether the supplied string can be parsed as a float.
     *
     * @param value the value to inspect
     * @return {@code true} when the value parses as a float
     */
    public static boolean isFloat(String value) {
        if (value == null) {
            return false;
        }
        try {
            Float.parseFloat(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * Checks whether the supplied string can be parsed as a double.
     *
     * @param value the value to inspect
     * @return {@code true} when the value parses as a double
     */
    public static boolean isDouble(String value) {
        if (value == null) {
            return false;
        }
        try {
            Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * Converts a supported numeric or numeric-string value to a float.
     *
     * @param value the value to convert
     * @return the converted float, or {@code null} when the input is {@code null}
     */
    public static Float toFloat(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Integer) {
            return ((Integer) value).floatValue();
        }
        if (value instanceof Float) {
            return (Float) value;
        }
        if (value instanceof Long) {
            return ((Long) value).floatValue();
        }
        if (value instanceof Double) {
            return ((Double) value).floatValue();
        }
        if (value instanceof String) {
            return Float.parseFloat((String) value);
        }
        throw new RuntimeException("Object type not covered by toFloat method. Value is: " + value.toString());
    }

    /**
     * Converts a supported numeric or numeric-string value to an integer.
     *
     * @param value the value to convert
     * @return the converted integer, or {@code null} when the input is {@code null}
     */
    public static Integer toInt(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Integer) {
            return (Integer) value;
        }
        if (value instanceof Float) {
            return Math.round((Float) value);
        }
        if (value instanceof Long) {
            return ((Long) value).intValue();
        }
        if (value instanceof Double) {
            return Math.toIntExact(Math.round((Double) value));
        }
        if (value instanceof String) {
            return Integer.parseInt((String) value);
        }
        throw new RuntimeException("Object type not covered by toInt method. Value is: " + value.toString());
    }

}
