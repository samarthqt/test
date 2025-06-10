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
    protected By releaseLabel = By.id("releaseLabel");
    protected By lastDeployedDateLabel = By.id("lastDeployedDateLabel");

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

    public void verifyReleaseLabelDisplayed() {
        waitUntilElementVisible(releaseLabel, 3);
        Assert.assertTrue(isElementVisible(releaseLabel), "Release label is not displayed.");
    }

    public void verifyLastDeployedDateLabelDisplayed() {
        waitUntilElementVisible(lastDeployedDateLabel, 3);
        Assert.assertTrue(isElementVisible(lastDeployedDateLabel), "Last Deployed Date label is not displayed.");
    }

    public boolean isElementVisible(By locator) {
        try {
            waitUntilElementVisible(locator, 3);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}