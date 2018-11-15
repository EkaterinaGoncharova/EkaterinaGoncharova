package pageObjects.base;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class LeftSectionCucumber {

    @FindBy(css = "[name='navigation-sidebar']")
    private SelenideElement leftSection;

    @FindBy(css = ".menu-title[index='3']")
    private SelenideElement service;

    @FindBy(css = ".menu-title[index='3'] > .sub li")
    private ElementsCollection serviceItems;

    public LeftSectionCucumber() {
        page(this);
    }

    //================================methods===================================

    @When("I click on Service subcategory in the left section")
    public void clickService() {
        service.click();
    }

    //================================checks===================================

    @And("left section is displayed")
    public void checkLeftSection() {
        leftSection.shouldBe(visible);
    }

    @Then("Service menu in the left section contains options:")
    public void checkServiceItems(List<String> itemTexts) {
        serviceItems.shouldHaveSize(itemTexts.size());
        serviceItems.shouldHave(exactTexts(itemTexts));
    }
}
