package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import com.page_objects.OrderConfirmationPage;

public class OrderConfirmationSteps extends OrderConfirmationPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has completed a purchase transaction")
    public void theUserHasCompletedAPurchaseTransaction() {
        completePurchaseTransaction();
    }

    @When("the user navigates to the order confirmation page")
    public void theUserNavigatesToTheOrderConfirmationPage() {
        navigateToOrderConfirmationPage();
    }

    @Then("the order confirmation page is displayed")
    public void theOrderConfirmationPageIsDisplayed() {
        verifyOrderConfirmationPageDisplayed();
    }

    @Then("the order number '12345' is displayed")
    public void theOrderNumberIsDisplayed() {
        verifyOrderNumberDisplayed("12345");
    }

    @Then("the shipping address '123 Main St, Springfield' is displayed")
    public void theShippingAddressIsDisplayedCorrectly() {
        verifyShippingAddressDisplayed("123 Main St, Springfield");
    }

    @Then("the items '1x Laptop, 2x Mouse' are listed")
    public void theItemsAreListed() {
        verifyItemsListed("1x Laptop, 2x Mouse");
    }

    @Then("the item quantities match the purchase order")
    public void theItemQuantitiesMatchThePurchaseOrder() {
        verifyItemQuantitiesMatch();
    }

    @Then("the item prices are accurate as per the purchase order")
    public void theItemPricesAreDisplayedCorrectly() {
        verifyItemPricesDisplayedCorrectly();
    }

    @Then("the total amount matches the purchase order")
    public void theTotalAmountMatchesThePurchaseTotal() {
        verifyTotalAmountMatches();
    }

    @Then("the estimated delivery date is displayed")
    public void theEstimatedDeliveryDateIsProvided() {
        verifyEstimatedDeliveryDateDisplayed();
    }

    @Then("the payment method is displayed")
    public void thePaymentMethodUsedIsListed() {
        verifyPaymentMethodDisplayed();
    }

    @Then("customer support contact information is displayed")
    public void customerSupportContactInformationIsProvided() {
        verifyCustomerSupportContactInformationDisplayed();
    }

    @Then("a tracking link is available")
    public void aLinkToTrackTheOrderIsAvailable() {
        verifyTrackingLinkAvailable();
    }

    @Then("the page layout is clear and information is easily readable")
    public void thePageLayoutIsUserFriendlyAndInformationIsLegible() {
        verifyPageLayoutIsUserFriendly();
    }

    @Then("a print option is available")
    public void thereIsAnOptionToPrintTheConfirmation() {
        verifyPrintOptionAvailable();
    }

    @Then("an email option is available")
    public void thereIsAnOptionToSendTheConfirmationToAnEmail() {
        verifyEmailOptionAvailable();
    }

    @Then("promotional offers or discounts are displayed if applicable")
    public void promotionalOffersOrDiscountsAreDisplayedIfApplicable() {
        verifyPromotionalOffersDisplayed();
    }
}