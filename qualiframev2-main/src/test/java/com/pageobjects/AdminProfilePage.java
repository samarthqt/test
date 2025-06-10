package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class AdminProfilePage extends WebReusableComponents {

    protected By userProfileSection = By.id("userProfileSection");
    protected By releaseLabel = By.id("releaseLabel");
    protected By lastDeployedDateLabel = By.id("lastDeployedDateLabel");

    public AdminProfilePage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyAdminLogin() {
        waitUntilElementVisible(userProfileSection, 5);
        Assert.assertTrue(isElementDisplayed(userProfileSection), "Admin login verification failed.");
    }

    public void navigateToUserProfile() {
        waitUntilElementVisible(userProfileSection, 3);
        clickElement(userProfileSection);
    }

    public void verifyUserProfileSectionDisplayed() {
        waitUntilElementVisible(userProfileSection, 3);
        Assert.assertTrue(isElementDisplayed(userProfileSection), "User profile section is not displayed.");
    }

    public void verifyMenuItemDisplayed(String menuItem) {
        By menuItemLocator = getMenuItemLocator(menuItem);
        waitUntilElementVisible(menuItemLocator, 3);
        Assert.assertTrue(isElementDisplayed(menuItemLocator), menuItem + " menu item is not displayed.");
    }

    public By getMenuItemLocator(String menuItem) {
        switch (menuItem) {
            case "Release":
                return releaseLabel;
            case "Last Deployed Date":
                return lastDeployedDateLabel;
            default:
                throw new IllegalArgumentException("Invalid menu item: " + menuItem);
        }
    }
}