package hw_jdi;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import site.JDISite;

import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static site.JDISite.metalAndColorsPage;

public class TestsInit extends TestNGBase {
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        WebSite.init(JDISite.class);
        logger.info("Run Tests");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        metalAndColorsPage.clearCache();
    }
}
