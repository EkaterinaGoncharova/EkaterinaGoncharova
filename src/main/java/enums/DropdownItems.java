package enums;

public enum DropdownItems {

    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    public String displayName;

    DropdownItems(String displayName) {
        this.displayName = displayName;
    }
}
