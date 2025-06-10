package bdd1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class UserProfilePage extends WebReusableComponents {

    protected By userProfileMenu = By.id("userProfileMenu");
    protected By menuItems = By.cssSelector(".menu-item");
    protected By txtUserName = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");

    public UserProfilePage() {
        PageFactory.initElements(driver, this);
    }

    public void loginToApplication() {
        waitUntilElementVisible(txtUserName, 3);
        String userName = getData("LoginData", "UserName");
        enterText(txtUserName, userName);
        
        waitUntilElementVisible(txtPassword, 3);
        String password = getData("LoginData", "Password");
        enterText(txtPassword, password);
        
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
        
        String expectedURL = getData("LoginData", "ExpectedHomePageURL");
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "User is not redirected to the homepage.");
    }

    public void navigateToUserProfile() {
        waitUntilElementVisible(userProfileMenu, 3);
        clickElement(userProfileMenu);
    }

    public void verifyAdminMenuItems(List<String> expectedItems) {
        waitUntilElementVisible(menuItems, 3);
        List<WebElement> items = getWebElementList(menuItems);
        for (String expectedItem : expectedItems) {
            boolean itemFound = items.stream().anyMatch(item -> item.getText().equals(expectedItem));
            Assert.assertTrue(itemFound, "Menu item " + expectedItem + " is not displayed.");
        }
    }

    public void verifyMenuItemsDisplayedProminently() {
        waitUntilElementVisible(menuItems, 3);
        List<WebElement> items = getWebElementList(menuItems);
        for (WebElement item : items) {
            boolean isProminent = item.isDisplayed() && item.getCssValue("font-weight").equals("bold");
            Assert.assertTrue(isProminent, "Menu item " + item.getText() + " is not prominently displayed.");
        }
    }
}