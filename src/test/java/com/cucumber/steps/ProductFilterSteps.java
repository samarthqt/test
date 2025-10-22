package com.cucumber.steps;
import io.cucumber.java.en.When;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import com.pageobjects.ProductFilterPage;

public class ProductFilterSteps extends ProductFilterPage {

    @Given("the user navigates to the product search page")
    public void theUserNavigatesToTheProductSearchPage() {
        navigateToProductSearchPage();
    }

    @When("the user selects {string} from the category filter")
    public void theUserSelectsCategoryFromTheCategoryFilter(String category) {
        selectCategoryFilter(category);
    }

    @Then("only products from the {string} category are displayed")
    public void onlyProductsFromTheCategoryAreDisplayed(String category) {
        verifyProductsDisplayedByCategory(category);
    }
}