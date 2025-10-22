package com.cucumber.steps;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import com.framework.cucumber.TestHarness;
import com.pageobjects.GuestCheckoutPage;

public class GuestCheckoutSteps {

    private GuestCheckoutPage guestCheckoutPage = new GuestCheckoutPage();
    private TestHarness testHarness = new TestHarness();

    @Given("the user navigates to the shopping cart page")
    public void theUserNavigatesToTheShoppingCartPage() {
        guestCheckoutPage.navigateToShoppingCartPage();
    }

    @Given("the shopping cart page is displayed with the selected product")
    public void theShoppingCartPageIsDisplayedWithTheSelectedProduct() {
        guestCheckoutPage.verifyShoppingCartPageDisplayed();
    }

    @When("the user chooses to proceed to checkout as a guest user")
    public void theUserChoosesToProceedToCheckoutAsAGuestUser() {
        guestCheckoutPage.proceedToGuestCheckout();
    }

    @Then("the guest checkout page is displayed")
    public void theGuestCheckoutPageIsDisplayed() {
        guestCheckoutPage.verifyGuestCheckoutPageDisplayed();
    }

    @When("the user enters {string} in the name field")
    public void theUserEntersInTheNameField(String name) {
        guestCheckoutPage.enterName(name);
    }

    @Then("the name is accepted")
    public void theNameIsAccepted() {
        guestCheckoutPage.verifyNameAccepted();
    }

    @When("the user enters {string} in the email field")
    public void theUserEntersInTheEmailField(String email) {
        guestCheckoutPage.enterEmail(email);
    }

    @Then("the email is accepted")
    public void theEmailIsAccepted() {
        guestCheckoutPage.verifyEmailAccepted();
    }

    @When("the user enters {string} in the phone field")
    public void theUserEntersInThePhoneField(String phone) {
        guestCheckoutPage.enterPhone(phone);
    }

    @Then("the phone number is accepted")
    public void thePhoneNumberIsAccepted() {
        guestCheckoutPage.verifyPhoneAccepted();
    }

    @When("the user enters {string} in the shipping address field")
    public void theUserEntersInTheShippingAddressField(String address) {
        guestCheckoutPage.enterShippingAddress(address);
    }

    @Then("the shipping address is accepted")
    public void theShippingAddressIsAccepted() {
        guestCheckoutPage.verifyShippingAddressAccepted();
    }

    @When("the user selects a payment method from the available options")
    public void theUserSelectsAPaymentMethodFromTheAvailableOptions() {
        guestCheckoutPage.selectPaymentMethod();
    }

    @Then("the payment method is selected")
    public void thePaymentMethodIsSelected() {
        guestCheckoutPage.verifyPaymentMethodSelected();
    }

    @When("the user completes the payment process")
    public void theUserCompletesThePaymentProcess() {
        guestCheckoutPage.completePaymentProcess();
    }

    @Then("the payment is processed successfully")
    public void thePaymentIsProcessedSuccessfully() {
        guestCheckoutPage.verifyPaymentProcessedSuccessfully();
    }

    @Then("the order confirmation page is displayed with order details")
    public void theOrderConfirmationPageIsDisplayedWithOrderDetails() {
        guestCheckoutPage.verifyOrderConfirmationPageDisplayed();
    }

    @Then("the user checks the email inbox for a confirmation email")
    public void theUserChecksTheEmailInboxForAConfirmationEmail() {
        guestCheckoutPage.checkEmailInboxForConfirmationEmail();
    }

    @Then("the order confirmation email is received in the inbox")
    public void theOrderConfirmationEmailIsReceivedInTheInbox() {
        guestCheckoutPage.verifyOrderConfirmationEmailReceived();
    }

    @When("the user attempts to access account-only features")
    public void theUserAttemptsToAccessAccountOnlyFeatures() {
        guestCheckoutPage.attemptAccessAccountOnlyFeatures();
    }

    @Then("access is denied with a prompt to register or log in")
    public void accessIsDeniedWithAPromptToRegisterOrLogIn() {
        guestCheckoutPage.verifyAccessDeniedWithPrompt();
    }

    @Then("the guest information is stored securely for order processing only")
    public void theGuestInformationIsStoredSecurelyForOrderProcessingOnly() {
        guestCheckoutPage.verifyGuestInformationStoredSecurely();
    }

    @Then("guest information is not accessible beyond order processing")
    public void guestInformationIsNotAccessibleBeyondOrderProcessing() {
        guestCheckoutPage.verifyGuestInformationNotAccessible();
    }

    @When("the user completes the checkout process with the same email")
    public void theUserCompletesTheCheckoutProcessWithTheSameEmail() {
        guestCheckoutPage.completeCheckoutProcess();
    }

    @Then("the system checks for duplicate orders")
    public void theSystemChecksForDuplicateOrders() {
        guestCheckoutPage.checkForDuplicateOrders();
    }

    @Then("the system prevents the duplicate order and displays a relevant message")
    public void theSystemPreventsTheDuplicateOrderAndDisplaysARelevantMessage() {
        guestCheckoutPage.verifyDuplicateOrderPreventionMessage();
    }

    @Then("the email is not accepted due to invalid format")
    public void theEmailIsNotAcceptedDueToInvalidFormat() {
        guestCheckoutPage.verifyEmailNotAccepted();
    }

    @Then("an error message is displayed indicating invalid email format")
    public void anErrorMessageIsDisplayedIndicatingInvalidEmailFormat() {
        guestCheckoutPage.verifyInvalidEmailErrorMessage();
    }

    @When("the user enters a shipping address \"{string}\" in the address field")
    public void theUserEntersAShippingAddressInTheAddressField(String address) {
        guestCheckoutPage.enterShippingAddress(address);
    }

    @Then("the shipping address is accepted if within character limits")
    public void theShippingAddressIsAcceptedIfWithinCharacterLimits() {
        guestCheckoutPage.verifyAddressAcceptance();
    }

    @Then("the checkout completes successfully with the long address")
    public void theCheckoutCompletesSuccessfullyWithTheLongAddress() {
        guestCheckoutPage.verifyCheckoutSuccess();
    }
}
