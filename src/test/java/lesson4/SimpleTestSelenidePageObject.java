package lesson4;

import base.SelenideTestBase;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageSelenide;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;

public class SimpleTestSelenidePageObject extends SelenideTestBase {

    private HomePageSelenide homePageSelenide;
    @BeforeClass
    public void beforeClass() {
        homePageSelenide = page(HomePageSelenide.class);
    }
    @Test
    public void simpleTestSelenide () {
        //setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        //2 Navigate
        open("https://epam.github.io/JDI/index.html");

        //3 Assert Title
        assertEquals(getWebDriver().getTitle(), "Home Page");

        //4 Login
        $(".profile-photo").click();
        $("[id = 'Name']").sendKeys("epam");
        $("[id = 'Password']").sendKeys("1234");
        $("[type = 'submit']").click();

        SelenideElement mainTitle = $("h3.main-title");
        mainTitle.shouldBe(visible);
        mainTitle.shouldHave(text("EPAM FRAMEWORK WISHES…"));
        assertEquals(mainTitle.getText(), "EPAM FRAMEWORK WISHES…");

        //$$(ByXPath("")).shouldHaveSize(4);

    }
}
