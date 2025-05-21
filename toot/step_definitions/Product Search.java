import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class ProductSearchSteps {
    WebDriver driver;
    WebDriverWait wait;
    ProductSearchPage productSearchPage;

    @Given("I am on the product search page")
    public void i_am_on_the_product_search_page() {
        driver.get("http://example.com/product-search");
        productSearchPage = new ProductSearchPage(driver);
    }

    @When("I enter {string} in the search bar")
    public void i_enter_in_the_search_bar(String productName) {
        productSearchPage.enterSearchQuery(productName);
    }

    @When("I select {string} from the category dropdown")
    public void i_select_from_the_category_dropdown(String category) {
        productSearchPage.selectCategory(category);
    }

    @When("I leave the search bar empty")
    public void i_leave_the_search_bar_empty() {
        productSearchPage.enterSearchQuery("");
    }

    @When("I click on the search button")
    public void i_click_on_the_search_button() {
        productSearchPage.clickSearchButton();
    }

    @Then("I should see a list of products with names containing {string}")
    public void i_should_see_a_list_of_products_with_names_containing(String productName) {
        Assert.assertTrue(productSearchPage.isProductListDisplayed(productName));
    }

    @Then("I should see a list of products under the {string} category")
    public void i_should_see_a_list_of_products_under_the_category(String category) {
        Assert.assertTrue(productSearchPage.isCategoryListDisplayed(category));
    }

    @Then("I should see a message {string}")
    public void i_should_see_a_message(String message) {
        Assert.assertEquals(message, productSearchPage.getNoProductsMessage());
    }

    @Then("I should see a validation message {string}")
    public void i_should_see_a_validation_message(String validationMessage) {
        Assert.assertEquals(validationMessage, productSearchPage.getValidationMessage());
    }
}