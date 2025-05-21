import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductFiltersStepDefinitions {
    private WebDriver driver;
    private WebDriverWait wait;
    private ProductSearchPage productSearchPage;

    @Given("the user is on the product search results page")
    public void the_user_is_on_the_product_search_results_page() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        productSearchPage = new ProductSearchPage(driver);
        driver.get("http://example.com/products");
    }

    @When("the user selects a price range filter")
    public void the_user_selects_a_price_range_filter() {
        productSearchPage.selectPriceRangeFilter("$10 - $50");
    }

    @Then("the search results should only display products within the selected price range")
    public void the_search_results_should_only_display_products_within_the_selected_price_range() {
        Assert.assertTrue(productSearchPage.areProductsWithinPriceRange("$10 - $50"));
    }

    @When("the user selects a rating filter")
    public void the_user_selects_a_rating_filter() {
        productSearchPage.selectRatingFilter(4);
    }

    @Then("the search results should only display products with the selected rating or higher")
    public void the_search_results_should_only_display_products_with_the_selected_rating_or_higher() {
        Assert.assertTrue(productSearchPage.areProductsWithRatingOrHigher(4));
    }

    @When("the user selects both price and rating filters")
    public void the_user_selects_both_price_and_rating_filters() {
        productSearchPage.selectPriceRangeFilter("$10 - $50");
        productSearchPage.selectRatingFilter(4);
    }

    @Then("the search results should only display products that meet both the selected price range and rating criteria")
    public void the_search_results_should_only_display_products_that_meet_both_the_selected_price_range_and_rating_criteria() {
        Assert.assertTrue(productSearchPage.areProductsMeetingBothCriteria("$10 - $50", 4));
    }

    @Given("the user has applied one or more filters")
    public void the_user_has_applied_one_or_more_filters() {
        productSearchPage.selectPriceRangeFilter("$10 - $50");
    }

    @When("the user clears all filters")
    public void the_user_clears_all_filters() {
        productSearchPage.clearAllFilters();
    }

    @Then("the search results should display all products without any applied filters")
    public void the_search_results_should_display_all_products_without_any_applied_filters() {
        Assert.assertTrue(productSearchPage.areAllProductsDisplayed());
    }

    @Given("the user has applied a price filter")
    public void the_user_has_applied_a_price_filter() {
        productSearchPage.selectPriceRangeFilter("$10 - $50");
    }

    @When("the user modifies the price filter to a different range")
    public void the_user_modifies_the_price_filter_to_a_different_range() {
        productSearchPage.selectPriceRangeFilter("$20 - $70");
    }

    @Then("the search results should update to display products within the new price range")
    public void the_search_results_should_update_to_display_products_within_the_new_price_range() {
        Assert.assertTrue(productSearchPage.areProductsWithinPriceRange("$20 - $70"));
    }
}