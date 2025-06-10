package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;
import java.util.stream.Collectors;

public class AdminProfilePage extends WebReusableComponents {

    protected By menuItems = By.cssSelector(".admin-menu-item");
    protected By txtUserName = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By userProfileLink = By.id("userProfileLink");

    public AdminProfilePage() {
        PageFactory.initElements(driver, this);
    }

    public void loginAsAdmin() {
        waitUntilElementVisible(txtUserName, 3);
        enterText(txtUserName, "adminUsername"); // Replace with actual admin username
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, "adminPassword"); // Replace with actual admin password
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
        String expectedURL = "expectedHomePageURL"; // Replace with actual expected URL
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "Admin is not redirected to the homepage.");
    }

    public void navigateToUserProfile() {
        waitUntilElementVisible(userProfileLink, 3);
        clickElement(userProfileLink);
        String expectedURL = "expectedUserProfileURL"; // Replace with actual expected URL
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "User profile page is not displayed.");
    }

    public void verifyAdminMenus(List<String> expectedMenus) {
        waitUntilElementVisible(menuItems, 3);
        List<String> actualMenus = getWebElementList(menuItems)
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toList());
        Assert.assertTrue(actualMenus.containsAll(expectedMenus), "Not all admin menus are displayed.");
    }
}