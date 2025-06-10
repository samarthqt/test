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
    protected By userProfileLink = By.id("userProfile");

    public AdminProfilePage() {
        PageFactory.initElements(driver, this);
    }

    public void loginAsAdmin() {
        WebElement loginBtn = driver.findElement(loginButton);
        waitUntilElementVisible(loginBtn, 3);
        loginBtn.click();
        Assert.assertTrue(isElementDisplayed(releaseLabel), "Login failed, release label is not displayed");
    }

    public void navigateToUserProfile() {
        WebElement userProfile = driver.findElement(userProfileLink);
        waitUntilElementVisible(userProfile, 3);
        userProfile.click();
        Assert.assertTrue(isElementDisplayed(releaseLabel), "Navigation to user profile failed");
    }

    public void verifyReleaseAndLastDeployedDateLabels() {
        Assert.assertTrue(isElementDisplayed(releaseLabel), "Release label is not displayed");
        Assert.assertTrue(isElementDisplayed(lastDeployedDateLabel), "Last Deployed Date label is not displayed");
    }

    private boolean isElementDisplayed(By locator) {
        WebElement element = driver.findElement(locator);
        return element.isDisplayed();
    }

    private void waitUntilElementVisible(WebElement element, int timeoutInSeconds) {
        // Implement explicit wait logic here
    }
}