package hw4;

import base.SelenideTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageSelenide;
import pageObjects.ServiceDatesPage;

import static com.codeborne.selenide.Selenide.page;
import static enums.ServiceItems.DATES;
import static enums.Sliders.FROM;
import static enums.Sliders.TO;
import static enums.Users.PITER_CHAILOVSKII;

public class DatesPageSlidersTest extends SelenideTestBase {

    private HomePageSelenide homePageSelenide;
    private ServiceDatesPage serviceDatesPage;

    @BeforeClass
    public void beforeClass() {
        homePageSelenide = page(HomePageSelenide.class);
        serviceDatesPage = page(ServiceDatesPage.class);
    }

    @Test
    public void dataPageSlidersCheck() {

        //1	Open test site by URL
        homePageSelenide.openPage();

        //2	Assert Browser title
        homePageSelenide.checkTitle();

        //3	Perform login
        homePageSelenide.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4	Assert User name in the left-top side of screen that user is loggined
        homePageSelenide.checkUserName(PITER_CHAILOVSKII.name);

        //5	Open through the header menu Service -> Dates Page
        homePageSelenide.clickHeaderServiceItem(DATES);
        serviceDatesPage.checkTitle();

        //6	Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
        serviceDatesPage.moveLeftSliderTo(0);
        serviceDatesPage.moveRightSliderTo(100);

        //7	Assert that for "From" and "To" sliders there are logs rows with corresponding values
        serviceDatesPage.checkLogAboutSliders(TO, 100, FROM, 0);

        //8	Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
        serviceDatesPage.moveLeftSliderTo(0);
        serviceDatesPage.moveRightSliderTo(0);

        //9	Assert that for "From" and "To" sliders there are logs rows with corresponding values
        serviceDatesPage.checkLogAboutSliders(TO, 0, FROM, 0);

        //10 Using drag-and-drop set Range sliders. left sliders - the most right position, right slider - the most right position.
        serviceDatesPage.moveRightSliderTo(100);
        serviceDatesPage.moveLeftSliderTo(100);

        //11 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        serviceDatesPage.checkLogAboutSliders(FROM, 100, TO, 100);

        //12 Using drag-and-drop set Range sliders.
        serviceDatesPage.moveLeftSliderTo(30);
        serviceDatesPage.moveRightSliderTo(70);

        //13 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        serviceDatesPage.checkLogAboutSliders(TO, 70, FROM, 30);

    }
}
