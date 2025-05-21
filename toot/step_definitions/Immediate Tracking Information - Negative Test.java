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

    public void givenUserHasValidCustomerAccount() {
        loginPage.login("validUsername", "validPassword");
        Assert.assertTrue("Login failed", loginPage.isLoggedIn());
    }

    public void whenUserNavigatesToTrackShipmentSection() {
        trackingPage.navigateToTrackShipment();
        Assert.assertTrue("Track Shipment section not displayed", trackingPage.isTrackShipmentSectionDisplayed());
    }

    public void whenUserEntersInvalidShipmentID() {
        trackingPage.enterShipmentID("SHIP99999");
        Assert.assertTrue("Error message not displayed", trackingPage.isErrorMessageDisplayed());
    }

    public void whenUserAttemptsToRefreshPage() {
        driver.navigate().refresh();
        Assert.assertTrue("Error message not persistent", trackingPage.isErrorMessageDisplayed());
    }

    public void whenUserLogsOut() {
        loginPage.logout();
        Assert.assertTrue("Logout failed", loginPage.isLoggedOut());
    }
}