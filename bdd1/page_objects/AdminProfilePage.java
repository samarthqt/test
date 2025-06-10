package bdd1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class AdminProfilePage extends WebReusableComponents {

    protected By userProfileMenu = By.id("userProfileMenu");
    protected By menuItems = By.className("menuItem");
    protected By adminLoginButton = By.id("adminLoginButton");
    protected By adminUsernameField = By.id("adminUsername");
    protected By adminPasswordField = By.id("adminPassword");

    public AdminProfilePage() {
        PageFactory.initElements(driver, this);
    }

    public void loginAsAdmin() {
        waitUntilElementVisible(adminUsernameField, 3);
        enterText(adminUsernameField, "adminUser");
        enterText(adminPasswordField, "adminPass");
        waitUntilElementVisible(adminLoginButton, 3);
        clickElement(adminLoginButton);
        Assert.assertTrue(isElementVisible(userProfileMenu), "Admin login failed.");
    }

    public void navigateToUserProfile() {
        waitUntilElementVisible(userProfileMenu, 3);
        clickElement(userProfileMenu);
        Assert.assertTrue(isElementVisible(menuItems), "Navigation to user profile failed.");
    }

    public void verifyAdminMenusDisplayed(List<String> expectedMenus) {
        List<String> actualMenus = getElementsText(menuItems);
        Assert.assertTrue(actualMenus.containsAll(expectedMenus), "Not all expected menus are displayed.");
    }

    public List<String> getElementsText(By locator) {
        List<String> texts = new ArrayList<>();
        List<WebElement> elements = getElements(locator);
        for (WebElement element : elements) {
            texts.add(element.getText());
        }
        return texts;
    }

    private boolean isElementVisible(By locator) {
        try {
            waitUntilElementVisible(locator, 3);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}