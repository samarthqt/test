import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class PriceHistoryStepDefinitions {

    WebDriver driver;
    WebDriverWait wait;
    ProductPricingPage productPricingPage;

    public PriceHistoryStepDefinitions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.productPricingPage = new ProductPricingPage(driver);
    }

    public void givenUserIsOnProductPricingPage() {
        driver.get("http://example.com/product-pricing");
    }

    public void givenUserSelectsAProduct() {
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.product-item")));
        product.click();
    }

    public void whenUserRequestsPriceHistory() {
        productPricingPage.clickPriceHistoryButton();
    }

    public void thenSystemShouldDisplayHistoricalPricing() {
        Assert.assertTrue("Price history not displayed", productPricingPage.isPriceHistoryDisplayed());
    }

    public void thenHistoricalPricingShouldBeChronological() {
        Assert.assertTrue("Price history not chronological", productPricingPage.isPriceHistoryChronological());
    }

    public void andEachEntryShouldIncludeDateAndPrice() {
        Assert.assertTrue("Price history entries missing date or price", productPricingPage.areEntriesComplete());
    }

    public void thenUserShouldIdentifyDiscountPeriods() {
        Assert.assertTrue("Discount periods not identifiable", productPricingPage.canIdentifyDiscountPeriods());
    }

    public void whenUserRequestsPriceHistoryForMultipleProducts() {
        productPricingPage.requestPriceHistoryForMultipleProducts();
    }

    public void thenSystemShouldDisplayHistoricalPricingForEachProduct() {
        Assert.assertTrue("Price history not displayed for each product", productPricingPage.isPriceHistoryDisplayedForAllProducts());
    }

    public void givenUserSelectsProductWithNoPriceHistory() {
        productPricingPage.selectProductWithNoPriceHistory();
    }

    public void thenSystemShouldInformNoHistoricalPricingAvailable() {
        Assert.assertTrue("No historical pricing message not displayed", productPricingPage.isNoPriceHistoryMessageDisplayed());
    }

    public void thenSystemShouldProvideHistoricalPricingWithLowPriority() {
        Assert.assertTrue("Historical pricing not provided with low priority", productPricingPage.isLowPriorityPricingProvided());
    }

    public void andSystemPerformanceShouldNotBeImpacted() {
        Assert.assertTrue("System performance impacted", productPricingPage.isPerformanceUnimpacted());
    }
}