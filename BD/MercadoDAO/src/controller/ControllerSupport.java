package controller;

abstract class ControllerSupport {
    protected static String requireNonBlank(String value, String field) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(field + " não pode ficar vazio.");
        }
        return value.trim();
    }

    protected static int requirePositive(int value, String field) {
        if (value <= 0) {
            throw new IllegalArgumentException(field + " deve ser maior que zero.");
        }
        return value;
    }

    protected static int requireNonNegative(int value, String field) {
        if (value < 0) {
            throw new IllegalArgumentException(field + " não pode ser negativo.");
        }
        return value;
    }

    protected static double requireNonNegative(double value, String field) {
        if (!Double.isFinite(value) || value < 0) {
            throw new IllegalArgumentException(field + " deve ser um número válido e não negativo.");
        }
        return value;
    }

    protected static <T> T requireEntity(T value, String field) {
        if (value == null) {
            throw new IllegalArgumentException(field + " é obrigatório.");
        }
        return value;
    }
}
