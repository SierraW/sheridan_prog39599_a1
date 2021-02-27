package ca.sheridancollege.zhanyiya.a1_movierating.beans;

public enum StarSelection {
    ONE("⭐"), TWO("⭐⭐"), THREE("⭐⭐⭐"), FOUR("⭐⭐⭐⭐"), FIVE("⭐⭐⭐⭐⭐");

    private final String value;

    StarSelection(final String newValue) {
        value = newValue;
    }

    public String getValue() { return value; }
}
