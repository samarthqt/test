import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PriceHistorySteps {
    WebDriver driver;
    WebDriverWait wait;
    ProductPage productPage;

    @Given("a user is on the product pricing page")
    public void user_on_product_pricing_page() {
        driver.get("http://example.com/product-pricing");
        productPage = new ProductPage(driver);
    }

    @Given("a product with a known price history")
    public void product_with_known_price_history() {
        productPage.selectProductWithPriceHistory();
    }

    @When("the user views the product details")
    public void user_views_product_details() {
        productPage.viewProductDetails();
    }

    @Then("the price history of the product should be displayed")
    public void price_history_should_be_displayed() {
        Assert.assertTrue(productPage.isPriceHistoryDisplayed());
    }

    @Then("the user should be able to see historical prices and dates")
    public void user_sees_historical_prices_and_dates() {
        Assert.assertTrue(productPage.areHistoricalPricesAndDatesVisible());
    }

    @Given("a product has had price changes over time")
    public void product_with_price_changes() {
        productPage.selectProductWithPriceChanges();
    }

    @When("the user views the price history")
    public void user_views_price_history() {
        productPage.viewPriceHistory();
    }

    @Then("the user should be able to identify periods of discounts")
    public void user_identifies_discount_periods() {
        Assert.assertTrue(productPage.canIdentifyDiscountPeriods());
    }

    @Given("a product with no recorded price history")
    public void product_with_no_price_history() {
        productPage.selectProductWithNoPriceHistory();
    }

    @Then("a message should be displayed stating \"No price history available\"")
    public void no_price_history_message_displayed() {
        Assert.assertTrue(productPage.isNoPriceHistoryMessageDisplayed());
    }

    @Then("the price history should be displayed in a chronological order")
    public void price_history_chronological_order() {
        Assert.assertTrue(productPage.isPriceHistoryChronological());
    }

    @Then("each entry should show the date and price")
    public void each_entry_shows_date_and_price() {
        Assert.assertTrue(productPage.areEntriesShowingDateAndPrice());
    }

    @When("the user interacts with the price history graph or list")
    public void user_interacts_with_price_history() {
        productPage.interactWithPriceHistory();
    }

    @Then("the user should be able to hover over points to see exact prices and dates")
    public void user_hovers_over_points() {
        Assert.assertTrue(productPage.canHoverOverPointsForDetails());
    }

    @Given("a user with accessibility needs")
    public void user_with_accessibility_needs() {
        productPage.enableAccessibilityFeatures();
    }

    @When("the user accesses the price history feature")
    public void user_accesses_price_history_feature() {
        productPage.accessPriceHistoryFeature();
    }

    @Then("the feature should be compatible with screen readers")
    public void feature_compatible_with_screen_readers() {
        Assert.assertTrue(productPage.isCompatibleWithScreenReaders());
    }

    @Then("all elements should have appropriate labels for accessibility")
    public void elements_have_accessibility_labels() {
        Assert.assertTrue(productPage.areElementsLabeledForAccessibility());
    }

    @When("the user applies a date range filter")
    public void user_applies_date_range_filter() {
        productPage.applyDateRangeFilter();
    }

    @Then("only the price history within the selected date range should be displayed")
    public void filtered_price_history_displayed() {
        Assert.assertTrue(productPage.isFilteredPriceHistoryDisplayed());
    }
}