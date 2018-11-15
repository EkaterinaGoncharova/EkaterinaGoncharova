package pageObjects.base;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Users;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertEquals;

public class HeaderCucumber {

    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private SelenideElement login;

    @FindBy(css = "[id = 'Password']")
    private SelenideElement password;

    @FindBy(css = "[type = 'submit']")
    private SelenideElement submit;

    @FindBy(css = ".profile-photo > span")
    private SelenideElement userName;

    @FindBy(css = ".dropdown > .dropdown-toggle")
    private SelenideElement headerServiceItem;

    @FindBy(css = ".dropdown-menu > li")
    private ElementsCollection headerServiceItems;

    public HeaderCucumber() {
        page(this);
    }

    //================================methods===================================

    @When("I login as user \"(.+)\"")
    public void login(String userStr) {
        Users user = Users.toUser(userStr);
        profileButton.click();
        login.sendKeys(user.name);
        password.sendKeys(user.password);
        submit.click();
    }

    @When("I click on \"Service\" button in Header")
    public void clickService() {
        headerServiceItem.click();
    }

    @And("I click on \"(.+)\" button in Service dropdown")
    public void selectServiceItem(String item) {
        headerServiceItems.find(text(item)).click();
    }

    //================================checks===================================

    @Then("\"(.+)\" user icon is displayed on the header")
    public void checkUserName(String userStr) {
        Users user = Users.toUser(userStr);
        assertEquals(userName.getText(), user.displayName);
    }

    @Then("Service menu in the header contains options:")
    public void checkServiceItems(List<String> itemTexts) {
        headerServiceItems.shouldHaveSize(itemTexts.size());
        headerServiceItems.shouldHave(exactTexts(itemTexts));
    }
}