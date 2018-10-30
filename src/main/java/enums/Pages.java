package enums;

public enum Pages {

    INDEX("Home Page", "https://epam.github.io/JDI/index.html"),
    DIFFERENT_ELEMENTS("Different Elements", "https://epam.github.io/JDI/different-elements.html"),
    DATES("Dates", "https://epam.github.io/JDI/dates.html"),
    JDI_GITHUB("epam/JDI: JDI is the test Framework for UI test automation", "https://github.com/epam/JDI");

    public String title;
    public String url;

    Pages(String title, String url) {
        this.title = title;
        this.url = url;
    }
}
