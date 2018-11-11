package pageObjects;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.Checkboxes;
import enums.DropdownItems;
import enums.Radios;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.Pages.DIFFERENT_ELEMENTS;
import static org.testng.Assert.assertEquals;

public class DifferentElementsPage {

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


    //================================methods===================================

    @Step
    public void clickCheckboxes(Checkboxes... checkboxes) {
        for (Checkboxes checkbox : checkboxes) {
            this.checkboxes.find(text(checkbox.displayName)).click();
        }
    }

    @Step
    public void clickRadio(Radios... radios) {
        for (Radios radio : radios) {
            this.radios.find(text(radio.displayName)).click();
        }
    }

    @Step
    public void clickDropdownItem(DropdownItems item) {
        dropdown.click();
        dropdownItems.find(text(item.displayName)).click();
    }

    //================================checks===================================

    @Step
    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), DIFFERENT_ELEMENTS.title);
    }

    @Step
    public void checkInterface() {
        checkboxes.shouldHaveSize(4);
        for (SelenideElement checkbox : checkboxes) {
            checkbox.shouldBe(visible);
        }
        radios.shouldHaveSize(4);
        for (SelenideElement radiobutton : radios) {
            radiobutton.shouldBe(visible);
        }
        dropdown.shouldBe(visible);
        defaultButton.shouldBe(visible);
        button.shouldBe(visible);
    }

    @Step
    public void checkRightSection() {
        rightSection.shouldBe(visible);
    }

    @Step
    public void checkCheckboxesLog(Checkboxes checkbox1, Checkboxes checkbox2, boolean isChecked) {
        logSection.findBy(text(checkbox1.displayName + checkboxLog + String.valueOf(isChecked))).shouldBe(visible);
        logSection.findBy(text(checkbox2.displayName + checkboxLog + String.valueOf(isChecked))).shouldBe(visible);
    }

    @Step
    public void checkRadioLog(Radios radio) {
        logSection.findBy(text(radioLog + radio.displayName)).shouldBe(visible);
    }

    @Step
    public void checkDropdownLog(DropdownItems item) {
        logSection.findBy(text(dropdownLog + item.displayName)).shouldBe(visible);
    }
}