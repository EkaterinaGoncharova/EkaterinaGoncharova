package pageObjects;


import enums.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageSelenium {

    private final List<String> HEADER_ITEMS = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");

    private final String MAIN_HEADER_TEXT = "EPAM FRAMEWORK WISHES…";

    private final String MAIN_TEXT = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT "
            + "UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS "
            + "NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE "
            + "CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";

    private final String SUB_HEADER_TEXT = "JDI GITHUB";

    private final List<String> IMAGES_TEXTS = Arrays.asList(
            "To include good practices\nand ideas from successful\nEPAM project",
            "To be flexible and\ncustomizable",
            "To be multiplatform",
            "Already have good base\n(about 20 internal and\n" + "some external projects),\nwish to get more…");


    @FindBy(css = ".profile-photo")
    private WebElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private WebElement login;

    @FindBy(css = "[id = 'Password']")
    private WebElement password;

    @FindBy(css = "[type = 'submit']")
    private WebElement submit;

    @FindBy(css = ".profile-photo > span")
    private WebElement userName;

    @FindBy(css = ".uui-navigation.nav > li")
    private List<WebElement> headerItems;

    @FindBy(css = ".benefit-icon")
    private List<WebElement> images;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> imagesTexts;

    @FindBy(css = "h3.main-title")
    private WebElement mainHeader;

    @FindBy(css = ".main-txt")
    private WebElement mainText;

    @FindBy(css = "[id='iframe']")
    private WebElement iframe;

    @FindBy(css = ".epam-logo img")
    private WebElement epamLogo;

    @FindBy(css = ".text-center > a")
    private WebElement subHeader;

    @FindBy(css = "[name='navigation-sidebar']")
    private WebElement leftSection;

    @FindBy(css = "footer")
    private WebElement footer;


    //================================methods===================================

    public void open(WebDriver driver) {
        driver.navigate().to(Pages.INDEX.url);
    }

    public void login(String name, String passwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();
    }

    public void clickOnIframe() {
        iframe.click();
    }

    public void switchToOriginalWindow(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    //================================checks===================================

    public void checkTitle(WebDriver driver) {
        assertEquals(driver.getTitle(), Pages.INDEX.title);
    }

    public void checkUserName(String user) {
        assertEquals(userName.getText(), user);
    }

    public void checkHeaderItems() {
        assertEquals(headerItems.size(), HEADER_ITEMS.size());
        for (WebElement item : headerItems) {
            assertTrue(HEADER_ITEMS.contains(item.getText()));
            assertTrue(item.isDisplayed());
        }
    }

    public void checkImages() {
        assertEquals(images.size(), 4);
        for (WebElement image : images) {
            assertTrue(image.isDisplayed());
        }
    }

    public void checkImagesTexts() {
        assertEquals(imagesTexts.size(), IMAGES_TEXTS.size());
        for (WebElement text : imagesTexts) {
            assertTrue(IMAGES_TEXTS.contains(text.getText()));
            assertTrue(text.isDisplayed());
        }
    }

    public void checkMainText() {
        assertEquals(mainHeader.getText(), MAIN_HEADER_TEXT);
        assertEquals(mainText.getText(), MAIN_TEXT);
    }

    public void checkIframe() {
        assertTrue(iframe.isDisplayed());
    }

    public void checkEpamLogo() {
        assertTrue(epamLogo.isDisplayed());
    }

    public void checkSubHeaderText() {
        assertEquals(subHeader.getText(), SUB_HEADER_TEXT);
    }

    public void checkSubHeaderLink() {
        assertEquals(subHeader.getAttribute("href"), Pages.JDI_GITHUB.url);
    }

    public void checkLeftSection() {
        assertTrue(leftSection.isDisplayed());
    }

    public void checkFooter() {
        assertTrue(footer.isDisplayed());
    }
}