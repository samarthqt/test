package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LiveTrackingPage extends WebReusableComponents {

    protected By trackingField = By.id("trackingField");
    protected By locationMap = By.id("locationMap");
    protected By btnLogin = By.id("loginButton");
    protected By btnLogout = By.id("logoutButton");
    protected By shipmentIDField = By.id("shipmentID");
    protected By liveTrackingDetails = By.id("liveTrackingDetails");
    protected By liveTrackingPageHeader = By.id("liveTrackingPageHeader");

    public LiveTrackingPage() {
        PageFactory.initElements(driver, this);
    }

    public void login(String userId) {
        WebElement loginButton = waitUntilElementVisible(btnLogin, 5);
        enterText(By.id("userId"), userId);
        loginButton.click();
        Assert.assertTrue(isLiveTrackingPageDisplayed(), "Login failed: Live Tracking Page is not displayed.");
    }

    public void navigateToLiveTrackingPage() {
        WebElement header = waitUntilElementVisible(liveTrackingPageHeader, 5);
        Assert.assertTrue(header.isDisplayed(), "Navigation failed: Live Tracking Page header is not visible.");
    }

    public boolean isLiveTrackingPageDisplayed() {
        WebElement header = waitUntilElementVisible(liveTrackingPageHeader, 5);
        return header.isDisplayed();
    }

    public void enterShipmentID(String shipmentId) {
        WebElement shipmentField = waitUntilElementVisible(shipmentIDField, 5);
        enterText(shipmentIDField, shipmentId);
        Assert.assertEquals(shipmentField.getAttribute("value"), shipmentId, "Shipment ID entry failed.");
    }

    public boolean isLiveTrackingDetailsDisplayed(String shipmentId) {
        WebElement details = waitUntilElementVisible(liveTrackingDetails, 5);
        return details.isDisplayed() && details.getText().contains(shipmentId);
    }

    public String getCurrentLocation() {
        WebElement map = waitUntilElementVisible(locationMap, 5);
        String currentLocation = map.getAttribute("data-current-location");
        Assert.assertNotNull(currentLocation, "Current location is not available.");
        return currentLocation;
    }

    public String getExpectedLocationOnMap() {
        WebElement map = waitUntilElementVisible(locationMap, 5);
        String expectedLocation = map.getAttribute("data-expected-location");
        Assert.assertNotNull(expectedLocation, "Expected location is not available.");
        return expectedLocation;
    }

    public void logout() {
        WebElement logoutButton = waitUntilElementVisible(btnLogout, 5);
        logoutButton.click();
        Assert.assertFalse(isLiveTrackingPageDisplayed(), "Logout failed: Live Tracking Page is still displayed.");
    }

    private WebElement waitUntilElementVisible(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void enterText(By locator, String text) {
        WebElement element = waitUntilElementVisible(locator, 5);
        element.clear();
        element.sendKeys(text);
    }
}