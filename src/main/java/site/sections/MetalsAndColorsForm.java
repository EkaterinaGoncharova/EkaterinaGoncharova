package site.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import entities.MetalsAndColorsData;
import org.openqa.selenium.support.FindBy;

import static enums.Vegetables.VEGETABLES;

public class MetalsAndColorsForm extends Form<MetalsAndColorsData> {

    @FindBy(css = "#odds-selector p")
    private RadioButtons odds;

    @FindBy(css = "#even-selector p")
    private RadioButtons evens;

    @FindBy(id = "calculate-button")
    private Button calculateButton;

    @FindBy(css = "#elements-checklist p")
    private CheckList elements;

    @JDropdown(
            root = @FindBy(id = "colors"),
            list = @FindBy(tagName = "li"),
            value = @FindBy(tagName = "button")
    )
    private Dropdown colors;

    @JDropdown(
            root = @FindBy(id = "metals"),
            list = @FindBy(tagName = "li"),
            value = @FindBy(css = ".filter-option"),
            expand = @FindBy(css = ".caret")
    )
    private Dropdown metals;

    @JDropdown(
            root = @FindBy(id = "salad-dropdown"),
            list = @FindBy(tagName = "li"),
            value = @FindBy(tagName = "button")
    )
    private Dropdown vegetables;

    @FindBy(id = "submit-button")
    private Button submitButton;

    public void submit(MetalsAndColorsData data) {
        odds.select(data.summary[0].toString());
        evens.select(data.summary[1].toString());
        calculateButton.click();
        elements.select(data.elements);
        colors.select(data.color);
        metals.select(data.metals);
        vegetables.select(VEGETABLES.value);
        for (String vegetable : data.vegetables) {
            vegetables.select(vegetable);
        }
        submitButton.click();
    }
}
