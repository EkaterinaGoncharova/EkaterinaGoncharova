package hw_jdi;

import dataProviders.DataProviders;
import entities.MetalsAndColorsData;
import org.testng.annotations.Test;

import static enums.MenuItems.METALS_AND_COLORS;
import static enums.Users.PITER_CHAILOVSKII;
import static site.JDISite.*;

public class MetalsAndColorsFormTest extends TestsInit {

    @Test(dataProvider = "metalsAndColorsDataProvider", dataProviderClass = DataProviders.class)
    public void metalsAndColorsFormTest(MetalsAndColorsData data) {

        //1 Login on JDI site as User
        homePage.open();
        // TODO This method should be parametrised.
        login(PITER_CHAILOVSKII);
        homePage.checkOpened();
        header.checkUserName(PITER_CHAILOVSKII);

        //2 Open Metals & Colors page by Header menu
        header.selectMenuItem(METALS_AND_COLORS);
        metalAndColorsPage.checkOpened();

        //3 Fill form Metals & Colors by data below:
        // Submit form Metals & Colors
        metalAndColorsPage.metalsAndColorsForm.submit(data);

        //4 Result sections should contains data below:
        result.checkMetalsAndColorsFormResult(data);

    }
}
