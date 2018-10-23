package hw2.ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageContentTests3 {

    private List<String> headers = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");

    private List<String> texts = Arrays.asList(
            "To include good practices\n" + "and ideas from successful\n" + "EPAM project",
            "To be flexible and\n" + "customizable",
            "To be multiplatform",
            "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n"
                    + "wish to get more…");

    private String text = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT "
            + "UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS "
            + "NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE "
            + "CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";

    @Test(groups = "Regression")
    public void homePageContentTest1() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        driver.findElement(By.cssSelector(".profile-photo")).click();
        driver.findElement(By.cssSelector("[id = 'Name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id = 'Password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[type = 'submit']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        assertEquals(driver.findElement(By.cssSelector(".profile-photo > span")).getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> items = driver.findElements(By.cssSelector(".uui-navigation.nav > li"));
        assertEquals(items.size(), headers.size());
        for (WebElement item : items) {
            assertTrue(headers.contains(item.getText()));
            assertTrue(item.isDisplayed());
        }

        //7 Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> icons = driver.findElements(By.cssSelector(".benefit-icon"));
        assertEquals(icons.size(), 4);
        for (WebElement icon : icons) {
            assertTrue(icon.isDisplayed());
        }

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> elements = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(elements.size(), texts.size());
        for (WebElement element : elements) {
            assertTrue(texts.contains(element.getText()));
            assertTrue(element.isDisplayed());
        }

        //9 Assert a text of the main header
        assertEquals(driver.findElement(By.cssSelector("h3.main-title")).getText(), "EPAM FRAMEWORK WISHES…");
        assertEquals(driver.findElement(By.cssSelector(".main-txt")).getText(), text);

        //10 Assert that there is the iframe in the center of page
        WebElement iframe = driver.findElement(By.cssSelector("[id='iframe']"));
        assertTrue(iframe.isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        iframe.click();
        assertTrue(driver.findElement(By.cssSelector(".epam-logo img")).isDisplayed());

        //12 Switch to original window back
        driver.switchTo().defaultContent();

        //13 Assert a text of the sub header
        WebElement href = driver.findElement(By.cssSelector(".text-center > a"));
        assertEquals(href.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(href.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        assertTrue(driver.findElement(By.cssSelector("[name='navigation-sidebar']")).isDisplayed());

        //16 Assert that there is Footer
        assertTrue(driver.findElement(By.cssSelector("footer")).isDisplayed());

        //17 Close Browser
        driver.close();
    }

    @Test(groups = "Regression")
    public void homePageContentTest2() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        driver.findElement(By.cssSelector(".profile-photo")).click();
        driver.findElement(By.cssSelector("[id = 'Name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id = 'Password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[type = 'submit']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        assertEquals(driver.findElement(By.cssSelector(".profile-photo > span")).getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> items = driver.findElements(By.cssSelector(".uui-navigation.nav > li"));
        assertEquals(items.size(), headers.size());
        for (WebElement item : items) {
            assertTrue(headers.contains(item.getText()));
            assertTrue(item.isDisplayed());
        }

        //7 Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> icons = driver.findElements(By.cssSelector(".benefit-icon"));
        assertEquals(icons.size(), 4);
        for (WebElement icon : icons) {
            assertTrue(icon.isDisplayed());
        }

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> elements = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(elements.size(), texts.size());
        for (WebElement element : elements) {
            assertTrue(texts.contains(element.getText()));
            assertTrue(element.isDisplayed());
        }

        //9 Assert a text of the main header
        assertEquals(driver.findElement(By.cssSelector("h3.main-title")).getText(), "EPAM FRAMEWORK WISHES…");
        assertEquals(driver.findElement(By.cssSelector(".main-txt")).getText(), text);

        //10 Assert that there is the iframe in the center of page
        WebElement iframe = driver.findElement(By.cssSelector("[id='iframe']"));
        assertTrue(iframe.isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        iframe.click();
        assertTrue(driver.findElement(By.cssSelector(".epam-logo img")).isDisplayed());

        //12 Switch to original window back
        driver.switchTo().defaultContent();

        //13 Assert a text of the sub header
        WebElement href = driver.findElement(By.cssSelector(".text-center > a"));
        assertEquals(href.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(href.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        assertTrue(driver.findElement(By.cssSelector("[name='navigation-sidebar']")).isDisplayed());

        //16 Assert that there is Footer
        assertTrue(driver.findElement(By.cssSelector("footer")).isDisplayed());

        //17 Close Browser
        driver.close();
    }

    @Test(groups = "Smoke")
    public void homePageContentTest3() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        driver.findElement(By.cssSelector(".profile-photo")).click();
        driver.findElement(By.cssSelector("[id = 'Name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id = 'Password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[type = 'submit']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        assertEquals(driver.findElement(By.cssSelector(".profile-photo > span")).getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> items = driver.findElements(By.cssSelector(".uui-navigation.nav > li"));
        assertEquals(items.size(), headers.size());
        for (WebElement item : items) {
            assertTrue(headers.contains(item.getText()));
            assertTrue(item.isDisplayed());
        }

        //7 Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> icons = driver.findElements(By.cssSelector(".benefit-icon"));
        assertEquals(icons.size(), 4);
        for (WebElement icon : icons) {
            assertTrue(icon.isDisplayed());
        }

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> elements = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(elements.size(), texts.size());
        for (WebElement element : elements) {
            assertTrue(texts.contains(element.getText()));
            assertTrue(element.isDisplayed());
        }

        //9 Assert a text of the main header
        assertEquals(driver.findElement(By.cssSelector("h3.main-title")).getText(), "EPAM FRAMEWORK WISHES…");
        assertEquals(driver.findElement(By.cssSelector(".main-txt")).getText(), text);

        //10 Assert that there is the iframe in the center of page
        WebElement iframe = driver.findElement(By.cssSelector("[id='iframe']"));
        assertTrue(iframe.isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        iframe.click();
        assertTrue(driver.findElement(By.cssSelector(".epam-logo img")).isDisplayed());

        //12 Switch to original window back
        driver.switchTo().defaultContent();

        //13 Assert a text of the sub header
        WebElement href = driver.findElement(By.cssSelector(".text-center > a"));
        assertEquals(href.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(href.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        assertTrue(driver.findElement(By.cssSelector("[name='navigation-sidebar']")).isDisplayed());

        //16 Assert that there is Footer
        assertTrue(driver.findElement(By.cssSelector("footer")).isDisplayed());

        //17 Close Browser
        driver.close();
    }
}
