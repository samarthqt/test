package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;

public class ProfilePage extends WebReusableComponents {

    protected By txtUserName = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By lblRelease = By.id("releaseLabel");
    protected By lblLastDeployedDate = By.id("lastDeployedDateLabel");
    protected By profilePageLink = By.id("profilePageLink");

    public ProfilePage() {
        PageFactory.initElements(driver, this);
    }

    public void loginToApplication(String username, String password) {
        launchUrl(getAppUrl());
        maximizeWindow();
        waitUntilElementVisible(txtUserName, 3);
        enterText(txtUserName, username);
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void navigateToProfilePage() {
        waitUntilElementVisible(profilePageLink, 3);
        clickElement(profilePageLink);
    }

    public void verifyReleaseLabel() {
        waitUntilElementVisible(lblRelease, 3);
        String releaseValue = getTextFromElement(lblRelease);
        Assert.assertNotNull(releaseValue, "Release label value is not displayed.");
    }

    public void verifyLastDeployedDateLabel() {
        waitUntilElementVisible(lblLastDeployedDate, 3);
        String lastDeployedDateValue = getTextFromElement(lblLastDeployedDate);
        Assert.assertNotNull(lastDeployedDateValue, "Last Deployed Date label value is not displayed.");
    }
}