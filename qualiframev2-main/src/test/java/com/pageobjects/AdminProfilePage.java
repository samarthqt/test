package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class AdminProfilePage extends WebReusableComponents {

    protected By userProfileSection = By.id("userProfileSection");
    protected By menuItemUserName = By.id("menuItemUserName");
    protected By menuItemMailID = By.id("menuItemMailID");
    protected By menuItemHome = By.id("menuItemHome");
    protected By menuItemProjects = By.id("menuItemProjects");
    protected By menuItemUsers = By.id("menuItemUsers");
    protected By menuItemDashboards = By.id("menuItemDashboards");
    protected By menuItemPrompts = By.id("menuItemPrompts");
    protected By menuItemVersion = By.id("menuItemVersion");
    protected By menuItemLogout = By.id("menuItemLogout");

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
        Assert.assertTrue(isElementDisplayed(userProfileSection), "Navigation to user profile section failed.");
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

    private By getMenuItemLocator(String menuItem) {
        switch (menuItem) {
            case "User name":
                return menuItemUserName;
            case "Mail ID":
                return menuItemMailID;
            case "Home":
                return menuItemHome;
            case "Projects":
                return menuItemProjects;
            case "Users":
                return menuItemUsers;
            case "Dashboards":
                return menuItemDashboards;
            case "Prompts":
                return menuItemPrompts;
            case "Version":
                return menuItemVersion;
            case "Logout":
                return menuItemLogout;
            default:
                throw new IllegalArgumentException("Invalid menu item: " + menuItem);
        }
    }
}