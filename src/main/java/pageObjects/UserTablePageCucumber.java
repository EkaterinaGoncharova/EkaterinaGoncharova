package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static enums.Pages.USER_TABLE;

public class UserTablePageCucumber {

    @FindBy(css = "#user-table select")
    private ElementsCollection dropdowns;

    @FindBy(css = "#user-table a")
    private ElementsCollection usernames;

    @FindBy(css = "#user-table img")
    private ElementsCollection images;

    @FindBy(css = "#user-table span")
    private ElementsCollection texts;

    @FindBy(css = "#user-table input")
    private ElementsCollection checkboxes;

    @FindBy(css = ".panel-body-list > li")
    private ElementsCollection logSection;

    @FindBy(css = "#user-table tbody > tr:nth-child(2) option")
    private ElementsCollection dropdownValues;

    public UserTablePageCucumber() {
        page(this);
    }

    //================================methods===================================

    @Then("\"User Table\" page is opened")
    public void openPage() {
        open(USER_TABLE.url);
    }

    @When("I select 'vip' checkbox for \"(.+)\"")
    public void selectCheckbox(String username) {
        String xpath = String.format("//*[text()[contains(.,'%s')]]/../following-sibling::td/div/input", username);
        $(By.xpath(xpath)).click();
    }

    @When("I click on dropdown in column Type for user (.+)")
    public void clickOnDropdown(String username) {
        String xpath = String.format("//*[text()[contains(.,'%s')]]/../preceding-sibling::td/select", username);
        $(By.xpath(xpath)).click();
    }

    //================================checks===================================

    @And("(\\d+) NumberType Dropdowns are displayed on Users Table on User Table Page")
    public void checkDropdownsAmount(int amount) {
        dropdowns.shouldHaveSize(amount);
    }

    @And("(\\d+) User names are displayed on Users Table on User Table Page")
    public void checkUserNamesAmount(int amount) {
        usernames.shouldHaveSize(amount);
    }

    @And("(\\d+) Description images are displayed on Users Table on User Table Page")
    public void checkImagesAmount(int amount) {
        images.shouldHaveSize(amount);
    }

    @And("(\\d+) Description texts under images are displayed on Users Table on User Table Page")
    public void checkTextsAmount(int amount) {
        texts.shouldHaveSize(amount);
    }

    @And("(\\d+) checkboxes are displayed on Users Table on User Table Page")
    public void checkCheckboxesAmount(int amount) {
        checkboxes.shouldHaveSize(amount);
    }

    @And("User table contains following values:")
    public void checkTableValues(DataTable args) {
        List<Map<String, String>> table = args.asMaps(String.class, String.class);
        for (Map<String, String> map : table) {
            usernames.findBy(text(map.get("User"))).shouldBe(visible);
            texts.findBy(text(map.get("Description"))).shouldBe(visible);
        }
    }

    @Then("(\\d+) log row has \"(.+)\" text in log section")
    public void checkLog(int amount, String text) {
        logSection.shouldHaveSize(amount);
        logSection.get(0).shouldHave(text(text));
    }

    @Then("droplist contains values")
    public void checkDropdownValues(DataTable args) {
        List<Map<String, String>> table = args.asMaps(String.class, String.class);
        int i = 0;
        for (Map<String, String> map : table) {
            for (String value : map.values()) {
                dropdownValues.get(i++).shouldHave(text(value));
            }
        }
    }
}
