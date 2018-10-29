package pageObjects;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.Checkboxes;
import enums.DropdownItems;
import enums.Pages;
import enums.Radios;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class ServiceDifferentElementsPage {

    private final String checkboxLogText = ": condition changed to ";

    private final String radioLogText = "metal: value changed to ";

    private final String dropdownLogText = "Colors: value changed to ";

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

    @FindBy(css = "[name='navigation-sidebar']")
    private SelenideElement leftSection;

    @FindBy(css = ".panel-body-list > li")
    private ElementsCollection logPanel;


    //================================methods===================================

    public void clickCheckbox(Checkboxes checkbox) {
        checkboxes.find(text(checkbox.displayName)).click();
    }

    public void clickRadio(Radios radio) {
        radios.find(text(radio.displayName)).click();
    }

    public void clickDropdownItem(DropdownItems item) {
        dropdown.click();
        dropdownItems.find(text(item.displayName)).click();
    }

    //================================checks===================================

    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), Pages.SERVICE_DEFFERENT_ELEMENTS.title);
    }

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

    public void checkRightSection() {
        rightSection.shouldBe(visible);
    }

    public void checkLeftSection() {
        leftSection.shouldBe(visible);
    }

    public void checkLogAboutCheckboxes(Checkboxes checkbox1, Checkboxes checkbox2, boolean isChecked) {
        logPanel.get(0).shouldHave(text(checkbox1.displayName + checkboxLogText + String.valueOf(isChecked)));
        logPanel.get(1).shouldHave(text(checkbox2.displayName + checkboxLogText + String.valueOf(isChecked)));
    }

    public void checkLogAboutRadio(Radios radio) {
        logPanel.get(0).shouldHave(text(radioLogText + radio.displayName));
    }

    public void checkLogAboutDropdownItem(DropdownItems item) {
        logPanel.get(0).shouldHave(text(dropdownLogText + item.displayName));
    }
}