package com.cucumber.steps;

import com.pageobjects.ProductSearchPage;
import io.cucumber.java.en.When;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

public class ProductSearchSteps extends ProductSearchPage {

    @Given("user navigates to the product search page")
    public void userNavigatesToTheProductSearchPage() {
        navigateToSearchPage();
    }

    @When("user enters {string} in the search bar")
    public void userEntersInTheSearchBar(String searchKeyword) {
        enterSearchKeyword(searchKeyword);
    }

    @When("user selects the 'Search' option")
    public void userSelectsTheSearchOption() {
        clickSearchButton();
    }

    @Then("relevant products related to {string} are displayed")
    public void relevantProductsRelatedToAreDisplayed(String searchKeyword) {
        verifySearchResults(searchKeyword);
    }
}