package enums;

public enum Checkboxes {

    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    public String displayName;

    Checkboxes(String displayName) {
        this.displayName = displayName;
    }
}
