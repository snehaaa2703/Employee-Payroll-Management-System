package paysystem;

class InputValidator {

    public static String validateString(String value, String field) {
        if (value == null || value.trim().isEmpty())
            throw new IllegalArgumentException(field + " cannot be empty.");
        return value;
    }

    public static int validatePositiveInt(int value, String field) {
        if (value <= 0)
            throw new IllegalArgumentException(field + " must be positive.");
        return value;
    }

    public static double validatePositiveDouble(double value, String field) {
        if (value <= 0)
            throw new IllegalArgumentException(field + " must be positive.");
        return value;
    }
}

