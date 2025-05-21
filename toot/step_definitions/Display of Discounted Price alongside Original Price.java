import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class DiscountPriceStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;

    public DiscountPriceStepDefinitions() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void givenIAmOnTheProductPricingPage() {
        driver.get("http://example.com/product-pricing");
    }

    public void givenAProductHasAnOriginalPriceOf(String price) {
        WebElement originalPriceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("original_price")));
        Assert.assertEquals(price, originalPriceElement.getText());
    }

    public void givenTheProductHasADiscountOf(String discount) {
        WebElement discountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("discount")));
        Assert.assertEquals(discount, discountElement.getText());
    }

    public void whenIViewTheProductPricingDetails() {
        WebElement viewDetailsButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("view_details")));
        viewDetailsButton.click();
    }

    public void thenIShouldSeeTheOriginalPriceDisplayedAs(String price) {
        WebElement originalPriceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("original_price_display")));
        Assert.assertEquals(price, originalPriceElement.getText());
    }

    public void andIShouldSeeTheDiscountedPriceDisplayedAs(String discountedPrice) {
        WebElement discountedPriceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("discounted_price_display")));
        Assert.assertEquals(discountedPrice, discountedPriceElement.getText());
    }

    public void andTheProductHasNoDiscount() {
        WebElement discountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("discount")));
        Assert.assertEquals("0%", discountElement.getText());
    }

    public void andIShouldNotSeeAnyDiscountedPriceDisplayed() {
        WebElement discountedPriceElement = driver.findElement(By.id("discounted_price_display"));
        Assert.assertFalse(discountedPriceElement.isDisplayed());
    }

    public void givenTheFollowingProductsExist(String productName, String originalPrice, String discount) {
        WebElement productElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='products']//tr[td[text()='" + productName + "']]")));
        WebElement originalPriceElement = productElement.findElement(By.className("original_price"));
        WebElement discountElement = productElement.findElement(By.className("discount"));
        Assert.assertEquals(originalPrice, originalPriceElement.getText());
        Assert.assertEquals(discount, discountElement.getText());
    }

    public void thenIShouldSeeTheOriginalPriceForDisplayedAs(String productName, String price) {
        WebElement productElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='products']//tr[td[text()='" + productName + "']]")));
        WebElement originalPriceElement = productElement.findElement(By.className("original_price_display"));
        Assert.assertEquals(price, originalPriceElement.getText());
    }

    public void andIShouldSeeTheDiscountedPriceForDisplayedAs(String productName, String discountedPrice) {
        WebElement productElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='products']//tr[td[text()='" + productName + "']]")));
        WebElement discountedPriceElement = productElement.findElement(By.className("discounted_price_display"));
        Assert.assertEquals(discountedPrice, discountedPriceElement.getText());
    }

    public void whenICalculateTheDiscountedPrice() {
        WebElement calculateButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("calculate_discounted_price")));
        calculateButton.click();
    }

    public void thenTheDiscountedPriceShouldBeCalculatedAs(String discountedPrice) {
        WebElement discountedPriceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("calculated_discounted_price")));
        Assert.assertEquals(discountedPrice, discountedPriceElement.getText());
    }

    public void givenAProductHasAnInvalidDiscountOf(String discount) {
        WebElement discountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("discount")));
        Assert.assertEquals(discount, discountElement.getText());
    }

    public void thenIShouldSeeAMessageIndicating(String message) {
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("discount_message")));
        Assert.assertEquals(message, messageElement.getText());
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}