package enums;

public enum Pages {

    INDEX("Home Page", "https://epam.github.io/JDI/index.html"),
    JDI_GITHUB("epam/JDI: JDI is the test Framework for UI test automation", "https://github.com/epam/JDI");

    public String title;
    public String url;

    Pages(String title, String url) {
        this.title = title;
        this.url = url;
    }
}
