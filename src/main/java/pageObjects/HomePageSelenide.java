package pageObjects;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.Pages.INDEX;
import static org.testng.Assert.assertEquals;

public class HomePageSelenide {

    private final String MAIN_TEXT = "EPAM FRAMEWORK WISHES…";

    @FindBy(css = "h3.main-title")
    private SelenideElement mainText;

    //================================methods===================================

    public void openPage() {
        open(INDEX.url);
    }

    //================================checks===================================

    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), INDEX.title);
    }

    public void checkMainText() {
        mainText.shouldBe(visible);
        mainText.shouldHave(text(MAIN_TEXT));
    }
}