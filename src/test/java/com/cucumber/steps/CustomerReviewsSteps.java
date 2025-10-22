package com.cucumber.steps;
import io.cucumber.java.en.When;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import com.framework.cucumber.TestHarness;

import com.pageobjects.ProductPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

public class CustomerReviewsSteps extends ProductPage {

    @Given("user navigates to the product detail page for {string}")
    public void userNavigatesToTheProductDetailPageFor(String productName) {
        navigateToProductDetailPage(productName);
    }

    @When("user scrolls to the reviews and ratings section")
    public void userScrollsToTheReviewsAndRatingsSection() {
        scrollToReviewsSection();
    }

    @Then("customer reviews and ratings are displayed correctly")
    public void customerReviewsAndRatingsAreDisplayedCorrectly() {
        verifyReviewsAndRatingsDisplayed();
    }
}