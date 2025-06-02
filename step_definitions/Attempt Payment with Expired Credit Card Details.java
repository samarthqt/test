package com.cucumber.steps;

import com.page_objects.PaymentPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentSteps extends PaymentPage {

    @Given("I am on the payment page")
    public void iAmOnThePaymentPage() {
        navigateToPaymentPage();
    }

    @When("I select Stripe as the payment method")
    public void iSelectStripeAsThePaymentMethod() {
        selectPaymentMethod("Stripe");
    }

    @When("I enter expired credit card details")
    public void iEnterExpiredCreditCardDetails() {
        enterCreditCardDetails("4111111111111111", "01/20", "123");
    }

    @Then("I should see an error message for expired credit card")
    public void iShouldSeeAnErrorMessageForExpiredCreditCard() {
        verifyErrorMessage("Your card is expired.");
    }

    @When("I enter a valid billing address")
    public void iEnterAValidBillingAddress() {
        enterBillingAddress("John Doe", "123 Main St", "Anytown", "12345", "1234567890");
    }

    @Then("the billing address should be accepted")
    public void theBillingAddressShouldBeAccepted() {
        verifyBillingAddressAccepted();
    }

    @When("I enter a valid email address")
    public void iEnterAValidEmailAddress() {
        enterEmailAddress("john.doe@example.com");
    }

    @Then("the email address should be accepted")
    public void theEmailAddressShouldBeAccepted() {
        verifyEmailAddressAccepted();
    }

    @When("I enter a product ID and the amount to be charged")
    public void iEnterAProductIDAndTheAmountToBeCharged() {
        enterProductDetails("PROD123", "100.00");
    }

    @Then("the product ID and amount should be accepted")
    public void theProductIDAndAmountShouldBeAccepted() {
        verifyProductDetailsAccepted();
    }

    @When("I attempt to submit the payment")
    public void iAttemptToSubmitThePayment() {
        submitPayment();
    }

    @Then("the payment submission should fail with an error message")
    public void thePaymentSubmissionShouldFailWithAnErrorMessage() {
        verifyPaymentSubmissionFailed("Payment failed due to expired card.");
    }

    @Then("the error message details should be clear and informative")
    public void theErrorMessageDetailsShouldBeClearAndInformative() {
        verifyErrorMessageDetails("Your card is expired. Please use a valid card.");
    }

    @When("I check the Stripe dashboard for a failed transaction record")
    public void iCheckTheStripeDashboardForAFailedTransactionRecord() {
        verifyNoFailedTransactionInStripe();
    }

    @Then("the failed transaction record should not be present in the Stripe dashboard")
    public void theFailedTransactionRecordShouldNotBePresentInTheStripeDashboard() {
        verifyNoFailedTransactionInStripe();
    }

    @When("I verify no email notification is received for the failed transaction")
    public void iVerifyNoEmailNotificationIsReceivedForTheFailedTransaction() {
        verifyNoEmailNotificationReceived();
    }

    @Then("no email notification should be received")
    public void noEmailNotificationShouldBeReceived() {
        verifyNoEmailNotificationReceived();
    }

    @When("I log out from the application")
    public void iLogOutFromTheApplication() {
        logout();
    }

    @Then("I should be logged out successfully")
    public void iShouldBeLoggedOutSuccessfully() {
        verifyLogoutSuccessful();
    }

    @When("I log back into the application")
    public void iLogBackIntoTheApplication() {
        login();
    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully() {
        verifyLoginSuccessful();
    }

    @When("I check order history for the failed transaction")
    public void iCheckOrderHistoryForTheFailedTransaction() {
        verifyNoFailedTransactionInOrderHistory();
    }

    @Then("the failed transaction should not be present in order history")
    public void theFailedTransactionShouldNotBePresentInOrderHistory() {
        verifyNoFailedTransactionInOrderHistory();
    }

    @When("I verify customer support is available for transaction queries")
    public void iVerifyCustomerSupportIsAvailableForTransactionQueries() {
        verifyCustomerSupportAvailable();
    }

    @Then("customer support should be available")
    public void customerSupportShouldBeAvailable() {
        verifyCustomerSupportAvailable();
    }

    @When("I ensure failed transaction details are logged for auditing")
    public void iEnsureFailedTransactionDetailsAreLoggedForAuditing() {
        verifyFailedTransactionLogged();
    }

    @Then("the failed transaction details should be logged")
    public void theFailedTransactionDetailsShouldBeLogged() {
        verifyFailedTransactionLogged();
    }
}