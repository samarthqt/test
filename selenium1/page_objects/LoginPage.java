package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class LoginPage extends WebReusableComponents {

    private final By txtUserName = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.id("loginButton");

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Enters the username into the username field.
     * @param username The username to be entered.
     */
    public void enterUserName(String username) {
        WebElement userNameElement = waitUntilElementVisible(txtUserName, 3);
        userNameElement.sendKeys(username);
    }

    /**
     * Enters the password into the password field.
     * @param password The password to be entered.
     */
    public void enterPassword(String password) {
        WebElement passwordElement = waitUntilElementVisible(txtPassword, 3);
        passwordElement.sendKeys(password);
    }

    /**
     * Clicks the login button.
     */
    public void clickLoginButton() {
        WebElement loginButtonElement = waitUntilElementVisible(btnLogin, 3);
        loginButtonElement.click();
    }

    /**
     * Verifies that the user is redirected to the homepage.
     * @param expectedURL The expected URL of the homepage.
     */
    public void verifyHomePageRedirection(String expectedURL) {
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "User is not redirected to the homepage.");
    }

    /**
     * Waits until the specified element is visible.
     * @param locator The locator of the element to wait for.
     * @param timeoutInSeconds The timeout in seconds.
     * @return The visible WebElement.
     */
    public WebElement waitUntilElementVisible(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Retrieves the current URL of the browser.
     * @return The current URL.
     */
    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }
}