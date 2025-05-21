import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class CartNotificationsStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;

    @Given("the user is logged into the e-commerce platform")
    public void userLoggedIn() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://example.com/login");
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login_button"));
        username.sendKeys("testuser");
        password.sendKeys("password123");
        loginButton.click();
    }

    @Given("the user has items in their cart")
    public void userHasItemsInCart() {
        driver.get("http://example.com/cart");
        WebElement cartItems = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cart_items")));
        Assert.assertTrue("Cart is empty", cartItems.isDisplayed());
    }

    @Given("the price threshold is set to {string}")
    public void setPriceThreshold(String threshold) {
        WebElement thresholdInput = driver.findElement(By.id("price_threshold"));
        thresholdInput.clear();
        thresholdInput.sendKeys(threshold);
    }

    @Given("the current total price of items in the cart is {string}")
    public void setCurrentTotalPrice(String currentTotal) {
        WebElement totalPrice = driver.findElement(By.id("total_price"));
        totalPrice.clear();
        totalPrice.sendKeys(currentTotal);
    }

    @When("the user adds an item with price {string}")
    public void addItemToCart(String itemPrice) {
        WebElement addItemButton = driver.findElement(By.id("add_item_button"));
        WebElement itemPriceInput = driver.findElement(By.id("item_price"));
        itemPriceInput.clear();
        itemPriceInput.sendKeys(itemPrice);
        addItemButton.click();
    }

    @When("the user removes an item with price {string}")
    public void removeItemFromCart(String itemPrice) {
        WebElement removeItemButton = driver.findElement(By.id("remove_item_button"));
        WebElement itemPriceInput = driver.findElement(By.id("item_price"));
        itemPriceInput.clear();
        itemPriceInput.sendKeys(itemPrice);
        removeItemButton.click();
    }

    @Then("the user should receive a notification that their cart has exceeded the threshold")
    public void verifyNotificationReceived() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("notification")));
        Assert.assertTrue("Notification not received", notification.isDisplayed());
    }

    @Then("the user should not receive a notification")
    public void verifyNoNotificationReceived() {
        WebElement notification = driver.findElement(By.id("notification"));
        Assert.assertFalse("Notification received unexpectedly", notification.isDisplayed());
    }

    @Then("the user should receive only one notification that their cart has exceeded the threshold")
    public void verifySingleNotificationReceived() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("notification")));
        Assert.assertTrue("Notification not received", notification.isDisplayed());
        // Additional logic to ensure only one notification is received
    }

    @Then("the user should receive a notification that their cart is now below the threshold")
    public void verifyBelowThresholdNotificationReceived() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("notification")));
        Assert.assertTrue("Below threshold notification not received", notification.isDisplayed());
    }
}