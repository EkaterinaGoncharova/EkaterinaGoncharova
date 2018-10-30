package lesson4;

import base.SelenideTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageSelenide;
import pageObjects.base.Header;

import static com.codeborne.selenide.Selenide.page;
import static enums.Users.PITER_CHAILOVSKII;

public class SimpleTestSelenidePageObject extends SelenideTestBase {

    private HomePageSelenide homePage;
    private Header header;

    @BeforeClass
    public void beforeClass() {
        homePage = page(HomePageSelenide.class);
        header = page(Header.class);
    }

    @Test
    public void simpleTestSelenide() {

        //2 Navigate
        homePage.openPage();

        //3 Assert Title
        homePage.checkTitle();

        //4 Login
        header.login(PITER_CHAILOVSKII);

        //5 Check main title
        homePage.checkMainText();
    }
}
