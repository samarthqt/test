package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import java.util.*;

public class LoginPage extends WebReusableComponents {

    protected By btnLoginWithSSO = By.id("loginWithSSOButton");
    protected By txtSSOUsername = By.id("ssoUsername");
    protected By txtSSOPassword = By.id("ssoPassword");
    protected By btnSubmitSSO = By.id("submitSSOButton");
    protected By loginPage = By.id("loginPage");
    protected By standardLoginOption = By.id("standardLoginOption");
    protected By loginOptions = By.id("loginOptions");
    protected By ssoLoginInitiated = By.id("ssoLoginInitiated");
    protected By ssoCredentialsAccepted = By.id("ssoCredentialsAccepted");
    protected By userLoggedIn = By.id("userLoggedIn");
    protected By homepage = By.id("homepage");

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyURLAccessibility() {
        Assert.assertTrue(isURLAccessible(getAppUrl()), "CoCo URL is not accessible.");
    }

    public void launchCoCoURL() {
        launchUrl(getAppUrl());
    }

    public void verifyLoginPageDisplayed() {
        Assert.assertTrue(isElementDisplayed(loginPage), "CoCo login page is not displayed.");
    }

    public void verifyStandardLoginOptionVisible() {
        Assert.assertTrue(isElementDisplayed(standardLoginOption), "Standard login option is not visible.");
    }

    public void observeLoginOptions() {
        Assert.assertTrue(isElementDisplayed(loginOptions), "Login options are not visible.");
    }

    public void verifySSOButtonDisplayed() {
        Assert.assertTrue(isElementDisplayed(btnLoginWithSSO), "Login with SSO button is not displayed.");
    }

    public void clickSSOButton() {
        waitUntilElementVisible(btnLoginWithSSO, 3);
        clickElement(btnLoginWithSSO);
    }

    public void verifySSOLoginInitiated() {
        Assert.assertTrue(isElementDisplayed(ssoLoginInitiated), "SSO login process is not initiated.");
    }

    public void enterSSOCredentials() {
        waitUntilElementVisible(txtSSOUsername, 3);
        enterText(txtSSOUsername, "validUsername");
        waitUntilElementVisible(txtSSOPassword, 3);
        enterText(txtSSOPassword, "validPassword");
    }

    public void submitSSOCredentials() {
        waitUntilElementVisible(btnSubmitSSO, 3);
        clickElement(btnSubmitSSO);
    }

    public void verifySSOCredentialsAccepted() {
        Assert.assertTrue(isElementDisplayed(ssoCredentialsAccepted), "SSO credentials are not accepted.");
    }

    public void verifyUserLoggedIn() {
        Assert.assertTrue(isElementDisplayed(userLoggedIn), "User is not logged into CoCo.");
    }

    public void verifyRedirectionToHomepage() {
        Assert.assertTrue(isElementDisplayed(homepage), "User is not redirected to the homepage.");
    }

    public void verifyUserOnHomepage() {
        Assert.assertTrue(isElementDisplayed(homepage), "User is not on the CoCo homepage.");
    }
}