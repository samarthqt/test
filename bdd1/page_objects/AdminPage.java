package bdd1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class AdminPage extends WebReusableComponents {

    protected By txtUserName = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By profileSection = By.id("profileSection");
    protected By projectsMenuOption = By.id("projectsMenuOption");
    protected By usersPage = By.id("usersPage");
    protected By createNewUserOption = By.id("createNewUserOption");

    public AdminPage() {
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

    public void verifyHomePageRedirection(String expectedURL) {
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "User is not redirected to the homepage.");
    }

    public void navigateToProfileSection() {
        waitUntilElementVisible(profileSection, 3);
        clickElement(profileSection);
    }

    public void verifyProfileMenuOptions() {
        waitUntilElementVisible(profileSection, 3);
        Assert.assertTrue(isElementVisible(profileSection), "Profile menu options are not visible.");
    }

    public void clickProjectsMenuOption() {
        waitUntilElementVisible(projectsMenuOption, 3);
        clickElement(projectsMenuOption);
    }

    public void verifyUsersPageRedirection(String expectedURL) {
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "User is not redirected to the Users page.");
    }

    public void verifyUsersPageLoaded() {
        waitUntilElementVisible(usersPage, 3);
        Assert.assertTrue(isElementVisible(usersPage), "Users page is not loaded.");
    }

    public void verifyCreateNewUserOption() {
        waitUntilElementVisible(createNewUserOption, 3);
        Assert.assertTrue(isElementVisible(createNewUserOption), "Create new User option is not visible.");
    }
}