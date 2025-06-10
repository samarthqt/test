package bdd1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class LoginPage extends WebReusableComponents {

    protected By txtUserName = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By btnSSOLogin = By.id("ssoLoginButton");

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Enters the username into the username field.
     * @param username The username to be entered.
     */
    public void enterUserName(String username) {
        waitUntilElementVisible(txtUserName, 3);
        enterText(txtUserName, username);
    }

    /**
     * Enters the password into the password field.
     * @param password The password to be entered.
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
     * Verifies the visibility of the SSO login button.
     */
    public void verifySSOButtonVisibility() {
        waitUntilElementVisible(btnSSOLogin, 3);
        boolean isDisplayed = isElementDisplayed(btnSSOLogin);
        Assert.assertTrue(isDisplayed, "SSO Login button is not displayed on the login screen.");
    }
}