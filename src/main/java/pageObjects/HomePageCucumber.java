package pageObjects;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.Pages.INDEX;
import static org.testng.Assert.assertEquals;

public class HomePageCucumber {

    @FindBy(css = ".benefit-icon")
    private ElementsCollection images;

    @FindBy(css = ".benefit-txt")
    private ElementsCollection imagesTexts;

    @FindBy(css = "h3.main-title")
    private SelenideElement mainHeader;

    @FindBy(css = ".main-txt")
    private SelenideElement mainText;

    public HomePageCucumber() {
        page(this);
    }

    //================================methods===================================

    @Given("I am on \"Home Page\"")
    public void openPage() {
        open(INDEX.url);
    }

    //================================checks===================================

    @Then("The browser title is Home Page")
    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), INDEX.title);
    }

    @And("(\\d+) pictures are displayed on the Home Page")
    public void checkImagesAmount(int amount) {
        assertEquals(images.size(), amount);
        for (SelenideElement image : images) {
            image.shouldBe(visible);
        }
    }

    @And("(\\d+) texts are displayed on the Home Page")
    public void checkImageTextsAmount(int amount) {
        assertEquals(imagesTexts.size(), amount);
        for (SelenideElement imageText : imagesTexts) {
            imageText.shouldBe(visible);
        }
    }

    @And("headline and description are displayed on the Home Page")
    public void checkHeadlineAndDescription() {
        mainHeader.shouldBe(visible);
        mainText.shouldBe(visible);
    }
}


