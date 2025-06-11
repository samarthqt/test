package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class AdminProfilePage extends WebReusableComponents {

    protected By userProfile = By.id("userProfile");
    protected By adminMenus = By.cssSelector(".admin-menu-item");

    public AdminProfilePage() {
        PageFactory.initElements(driver, this);
    }

    public void loginAsAdmin() {
        // Implement login logic specific to Admin
        String adminUsername = "admin"; // Replace with actual admin username retrieval logic
        String adminPassword = "admin123"; // Replace with actual admin password retrieval logic
        enterUserName(adminUsername);
        enterPassword(adminPassword);
        clickLoginButton();
        verifyHomePageRedirection("expectedAdminHomePageURL"); // Replace with actual expected URL
    }

    public void navigateToUserProfile() {
        waitUntilElementVisible(userProfile, 3);
        clickElement(userProfile);
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("userProfile"), "User profile page is not displayed.");
    }

    public void verifyAdminMenusDisplayed(List<String> expectedMenus) {
        waitUntilElementVisible(adminMenus, 3);
        List<WebElement> menuElements = getWebElementList(adminMenus);
        List<String> actualMenus = new ArrayList<>();
        for (WebElement element : menuElements) {
            actualMenus.add(element.getText());
        }
        Assert.assertTrue(actualMenus.containsAll(expectedMenus), "Not all admin menus are displayed.");
    }
}