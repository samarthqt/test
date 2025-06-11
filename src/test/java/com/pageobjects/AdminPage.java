package com.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class AdminPage extends WebReusableComponents {

    protected By userProfileSection = By.id("userProfileSection");
    protected By profileMenuOptions = By.id("profileMenuOptions");
    protected By projectsMenuOption = By.id("projectsMenuOption");
    protected By projectsPage = By.id("projectsPage");
    protected By createNewProjectOption = By.id("createNewProjectOption");

    public AdminPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyAdminLoggedIn() {
        waitUntilElementVisible(By.id("adminLoggedIn"), 3);
        Assert.assertTrue(isElementDisplayed(By.id("adminLoggedIn")), "Admin user is not logged in.");
    }

    public void navigateToUserProfileSection() {
        waitUntilElementVisible(userProfileSection, 3);
        clickElement(userProfileSection);
    }

    public void verifyProfileMenuOptionsVisible() {
        waitUntilElementVisible(profileMenuOptions, 3);
        Assert.assertTrue(isElementDisplayed(profileMenuOptions), "Profile menu options are not visible.");
    }

    public void clickProjectsMenuOption() {
        waitUntilElementVisible(projectsMenuOption, 3);
        clickElement(projectsMenuOption);
    }

    public void verifyRedirectionToProjectsPage() {
        waitUntilElementVisible(projectsPage, 3);
        Assert.assertTrue(isElementDisplayed(projectsPage), "User is not redirected to the projects page.");
    }

    public void verifyCreateNewProjectOptionVisible() {
        waitUntilElementVisible(createNewProjectOption, 3);
        Assert.assertTrue(isElementDisplayed(createNewProjectOption), "Create new project option is not visible.");
    }
}