package hw4;

import base.SelenideTestBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listeners.AllureAttachmentListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.DatesPage;
import pageObjects.HomePage;
import pageObjects.base.Header;

import static com.codeborne.selenide.Selenide.page;
import static enums.ServiceItems.DATES;
import static enums.Users.PITER_CHAILOVSKII;

@Feature("Service tests")
@Story("Dates Page Testing")
@Listeners(AllureAttachmentListener.class)
public class DatesPageSlidersTest extends SelenideTestBase {

    private HomePage homePage;
    private Header header;
    private DatesPage datesPage;

    @BeforeClass
    public void beforeClass() {
        homePage = page(HomePage.class);
        header = page(Header.class);
        datesPage = page(DatesPage.class);
    }

    @Test
    public void dataPageSlidersCheck() {

        //1 Open test site by URL
        homePage.openPage();

        //2 Assert Browser title
        homePage.checkTitle();

        //3 Perform login
        header.login(PITER_CHAILOVSKII);

        //4 Assert User name in the left-top side of screen that user is logged
        header.checkUserName(PITER_CHAILOVSKII);

        //5 Open through the header menu Service -> Dates Page
        header.selectServiceItem(DATES);
        datesPage.checkTitle();

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
        datesPage.moveSlidersTo(0, 100);

        //7 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkSlidersLog(0, 100);

        //8 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
        datesPage.moveSlidersTo(0, 0);

        //9 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkSlidersLog(0, 0);

        //10 Using drag-and-drop set Range sliders. left sliders - the most right position, right slider - the most right position.
        datesPage.moveSlidersTo(100, 100);

        //11 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkSlidersLog(100, 100);

        //12 Using drag-and-drop set Range sliders.
        datesPage.moveSlidersTo(30, 70);

        //13 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkSlidersLog(30, 70);
    }
}
