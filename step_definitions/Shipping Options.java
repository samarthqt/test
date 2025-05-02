package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShippingOptionsSteps extends ShippingOptionsPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is on the checkout page")
    public void theUserIsOnTheCheckoutPage() {
        navigateToCheckoutPage();
    }

    @When("the user is presented with shipping options")
    public void theUserIsPresentedWithShippingOptions() {
        displayShippingOptions();
    }

    @Then("the user should see options for different delivery speeds")
    public void theUserShouldSeeOptionsForDifferentDeliverySpeeds() {
        verifyDeliverySpeedOptions();
    }

    @Then("the user selects a shipping option based on preferred delivery speed")
    public void theUserSelectsAShippingOptionBasedOnPreferredDeliverySpeed() {
        String preferredSpeed = testHarness.getData("ShippingData", "PreferredSpeed");
        selectShippingOptionBySpeed(preferredSpeed);
    }

    @Then("the selected shipping option should be displayed in the order summary")
    public void theSelectedShippingOptionShouldBeDisplayedInTheOrderSummary() {
        verifySelectedShippingOptionInSummary();
    }

    @When("the user enters their delivery location")
    public void theUserEntersTheirDeliveryLocation() {
        String location = testHarness.getData("ShippingData", "Location");
        enterDeliveryLocation(location);
    }

    @Then("the user should see shipping options available for their location")
    public void theUserShouldSeeShippingOptionsAvailableForTheirLocation() {
        verifyLocationBasedShippingOptions();
    }

    @Then("the user selects a shipping option based on preferred delivery location")
    public void theUserSelectsAShippingOptionBasedOnPreferredDeliveryLocation() {
        String preferredLocation = testHarness.getData("ShippingData", "PreferredLocation");
        selectShippingOptionByLocation(preferredLocation);
    }

    @Given("the user has selected items to purchase")
    public void theUserHasSelectedItemsToPurchase() {
        selectItemsForPurchase();
    }

    @When("the user proceeds to checkout")
    public void theUserProceedsToCheckout() {
        proceedToCheckout();
    }

    @Then("the user should see a list of available shipping options")
    public void theUserShouldSeeAListOfAvailableShippingOptions() {
        displayAvailableShippingOptions();
    }

    @Then("the user reviews the shipping options based on delivery speed and location")
    public void theUserReviewsTheShippingOptionsBasedOnDeliverySpeedAndLocation() {
        reviewShippingOptions();
    }

    @Then("the user selects the most suitable shipping option")
    public void theUserSelectsTheMostSuitableShippingOption() {
        selectMostSuitableShippingOption();
    }

    @Given("the user has initially selected a shipping option")
    public void theUserHasInitiallySelectedAShippingOption() {
        selectInitialShippingOption();
    }

    @When("the user decides to change the shipping option")
    public void theUserDecidesToChangeTheShippingOption() {
        changeShippingOption();
    }

    @Then("the user should be able to view all available shipping options again")
    public void theUserShouldBeAbleToViewAllAvailableShippingOptionsAgain() {
        displayAvailableShippingOptions();
    }

    @Then("the user selects a new shipping option")
    public void theUserSelectsANewShippingOption() {
        selectNewShippingOption();
    }

    @Given("the user is on the shipping options page")
    public void theUserIsOnTheShippingOptionsPage() {
        navigateToShippingOptionsPage();
    }

    @When("the user reviews the available shipping options")
    public void theUserReviewsTheAvailableShippingOptions() {
        reviewAvailableShippingOptions();
    }

    @Then("the user should see the cost associated with each shipping option")
    public void theUserShouldSeeTheCostAssociatedWithEachShippingOption() {
        verifyShippingOptionCosts();
    }

    @Then("the user selects a shipping option based on cost preference")
    public void theUserSelectsAShippingOptionBasedOnCostPreference() {
        String costPreference = testHarness.getData("ShippingData", "CostPreference");
        selectShippingOptionByCost(costPreference);
    }

    @Then("the selected shipping option cost should be displayed in the order summary")
    public void theSelectedShippingOptionCostShouldBeDisplayedInTheOrderSummary() {
        verifySelectedShippingOptionCostInSummary();
    }
}