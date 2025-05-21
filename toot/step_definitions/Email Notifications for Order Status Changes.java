import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class EmailNotificationSteps {

    WebDriver driver;
    WebDriverWait wait;
    EmailPage emailPage;

    @Given("the user is logged into the order management system")
    public void userLoggedIn() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://example.com/login");
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        usernameField.sendKeys("testuser");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("password123");
        WebElement loginButton = driver.findElement(By.id("login_button"));
        loginButton.click();
        emailPage = new EmailPage(driver);
    }

    @Given("the user has valid email notification settings configured")
    public void emailSettingsConfigured() {
        WebElement settingsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("settings_link")));
        settingsLink.click();
        WebElement emailSettings = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_settings")));
        Assert.assertTrue(emailSettings.isDisplayed());
    }

    @Given("an order with ID {string} is in the system")
    public void orderInSystem(String orderId) {
        WebElement orderSearchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("order_search")));
        orderSearchField.sendKeys(orderId);
        WebElement searchButton = driver.findElement(By.id("search_button"));
        searchButton.click();
        WebElement orderDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("order_details")));
        Assert.assertTrue(orderDetails.isDisplayed());
    }

    @When("the order status is updated to {string}")
    public void updateOrderStatus(String status) {
        WebElement statusDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("status_dropdown")));
        statusDropdown.sendKeys(status);
        WebElement updateButton = driver.findElement(By.id("update_button"));
        updateButton.click();
    }

    @Then("an email notification should be sent to the customer's registered email address")
    public void emailNotificationSent() {
        WebElement emailSentMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_sent_message")));
        Assert.assertTrue(emailSentMessage.isDisplayed());
    }

    @Then("the email subject should be {string}")
    public void verifyEmailSubject(String expectedSubject) {
        String actualSubject = emailPage.getEmailSubject();
        Assert.assertEquals(expectedSubject, actualSubject);
    }

    @Then("the email body should contain the shipping details and tracking information")
    public void verifyEmailBodyForShipped() {
        String emailBody = emailPage.getEmailBody();
        Assert.assertTrue(emailBody.contains("shipping details"));
        Assert.assertTrue(emailBody.contains("tracking information"));
    }

    @Then("the email body should contain the delivery confirmation and feedback request")
    public void verifyEmailBodyForDelivered() {
        String emailBody = emailPage.getEmailBody();
        Assert.assertTrue(emailBody.contains("delivery confirmation"));
        Assert.assertTrue(emailBody.contains("feedback request"));
    }

    @Then("no email notification should be sent to the customer")
    public void noEmailNotificationSent() {
        WebElement emailSentMessage = driver.findElement(By.id("email_sent_message"));
        Assert.assertFalse(emailSentMessage.isDisplayed());
    }

    @Then("the system should log an error indicating the email could not be sent")
    public void logEmailError() {
        WebElement errorLog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_log")));
        Assert.assertTrue(errorLog.isDisplayed());
    }

    @Then("the user should be notified of the failure to send the email notification")
    public void notifyUserOfFailure() {
        WebElement failureNotification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("failure_notification")));
        Assert.assertTrue(failureNotification.isDisplayed());
    }

    @Then("the email should contain the correct order ID, status, and customer details")
    public void verifyEmailContentForShipped() {
        String emailBody = emailPage.getEmailBody();
        Assert.assertTrue(emailBody.contains("order ID"));
        Assert.assertTrue(emailBody.contains("status"));
        Assert.assertTrue(emailBody.contains("customer details"));
    }

    @Then("the email should contain the correct order ID, status, and delivery details")
    public void verifyEmailContentForDelivered() {
        String emailBody = emailPage.getEmailBody();
        Assert.assertTrue(emailBody.contains("order ID"));
        Assert.assertTrue(emailBody.contains("status"));
        Assert.assertTrue(emailBody.contains("delivery details"));
    }
}