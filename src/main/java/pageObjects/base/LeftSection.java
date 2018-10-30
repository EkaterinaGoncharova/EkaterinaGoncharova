package pageObjects.base;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.ServiceItems;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.visible;

public class LeftSection {

    @FindBy(css = "[name='navigation-sidebar']")
    private SelenideElement leftSection;

    @FindBy(css = ".menu-title[index='3']")
    private SelenideElement service;

    @FindBy(css = ".menu-title[index='3'] > .sub li")
    private ElementsCollection serviceItems;

    //================================methods===================================

    public void clickService() {
        service.click();
    }

    //================================checks===================================

    public void checkLeftSection() {
        leftSection.shouldBe(visible);
    }

    public void checkServiceItems() {
        List<String> itemTexts = ServiceItems.toList();
        serviceItems.shouldHaveSize(itemTexts.size());
        serviceItems.shouldHave(exactTexts(itemTexts));
    }
}
