package bdd1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import java.util.*;

public class LoginPage extends WebReusableComponents {

    private By txtUserName = By.id("username");
    private By txtPassword = By.id("password");
    private By btnLogin = By.id("loginButton");
    private By errorMessage = By.id("errorMessage");
    private By btnSSOLogin = By.id("ssoLoginButton");

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Enters the username into the username field.
     * @param username The username to enter.
     */
    public void enterUserName(String username) {
        waitUntilElementVisible(txtUserName, 3);
        enterText(txtUserName, username);
    }

    /**
     * Enters the password into the password field.
     * @param password The password to enter.
     */
    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    /**
     * Clicks the login button.
     */
    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    /**
     * Verifies that the user is redirected to the homepage.
     * @param expectedURL The expected URL of the homepage.
     */
    public void verifyHomePageRedirection(String expectedURL) {
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "User is not redirected to the homepage.");
    }

    /**
     * Retrieves the error message displayed on the page.
     * @return The error message text.
     */
    public String getErrorMessage() {
        waitUntilElementVisible(errorMessage, 3);
        return getTextFromElement(errorMessage);
    }

    /**
     * Checks if the SSO login button is visible.
     * @return True if the SSO login button is visible, false otherwise.
     */
    public boolean isSSOButtonVisible() {
        return isElementVisible(btnSSOLogin);
    }

    /**
     * Checks if the specified element is visible.
     * @param locator The locator of the element to check.
     * @return True if the element is visible, false otherwise.
     */
    public boolean isElementVisible(By locator) {
        try {
            waitUntilElementVisible(locator, 3);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}