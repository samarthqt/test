import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class TrackingStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;

    @Given("the user has a valid customer account with Customer ID {string}")
    public void user_has_valid_customer_account(String customerId) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://example.com/login");
    }

    @When("the user logs in to the customer account using valid credentials")
    public void user_logs_in_with_valid_credentials() {
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        usernameField.sendKeys("testuser");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SecurePassword123");
        WebElement loginButton = driver.findElement(By.id("login_button"));
        loginButton.click();
    }

    @Then("the user is successfully logged in to their account")
    public void user_is_logged_in() {
        WebElement dashboardElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dashboard")));
        Assert.assertTrue("Login failed - Dashboard not found", dashboardElement.isDisplayed());
    }

    @And("the user navigates to the 'Track Shipment' section")
    public void user_navigates_to_track_shipment() {
        WebElement trackShipmentLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("track_shipment_link")));
        trackShipmentLink.click();
    }

    @Then("the 'Track Shipment' section is displayed")
    public void track_shipment_section_displayed() {
        WebElement trackShipmentSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("track_shipment_section")));
        Assert.assertTrue("Track Shipment section not displayed", trackShipmentSection.isDisplayed());
    }

    @When("the user enters the Long Shipment ID {string} in the search bar")
    public void user_enters_long_shipment_id(String shipmentId) {
        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipment_search_bar")));
        searchBar.sendKeys(shipmentId);
        WebElement searchButton = driver.findElement(By.id("search_button"));
        searchButton.click();
    }

    @Then("the system processes the input without crashing or displaying errors")
    public void system_processes_input() {
        WebElement feedbackMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("feedback_message")));
        Assert.assertTrue("System crashed or displayed errors", feedbackMessage.isDisplayed());
    }

    @And("the system provides feedback or an error message for the long ID")
    public void system_provides_feedback() {
        WebElement errorMessage = driver.findElement(By.id("error_message"));
        Assert.assertTrue("No feedback or error message provided", errorMessage.isDisplayed());
    }

    @Then("the system either displays an error message or handles the input gracefully")
    public void system_handles_input_gracefully() {
        WebElement gracefulHandlingMessage = driver.findElement(By.id("graceful_handling_message"));
        Assert.assertTrue("Input not handled gracefully", gracefulHandlingMessage.isDisplayed());
    }

    @When("the user logs out of the customer account")
    public void user_logs_out() {
        WebElement logoutButton = driver.findElement(By.id("logout_button"));
        logoutButton.click();
    }

    @Then("the user is successfully logged out")
    public void user_is_logged_out() {
        WebElement loginPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_page")));
        Assert.assertTrue("Logout failed", loginPage.isDisplayed());
        driver.quit();
    }
}