package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TaxCalculationSteps extends TaxCalculationPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user is located in a region with a specific tax rate")
    public void userLocatedInRegionWithSpecificTaxRate() {
        String region = testHarness.getData("UserData", "Region");
        setUserRegion(region);
    }

    @When("the user adds items to their cart")
    public void userAddsItemsToCart() {
        addItemsToCart();
    }

    @When("proceeds to checkout")
    public void userProceedsToCheckout() {
        proceedToCheckout();
    }

    @Then("the system should automatically calculate the taxes based on the user's location")
    public void systemCalculatesTaxesBasedOnLocation() {
        calculateTaxes();
    }

    @Then("display the accurate pricing including taxes")
    public void displayAccuratePricingIncludingTaxes() {
        verifyPricingWithTaxes();
    }

    @Given("a user is located in region A with tax rate X")
    public void userLocatedInRegionAWithTaxRateX() {
        setUserRegion("RegionA");
    }

    @Then("the system should calculate the taxes as X% of the total cart value")
    public void systemCalculatesTaxesAsXPercent() {
        verifyTaxCalculation("X");
    }

    @Given("a user is located in region B with tax rate Y")
    public void userLocatedInRegionBWithTaxRateY() {
        setUserRegion("RegionB");
    }

    @Then("the system should calculate the taxes as Y% of the total cart value")
    public void systemCalculatesTaxesAsYPercent() {
        verifyTaxCalculation("Y");
    }

    @Given("a user is located in a tax-exempt region")
    public void userLocatedInTaxExemptRegion() {
        setUserRegion("TaxExempt");
    }

    @Then("the system should not apply any taxes")
    public void systemDoesNotApplyTaxes() {
        verifyNoTaxApplied();
    }

    @Then("display the pricing without any tax inclusion")
    public void displayPricingWithoutTaxInclusion() {
        verifyPricingWithoutTaxes();
    }

    @Given("a user initially located in region C with tax rate Z")
    public void userInitiallyLocatedInRegionCWithTaxRateZ() {
        setUserRegion("RegionC");
    }

    @When("the user changes their location to region D with tax rate W")
    public void userChangesLocationToRegionDWithTaxRateW() {
        changeUserRegion("RegionD");
    }

    @Then("the system should update the tax calculation based on the new location")
    public void systemUpdatesTaxCalculationBasedOnNewLocation() {
        updateTaxCalculation();
    }

    @Then("display the pricing including the updated tax rate")
    public void displayPricingIncludingUpdatedTaxRate() {
        verifyUpdatedPricingWithTaxes();
    }

    @Given("a user is eligible for a promotional discount")
    public void userEligibleForPromotionalDiscount() {
        applyPromotionalDiscount();
    }

    @Given("is located in a region with a specific tax rate")
    public void userLocatedInRegionWithSpecificTaxRateForPromotion() {
        setUserRegion("PromotionRegion");
    }

    @When("the user applies the discount to their cart")
    public void userAppliesDiscountToCart() {
        applyDiscountToCart();
    }

    @Then("the system should calculate the taxes after applying the discount")
    public void systemCalculatesTaxesAfterDiscount() {
        calculateTaxesAfterDiscount();
    }

    @Then("display the final pricing including taxes and discount adjustments")
    public void displayFinalPricingIncludingTaxesAndDiscount() {
        verifyFinalPricingWithTaxesAndDiscount();
    }
}