package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReturnFlowSteps extends ReturnFlowPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the customer has purchased an Achieve access code")
    public void theCustomerHasPurchasedAnAchieveAccessCode() {
        verifyPurchaseOfAccessCode();
    }

    @Given("the purchase was made within the last 14 days")
    public void thePurchaseWasMadeWithinTheLast14Days() {
        verifyPurchaseDateWithinEligiblePeriod();
    }

    @When("the customer logs in to the BFW store with their account")
    public void theCustomerLogsInToTheBFWStoreWithTheirAccount() {
        loginToBFWStore();
    }

    @Then("the customer's account dashboard is displayed")
    public void theCustomersAccountDashboardIsDisplayed() {
        verifyAccountDashboardDisplayed();
    }

    @Given("the customer is logged in")
    public void theCustomerIsLoggedIn() {
        verifyCustomerLoggedIn();
    }

    @When("the customer navigates to the 'Order Details' section")
    public void theCustomerNavigatesToTheOrderDetailsSection() {
        navigateToOrderDetailsSection();
    }

    @Then("order details are displayed with a list of recent purchases")
    public void orderDetailsAreDisplayedWithAListOfRecentPurchases() {
        verifyOrderDetailsDisplayed();
    }

    @Given("the customer is on the 'Order Details' section")
    public void theCustomerIsOnTheOrderDetailsSection() {
        verifyOnOrderDetailsSection();
    }

    @When("the customer selects the order with ID 98765")
    public void theCustomerSelectsTheOrderWithID98765() {
        selectOrderWithID("98765");
    }

    @Then("order details for order ID 98765 are displayed")
    public void orderDetailsForOrderID98765AreDisplayed() {
        verifyOrderDetailsForID("98765");
    }

    @Given("the customer is viewing order details for order ID 98765")
    public void theCustomerIsViewingOrderDetailsForOrderID98765() {
        verifyViewingOrderDetailsForID("98765");
    }

    @When("the customer clicks on the 'Initiate Return' button for the Achieve access code")
    public void theCustomerClicksOnTheInitiateReturnButtonForTheAchieveAccessCode() {
        clickInitiateReturnButton();
    }

    @Then("the 'Initiate Return' form is displayed")
    public void theInitiateReturnFormIsDisplayed() {
        verifyInitiateReturnFormDisplayed();
    }

    @Given("the 'Initiate Return' form is displayed")
    public void theInitiateReturnFormIsDisplayedAgain() {
        verifyInitiateReturnFormDisplayed();
    }

    @When("the customer completes the return form with required details and submits")
    public void theCustomerCompletesTheReturnFormWithRequiredDetailsAndSubmits() {
        completeAndSubmitReturnForm();
    }

    @Then("the return request is submitted successfully")
    public void theReturnRequestIsSubmittedSuccessfully() {
        verifyReturnRequestSubmission();
    }

    @Given("the return request is submitted")
    public void theReturnRequestIsSubmitted() {
        verifyReturnRequestSubmission();
    }

    @When("the refund is processed by Braintree")
    public void theRefundIsProcessedByBraintree() {
        processRefundByBraintree();
    }

    @Then("the refund is processed immediately")
    public void theRefundIsProcessedImmediately() {
        verifyImmediateRefundProcessing();
    }

    @Given("the refund is processed")
    public void theRefundIsProcessed() {
        verifyImmediateRefundProcessing();
    }

    @When("the customer checks their email")
    public void theCustomerChecksTheirEmail() {
        checkCustomerEmailForConfirmation();
    }

    @Then("the customer receives a confirmation email from Braintree")
    public void theCustomerReceivesAConfirmationEmailFromBraintree() {
        verifyConfirmationEmailReceived();
    }

    @Given("the return request is submitted")
    public void theReturnRequestIsSubmittedAgain() {
        verifyReturnRequestSubmission();
    }

    @When("the daily return request email is sent to CX")
    public void theDailyReturnRequestEmailIsSentToCX() {
        sendDailyReturnRequestEmailToCX();
    }

    @Then("order details are present in the daily return request email to CX")
    public void orderDetailsArePresentInTheDailyReturnRequestEmailToCX() {
        verifyOrderDetailsInCXEmail();
    }

    @Given("the daily return request email is sent to CX")
    public void theDailyReturnRequestEmailIsSentToCXAgain() {
        sendDailyReturnRequestEmailToCX();
    }

    @When("the CX system is checked for the return request")
    public void theCXSystemIsCheckedForTheReturnRequest() {
        checkCXSystemForReturnRequest();
    }

    @Then("CX receives the return request and takes appropriate action")
    public void cxReceivesTheReturnRequestAndTakesAppropriateAction() {
        verifyCXActionOnReturnRequest();
    }

    @Given("the return request is processed")
    public void theReturnRequestIsProcessedAgain() {
        verifyImmediateRefundProcessing();
    }

    @When("the access code was redeemed")
    public void theAccessCodeWasRedeemed() {
        verifyAccessCodeRedemption();
    }

    @Then("access to the Achieve course is revoked")
    public void accessToTheAchieveCourseIsRevoked() {
        revokeAccessToAchieveCourse();
    }

    @Given("the return request is processed")
    public void theReturnRequestIsProcessedYetAgain() {
        verifyImmediateRefundProcessing();
    }

    @When("the access code was not redeemed")
    public void theAccessCodeWasNotRedeemed() {
        verifyAccessCodeNotRedeemed();
    }

    @Then("the access code is zeroed out and can no longer be used")
    public void theAccessCodeIsZeroedOutAndCanNoLongerBeUsed() {
        zeroOutAccessCode();
    }

    @Given("the return request is processed")
    public void theReturnRequestIsProcessedOnceMore() {
        verifyImmediateRefundProcessing();
    }

    @When("the refund is completed")
    public void theRefundIsCompleted() {
        verifyRefundCompletion();
    }

    @Then("the access code is invalid for accessing the Achieve course")
    public void theAccessCodeIsInvalidForAccessingTheAchieveCourse() {
        verifyAccessCodeInvalidity();
    }
}