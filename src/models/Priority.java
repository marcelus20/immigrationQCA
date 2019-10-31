package models;

public enum Priority {

    high(1), medium(2), low(3);

    private final int precedence;

    Priority(int precedence) {
        this.precedence = precedence;
    }

    public int getPrecedence() {
        return precedence;
    }
}
