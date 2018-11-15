package pageObjects;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.Pages.INDEX;
import static org.testng.Assert.assertEquals;

public class HomePage {

    private final String MAIN_TEXT = "EPAM FRAMEWORK WISHES…";

    @FindBy(css = "h3.main-title")
    private SelenideElement mainText;

    //================================methods===================================

    @Step
    public void openPage() {
        open(INDEX.url);
    }

    //================================checks===================================

    @Step
    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), INDEX.title);
    }

    @Step
    public void checkMainText() {
        mainText.shouldBe(visible);
        mainText.shouldHave(text(MAIN_TEXT));
    }
}