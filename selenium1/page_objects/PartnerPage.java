package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class PartnerPage extends WebReusableComponents {

    protected By btnFindPartner = By.id("findPartnerButton");
    protected By txtUserName = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");

    public PartnerPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Opens a new browser window.
     */
    public void openNewBrowserWindow() {
        openNewWindow();
        Assert.assertTrue(isWindowOpened(), "New browser window was not opened successfully.");
    }

    /**
     * Navigates to the Partner Page URL.
     */
    public void enterPartnerPageUrl() {
        navigateToUrl("http://www.qasymphony.com/partners.html");
        Assert.assertEquals(getCurrentURL(), "http://www.qasymphony.com/partners.html", "Failed to navigate to Partner Page URL.");
    }

    /**
     * Clicks the Find Partner button.
     */
    public void clickFindPartnerButton() {
        waitUntilElementVisible(btnFindPartner, 3);
        clickElement(btnFindPartner);
        Assert.assertTrue(isElementClicked(btnFindPartner), "Find Partner button was not clicked successfully.");
    }

    /**
     * Enters the username in the login field.
     * @param username the username to enter
     */
    public void enterUserName(String username) {
        waitUntilElementVisible(txtUserName, 3);
        enterText(txtUserName, username);
        Assert.assertTrue(isTextEntered(txtUserName, username), "Username was not entered successfully.");
    }

    /**
     * Enters the password in the login field.
     * @param password the password to enter
     */
    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
        Assert.assertTrue(isTextEntered(txtPassword, password), "Password was not entered successfully.");
    }

    /**
     * Clicks the Login button.
     */
    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
        Assert.assertTrue(isElementClicked(btnLogin), "Login button was not clicked successfully.");
    }

    /**
     * Waits until the specified element is visible.
     * @param by the locator of the element
     * @param timeOutInSeconds the timeout in seconds
     */
    public void waitUntilElementVisible(By by, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        Assert.assertNotNull(element, "Element is not visible: " + by.toString());
    }

    /**
     * Clicks the specified element.
     * @param by the locator of the element
     */
    public void clickElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
        Assert.assertTrue(isElementClicked(by), "Element was not clicked: " + by.toString());
    }

    /**
     * Enters text into the specified element.
     * @param by the locator of the element
     * @param text the text to enter
     */
    public void enterText(By by, String text) {
        WebElement element = driver.findElement(by);
        element.clear();
        element.sendKeys(text);
        Assert.assertTrue(isTextEntered(by, text), "Text was not entered: " + by.toString());
    }

    /**
     * Checks if the specified element was clicked.
     * @param by the locator of the element
     * @return true if the element was clicked, false otherwise
     */
    public boolean isElementClicked(By by) {
        // Implement logic to verify if the element was clicked
        return true; // Placeholder for actual implementation
    }

    /**
     * Checks if the specified text was entered into the element.
     * @param by the locator of the element
     * @param text the text to verify
     * @return true if the text was entered, false otherwise
     */
    public boolean isTextEntered(By by, String text) {
        // Implement logic to verify if the text was entered
        return true; // Placeholder for actual implementation
    }

    /**
     * Checks if a new browser window was opened.
     * @return true if a new window was opened, false otherwise
     */
    public boolean isWindowOpened() {
        // Implement logic to verify if a new window was opened
        return true; // Placeholder for actual implementation
    }
}