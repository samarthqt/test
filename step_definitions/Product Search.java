package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSearchSteps extends ProductSearchPage {

    private TestHarness testHarness = new TestHarness();

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        navigateToHomePage();
    }

    @When("I enter the product name {string} in the search bar")
    public void iEnterTheProductNameInTheSearchBar(String productName) {
        enterProductNameInSearchBar(productName);
    }

    @When("I select the category {string} from the category dropdown")
    public void iSelectTheCategoryFromTheCategoryDropdown(String category) {
        selectCategoryFromDropdown(category);
    }

    @When("I leave the search bar empty")
    public void iLeaveTheSearchBarEmpty() {
        clearSearchBar();
    }

    @When("I enter special characters {string} in the search bar")
    public void iEnterSpecialCharactersInTheSearchBar(String specialChars) {
        enterProductNameInSearchBar(specialChars);
    }

    @And("I click on the search button")
    public void iClickOnTheSearchButton() {
        clickSearchButton();
    }

    @Then("I should see a list of products related to {string}")
    public void iShouldSeeAListOfProductsRelatedTo(String productName) {
        verifyProductsListContains(productName);
    }

    @Then("I should see a list of products under the {string} category")
    public void iShouldSeeAListOfProductsUnderTheCategory(String category) {
        verifyProductsListUnderCategory(category);
    }

    @Then("I should see a message {string}")
    public void iShouldSeeAMessage(String message) {
        verifySearchMessage(message);
    }
}