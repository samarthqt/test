package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class UsersPage extends WebReusableComponents {

    protected By txtUserName = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By adminProfileMenu = By.id("adminProfileMenu");
    protected By projectsMenuOption = By.id("projectsMenuOption");
    protected By usersPageHeader = By.id("usersPageHeader");
    protected By createNewUserOption = By.id("createNewUserOption");

    public UsersPage() {
        PageFactory.initElements(driver, this);
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

    public void verifyAdminLogin() {
        Assert.assertTrue(isElementVisible(adminProfileMenu), "Admin user is not logged in.");
    }

    public void openAdminProfileMenu() {
        waitUntilElementVisible(adminProfileMenu, 3);
        clickElement(adminProfileMenu);
    }

    public void verifyAdminMenuOptions() {
        Assert.assertTrue(isElementVisible(projectsMenuOption), "Admin menu options are not visible.");
    }

    public void clickProjectsMenuOption() {
        waitUntilElementVisible(projectsMenuOption, 3);
        clickElement(projectsMenuOption);
    }

    public void verifyUsersPageRedirection() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("users"), "Redirection to Users page failed.");
    }

    public void verifyOnUsersPage() {
        Assert.assertTrue(isElementVisible(usersPageHeader), "Not on Users page.");
    }

    public void verifyCreateNewUserOption() {
        Assert.assertTrue(isElementVisible(createNewUserOption), "Create new User option is not available.");
    }
}