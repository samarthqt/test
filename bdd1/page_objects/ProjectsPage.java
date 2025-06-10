package bdd1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class ProjectsPage extends WebReusableComponents {

    private By projectsMenuOption = By.id("projectsMenuOption");
    private By createNewProjectOption = By.id("createNewProjectOption");

    public ProjectsPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Clicks on the projects menu option.
     */
    public void clickProjectsMenuOption() {
        waitUntilElementVisible(projectsMenuOption, 3);
        clickElement(projectsMenuOption);
    }

    /**
     * Verifies that the user is redirected to the projects page.
     */
    public void verifyProjectsPageRedirection() {
        String expectedURL = "expectedProjectsPageURL"; // Replace with actual expected URL
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "User is not redirected to the projects page.");
    }

    /**
     * Verifies that the 'Create New Project' option is visible on the projects page.
     */
    public void verifyCreateNewProjectOptionVisible() {
        waitUntilElementVisible(createNewProjectOption, 3);
        Assert.assertTrue(isElementVisible(createNewProjectOption), "Create new project option is not visible on the projects page.");
    }

    /**
     * Checks if the specified element is visible.
     * @param locator The locator of the element to check.
     * @return true if the element is visible, false otherwise.
     */
    public boolean isElementVisible(By locator) {
        try {
            waitUntilElementVisible(locator, 3);
            WebElement element = driver.findElement(locator);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}