package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class ProjectsPage extends WebReusableComponents {

    protected By txtUserName = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By profileMenuOptions = By.id("profileMenuOptions");
    protected By projectsMenuOption = By.id("projectsMenuOption");
    protected By createNewProjectOption = By.id("createNewProjectOption");

    public ProjectsPage() {
        PageFactory.initElements(driver, this);
    }

    public void launchApplication() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    public void enterUserName(String username) {
        waitUntilElementVisible(txtUserName, 3);
        enterText(txtUserName, username);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void verifySuccessfulLogin() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("dashboard"), "Login was not successful.");
    }

    public void verifyProfileMenuOptionsVisible() {
        waitUntilElementVisible(profileMenuOptions, 3);
        Assert.assertTrue(isElementVisible(profileMenuOptions), "Profile menu options are not visible.");
    }

    public void clickProjectsMenuOption() {
        waitUntilElementVisible(projectsMenuOption, 3);
        clickElement(projectsMenuOption);
    }

    public void verifyProjectsPageRedirection() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("projects"), "User is not redirected to the Projects page.");
    }

    public void verifyCreateNewProjectOptionDisplayed() {
        waitUntilElementVisible(createNewProjectOption, 3);
        Assert.assertTrue(isElementVisible(createNewProjectOption), "Create New Project option is not displayed.");
    }
}