package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.Pages.DATES;
import static org.testng.Assert.assertEquals;

public class DatesPage {

    private final String fromSliderLogBegin = "Range 2(From):";
    private final String toSliderLogBegin = "Range 2(To):";
    private final String slidersLogEnd = " link clicked";

    @FindBy(css = ".ui-slider")
    private SelenideElement slider;

    @FindBy(css = ".ui-slider-handle")
    private ElementsCollection sliders;

    @FindBy(css = ".panel-body-list > li")
    private ElementsCollection logSection;


    //================================methods===================================

    @Step
    public void moveSlidersTo(int fromPosition, int toPosition) {
        SelenideElement toSlider = sliders.get(1);
        int toSliderCurrentPosition = Integer.valueOf(toSlider.getText());
        if (fromPosition > toSliderCurrentPosition) {
            moveToSlider(toPosition);
            moveFromSlider(fromPosition);
        } else {
            moveFromSlider(fromPosition);
            moveToSlider(toPosition);
        }
    }

    private void moveFromSlider(int position) {
        int sliderWidth = slider.getSize().getWidth();
        SelenideElement fromSlider = sliders.get(0);
        Actions action = new Actions(getWebDriver());
        int xOffset = position - Integer.valueOf(fromSlider.getText());
        if (xOffset <= 0) {
            xOffset--;
        }
        action.dragAndDropBy(fromSlider, xOffset * sliderWidth / 100, 0).perform();
    }

    private void moveToSlider(int position) {
        int sliderWidth = slider.getSize().getWidth();
        SelenideElement toSlider = sliders.get(1);
        Actions action = new Actions(getWebDriver());
        int xOffset = position - Integer.valueOf(toSlider.getText());
        if (xOffset <= 0) {
            xOffset--;
        }
        action.dragAndDropBy(toSlider, xOffset * sliderWidth / 100, 0).perform();
    }

    //================================checks===================================

    @Step
    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), DATES.title);
    }

    @Step
    public void checkSlidersLog(int fromSlider, int toSlider) {
        logSection.findBy(text(fromSliderLogBegin + (String.valueOf(fromSlider)) + slidersLogEnd)).shouldBe(visible);
        logSection.findBy(text(toSliderLogBegin + (String.valueOf(toSlider)) + slidersLogEnd)).shouldBe(visible);
    }
}