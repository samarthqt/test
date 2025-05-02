package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DiscountApplicationSteps extends DiscountPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user has added eligible products to the cart")
    public void aUserHasAddedEligibleProductsToTheCart() {
        String productName = testHarness.getData("DiscountData", "EligibleProductName");
        addProductToCart(productName);
    }

    @When("the user proceeds to checkout")
    public void theUserProceedsToCheckout() {
        proceedToCheckout();
    }

    @Then("applicable discounts should be automatically applied to the eligible products")
    public void applicableDiscountsShouldBeAutomaticallyAppliedToTheEligibleProducts() {
        verifyDiscountsApplied();
    }

    @Then("the user should see the updated total price reflecting the discounts")
    public void theUserShouldSeeTheUpdatedTotalPriceReflectingTheDiscounts() {
        verifyUpdatedTotalPrice();
    }

    @When("the user views the cart")
    public void theUserViewsTheCart() {
        openCart();
    }

    @Then("the user should see discount details for each eligible product")
    public void theUserShouldSeeDiscountDetailsForEachEligibleProduct() {
        verifyDiscountDetails();
    }

    @Then("the total savings should be displayed")
    public void theTotalSavingsShouldBeDisplayed() {
        verifyTotalSavingsDisplayed();
    }

    @Given("a user has added ineligible products to the cart")
    public void aUserHasAddedIneligibleProductsToTheCart() {
        String productName = testHarness.getData("DiscountData", "IneligibleProductName");
        addProductToCart(productName);
    }

    @Then("no discounts should be applied to the ineligible products")
    public void noDiscountsShouldBeAppliedToTheIneligibleProducts() {
        verifyNoDiscountsApplied();
    }

    @Then("the total price should be calculated without any discounts")
    public void theTotalPriceShouldBeCalculatedWithoutAnyDiscounts() {
        verifyTotalPriceWithoutDiscounts();
    }

    @Given("a user has added a product eligible for multiple discounts to the cart")
    public void aUserHasAddedAProductEligibleForMultipleDiscountsToTheCart() {
        String productName = testHarness.getData("DiscountData", "MultipleDiscountProductName");
        addProductToCart(productName);
    }

    @Then("all applicable discounts should be applied to the product")
    public void allApplicableDiscountsShouldBeAppliedToTheProduct() {
        verifyMultipleDiscountsApplied();
    }

    @Given("a returning user has added eligible products to the cart")
    public void aReturningUserHasAddedEligibleProductsToTheCart() {
        String productName = testHarness.getData("DiscountData", "ReturningUserProductName");
        addProductToCart(productName);
    }

    @Then("loyalty discounts should be automatically applied to the eligible products")
    public void loyaltyDiscountsShouldBeAutomaticallyAppliedToTheEligibleProducts() {
        verifyLoyaltyDiscountsApplied();
    }

    @Given("a user has added eligible products to the cart during a promotional period")
    public void aUserHasAddedEligibleProductsToTheCartDuringAPromotionalPeriod() {
        String productName = testHarness.getData("DiscountData", "PromotionalPeriodProductName");
        addProductToCart(productName);
    }

    @Then("promotional discounts should be automatically applied to the eligible products")
    public void promotionalDiscountsShouldBeAutomaticallyAppliedToTheEligibleProducts() {
        verifyPromotionalDiscountsApplied();
    }

    @Then("no duplicate discounts should be applied to the eligible products")
    public void noDuplicateDiscountsShouldBeAppliedToTheEligibleProducts() {
        verifyNoDuplicateDiscounts();
    }

    @Then("the total price should accurately reflect the applicable discounts without duplication")
    public void theTotalPriceShouldAccuratelyReflectTheApplicableDiscountsWithoutDuplication() {
        verifyTotalPriceWithoutDuplicateDiscounts();
    }
}