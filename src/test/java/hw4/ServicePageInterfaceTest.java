package hw4;

import base.SelenideTestBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listeners.AllureAttachmentListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.DifferentElementsPage;
import pageObjects.HomePage;
import pageObjects.base.Header;
import pageObjects.base.LeftSection;

import static com.codeborne.selenide.Selenide.page;
import static enums.Checkboxes.WATER;
import static enums.Checkboxes.WIND;
import static enums.DropdownItems.YELLOW;
import static enums.Radios.SELEN;
import static enums.ServiceItems.DIFFERENT_ELEMENTS;
import static enums.Users.PITER_CHAILOVSKII;

@Feature("Service tests")
@Story("Different Elements Page Testing")
@Listeners(AllureAttachmentListener.class)
public class ServicePageInterfaceTest extends SelenideTestBase {

    private HomePage homePage;
    private Header header;
    private LeftSection leftSection;
    private DifferentElementsPage differentElementsPage;

    @BeforeClass
    public void beforeClass() {
        homePage = page(HomePage.class);
        header = page(Header.class);
        leftSection = page(LeftSection.class);
        differentElementsPage = page(DifferentElementsPage.class);
    }

    @Test
    public void servicePageInterfaceCheck() {

        //1 Open test site by URL
        homePage.openPage();

        //2 Assert Browser title
        homePage.checkTitle();

        //3 Perform login
        header.login(PITER_CHAILOVSKII);

        //4 Assert User name in the left-top side of screen that user is logged
        header.checkUserName(PITER_CHAILOVSKII);

        //5 Click on "Service" subcategory in the header and check that drop down contains options
        header.clickService();
        header.checkServiceItems();

        //6 Click on Service subcategory in the left section and check that drop down contains options
        leftSection.clickService();
        leftSection.checkServiceItems();

        //7 Open through the header menu Service -> Different Elements Page
        header.selectServiceItem(DIFFERENT_ELEMENTS);
        differentElementsPage.checkTitle();

        //8 Check interface on Different elements page, it contains all needed elements
        differentElementsPage.checkInterface();

        //9 Assert that there is Right Section
        differentElementsPage.checkRightSection();

        //10 Assert that there is Left Section
        leftSection.checkLeftSection();

        //11 Select checkboxes
        differentElementsPage.clickCheckboxes(WATER, WIND);

        //12 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        differentElementsPage.checkCheckboxesLog(WIND, WATER, true);

        //13 Select radio
        differentElementsPage.clickRadio(SELEN);

        //14 Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        differentElementsPage.checkRadioLog(SELEN);

        //15 Select in dropdown
        differentElementsPage.clickDropdownItem(YELLOW);

        //16 Assert that for dropdown there is a log row and value is corresponded to the selected value. 
        differentElementsPage.checkDropdownLog(YELLOW);

        //17 Unselect and assert checkboxes
        differentElementsPage.clickCheckboxes(WATER, WIND);

        //18 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementsPage.checkCheckboxesLog(WIND, WATER, false);
    }
}
