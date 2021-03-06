package lesson3;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePageSelenium;

import java.util.concurrent.TimeUnit;

import static enums.Users.PITER_CHAILOVSKII;


public class SimpleTestPageObject extends TestBase {

    private WebDriver driver;
    private HomePageSelenium homePage;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        homePage = PageFactory.initElements(driver, HomePageSelenium.class);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driver.close();
    }

    @Test
    public void simpleTest() {
        //2 Navigate
        homePage.open(driver);

        //3 Assert Title
        homePage.checkTitle(driver);

        //4 Login
        homePage.login(PITER_CHAILOVSKII.name, PITER_CHAILOVSKII.password);

        //5
        homePage.checkMainText();
    }
}