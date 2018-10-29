package hw4;

import base.SelenideTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageSelenide;
import pageObjects.ServiceDifferentElementsPage;

import static com.codeborne.selenide.Selenide.page;
import static enums.Checkboxes.WATER;
import static enums.Checkboxes.WIND;
import static enums.DropdownItems.YELLOW;
import static enums.Radios.SELEN;
import static enums.ServiceItems.DIFFERENT_ELEMENTS;
import static enums.Users.PITER_CHAILOVSKII;

public class ServicePageInterfaceTest extends SelenideTestBase {

    private HomePageSelenide homePageSelenide;
    private ServiceDifferentElementsPage serviceDifferentElementsPage;

    @BeforeClass
    public void beforeClass() {
        homePageSelenide = page(HomePageSelenide.class);
        serviceDifferentElementsPage = page(ServiceDifferentElementsPage.class);
    }

    @Test
    public void servicePageInterfaceCheck() {

        //1 Open test site by URL
        homePageSelenide.openPage();

        //2 Assert Browser title
        homePageSelenide.checkTitle();

        //3 Perform login
        homePageSelenide.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4 Assert User name in the left-top side of screen that user is loggined
        homePageSelenide.checkUserName(PITER_CHAILOVSKII.name);

        //5 Click on "Service" subcategory in the header and check that drop down contains options
        homePageSelenide.clickHeaderServiceItem();
        homePageSelenide.checkHeaderServiceItems();

        //6 Click on Service subcategory in the left section and check that drop down contains options
        homePageSelenide.clickLeftSectionServiceItem();
        homePageSelenide.checkLeftSectionServiceItems();

        //7 Open through the header menu Service -> Different Elements Page
        homePageSelenide.clickHeaderServiceItem(DIFFERENT_ELEMENTS);
        serviceDifferentElementsPage.checkTitle();

        //8 Check interface on Different elements page, it contains all needed elements
        serviceDifferentElementsPage.checkInterface();

        //9 Assert that there is Right Section
        serviceDifferentElementsPage.checkRightSection();

        //10 Assert that there is Left Section
        serviceDifferentElementsPage.checkLeftSection();

        //11 Select checkboxes
        serviceDifferentElementsPage.clickCheckbox(WATER);
        serviceDifferentElementsPage.clickCheckbox(WIND);

        //12 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        serviceDifferentElementsPage.checkLogAboutCheckboxes(WIND, WATER, true);

        //13 Select radio
        serviceDifferentElementsPage.clickRadio(SELEN);

        //14 Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        serviceDifferentElementsPage.checkLogAboutRadio(SELEN);

        //15 Select in dropdown
        serviceDifferentElementsPage.clickDropdownItem(YELLOW);

        //16 Assert that for dropdown there is a log row and value is corresponded to the selected value. 
        serviceDifferentElementsPage.checkLogAboutDropdownItem(YELLOW);

        //17 Unselect and assert checkboxes
        serviceDifferentElementsPage.clickCheckbox(WATER);
        serviceDifferentElementsPage.clickCheckbox(WIND);

        //18 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        serviceDifferentElementsPage.checkLogAboutCheckboxes(WIND, WATER, false);

    }
}
