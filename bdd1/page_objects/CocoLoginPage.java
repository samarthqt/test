package bdd1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class CocoLoginPage extends WebReusableComponents {

    protected By btnLoginWithSSO = By.id("loginWithSSOButton");
    protected By ssoUsername = By.id("ssoUsername");
    protected By ssoPassword = By.id("ssoPassword");
    protected By submitSSOLogin = By.id("submitSSOLogin");
    protected By ssoErrorMessage = By.id("ssoErrorMessage");
    protected By cancelSSOLogin = By.id("cancelSSOLogin");

    public CocoLoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToCocoLoginScreen() {
        launchUrl("https://coco-login.com");
        maximizeWindow();
    }

    public void verifyLoginWithSSOButtonVisible() {
        waitUntilElementVisible(btnLoginWithSSO, 3);
        Assert.assertTrue(isElementVisible(btnLoginWithSSO), "Login with SSO button is not visible.");
    }

    public void clickLoginWithSSOButton() {
        waitUntilElementVisible(btnLoginWithSSO, 3);
        clickElement(btnLoginWithSSO);
    }

    public void verifyRedirectionToSSOLoginPage() {
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, "https://sso-login.com", "Redirection to SSO login page failed.");
    }

    public void navigateToSSOLoginPage() {
        launchUrl("https://sso-login.com");
        maximizeWindow();
    }

    public void enterSSOCredentials(String username, String password) {
        waitUntilElementVisible(ssoUsername, 3);
        enterText(ssoUsername, username);
        enterText(ssoPassword, password);
    }

    public void submitSSOLoginForm() {
        waitUntilElementVisible(submitSSOLogin, 3);
        clickElement(submitSSOLogin);
    }

    public void verifySuccessfulLoginToCocoApplication() {
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, "https://coco-application.com/home", "Login to COCO application failed.");
    }

    public void verifyInvalidCredentialsErrorMessage() {
        waitUntilElementVisible(ssoErrorMessage, 3);
        String errorMessage = getTextFromElement(ssoErrorMessage);
        Assert.assertEquals(errorMessage, "Invalid credentials.", "Error message for invalid credentials is incorrect.");
    }

    public void cancelSSOLoginProcess() {
        waitUntilElementVisible(cancelSSOLogin, 3);
        clickElement(cancelSSOLogin);
    }

    public void verifyRedirectionToCocoLoginScreen() {
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, "https://coco-login.com", "Redirection back to COCO login screen failed.");
    }
}