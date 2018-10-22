package pageObjects;


import org.openqa.selenium.WebDriver;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;

public class HomePageSelenide {

    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private SelenideElement login;

    @FindBy(css = "[id = 'Password']")
    private SelenideElement password;

    @FindBy(css = "[type = 'submit']")
    private SelenideElement submit;

    @FindBy(css = "")
    private SelenideElement mainText;

    //================================methods===================================

    public void open(WebDriver driver) {
        driver.get("");
    }

    public void login(String name, String passwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();
    }

    //================================checks===================================

    public void checkTitle(WebDriver driver) {
        assertEquals(driver, "");
    }

    public void checkMainText() {
        assertEquals(mainText.getText(), "");
    }
}