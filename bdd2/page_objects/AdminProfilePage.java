package bdd2.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class AdminProfilePage extends WebReusableComponents {

    protected By releaseLabel = By.id("releaseLabel");
    protected By lastDeployedDateLabel = By.id("lastDeployedDateLabel");
    protected By loginButton = By.id("loginButton");
    protected By homeMenu = By.id("home");
    protected By userProfileLink = By.id("userProfile");
    protected By userNameDisplay = By.id("userName");

    public AdminProfilePage() {
        PageFactory.initElements(driver, this);
    }

    public void loginAsAdmin() {
        waitUntilElementVisible(loginButton, 3);
        driver.findElement(loginButton).click();
        Assert.assertTrue(isElementDisplayed(homeMenu), "Login failed, home menu is not displayed");
    }

    public void loginAsUser() {
        waitUntilElementVisible(loginButton, 3);
        driver.findElement(loginButton).click();
        Assert.assertTrue(isElementDisplayed(homeMenu), "Login failed, home menu is not displayed");
    }

    public void navigateToUserProfile() {
        waitUntilElementVisible(userProfileLink, 3);
        driver.findElement(userProfileLink).click();
        Assert.assertTrue(isElementDisplayed(userNameDisplay), "Navigation to user profile failed");
    }

    public void verifyLabelDisplayedWithValue(String label) {
        By labelLocator;
        switch (label) {
            case "Release":
                labelLocator = releaseLabel;
                break;
            case "Last Deployed Date":
                labelLocator = lastDeployedDateLabel;
                break;
            default:
                throw new IllegalArgumentException("Unknown label: " + label);
        }
        waitUntilElementVisible(labelLocator, 3);
        Assert.assertTrue(isElementDisplayed(labelLocator), label + " label is not displayed");
    }
}