package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class UsersPage extends WebReusableComponents {

    protected By txtUserName = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By menuUsersOption = By.id("usersMenuOption");
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

    public void verifyLoginSuccess() {
        Assert.assertTrue(isElementVisible(menuUsersOption), "Login was not successful.");
    }

    public void verifyProfileMenuOptionsVisible() {
        Assert.assertTrue(isElementVisible(menuUsersOption), "Profile menu options are not visible.");
    }

    public void clickUsersMenuOption() {
        waitUntilElementVisible(menuUsersOption, 3);
        clickElement(menuUsersOption);
    }

    public void verifyUsersPageRedirection() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("usersPage"), "User is not redirected to the Users page.");
    }

    public void verifyCreateNewUserOptionDisplayed() {
        Assert.assertTrue(isElementVisible(createNewUserOption), "Create New User option is not displayed.");
    }
}