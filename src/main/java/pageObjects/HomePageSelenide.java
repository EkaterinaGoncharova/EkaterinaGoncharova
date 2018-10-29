package pageObjects;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.Pages;
import enums.ServiceItems;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class HomePageSelenide {

    private final String MAIN_TEXT = "EPAM FRAMEWORK WISHES…";

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

    @FindBy(css = "h3.main-title")
    private SelenideElement mainText;

    @FindBy(css = ".dropdown > .dropdown-toggle")
    private SelenideElement headerServiceItem;

    @FindBy(css = ".dropdown-menu > li")
    private ElementsCollection headerServiceItems;

    @FindBy(css = ".menu-title[index='3']")
    private SelenideElement leftSectionServiceItem;

    @FindBy(css = ".menu-title[index='3'] > .sub li")
    private ElementsCollection leftSectionServiceItems;


    //================================methods===================================

    public void openPage() {
        open(Pages.INDEX.url);
    }

    public void login(String name, String passwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();
    }

    public void clickHeaderServiceItem() {
        headerServiceItem.click();
    }

    public void clickLeftSectionServiceItem() {
        leftSectionServiceItem.click();
    }

    public void clickHeaderServiceItem(ServiceItems item) {
        headerServiceItem.click();
        headerServiceItems.find(text(item.displayNameUpperCase)).click();
    }

    //================================checks===================================

    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), Pages.INDEX.title);
    }

    public void checkUserName(String user) {
        assertEquals(userName.getText(), user);
    }

    public void checkMainText() {
        mainText.shouldBe(visible);
        mainText.shouldHave(text(MAIN_TEXT));
    }

    public void checkHeaderServiceItems() {
        List<String> itemTexts = ServiceItems.toUpperCaseList();
        headerServiceItems.shouldHaveSize(itemTexts.size());
        headerServiceItems.shouldHave(exactTexts(itemTexts));
    }

    public void checkLeftSectionServiceItems() {
        List<String> itemTexts = ServiceItems.toList();
        leftSectionServiceItems.shouldHaveSize(itemTexts.size());
        leftSectionServiceItems.shouldHave(exactTexts(itemTexts));
    }
}