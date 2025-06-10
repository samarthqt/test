package bdd1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class ProjectsPage extends WebReusableComponents {

    protected By adminProfileMenu = By.id("adminProfileMenu");
    protected By projectsMenuOption = By.id("projectsMenuOption");
    protected By createNewProjectOption = By.id("createNewProjectOption");

    public ProjectsPage() {
        PageFactory.initElements(driver, this);
    }

    public void loginAsAdmin() {
        // Implement login logic for Admin user
        String adminUsername = "admin"; // Replace with actual admin username
        String adminPassword = "password"; // Replace with actual admin password
        enterText(By.id("username"), adminUsername);
        enterText(By.id("password"), adminPassword);
        clickElement(By.id("loginButton"));
        Assert.assertTrue(isElementDisplayed(adminProfileMenu), "Login as admin failed.");
    }

    public void verifyAdminProfileMenuOptions() {
        waitUntilElementVisible(adminProfileMenu, 3);
        Assert.assertTrue(isElementDisplayed(adminProfileMenu), "Admin profile menu options are not visible.");
    }

    public void clickProjectsMenuOption() {
        waitUntilElementVisible(projectsMenuOption, 3);
        clickElement(projectsMenuOption);
    }

    public void verifyProjectsPageRedirection() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("projects"), "Not redirected to the projects page.");
    }

    public void verifyCreateNewProjectOption() {
        waitUntilElementVisible(createNewProjectOption, 3);
        Assert.assertTrue(isElementDisplayed(createNewProjectOption), "Create new project option is not visible.");
    }
}