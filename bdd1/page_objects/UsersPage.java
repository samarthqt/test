package bdd1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class UsersPage extends WebReusableComponents {

    private By usersMenuOption = By.id("usersMenuOption");
    private By createNewUserOption = By.id("createNewUserOption");

    public UsersPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Clicks on the Users menu option.
     */
    public void clickUsersMenuOption() {
        waitUntilElementVisible(usersMenuOption, 3);
        clickElement(usersMenuOption);
    }

    /**
     * Verifies that the user is redirected to the Users page.
     */
    public void verifyUsersPageRedirection() {
        String expectedURL = "expectedUsersPageURL"; // Replace with actual expected URL
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "User is not redirected to the users page.");
    }

    /**
     * Verifies that the 'Create New User' option is visible on the Users page.
     */
    public void verifyCreateNewUserOptionVisible() {
        waitUntilElementVisible(createNewUserOption, 3);
        Assert.assertTrue(isElementVisible(createNewUserOption), "Create new user option is not visible on the users page.");
    }

    /**
     * Checks if an element is visible on the page.
     * @param locator The locator of the element to check.
     * @return True if the element is visible, false otherwise.
     */
    public boolean isElementVisible(By locator) {
        try {
            waitUntilElementVisible(locator, 3);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}