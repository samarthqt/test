package com.cucumber.steps;

import com.page_objects.OrderConfirmationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderConfirmationSteps extends OrderConfirmationPage {

    @Given("the user has completed a purchase transaction")
    public void theUserHasCompletedAPurchaseTransaction() {
        completePurchaseTransaction();
    }

    @Given("the user is on the order confirmation page")
    public void theUserIsOnTheOrderConfirmationPage() {
        navigateToOrderConfirmationPage();
    }

    @When("the user navigates to the order confirmation page")
    public void theUserNavigatesToTheOrderConfirmationPage() {
        navigateToOrderConfirmationPage();
    }

    @When("the system checks for the order number")
    public void theSystemChecksForTheOrderNumber() {
        checkOrderNumber();
    }

    @When("the system checks for the shipping address")
    public void theSystemChecksForTheShippingAddress() {
        checkShippingAddress();
    }

    @When("the system checks for items purchased")
    public void theSystemChecksForItemsPurchased() {
        checkItemsPurchased();
    }

    @When("the system checks for missing information")
    public void theSystemChecksForMissingInformation() {
        checkMissingInformation();
    }

    @When("the system checks the page layout")
    public void theSystemChecksThePageLayout() {
        checkPageLayout();
    }

    @When("the system checks for the total amount")
    public void theSystemChecksForTheTotalAmount() {
        checkTotalAmount();
    }

    @When("the system checks for the estimated delivery date")
    public void theSystemChecksForTheEstimatedDeliveryDate() {
        checkEstimatedDeliveryDate();
    }

    @When("the system checks for payment method details")
    public void theSystemChecksForPaymentMethodDetails() {
        checkPaymentMethodDetails();
    }

    @When("the system checks for customer support contact information")
    public void theSystemChecksForCustomerSupportContactInformation() {
        checkCustomerSupportContactInformation();
    }

    @When("the system checks for a link to track the order")
    public void theSystemChecksForALinkToTrackTheOrder() {
        checkOrderTrackingLink();
    }

    @When("the system checks the print option")
    public void theSystemChecksThePrintOption() {
        checkPrintOption();
    }

    @When("the system checks the email option")
    public void theSystemChecksTheEmailOption() {
        checkEmailOption();
    }

    @When("the system checks for promotional offers or discounts")
    public void theSystemChecksForPromotionalOffersOrDiscounts() {
        checkPromotionalOffersOrDiscounts();
    }

    @When("the system checks for missing order confirmation details")
    public void theSystemChecksForMissingOrderConfirmationDetails() {
        checkMissingOrderConfirmationDetails();
    }

    @Then("the order confirmation page is displayed")
    public void theOrderConfirmationPageIsDisplayed() {
        verifyOrderConfirmationPageDisplayed();
    }

    @Then("the order ID is not present")
    public void theOrderIDIsNotPresent() {
        verifyOrderIDNotPresent();
    }

    @Then("the system provides a message indicating the absence of order number")
    public void theSystemProvidesAMessageIndicatingTheAbsenceOfOrderNumber() {
        verifyAbsenceOfOrderNumberMessage();
    }

    @Then("the system provides a message indicating the absence of shipping address")
    public void theSystemProvidesAMessageIndicatingTheAbsenceOfShippingAddress() {
        verifyAbsenceOfShippingAddressMessage();
    }

    @Then("the system provides a message indicating the absence of items purchased")
    public void theSystemProvidesAMessageIndicatingTheAbsenceOfItemsPurchased() {
        verifyAbsenceOfItemsPurchasedMessage();
    }

    @Then("error messages or alerts are displayed for missing information")
    public void errorMessagesOrAlertsAreDisplayedForMissingInformation() {
        verifyErrorMessagesForMissingInformation();
    }

    @Then("the page layout is clear and information is easily readable despite missing data")
    public void thePageLayoutIsClearAndInformationIsEasilyReadableDespiteMissingData() {
        verifyPageLayoutIntact();
    }

    @Then("the total amount is not displayed")
    public void theTotalAmountIsNotDisplayed() {
        verifyTotalAmountNotDisplayed();
    }

    @Then("a message explains the reason")
    public void aMessageExplainsTheReason() {
        verifyReasonMessageForTotalAmountAbsence();
    }

    @Then("the system provides a message indicating the absence of an estimated delivery date")
    public void theSystemProvidesAMessageIndicatingTheAbsenceOfAnEstimatedDeliveryDate() {
        verifyAbsenceOfEstimatedDeliveryDateMessage();
    }

    @Then("the system provides a message indicating the absence of payment method details")
    public void theSystemProvidesAMessageIndicatingTheAbsenceOfPaymentMethodDetails() {
        verifyAbsenceOfPaymentMethodDetailsMessage();
    }

    @Then("customer support contact information is displayed")
    public void customerSupportContactInformationIsDisplayed() {
        verifyCustomerSupportContactInformationDisplayed();
    }

    @Then("the system provides a message indicating the absence of tracking information")
    public void theSystemProvidesAMessageIndicatingTheAbsenceOfTrackingInformation() {
        verifyAbsenceOfTrackingInformationMessage();
    }

    @Then("the print option is disabled or provides a message about missing data")
    public void thePrintOptionIsDisabledOrProvidesAMessageAboutMissingData() {
        verifyPrintOptionDisabledOrMessage();
    }

    @Then("the email option is disabled or provides a message about missing data")
    public void theEmailOptionIsDisabledOrProvidesAMessageAboutMissingData() {
        verifyEmailOptionDisabledOrMessage();
    }

    @Then("promotional offers or discounts are displayed if applicable")
    public void promotionalOffersOrDiscountsAreDisplayedIfApplicable() {
        verifyPromotionalOffersOrDiscountsDisplayed();
    }

    @Then("a message explains the missing order details")
    public void aMessageExplainsTheMissingOrderDetails() {
        verifyMessageExplainingMissingOrderDetails();
    }

    @Then("the system logs an error for auditing purposes")
    public void theSystemLogsAnErrorForAuditingPurposes() {
        verifyErrorLoggedForMissingOrderConfirmationDetails();
    }
}