package pageObjects;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.Pages.DIFFERENT_ELEMENTS;
import static org.testng.Assert.assertEquals;

public class DifferentElementsPageCucumber {

    private final String checkboxLog = ": condition changed to ";
    private final String radioLog = "metal: value changed to ";
    private final String dropdownLog = "Colors: value changed to ";

    @FindBy(css = ".checkbox-row > .label-checkbox")
    private ElementsCollection checkboxes;

    @FindBy(css = ".checkbox-row > .label-radio")
    private ElementsCollection radios;

    @FindBy(css = "select.uui-form-element")
    private SelenideElement dropdown;

    @FindBy(css = "select.uui-form-element > option")
    private ElementsCollection dropdownItems;

    @FindBy(css = "[value='Default Button']")
    private SelenideElement defaultButton;

    @FindBy(css = "[value='Button']")
    private SelenideElement button;

    @FindBy(css = "#mCSB_2")
    private SelenideElement rightSection;

    @FindBy(css = ".panel-body-list > li")
    private ElementsCollection logSection;

    public DifferentElementsPageCucumber() {
        page(this);
    }

    //================================methods===================================

    @When("select checkboxes:")
    public void clickCheckboxes(List<String> checkboxes) {
        for (String checkbox : checkboxes) {
            this.checkboxes.find(text(checkbox)).click();
        }
    }

    @When("select (.+) radio")
    public void clickRadio(String radio) {
        radios.find(text(radio)).click();
    }

    @When("select (.+) dropdown item")
    public void clickDropdownItem(String item) {
        dropdown.click();
        dropdownItems.find(text(item)).click();
    }

    //================================checks===================================

    @Then("Different Elements page is opened")
    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), DIFFERENT_ELEMENTS.title);
    }

    @And("(\\d+) checkboxes are displayed on the Different Elements Page")
    public void checkCheckboxesAmount(int amount) {
        checkboxes.shouldHaveSize(amount);
        for (SelenideElement checkbox : checkboxes) {
            checkbox.shouldBe(visible);
        }
    }

    @Then("(\\d+) radios are displayed on the Different Elements Page")
    public void checkRadiosAmount(int amount) {
        radios.shouldHaveSize(amount);
        for (SelenideElement radiobutton : radios) {
            radiobutton.shouldBe(visible);
        }
    }

    @And("dropdown and buttons are displayed on the Different Elements Page")
    public void checkDropdownAndButtons() {
        dropdown.shouldBe(visible);
        defaultButton.shouldBe(visible);
        button.shouldBe(visible);
    }

    @And("right section is displayed")
    public void checkRightSection() {
        rightSection.shouldBe(visible);
    }

    @Then("log contains rows that checkboxes are set to (.+):")
    public void checkCheckboxesLog(String isChecked, List<String> checkboxes) {
        for (String checkbox : checkboxes) {
            logSection.findBy(text(checkbox + checkboxLog + isChecked)).shouldBe(visible);
        }
    }

    @Then("log contains row about (.+) radio")
    public void checkRadioLog(String radio) {
        logSection.findBy(text(radioLog + radio)).shouldBe(visible);
    }

    @Then("log contains row about (.+) dropdown item")
    public void checkDropdownLog(String item) {
        logSection.findBy(text(dropdownLog + item)).shouldBe(visible);
    }
}