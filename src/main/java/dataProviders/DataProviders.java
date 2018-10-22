package dataProviders;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider
    public Object[][] simpleDataProvider() {
        return new Object[][] {
                {"String1", 1},
                {"String2", 2},
                {"String3", 3}
        };
    }

    @DataProvider(parallel = true)
    public Object[][] homePageTextDataProvider() {
        return new Object[][] {
                {"//span[@class='icons-benefit icon-practise']/../following-sibling::span",
                        "To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project"},
                {"//span[@class='icons-benefit icon-custom']/../following-sibling::span",
                        "To be flexible and\n" +
                        "customizable"},
                {"//span[@class='icons-benefit icon-multi']/../following-sibling::span",
                        "To be multiplatform"},
                {"//span[@class='icons-benefit icon-base']/../following-sibling::span",
                        "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n"
                        + "wish to get more…"}
        };
    }
}
