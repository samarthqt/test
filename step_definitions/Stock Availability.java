package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StockAvailabilitySteps extends StockAvailabilityPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user navigates to a product page")
    public void aUserNavigatesToAProductPage() {
        String productPageURL = testHarness.getData("StockData", "ProductPageURL");
        navigateToPage(productPageURL);
    }

    @When("the product page loads")
    public void theProductPageLoads() {
        verifyPageLoaded();
    }

    @Then("the user should see the real-time stock availability information for the item")
    public void theUserShouldSeeTheRealTimeStockAvailabilityInformationForTheItem() {
        verifyStockAvailabilityDisplayed();
    }

    @Given("a user is on a product page")
    public void aUserIsOnAProductPage() {
        String productPageURL = testHarness.getData("StockData", "ProductPageURL");
        navigateToPage(productPageURL);
    }

    @When("the stock quantity changes due to a purchase or restock")
    public void theStockQuantityChangesDueToAPurchaseOrRestock() {
        simulateStockChange();
    }

    @Then("the stock availability information should update in real-time")
    public void theStockAvailabilityInformationShouldUpdateInRealTime() {
        verifyStockAvailabilityUpdated();
    }

    @When("the item becomes out of stock")
    public void theItemBecomesOutOfStock() {
        simulateOutOfStock();
    }

    @Then("the user should be notified that the item is out of stock")
    public void theUserShouldBeNotifiedThatTheItemIsOutOfStock() {
        verifyOutOfStockNotification();
    }

    @Given("a user is on a product page with multiple variations \(e.g., color, size\)")
    public void aUserIsOnAProductPageWithMultipleVariations() {
        String productPageURL = testHarness.getData("StockData", "ProductPageURL");
        navigateToPage(productPageURL);
    }

    @When("the user selects a different product variation")
    public void theUserSelectsADifferentProductVariation() {
        selectProductVariation();
    }

    @Then("the stock availability information should update to reflect the selected variation")
    public void theStockAvailabilityInformationShouldUpdateToReflectTheSelectedVariation() {
        verifyStockAvailabilityForVariation();
    }

    @When("the user views the stock availability information")
    public void theUserViewsTheStockAvailabilityInformation() {
        viewStockAvailability();
    }

    @Then("the information should accurately reflect the current stock status of the item")
    public void theInformationShouldAccuratelyReflectTheCurrentStockStatusOfTheItem() {
        verifyAccurateStockInformation();
    }
}