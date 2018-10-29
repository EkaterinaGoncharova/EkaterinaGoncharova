package lesson4;

import base.SelenideTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageSelenide;

import static com.codeborne.selenide.Selenide.page;
import static enums.Users.PITER_CHAILOVSKII;

public class SimpleTestSelenidePageObject extends SelenideTestBase {

    private HomePageSelenide homePageSelenide;

    @BeforeClass
    public void beforeClass() {
        homePageSelenide = page(HomePageSelenide.class);
    }

    @Test
    public void simpleTestSelenide() {

        //2 Navigate
        homePageSelenide.openPage();

        //3 Assert Title
        homePageSelenide.checkTitle();

        //4 Login
        homePageSelenide.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //5 Check main title
        homePageSelenide.checkMainText();
    }
}
