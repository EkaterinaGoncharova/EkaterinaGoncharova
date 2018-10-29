package enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum ServiceItems {

    SUPPORT("Support", "SUPPORT"),
    DATES("Dates", "DATES"),
    COMPLEX_TABLE("Complex Table", "COMPLEX TABLE"),
    SIMPLE_TABLE("Simple Table", "SIMPLE TABLE"),
    USER_TABLE("User Table", "USER TABLE"),
    TABLE_WITH_PAGES("Table with pages", "TABLE WITH PAGES"),
    DIFFERENT_ELEMENTS("Different elements", "DIFFERENT ELEMENTS"),
    PERFORMANCE("Performance", "PERFORMANCE");

    public String displayName;
    public String displayNameUpperCase;

    ServiceItems(String displayName, String displayNameUpperCase) {
        this.displayName = displayName;
        this.displayNameUpperCase = displayNameUpperCase;
    }

    public static List<String> toList() {
        List<ServiceItems> items = new ArrayList<ServiceItems>(Arrays.asList(ServiceItems.values()));
        List<String> itemsList = new ArrayList<String>();
        for (ServiceItems item : items) {
            itemsList.add(item.displayName);
        }
        return itemsList;
    }

    public static List<String> toUpperCaseList() {
        List<ServiceItems> items = new ArrayList<ServiceItems>(Arrays.asList(ServiceItems.values()));
        List<String> itemsList = new ArrayList<String>();
        for (ServiceItems item : items) {
            itemsList.add(item.displayNameUpperCase);
        }
        return itemsList;
    }

}
