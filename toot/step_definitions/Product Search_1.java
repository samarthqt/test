import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ProductSearchSteps {
    WebDriver driver;
    WebDriverWait wait;
    ProductSearchPage productSearchPage;

    @Given("the user is on the product search page")
    public void the_user_is_on_the_product_search_page() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        productSearchPage = new ProductSearchPage(driver);
        driver.get("http://example.com/product-search");
    }

    @When("the user enters a product name in the search bar")
    public void the_user_enters_a_product_name_in_the_search_bar() {
        productSearchPage.enterSearchQuery("Laptop");
    }

    @When("the user selects a category from the category dropdown")
    public void the_user_selects_a_category_from_the_category_dropdown() {
        productSearchPage.selectCategory("Electronics");
    }

    @When("the user enters a non-existent product name in the search bar")
    public void the_user_enters_a_non_existent_product_name_in_the_search_bar() {
        productSearchPage.enterSearchQuery("NonExistentProduct");
    }

    @When("the user enters special characters in the search bar")
    public void the_user_enters_special_characters_in_the_search_bar() {
        productSearchPage.enterSearchQuery("@#$%^&*");
    }

    @When("the user leaves the search bar empty")
    public void the_user_leaves_the_search_bar_empty() {
        productSearchPage.enterSearchQuery("");
    }

    @When("the user enters a partial product name in the search bar")
    public void the_user_enters_a_partial_product_name_in_the_search_bar() {
        productSearchPage.enterSearchQuery("Lap");
    }

    @When("the user enters a product name in the search bar with different case")
    public void the_user_enters_a_product_name_in_the_search_bar_with_different_case() {
        productSearchPage.enterSearchQuery("laptop");
    }

    @When("clicks the search button")
    public void clicks_the_search_button() {
        productSearchPage.clickSearchButton();
    }

    @Then("the system should display a list of products that match the entered name")
    public void the_system_should_display_a_list_of_products_that_match_the_entered_name() {
        Assert.assertTrue(productSearchPage.isProductListDisplayed());
    }

    @Then("the system should display a list of products that belong to the selected category")
    public void the_system_should_display_a_list_of_products_that_belong_to_the_selected_category() {
        Assert.assertTrue(productSearchPage.isProductListDisplayed());
    }

    @Then("the system should display a message indicating no products were found")
    public void the_system_should_display_a_message_indicating_no_products_were_found() {
        Assert.assertTrue(productSearchPage.isNoProductsFoundMessageDisplayed());
    }

    @Then("the system should handle the input gracefully and display a message if no products are found")
    public void the_system_should_handle_the_input_gracefully_and_display_a_message_if_no_products_are_found() {
        Assert.assertTrue(productSearchPage.isNoProductsFoundMessageDisplayed());
    }

    @Then("the system should prompt the user to enter a search term")
    public void the_system_should_prompt_the_user_to_enter_a_search_term() {
        Assert.assertTrue(productSearchPage.isEnterSearchTermPromptDisplayed());
    }

    @Then("the system should display a list of products that match the partial name")
    public void the_system_should_display_a_list_of_products_that_match_the_partial_name() {
        Assert.assertTrue(productSearchPage.isProductListDisplayed());
    }

    @Then("the system should display a list of products that match the entered name regardless of case")
    public void the_system_should_display_a_list_of_products_that_match_the_entered_name_regardless_of_case() {
        Assert.assertTrue(productSearchPage.isProductListDisplayed());
    }
}