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

    @Given("the user has a valid customer account")
    public void user_has_valid_customer_account() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("the user logs in to the customer account using valid credentials")
    public void user_logs_in() {
        driver.get("http://example.com/login");
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        usernameField.sendKeys("validUsername");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("validPassword");
        WebElement loginButton = driver.findElement(By.id("login_button"));
        loginButton.click();
    }

    @Then("the user is successfully logged in to their account")
    public void user_is_logged_in() {
        WebElement dashboardElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dashboard")));
        Assert.assertTrue("Login failed - Dashboard not found", dashboardElement.isDisplayed());
    }

    @And("the customer ID is \"CUST24680\"")
    public void customer_id_is_displayed() {
        WebElement customerIdElement = driver.findElement(By.id("customer_id"));
        Assert.assertEquals("CUST24680", customerIdElement.getText());
    }

    @When("the user navigates to the 'Track Shipment' section")
    public void user_navigates_to_track_shipment() {
        WebElement trackShipmentLink = driver.findElement(By.id("track_shipment_link"));
        trackShipmentLink.click();
    }

    @Then("the 'Track Shipment' section is displayed")
    public void track_shipment_section_is_displayed() {
        WebElement trackShipmentSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("track_shipment_section")));
        Assert.assertTrue(trackShipmentSection.isDisplayed());
    }

    @When("the user enters the long shipment ID \"SHIP12345678901234567890\" in the search bar")
    public void user_enters_long_shipment_id() {
        WebElement searchBar = driver.findElement(By.id("shipment_search_bar"));
        searchBar.sendKeys("SHIP12345678901234567890");
        WebElement searchButton = driver.findElement(By.id("search_button"));
        searchButton.click();
    }

    @Then("the system processes the input without crashing or displaying errors")
    public void system_processes_input() {
        WebElement errorMessage = driver.findElement(By.id("error_message"));
        Assert.assertFalse("System displayed an error message", errorMessage.isDisplayed());
    }

    @When("the user checks if the system provides any feedback or error message for the long ID")
    public void user_checks_feedback_for_long_id() {
        WebElement feedbackMessage = driver.findElement(By.id("feedback_message"));
        Assert.assertTrue("No feedback provided", feedbackMessage.isDisplayed());
    }

    @Then("the system either displays an error message or handles the input gracefully")
    public void system_handles_input_gracefully() {
        WebElement feedbackMessage = driver.findElement(By.id("feedback_message"));
        Assert.assertTrue("Feedback message not displayed", feedbackMessage.isDisplayed());
    }

    @When("the user logs out of the customer account")
    public void user_logs_out() {
        WebElement logoutButton = driver.findElement(By.id("logout_button"));
        logoutButton.click();
    }

    @Then("the user is successfully logged out")
    public void user_is_logged_out() {
        WebElement loginPageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_page")));
        Assert.assertTrue("Logout failed - Login page not displayed", loginPageElement.isDisplayed());
        driver.quit();
    }
}