import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class ShipmentMonitoringSteps {

    WebDriver driver;
    WebDriverWait wait;

    @Given("the user has a valid customer account with Customer ID {string}")
    public void user_has_valid_customer_account(String customerId) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://example.com/login");
    }

    @Given("the shipment is in transit")
    public void shipment_is_in_transit() {
        // Assume shipment status is set in the system
    }

    @When("the user logs in to the customer account using valid credentials")
    public void user_logs_in() {
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        usernameField.sendKeys("testuser");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SecurePassword123");
        WebElement loginButton = driver.findElement(By.id("login_button"));
        loginButton.click();
    }

    @Then("the user is successfully logged in to their account")
    public void user_logged_in_successfully() {
        WebElement dashboardElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dashboard")));
        Assert.assertTrue("Login failed - Dashboard not found", dashboardElement.isDisplayed());
    }

    @When("the user navigates to the 'Track Shipment' section")
    public void user_navigates_to_track_shipment() {
        WebElement trackShipmentLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("track_shipment_link")));
        trackShipmentLink.click();
    }

    @Then("the 'Track Shipment' section is displayed")
    public void track_shipment_section_displayed() {
        WebElement trackShipmentSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("track_shipment_section")));
        Assert.assertTrue("Track Shipment section not displayed", trackShipmentSection.isDisplayed());
    }

    @When("the user enters the Shipment ID {string} in the search bar")
    public void user_enters_shipment_id(String shipmentId) {
        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipment_search_bar")));
        searchBar.sendKeys(shipmentId);
        WebElement searchButton = driver.findElement(By.id("search_button"));
        searchButton.click();
    }

    @Then("the shipment details are displayed for {string}")
    public void shipment_details_displayed(String shipmentId) {
        WebElement shipmentDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipment_details")));
        Assert.assertTrue("Shipment details not displayed", shipmentDetails.isDisplayed());
    }

    @Then("the current location of the shipment is displayed as {string}")
    public void current_location_displayed(String location) {
        WebElement locationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("current_location")));
        Assert.assertEquals("Location not displayed correctly", location, locationElement.getText());
    }

    @Then("the estimated delivery time is displayed as {string}")
    public void estimated_delivery_time_displayed(String deliveryTime) {
        WebElement deliveryTimeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("estimated_delivery_time")));
        Assert.assertEquals("Delivery time not displayed correctly", deliveryTime, deliveryTimeElement.getText());
    }

    @When("the user waits for 5 minutes and refreshes the page")
    public void user_waits_and_refreshes() throws InterruptedException {
        Thread.sleep(300000); // Wait for 5 minutes
        driver.navigate().refresh();
    }

    @Then("any changes in location or delivery time are updated in real-time")
    public void changes_updated_in_real_time() {
        WebElement updatedLocation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("updated_location")));
        WebElement updatedDeliveryTime = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("updated_delivery_time")));
        Assert.assertTrue("Location not updated", updatedLocation.isDisplayed());
        Assert.assertTrue("Delivery time not updated", updatedDeliveryTime.isDisplayed());
    }

    @When("the user logs out of the customer account")
    public void user_logs_out() {
        WebElement logoutButton = driver.findElement(By.id("logout_button"));
        logoutButton.click();
    }

    @Then("the user is successfully logged out")
    public void user_logged_out_successfully() {
        WebElement loginPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_page")));
        Assert.assertTrue("Logout failed", loginPage.isDisplayed());
    }
}