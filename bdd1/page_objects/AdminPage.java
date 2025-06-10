package bdd1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class AdminPage extends WebReusableComponents {

    protected By txtAdminUsername = By.id("adminUsername");
    protected By txtAdminPassword = By.id("adminPassword");
    protected By btnLogin = By.id("loginButton");
    protected By profileMenu = By.id("profileMenu");
    protected By projectsMenuOption = By.id("projectsMenuOption");
    protected By createNewProjectOption = By.id("createNewProjectOption");

    public AdminPage() {
        PageFactory.initElements(driver, this);
    }

    public void launchLoginPage() {
        navigateToUrl(getAppUrl());
        Assert.assertTrue(isElementVisible(txtAdminUsername), "Login page did not load correctly.");
    }

    public void enterAdminCredentials() {
        waitUntilElementVisible(txtAdminUsername, 3);
        enterText(txtAdminUsername, "adminUser");
        waitUntilElementVisible(txtAdminPassword, 3);
        enterText(txtAdminPassword, "adminPass");
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
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("dashboard"), "Admin login verification failed.");
    }

    public void navigateToProfileMenu() {
        waitUntilElementVisible(profileMenu, 3);
        clickElement(profileMenu);
    }

    public void verifyAdminProfileMenuOptions() {
        boolean optionsVisible = isElementVisible(profileMenu);
        Assert.assertTrue(optionsVisible, "Admin profile menu options are not visible.");
    }

    public void clickProjectsMenuOption() {
        waitUntilElementVisible(projectsMenuOption, 3);
        clickElement(projectsMenuOption);
    }

    public void verifyProjectsPageRedirection() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("projects"), "Redirection to Projects page failed.");
    }

    public void verifyProjectsPage() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("projects"), "Not on Projects page.");
    }

    public void viewAvailableOptions() {
        waitUntilElementVisible(createNewProjectOption, 3);
        Assert.assertTrue(isElementVisible(createNewProjectOption), "Available options are not visible.");
    }

    public void verifyCreateNewProjectOption() {
        boolean optionVisible = isElementVisible(createNewProjectOption);
        Assert.assertTrue(optionVisible, "Create new project option is not visible.");
    }
}