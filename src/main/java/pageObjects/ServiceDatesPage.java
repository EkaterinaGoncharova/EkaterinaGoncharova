package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.Pages;
import enums.Sliders;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class ServiceDatesPage {

    private final String sliderLogBegin = "Range 2(";
    private final String sliderLogMiddle = "):";
    private final String sliderLogEnd = " link clicked";

    @FindBy(css = ".ui-slider")
    private SelenideElement slider;

    @FindBy(css = ".ui-slider-handle")
    private ElementsCollection sliders;

    @FindBy(css = ".panel-body-list > li")
    private ElementsCollection logPanel;


    //================================methods===================================

    public void moveLeftSliderTo(int position) {
        int width = slider.getSize().getWidth();
        SelenideElement leftSlider = sliders.get(0);
        Actions action = new Actions(getWebDriver());
        int leftX = position - Integer.valueOf(leftSlider.getText()) - 1;
        action.dragAndDropBy(leftSlider, leftX * width / 100, 0).perform();
    }

    public void moveRightSliderTo(int position) {
        int width = slider.getSize().getWidth();
        SelenideElement rightSlider = sliders.get(1);
        Actions action = new Actions(getWebDriver());
        int leftX = position - Integer.valueOf(rightSlider.getText()) - 1;
        action.dragAndDropBy(rightSlider, leftX * width / 100, 0).perform();
    }

    //================================checks===================================

    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), Pages.SERVICE_DATES.title);
    }

    public void checkLogAboutSliders(Sliders slider1, int position1, Sliders slider2, int position2) {
        String logText = sliderLogBegin + slider1.displayName + sliderLogMiddle + String.valueOf(position1) + sliderLogEnd;
        logPanel.get(0).shouldHave(text(logText));
        logText = sliderLogBegin + slider2.displayName + sliderLogMiddle + String.valueOf(position2) + sliderLogEnd;
        logPanel.get(1).shouldHave(text(logText));
    }
}
