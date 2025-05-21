import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class ReturnFlowSteps {

    WebDriver driver;
    WebDriverWait wait;
    AccountDashboardPage accountDashboardPage;
    OrderDetailsPage orderDetailsPage;

    @Given("the customer has purchased an Achieve access code")
    public void customerHasPurchasedAccessCode() {
        // Assume purchase is verified through backend or database
    }

    @Given("the purchase was made more than 14 days ago")
    public void purchaseMadeMoreThan14DaysAgo() {
        // Assume date verification through backend or database
    }

    @Given("the customer logs in to the BFW store with their account")
    public void customerLogsInToBFWStore() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://bfwstore.com/login");
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        usernameField.sendKeys("customer@example.com");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("password123");
        WebElement loginButton = driver.findElement(By.id("login_button"));
        loginButton.click();
    }

    @Then("the customer's account dashboard is displayed")
    public void accountDashboardIsDisplayed() {
        accountDashboardPage = new AccountDashboardPage(driver);
        Assert.assertTrue("Account dashboard not displayed", accountDashboardPage.isDashboardDisplayed());
    }

    @When("the customer navigates to the 'Order Details' section")
    public void navigateToOrderDetailsSection() {
        accountDashboardPage.clickOrderDetails();
    }

    @Then("order details are displayed with a list of recent purchases")
    public void orderDetailsDisplayed() {
        orderDetailsPage = new OrderDetailsPage(driver);
        Assert.assertTrue("Order details not displayed", orderDetailsPage.isOrderListDisplayed());
    }

    @And("the customer selects the order with ID 87654")
    public void selectOrderWithID() {
        orderDetailsPage.selectOrderById("87654");
    }

    @Then("order details for order ID 87654 are displayed")
    public void orderDetailsForIDDisplayed() {
        Assert.assertTrue("Order details for ID 87654 not displayed", orderDetailsPage.isOrderDetailsDisplayed("87654"));
    }

    @And("the access code ACH54321 is shown")
    public void accessCodeIsShown() {
        Assert.assertTrue("Access code ACH54321 not shown", orderDetailsPage.isAccessCodeDisplayed("ACH54321"));
    }

    @When("the customer attempts to click on the 'Initiate Return' button for the Achieve access code")
    public void attemptToClickInitiateReturn() {
        orderDetailsPage.attemptInitiateReturn("ACH54321");
    }

    @Then("the 'Initiate Return' button is disabled or not present")
    public void initiateReturnButtonDisabledOrNotPresent() {
        Assert.assertTrue("'Initiate Return' button is enabled or present", orderDetailsPage.isInitiateReturnDisabledOrNotPresent("ACH54321"));
    }

    @And("the customer is notified that the return period has expired")
    public void returnPeriodExpiredNotification() {
        Assert.assertTrue("Return period expired notification not displayed", orderDetailsPage.isReturnPeriodExpiredNotificationDisplayed());
    }
}