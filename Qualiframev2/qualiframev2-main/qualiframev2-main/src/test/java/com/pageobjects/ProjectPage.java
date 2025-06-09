package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class ProjectPage extends WebReusableComponents {

    protected By txtUserName = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By homeScreenOptions = By.id("homeOptions");
    protected By projectsDropdown = By.id("projectsDropdown");
    protected By projectNames = By.cssSelector(".project-name");
    protected By loadingIndicator = By.id("loadingIndicator");

    public ProjectPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyLoginPageFields() {
        waitUntilElementVisible(txtUserName, 3);
        waitUntilElementVisible(txtPassword, 3);
        Assert.assertTrue(isElementVisible(txtUserName) && isElementVisible(txtPassword), "Login page fields are not visible.");
    }

    public void enterUserName(String username) {
        waitUntilElementVisible(txtUserName, 3);
        enterText(txtUserName, username);
        verifyUserNameEntered();
    }

    public void verifyUserNameEntered() {
        String enteredUsername = getTextFromElement(txtUserName);
        Assert.assertFalse(enteredUsername.isEmpty(), "Username not entered.");
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
        verifyPasswordEntered();
    }

    public void verifyPasswordEntered() {
        String enteredPassword = getTextFromElement(txtPassword);
        Assert.assertFalse(enteredPassword.isEmpty(), "Password not entered.");
    }

    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
        verifySuccessfulLogin();
    }

    public void verifySuccessfulLogin() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("home"), "Login failed.");
    }

    public void navigateToHomeScreen() {
        waitUntilElementVisible(homeScreenOptions, 3);
        verifyHomeScreenOptions();
    }

    public void verifyHomeScreenOptions() {
        Assert.assertTrue(isElementVisible(homeScreenOptions), "Home screen options not visible.");
    }

    public void locateProjectsDropdown() {
        waitUntilElementVisible(projectsDropdown, 3);
        verifyProjectsDropdownVisible();
    }

    public void verifyProjectsDropdownVisible() {
        Assert.assertTrue(isElementVisible(projectsDropdown), "Projects dropdown not visible.");
    }

    public void clickProjectsDropdown() {
        waitUntilElementVisible(projectsDropdown, 3);
        clickElement(projectsDropdown);
        verifyProjectsListDisplayed();
    }

    public void verifyProjectsListDisplayed() {
        List<WebElement> projects = getWebElementList(projectNames);
        Assert.assertFalse(projects.isEmpty(), "Projects list not displayed.");
    }

    public void verifyProjectNamesClickable() {
        List<WebElement> projects = getWebElementList(projectNames);
        for (WebElement project : projects) {
            Assert.assertTrue(project.isEnabled(), "Project name not clickable.");
        }
    }

    public void clickOnProjectName() {
        List<WebElement> projects = getWebElementList(projectNames);
        if (!projects.isEmpty()) {
            clickElement(projects.get(0));
            verifyNavigationToProjectDetailsPage();
        }
    }

    public void verifyNavigationToProjectDetailsPage() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("projectDetails"), "Navigation to project details page failed.");
    }

    public void verifyLoadingIndicatorDisplayed() {
        Assert.assertTrue(isElementVisible(loadingIndicator), "Loading indicator not displayed.");
    }

    public void verifyCompleteProjectList() {
        List<WebElement> projects = getWebElementList(projectNames);
        Assert.assertFalse(projects.isEmpty(), "Project list is incomplete.");
    }

    public void logout() {
        // Implement logout functionality
        verifyLogoutSuccess();
    }

    public void verifyLogoutSuccess() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("login"), "Logout failed.");
    }

    public void closeApplication() {
        // Implement application close functionality
        verifyApplicationClosed();
    }

    public void verifyApplicationClosed() {
        // Verify application closed successfully
        Assert.assertTrue(driver == null || driver.toString().contains("(null)"), "Application did not close successfully.");
    }
}