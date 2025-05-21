import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class TrackingStepDefinitions {

    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    TrackingPage trackingPage;

    public TrackingStepDefinitions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.loginPage = new LoginPage(driver);
        this.trackingPage = new TrackingPage(driver);
    }

    public void givenUserHasValidCustomerAccount(String customerId) {
        // Assume customer account is valid
    }

    public void andShipmentIsInTransit(String shipmentId) {
        // Assume shipment is in transit
    }

    public void whenUserLogsInWithValidCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    public void thenUserIsSuccessfullyLoggedIn() {
        WebElement accountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account_dashboard")));
        Assert.assertTrue(accountElement.isDisplayed());
    }

    public void whenUserNavigatesToTrackShipmentSection() {
        trackingPage.navigateToTrackShipment();
    }

    public void thenTrackShipmentSectionIsDisplayed() {
        WebElement trackShipmentElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("track_shipment_section")));
        Assert.assertTrue(trackShipmentElement.isDisplayed());
    }

    public void whenUserEntersShipmentId(String shipmentId) {
        trackingPage.enterShipmentId(shipmentId);
    }

    public void thenShipmentDetailsAreDisplayed(String shipmentId) {
        WebElement shipmentDetailsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipment_details")));
        Assert.assertTrue(shipmentDetailsElement.getText().contains(shipmentId));
    }

    public void andCurrentStatusIsDisplayed(String status) {
        WebElement statusElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipment_status")));
        Assert.assertEquals(status, statusElement.getText());
    }

    public void thenCurrentStatusIsAccuratelyDisplayed(String status) {
        WebElement statusElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipment_status")));
        Assert.assertEquals(status, statusElement.getText());
    }

    public void whenUserRefreshesPage() {
        driver.navigate().refresh();
    }

    public void thenTrackingInformationUpdatesImmediately() {
        WebElement updatedStatusElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("updated_shipment_status")));
        Assert.assertTrue(updatedStatusElement.isDisplayed());
    }

    public void whenUserLogsOut() {
        loginPage.clickLogoutButton();
    }

    public void thenUserIsSuccessfullyLoggedOut() {
        WebElement loginElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_page")));
        Assert.assertTrue(loginElement.isDisplayed());
    }
}