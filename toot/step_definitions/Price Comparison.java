import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class PriceComparisonSteps {
    WebDriver driver;
    WebDriverWait wait;
    ProductComparisonPage comparisonPage;

    public PriceComparisonSteps() {
        this.driver = Hooks.getDriver();
        this.wait = new WebDriverWait(driver, 10);
        this.comparisonPage = new ProductComparisonPage(driver);
    }

    @Given("I am on the product comparison page")
    public void i_am_on_the_product_comparison_page() {
        driver.get("http://example.com/product-comparison");
    }

    @When("I select two similar products to compare")
    public void i_select_two_similar_products_to_compare() {
        comparisonPage.selectProduct(1);
        comparisonPage.selectProduct(2);
    }

    @Then("I should see a side-by-side comparison of the products' features")
    public void i_should_see_a_side_by_side_comparison_of_the_products_features() {
        Assert.assertTrue(comparisonPage.isComparisonDisplayed());
    }

    @Then("I should see the price difference between the two products")
    public void i_should_see_the_price_difference_between_the_two_products() {
        Assert.assertTrue(comparisonPage.isPriceDifferenceDisplayed());
    }

    @When("I select multiple similar products to compare")
    public void i_select_multiple_similar_products_to_compare() {
        comparisonPage.selectProduct(1);
        comparisonPage.selectProduct(2);
        comparisonPage.selectProduct(3);
    }

    @Then("I should see the price differences among the selected products")
    public void i_should_see_the_price_differences_among_the_selected_products() {
        Assert.assertTrue(comparisonPage.arePriceDifferencesDisplayed());
    }

    @When("I do not select any products to compare")
    public void i_do_not_select_any_products_to_compare() {
        // No action needed
    }

    @Then("I should see a message indicating that no products have been selected for comparison")
    public void i_should_see_a_message_indicating_that_no_products_have_been_selected_for_comparison() {
        Assert.assertTrue(comparisonPage.isNoSelectionMessageDisplayed());
    }

    @When("I select products with different attributes to compare")
    public void i_select_products_with_different_attributes_to_compare() {
        comparisonPage.selectProduct(1);
        comparisonPage.selectProduct(4);
    }

    @Then("I should see the attributes that are not comparable highlighted or noted")
    public void i_should_see_the_attributes_that_are_not_comparable_highlighted_or_noted() {
        Assert.assertTrue(comparisonPage.areNonComparableAttributesHighlighted());
    }

    @When("I select products with similar prices to compare")
    public void i_select_products_with_similar_prices_to_compare() {
        comparisonPage.selectProduct(2);
        comparisonPage.selectProduct(3);
    }

    @Then("I should see a message indicating that the prices are similar")
    public void i_should_see_a_message_indicating_that_the_prices_are_similar() {
        Assert.assertTrue(comparisonPage.isSimilarPriceMessageDisplayed());
    }

    @When("I select a product from the comparison list")
    public void i_select_a_product_from_the_comparison_list() {
        comparisonPage.selectProductForDetails(1);
    }

    @Then("I should be able to view detailed information about the selected product")
    public void i_should_be_able_to_view_detailed_information_about_the_selected_product() {
        Assert.assertTrue(comparisonPage.isProductDetailDisplayed());
    }

    @Given("I have selected products for comparison")
    public void i_have_selected_products_for_comparison() {
        comparisonPage.selectProduct(1);
        comparisonPage.selectProduct(2);
    }

    @When("I choose to reset the comparison selection")
    public void i_choose_to_reset_the_comparison_selection() {
        comparisonPage.resetSelection();
    }

    @Then("all selected products should be deselected")
    public void all_selected_products_should_be_deselected() {
        Assert.assertTrue(comparisonPage.areAllProductsDeselected());
    }

    @Then("the comparison page should be reset to its initial state")
    public void the_comparison_page_should_be_reset_to_its_initial_state() {
        Assert.assertTrue(comparisonPage.isPageReset());
    }
}