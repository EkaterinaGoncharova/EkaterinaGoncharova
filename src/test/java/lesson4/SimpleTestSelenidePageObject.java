package lesson4;

import base.SelenideTestBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import listeners.AllureAttachmentListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.HomePageSelenide;
import pageObjects.base.Header;

import static com.codeborne.selenide.Selenide.page;
import static enums.Users.PITER_CHAILOVSKII;

@Feature("Smoke  tests")
@Story("Home Page Testing")
@Listeners(AllureAttachmentListener.class)
public class SimpleTestSelenidePageObject extends SelenideTestBase {

    private HomePageSelenide homePage;
    private Header header;

    @BeforeClass(alwaysRun = true)
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
