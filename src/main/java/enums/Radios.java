package enums;

public enum Radios {

    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    public String displayName;

    Radios(String displayName) {
        this.displayName = displayName;
    }
}
