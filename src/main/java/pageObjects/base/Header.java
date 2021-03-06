package pageObjects.base;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.ServiceItems;
import enums.Users;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.text;
import static org.testng.Assert.assertEquals;

public class Header {

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

    //================================methods===================================

    @Step
    public void login(Users user) {
        profileButton.click();
        login.sendKeys(user.name);
        password.sendKeys(user.password);
        submit.click();
    }

    @Step
    public void clickService() {
        headerServiceItem.click();
    }

    @Step
    public void selectServiceItem(ServiceItems item) {
        headerServiceItem.click();
        headerServiceItems.find(text(item.displayNameUpperCase)).click();
    }

    //================================checks===================================

    @Step
    public void checkUserName(Users user) {
        assertEquals(userName.getText(), user.displayName);
    }

    @Step
    public void checkServiceItems() {
        List<String> itemTexts = ServiceItems.toUpperCaseList();
        headerServiceItems.shouldHaveSize(itemTexts.size());
        headerServiceItems.shouldHave(exactTexts(itemTexts));
    }
}