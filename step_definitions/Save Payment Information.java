package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentInformationSteps extends PaymentInformationPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into their account")
    public void theUserIsLoggedIntoTheirAccount() {
        loginToAccount();
    }

    @Given("the user is on the checkout page")
    public void theUserIsOnTheCheckoutPage() {
        navigateToCheckoutPage();
    }

    @When("the user enters valid payment information")
    public void theUserEntersValidPaymentInformation() {
        String cardNumber = testHarness.getData("PaymentData", "CardNumber");
        String expiryDate = testHarness.getData("PaymentData", "ExpiryDate");
        String cvv = testHarness.getData("PaymentData", "CVV");
        enterPaymentInformation(cardNumber, expiryDate, cvv);
    }

    @When("the user chooses to save the payment information for future purchases")
    public void theUserChoosesToSaveThePaymentInformationForFuturePurchases() {
        chooseToSavePaymentInformation(true);
    }

    @When("the user chooses not to save the payment information")
    public void theUserChoosesNotToSaveThePaymentInformation() {
        chooseToSavePaymentInformation(false);
    }

    @When("the user submits the payment information")
    public void theUserSubmitsThePaymentInformation() {
        submitPaymentInformation();
    }

    @Then("the payment information is saved securely")
    public void thePaymentInformationIsSavedSecurely() {
        verifyPaymentInformationSaved();
    }

    @Then("a confirmation message is displayed to the user")
    public void aConfirmationMessageIsDisplayedToTheUser() {
        verifyConfirmationMessageDisplayed();
    }

    @Then("the payment information is not saved")
    public void thePaymentInformationIsNotSaved() {
        verifyPaymentInformationNotSaved();
    }

    @Then("the transaction is completed successfully")
    public void theTransactionIsCompletedSuccessfully() {
        verifyTransactionCompleted();
    }

    @When("the user enters invalid payment information")
    public void theUserEntersInvalidPaymentInformation() {
        String cardNumber = testHarness.getData("PaymentData", "InvalidCardNumber");
        String expiryDate = testHarness.getData("PaymentData", "InvalidExpiryDate");
        String cvv = testHarness.getData("PaymentData", "InvalidCVV");
        enterPaymentInformation(cardNumber, expiryDate, cvv);
    }

    @Then("an error message is displayed indicating the payment information is invalid")
    public void anErrorMessageIsDisplayedIndicatingThePaymentInformationIsInvalid() {
        verifyErrorMessageDisplayed();
    }

    @Given("the user has previously saved payment information")
    public void theUserHasPreviouslySavedPaymentInformation() {
        verifySavedPaymentInformationExists();
    }

    @When("the user navigates to the payment information section of their account")
    public void theUserNavigatesToThePaymentInformationSectionOfTheirAccount() {
        navigateToPaymentInformationSection();
    }

    @Then("the saved payment information is displayed securely")
    public void theSavedPaymentInformationIsDisplayedSecurely() {
        verifySavedPaymentInformationDisplayed();
    }

    @Then("the user can edit or delete the payment information")
    public void theUserCanEditOrDeleteThePaymentInformation() {
        verifyEditOrDeleteOptionsAvailable();
    }

    @When("the user chooses to delete the saved payment information")
    public void theUserChoosesToDeleteTheSavedPaymentInformation() {
        deleteSavedPaymentInformation();
    }

    @Then("the payment information is removed from the account")
    public void thePaymentInformationIsRemovedFromTheAccount() {
        verifyPaymentInformationRemoved();
    }

    @When("the user edits the saved payment information")
    public void theUserEditsTheSavedPaymentInformation() {
        String newCardNumber = testHarness.getData("PaymentData", "NewCardNumber");
        String newExpiryDate = testHarness.getData("PaymentData", "NewExpiryDate");
        String newCvv = testHarness.getData("PaymentData", "NewCVV");
        editPaymentInformation(newCardNumber, newExpiryDate, newCvv);
    }

    @When("the user submits the updated payment information")
    public void theUserSubmitsTheUpdatedPaymentInformation() {
        submitUpdatedPaymentInformation();
    }

    @Then("the payment information is updated securely")
    public void thePaymentInformationIsUpdatedSecurely() {
        verifyPaymentInformationUpdated();
    }
}