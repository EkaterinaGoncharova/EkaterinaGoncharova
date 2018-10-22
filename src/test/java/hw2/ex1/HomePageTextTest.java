package hw2.ex1;

import base.TestBase;
import dataProviders.DataProviders;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageTextTest extends TestBase {

    @Test(dataProvider = "homePageTextDataProvider", dataProviderClass = DataProviders.class)
    public void homePageTextTest(String selector, String text) {

        //1 Open BR
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //3 Assert that there are 4 texts on the Index Page under icons and they have proper text
        WebElement element = driver.findElement(By.xpath(selector));
        assertEquals(element.getText(), text);
        assertTrue(element.isDisplayed());

        //4 Close BR
        driver.close();
    }
}
