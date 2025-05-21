import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class StockWarningSteps {

    WebDriver driver;
    WebDriverWait wait;
    InventoryPage inventoryPage;

    @Given("the product inventory system is operational")
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        inventoryPage = new InventoryPage(driver);
        driver.get("http://example.com/inventory");
    }

    @Given("a product with a stock threshold set to {int} units")
    public void setProductThreshold(int threshold) {
        inventoryPage.setProductThreshold(threshold);
    }

    @Given("the current stock level is {int} units")
    public void setCurrentStockLevel(int stockLevel) {
        inventoryPage.setCurrentStockLevel(stockLevel);
    }

    @When("the inventory system checks the stock level")
    public void checkStockLevel() {
        inventoryPage.checkStockLevel();
    }

    @Then("a warning message should be displayed indicating the stock is low")
    public void verifyWarningMessageDisplayed() {
        Assert.assertTrue("Warning message not displayed", inventoryPage.isWarningMessageDisplayed());
    }

    @Then("no warning message should be displayed")
    public void verifyNoWarningMessageDisplayed() {
        Assert.assertFalse("Warning message displayed", inventoryPage.isWarningMessageDisplayed());
    }

    @Given("a warning message is displayed")
    public void warningMessageIsDisplayed() {
        Assert.assertTrue("Warning message not displayed", inventoryPage.isWarningMessageDisplayed());
    }

    @When("the stock level is updated to {int} units")
    public void updateStockLevel(int newStockLevel) {
        inventoryPage.updateStockLevel(newStockLevel);
    }

    @Then("the warning message should be removed")
    public void verifyWarningMessageRemoved() {
        Assert.assertFalse("Warning message not removed", inventoryPage.isWarningMessageDisplayed());
    }

    @Given("products with the following stock thresholds and current stock levels:")
    public void setMultipleProductsStockLevels(DataTable dataTable) {
        List<Map<String, String>> products = dataTable.asMaps(String.class, String.class);
        inventoryPage.setMultipleProductsStockLevels(products);
    }

    @Then("a warning message should be displayed for Product ID {int} indicating the stock is low")
    public void verifyWarningMessageForProduct(int productId) {
        Assert.assertTrue("Warning message not displayed for Product ID " + productId, inventoryPage.isWarningMessageDisplayedForProduct(productId));
    }

    @Then("no warning message should be displayed for Product ID {int}")
    public void verifyNoWarningMessageForProduct(int productId) {
        Assert.assertFalse("Warning message displayed for Product ID " + productId, inventoryPage.isWarningMessageDisplayedForProduct(productId));
    }
}