package com.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class ProfilePage extends WebReusableComponents {

    protected By profileSection = By.id("profileSection");
    protected By releaseLabel = By.id("releaseLabel");
    protected By lastDeployedDateLabel = By.id("lastDeployedDateLabel");
    protected By logoutButton = By.id("logoutButton");
    protected By loginPage = By.id("loginPage");
    protected By adminLoggedIn = By.id("adminLoggedIn");
    protected By userLoggedIn = By.id("userLoggedIn");

    public ProfilePage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToProfileSection() {
        waitUntilElementVisible(profileSection, 3);
        clickElement(profileSection);
    }

    public void verifyProfileSectionDisplayed() {
        waitUntilElementVisible(profileSection, 3);
        Assert.assertTrue(isElementDisplayed(profileSection), "Profile section is not displayed.");
    }

    public void verifyReleaseLabelDisplayed() {
        waitUntilElementVisible(releaseLabel, 3);
        Assert.assertTrue(isElementDisplayed(releaseLabel), "Release label is not displayed.");
    }

    public void verifyLastDeployedDateLabelDisplayed() {
        waitUntilElementVisible(lastDeployedDateLabel, 3);
        Assert.assertTrue(isElementDisplayed(lastDeployedDateLabel), "Last Deployed Date label is not displayed.");
    }

    public void logoutAdminUser() {
        waitUntilElementVisible(logoutButton, 3);
        clickElement(logoutButton);
    }

    public void verifyAdminUserLoggedOut() {
        waitUntilElementVisible(loginPage, 3);
        Assert.assertTrue(isElementDisplayed(loginPage), "Admin user is not logged out.");
    }

    public void verifyAdminLoggedIn() {
        waitUntilElementVisible(adminLoggedIn, 3);
        Assert.assertTrue(isElementDisplayed(adminLoggedIn), "Admin user is not logged in.");
    }

    public void verifyUserLoggedIn() {
        waitUntilElementVisible(userLoggedIn, 3);
        Assert.assertTrue(isElementDisplayed(userLoggedIn), "User is not logged in.");
    }
}