
package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import .util.List;

public class BrowserWindowPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public BrowserWindowPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void openNewBrowserWindow() {
        driver.switchTo().newWindow(WindowType.WINDOW);
        Assert.assertNotNull(driver.getWindowHandle(), New browser window was not opened successfully.);
    }

    public void waitUntilElementLocated(By by, long timeOutInSeconds) {
        new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitUntilElementVisible(By by, long timeOutInSeconds) {
        new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitUntilElementClickable(By by, long timeOutInSeconds) {
        new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitUntilElementEnabled(By by, long timeOutInSeconds) {
        WebElement element = new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOfElementLocated(by));
        Assert.assertTrue(element.isEnabled(), Element is not enabled.);
    }

    public void waitUntilElementDisabled(By by, long timeOutInSeconds) {
        WebElement element = new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOfElementLocated(by));
        Assert.assertFalse(element.isEnabled(), Element is not disabled.);
    }

    public void mouseOver(By by) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        // Assuming Actions class is used for mouse over
        new org.openqa.selenium.interactions.Actions(driver).moveToElement(element).perform();
    }

    public boolean objectExists(By by) {
        return !driver.findElements(by).isEmpty();
    }

    public boolean isTextPresent(String textPattern) {
        String bodyText = driver.findElement(By.cssSelector(BODY)).getText();
        return bodyText.contains(textPattern);
    }

    public boolean isAlertPresent(long timeOutInSeconds) {
        try {
            new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public void clickElement(By by) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        element.click();
    }

    public void enterText(By by, String valueToEnter) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        element.clear();
        element.sendKeys(valueToEnter);
    }

    public void verifyRedirect(String expURL) {
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, expURL, Redirected to incorrect URL.);
    }

    public List<WebElement> getWebElementList(By by) {
        return driver.findElements(by);
    }

    public String getTextFromElement(By by) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return element.getText();
    }

    public String checkifNullorEmpty(String value) {
        return (value == null || value.isEmpty()) ? default : value;
    }

    public String getValue(Object classname, String locatorName) {
        // Assuming some logic to retrieve value based on classname and locatorName
        return value; // Placeholder for actual logic
    }

    public boolean elementVisible(By by) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return element.isDisplayed();
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public boolean elementVisible(By by, long seconds) {
        try {
            WebElement element = new WebDriverWait(driver, seconds).until(ExpectedConditions.visibilityOfElementLocated(by));
            return element.isDisplayed();
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public void switchToLastestWindow() {
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
    }

    public void switchToParentWindow() {
        String parentHandle = driver.getWindowHandles().iterator().next();
        driver.switchTo().window(parentHandle);
    }

    public void waitUntilNewTabLoads() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.numberOfWindowsToBe(2));
    }
}
