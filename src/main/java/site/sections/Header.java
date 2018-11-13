package site.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.web.matcher.junit.Assert;
import enums.MenuItems;
import enums.Users;
import org.openqa.selenium.support.FindBy;

public class Header extends Section {

    public LoginForm loginForm;

    @FindBy(css = ".profile-photo")
    public Button profilePhoto;

    @FindBy(css = ".uui-navigation.m-l8")
    public Menu<MenuItems> navigation;

    public void checkUserName(Users user) {
        Assert.areEquals(profilePhoto.getText(), user.displayName);
    }

    public void selectMenuItem(MenuItems item) {
        // TODO Take a look on IDEA warning
        navigation.select(item);
    }


}
