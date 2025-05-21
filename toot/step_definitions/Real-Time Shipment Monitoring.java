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

    @And("the shipment with Shipment ID {string} is in transit")
    public void shipment_is_in_transit(String shipmentId) {
        // Assume shipment is in transit
    }

    @When("the user logs in to the customer account using valid credentials")
    public void user_logs_in() {
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        usernameField.sendKeys("validUsername");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("validPassword");

        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
    }

    @Then("the user is successfully logged in to their account")
    public void user_is_logged_in() {
        WebElement accountDashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account_dashboard")));
        Assert.assertTrue(accountDashboard.isDisplayed());
    }

    @When("the user navigates to the 'Track Shipment' section")
    public void user_navigates_to_track_shipment() {
        WebElement trackShipmentLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("track_shipment_link")));
        trackShipmentLink.click();
    }

    @Then("the 'Track Shipment' section is displayed")
    public void track_shipment_section_is_displayed() {
        WebElement trackShipmentSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("track_shipment_section")));
        Assert.assertTrue(trackShipmentSection.isDisplayed());
    }

    @When("the user enters the Shipment ID {string} in the search bar")
    public void user_enters_shipment_id(String shipmentId) {
        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipment_search_bar")));
        searchBar.sendKeys(shipmentId);

        WebElement searchButton = driver.findElement(By.id("search_button"));
        searchButton.click();
    }

    @Then("the shipment details are displayed for {string}")
    public void shipment_details_are_displayed(String shipmentId) {
        WebElement shipmentDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipment_details")));
        Assert.assertTrue(shipmentDetails.getText().contains(shipmentId));
    }

    @When("the user verifies the current location of the shipment")
    public void user_verifies_current_location() {
        WebElement currentLocation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("current_location")));
        Assert.assertTrue(currentLocation.isDisplayed());
    }

    @Then("the current location is accurately displayed as {string}")
    public void current_location_is_displayed(String location) {
        WebElement currentLocation = driver.findElement(By.id("current_location"));
        Assert.assertEquals(location, currentLocation.getText());
    }

    @When("the user checks the estimated delivery time")
    public void user_checks_estimated_delivery_time() {
        WebElement estimatedDeliveryTime = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("estimated_delivery_time")));
        Assert.assertTrue(estimatedDeliveryTime.isDisplayed());
    }

    @Then("the estimated delivery time is shown as {string}")
    public void estimated_delivery_time_is_displayed(String deliveryTime) {
        WebElement estimatedDeliveryTime = driver.findElement(By.id("estimated_delivery_time"));
        Assert.assertEquals(deliveryTime, estimatedDeliveryTime.getText());
    }

    @When("the user refreshes the page to ensure real-time updates are reflected")
    public void user_refreshes_page() {
        driver.navigate().refresh();
    }

    @Then("any changes in location or delivery time are updated in real-time")
    public void changes_are_updated_in_real_time() {
        WebElement updatedLocation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("current_location")));
        WebElement updatedDeliveryTime = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("estimated_delivery_time")));
        Assert.assertTrue(updatedLocation.isDisplayed() && updatedDeliveryTime.isDisplayed());
    }

    @When("the user logs out of the customer account")
    public void user_logs_out() {
        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_button")));
        logoutButton.click();
    }

    @Then("the user is successfully logged out")
    public void user_is_logged_out() {
        WebElement loginPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_page")));
        Assert.assertTrue(loginPage.isDisplayed());
    }
}