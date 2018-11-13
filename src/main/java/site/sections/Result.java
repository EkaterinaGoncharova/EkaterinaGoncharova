package site.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import entities.MetalsAndColorsData;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;


public class Result extends Section {

    @FindBy(css = ".results > li")
    public TextList results;

    public void checkMetalsAndColorsFormResult(MetalsAndColorsData data) {
        assertEquals(results.getTextList(), data.getTextList());
    }
}
