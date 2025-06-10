package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class AdminProfilePage extends WebReusableComponents {

    protected By userNameMenu = By.id("userName");
    protected By mailIdMenu = By.id("mailId");
    protected By homeMenu = By.id("home");
    protected By projectsMenu = By.id("projects");
    protected By usersMenu = By.id("users");
    protected By dashboardsMenu = By.id("dashboards");
    protected By promptsMenu = By.id("prompts");
    protected By versionMenu = By.id("version");
    protected By logoutMenu = By.id("logout");

    public AdminProfilePage() {
        PageFactory.initElements(driver, this);
    }

    public void loginAsAdmin() {
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        waitUntilElementVisible(loginButton, 3);
        loginButton.click();
        Assert.assertTrue(isElementDisplayed(homeMenu), "Login failed, home menu is not displayed");
    }

    public void navigateToUserProfile() {
        WebElement userProfileLink = driver.findElement(By.id("userProfile"));
        waitUntilElementVisible(userProfileLink, 3);
        userProfileLink.click();
        Assert.assertTrue(isElementDisplayed(userNameMenu), "Navigation to user profile failed");
    }

    public void verifyAdminMenusDisplayed(List<String> menuItems) {
        for (String menuItem : menuItems) {
            switch (menuItem) {
                case "User name":
                    Assert.assertTrue(isElementDisplayed(userNameMenu), "User name menu is not displayed");
                    break;
                case "Mail ID":
                    Assert.assertTrue(isElementDisplayed(mailIdMenu), "Mail ID menu is not displayed");
                    break;
                case "Home":
                    Assert.assertTrue(isElementDisplayed(homeMenu), "Home menu is not displayed");
                    break;
                case "Projects":
                    Assert.assertTrue(isElementDisplayed(projectsMenu), "Projects menu is not displayed");
                    break;
                case "Users":
                    Assert.assertTrue(isElementDisplayed(usersMenu), "Users menu is not displayed");
                    break;
                case "Dashboards":
                    Assert.assertTrue(isElementDisplayed(dashboardsMenu), "Dashboards menu is not displayed");
                    break;
                case "Prompts":
                    Assert.assertTrue(isElementDisplayed(promptsMenu), "Prompts menu is not displayed");
                    break;
                case "Version":
                    Assert.assertTrue(isElementDisplayed(versionMenu), "Version menu is not displayed");
                    break;
                case "Logout":
                    Assert.assertTrue(isElementDisplayed(logoutMenu), "Logout menu is not displayed");
                    break;
                default:
                    throw new IllegalArgumentException("Unknown menu item: " + menuItem);
            }
        }
    }

    public void navigateToHomePage() {
        WebElement homeLink = driver.findElement(homeMenu);
        waitUntilElementVisible(homeLink, 3);
        homeLink.click();
        Assert.assertTrue(isElementDisplayed(homeMenu), "Navigation to home page failed");
    }

    public void verifyAllAdminMenusDisplayed() {
        Assert.assertTrue(isElementDisplayed(userNameMenu), "User name menu is not displayed");
        Assert.assertTrue(isElementDisplayed(mailIdMenu), "Mail ID menu is not displayed");
        Assert.assertTrue(isElementDisplayed(homeMenu), "Home menu is not displayed");
        Assert.assertTrue(isElementDisplayed(projectsMenu), "Projects menu is not displayed");
        Assert.assertTrue(isElementDisplayed(usersMenu), "Users menu is not displayed");
        Assert.assertTrue(isElementDisplayed(dashboardsMenu), "Dashboards menu is not displayed");
        Assert.assertTrue(isElementDisplayed(promptsMenu), "Prompts menu is not displayed");
        Assert.assertTrue(isElementDisplayed(versionMenu), "Version menu is not displayed");
        Assert.assertTrue(isElementDisplayed(logoutMenu), "Logout menu is not displayed");
    }
}