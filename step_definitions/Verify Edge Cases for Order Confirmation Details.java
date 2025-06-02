package com.cucumber.steps;

import com.page_objects.OrderConfirmationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class OrderConfirmationSteps extends OrderConfirmationPage {

    @Given("the user has completed a purchase transaction with edge case data")
    public void theUserHasCompletedAPurchaseTransactionWithEdgeCaseData() {
        completePurchaseWithEdgeCaseData();
    }

    @When("the user navigates to the order confirmation page")
    public void theUserNavigatesToTheOrderConfirmationPage() {
        navigateToOrderConfirmationPage();
    }

    @Then("the order confirmation page is displayed")
    public void theOrderConfirmationPageIsDisplayed() {
        verifyOrderConfirmationPageDisplayed();
    }

    @Given("the order ID is '99999999999999999999'")
    public void theOrderIDIsMaxDigits() {
        setOrderID("99999999999999999999");
    }

    @Then("the order number '99999999999999999999' is displayed without truncation")
    public void theOrderNumberIsDisplayedWithoutTruncation() {
        verifyOrderNumberDisplayedCorrectly("99999999999999999999");
    }

    @Given("the shipping address exceeds normal limits")
    public void theShippingAddressExceedsNormalLimits() {
        setLongShippingAddress();
    }

    @Then("the shipping address is displayed without truncation or errors")
    public void theShippingAddressIsDisplayedWithoutTruncationOrErrors() {
        verifyShippingAddressDisplayedCorrectly();
    }

    @Given("no items were purchased")
    public void noItemsWerePurchased() {
        setNoItemsPurchased();
    }

    @Then("the system indicates no items were purchased with a user-friendly message")
    public void theSystemIndicatesNoItemsWerePurchased() {
        verifyNoItemsPurchasedMessage();
    }

    @Then("the UI remains intact and user-friendly despite the long address")
    public void theUIRemainsIntactDespiteLongAddress() {
        verifyUIIntegrityWithLongAddress();
    }

    @Then("the total amount is displayed as zero with a message explaining the reason")
    public void theTotalAmountIsDisplayedAsZero() {
        verifyTotalAmountDisplayedAsZero();
    }

    @Then("the message indicates no delivery date due to no items purchased")
    public void theMessageIndicatesNoDeliveryDate() {
        verifyNoDeliveryDateMessage();
    }

    @Then("the payment method is displayed as N/A with a message explaining the reason")
    public void thePaymentMethodIsDisplayedAsNA() {
        verifyPaymentMethodDisplayedAsNA();
    }

    @Then("customer support contact information is displayed")
    public void customerSupportContactInformationIsDisplayed() {
        verifyCustomerSupportContactInformation();
    }

    @Then("the system provides a message indicating the absence of tracking information")
    public void theSystemProvidesMessageForNoTrackingInformation() {
        verifyNoTrackingInformationMessage();
    }

    @Then("the print option is disabled or provides a message about no items")
    public void thePrintOptionIsDisabledOrProvidesMessage() {
        verifyPrintOptionDisabledOrMessage();
    }

    @Then("the email option is disabled or provides a message about no items")
    public void theEmailOptionIsDisabledOrProvidesMessage() {
        verifyEmailOptionDisabledOrMessage();
    }

    @Then("promotional offers or discounts are displayed if applicable, with a message about no items")
    public void promotionalOffersOrDiscountsDisplayedIfApplicable() {
        verifyPromotionalOffersOrDiscounts();
    }

    @Then("the system logs an error for handling edge case order confirmation details for auditing purposes")
    public void theSystemLogsAnErrorForEdgeCaseOrderConfirmation() {
        verifySystemLogsErrorForEdgeCaseOrderConfirmation();
    }

    @Given("multiple edge case orders are placed simultaneously")
    public void multipleEdgeCaseOrdersPlacedSimultaneously() {
        placeMultipleEdgeCaseOrders();
    }

    @Then("the system handles multiple edge case orders without crashing or performance issues")
    public void theSystemHandlesMultipleEdgeCaseOrders() {
        verifySystemHandlesMultipleEdgeCaseOrders();
    }
}