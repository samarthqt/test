package com.cucumber.steps;
import io.cucumber.java.en.When;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import com.framework.cucumber.TestHarness;

import com.pageobjects.SearchPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

public class SearchPerformanceSteps extends SearchPage {

    @Given("a large product dataset is available")
    public void aLargeProductDatasetIsAvailable() {
        loadLargeDataset();
    }

    @When("the user enters {string} in the search bar")
    public void theUserEntersInTheSearchBar(String searchKeyword) {
        enterSearchKeyword(searchKeyword);
    }

    @When("the user initiates the search")
    public void theUserInitiatesTheSearch() {
        initiateSearch();
    }

    @Then("the search results should be displayed promptly without delay")
    public void theSearchResultsShouldBeDisplayedPromptlyWithoutDelay() {
        verifySearchResultsDisplayedPromptly();
    }
}