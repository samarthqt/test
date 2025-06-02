package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ReturnFlowPage;

public class ReturnFlowSteps extends ReturnFlowPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the customer has purchased an Achieve access code")
    public void theCustomerHasPurchasedAnAchieveAccessCode() {
        verifyPurchaseOfAchieveAccessCode();
    }

    @Given("the order ID is 98765")
    public void theOrderIDIs98765() {
        verifyOrderID("98765");
    }

    @Given("the purchase was made within the last 14 days")
    public void thePurchaseWasMadeWithinTheLast14Days() {
        verifyPurchaseWithinEligiblePeriod();
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

    @Then("the order details are displayed with a list of recent purchases")
    public void theOrderDetailsAreDisplayedWithAListOfRecentPurchases() {
        verifyOrderDetailsDisplayed();
    }

    @Given("the order details are displayed")
    public void theOrderDetailsAreDisplayed() {
        verifyOrderDetailsDisplayed();
    }

    @When("the customer selects the order with ID 98765")
    public void theCustomerSelectsTheOrderWithID98765() {
        selectOrderWithID("98765");
    }

    @Then("the order details for order ID 98765 are displayed")
    public void theOrderDetailsForOrderID98765AreDisplayed() {
        verifyOrderDetailsForID("98765");
    }

    @Given("the order details for order ID 98765 are displayed")
    public void theOrderDetailsForOrderID98765AreDisplayed() {
        verifyOrderDetailsForID("98765");
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
    public void theInitiateReturnFormIsDisplayed() {
        verifyInitiateReturnFormDisplayed();
    }

    @When("the customer completes the return form with required details and submits it")
    public void theCustomerCompletesTheReturnFormWithRequiredDetailsAndSubmitsIt() {
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

    @Then("the refund is processed immediately by Braintree")
    public void theRefundIsProcessedImmediatelyByBraintree() {
        verifyImmediateRefundProcessing();
    }

    @Given("the refund is processed")
    public void theRefundIsProcessed() {
        verifyImmediateRefundProcessing();
    }

    @When("the customer checks their email for confirmation")
    public void theCustomerChecksTheirEmailForConfirmation() {
        checkEmailForConfirmation();
    }

    @Then("the customer receives a confirmation email from Braintree")
    public void theCustomerReceivesAConfirmationEmailFromBraintree() {
        verifyConfirmationEmailReceived();
    }

    @When("the order details are verified in the daily return request email to CX")
    public void theOrderDetailsAreVerifiedInTheDailyReturnRequestEmailToCX() {
        verifyOrderDetailsInDailyEmail();
    }

    @Then("the order details are present in the daily return request email to CX")
    public void theOrderDetailsArePresentInTheDailyReturnRequestEmailToCX() {
        verifyOrderDetailsInDailyEmail();
    }

    @When("the CX system is checked for the return request")
    public void theCXSystemIsCheckedForTheReturnRequest() {
        checkCXSystemForReturnRequest();
    }

    @Then("CX receives the return request and takes appropriate action")
    public void cxReceivesTheReturnRequestAndTakesAppropriateAction() {
        verifyCXSystemAction();
    }

    @Given("the Achieve access code was redeemed")
    public void theAchieveAccessCodeWasRedeemed() {
        verifyAccessCodeRedemption();
    }

    @When("the refund is processed")
    public void theRefundIsProcessed() {
        verifyImmediateRefundProcessing();
    }

    @Then("access to the Achieve course is revoked")
    public void accessToTheAchieveCourseIsRevoked() {
        verifyAccessRevocation();
    }

    @Given("the Achieve access code was not redeemed")
    public void theAchieveAccessCodeWasNotRedeemed() {
        verifyAccessCodeNotRedeemed();
    }

    @Then("the access code is zeroed out and can no longer be used")
    public void theAccessCodeIsZeroedOutAndCanNoLongerBeUsed() {
        verifyAccessCodeZeroedOut();
    }

    @When("the customer attempts to use the access code")
    public void theCustomerAttemptsToUseTheAccessCode() {
        attemptToUseAccessCode();
    }

    @Then("the access code is invalid for accessing the Achieve course")
    public void theAccessCodeIsInvalidForAccessingTheAchieveCourse() {
        verifyAccessCodeInvalid();
    }
}