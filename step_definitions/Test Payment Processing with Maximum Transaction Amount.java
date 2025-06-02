package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.PaymentPage;

public class PaymentSteps extends PaymentPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user navigates to the payment page")
    public void theUserNavigatesToThePaymentPage() {
        navigateToPaymentPage();
    }

    @Then("the payment page is displayed correctly")
    public void thePaymentPageIsDisplayedCorrectly() {
        verifyPaymentPageDisplayed();
    }

    @When("the user selects Stripe as the payment method")
    public void theUserSelectsStripeAsThePaymentMethod() {
        selectStripePaymentMethod();
    }

    @Then("Stripe payment method is selected")
    public void stripePaymentMethodIsSelected() {
        verifyStripePaymentMethodSelected();
    }

    @When("the user enters valid credit card details")
    public void theUserEntersValidCreditCardDetails() {
        String cardNumber = testHarness.getData("PaymentData", "CardNumber");
        String expiryDate = testHarness.getData("PaymentData", "ExpiryDate");
        String cvv = testHarness.getData("PaymentData", "CVV");
        enterCreditCardDetails(cardNumber, expiryDate, cvv);
    }

    @Then("the credit card details are accepted")
    public void theCreditCardDetailsAreAccepted() {
        verifyCreditCardDetailsAccepted();
    }

    @When("the user enters a valid billing address")
    public void theUserEntersAValidBillingAddress() {
        String address = testHarness.getData("PaymentData", "BillingAddress");
        enterBillingAddress(address);
    }

    @Then("the billing address is accepted")
    public void theBillingAddressIsAccepted() {
        verifyBillingAddressAccepted();
    }

    @When("the user enters a valid email address")
    public void theUserEntersAValidEmailAddress() {
        String email = testHarness.getData("PaymentData", "EmailAddress");
        enterEmailAddress(email);
    }

    @Then("the email address is accepted")
    public void theEmailAddressIsAccepted() {
        verifyEmailAddressAccepted();
    }

    @When("the user enters the product ID and maximum amount to be charged")
    public void theUserEntersTheProductIDAndMaximumAmountToBeCharged() {
        String productId = testHarness.getData("PaymentData", "ProductID");
        String maxAmount = testHarness.getData("PaymentData", "MaxAmount");
        enterProductIDAndMaxAmount(productId, maxAmount);
    }

    @Then("the product ID and maximum amount are accepted")
    public void theProductIDAndMaximumAmountAreAccepted() {
        verifyProductIDAndMaxAmountAccepted();
    }

    @When("the user submits the payment")
    public void theUserSubmitsThePayment() {
        submitPayment();
    }

    @Then("the payment is processed successfully")
    public void thePaymentIsProcessedSuccessfully() {
        verifyPaymentProcessedSuccessfully();
    }

    @Then("the transaction confirmation message is displayed")
    public void theTransactionConfirmationMessageIsDisplayed() {
        verifyTransactionConfirmationMessageDisplayed();
    }

    @Then("the transaction record is present in the Stripe dashboard")
    public void theTransactionRecordIsPresentInTheStripeDashboard() {
        verifyTransactionRecordInStripeDashboard();
    }

    @Then("the email notification for the transaction is received")
    public void theEmailNotificationForTheTransactionIsReceived() {
        verifyEmailNotificationReceived();
    }

    @When("the user logs out from the application")
    public void theUserLogsOutFromTheApplication() {
        logoutFromApplication();
    }

    @Then("the user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        verifyUserLoggedOutSuccessfully();
    }

    @When("the user logs back into the application")
    public void theUserLogsBackIntoTheApplication() {
        loginToApplication();
    }

    @Then("the user is logged in successfully")
    public void theUserIsLoggedInSuccessfully() {
        verifyUserLoggedInSuccessfully();
    }

    @Then("the transaction is present in the order history")
    public void theTransactionIsPresentInTheOrderHistory() {
        verifyTransactionInOrderHistory();
    }

    @Then("customer support is available for transaction queries")
    public void customerSupportIsAvailableForTransactionQueries() {
        verifyCustomerSupportAvailable();
    }

    @Then("transaction details are logged for auditing")
    public void transactionDetailsAreLoggedForAuditing() {
        verifyTransactionDetailsLoggedForAuditing();
    }
}