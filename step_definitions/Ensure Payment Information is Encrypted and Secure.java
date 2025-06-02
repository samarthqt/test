package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.CheckoutPage;

public class CheckoutSteps extends CheckoutPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @When("the user navigates to the shopping cart")
    public void theUserNavigatesToTheShoppingCart() {
        navigateToShoppingCart();
    }

    @Then("the shopping cart is displayed with all added items")
    public void theShoppingCartIsDisplayedWithAllAddedItems() {
        verifyShoppingCartItems();
    }

    @Given("the user has items in the shopping cart")
    public void theUserHasItemsInTheShoppingCart() {
        verifyItemsInCart();
    }

    @When("the user proceeds to the checkout page")
    public void theUserProceedsToTheCheckoutPage() {
        proceedToCheckoutPage();
    }

    @Then("the checkout page is displayed with the order summary")
    public void theCheckoutPageIsDisplayedWithTheOrderSummary() {
        verifyOrderSummary();
    }

    @Given("the checkout page is displayed")
    public void theCheckoutPageIsDisplayed() {
        verifyCheckoutPage();
    }

    @When("the user selects 'Credit Card' as the payment option")
    public void theUserSelectsCreditCardAsThePaymentOption() {
        selectCreditCardPaymentOption();
    }

    @Then("the credit card payment form is displayed")
    public void theCreditCardPaymentFormIsDisplayed() {
        verifyCreditCardForm();
    }

    @Given("the credit card payment form is displayed")
    public void theCreditCardPaymentFormIsDisplayedAgain() {
        verifyCreditCardForm();
    }

    @When("the user enters valid credit card details")
    public void theUserEntersValidCreditCardDetails() {
        enterValidCreditCardDetails();
    }

    @Then("the system accepts the card details and proceeds to the next step")
    public void theSystemAcceptsTheCardDetailsAndProceedsToTheNextStep() {
        verifyCardDetailsAccepted();
    }

    @Given("the user has entered valid credit card details")
    public void theUserHasEnteredValidCreditCardDetails() {
        verifyCardDetailsEntered();
    }

    @When("the user inspects the network requests")
    public void theUserInspectsTheNetworkRequests() {
        inspectNetworkRequests();
    }

    @Then("the card details are encrypted in the network requests")
    public void theCardDetailsAreEncryptedInTheNetworkRequests() {
        verifyCardDetailsEncryption();
    }

    @Given("the user is on the checkout page")
    public void theUserIsOnTheCheckoutPage() {
        verifyCheckoutPage();
    }

    @When("the user verifies the security certificate")
    public void theUserVerifiesTheSecurityCertificate() {
        verifySecurityCertificate();
    }

    @Then("the checkout page has a valid security certificate")
    public void theCheckoutPageHasAValidSecurityCertificate() {
        verifyValidSecurityCertificate();
    }

    @When("the user confirms the payment gateway integration")
    public void theUserConfirmsThePaymentGatewayIntegration() {
        confirmPaymentGatewayIntegration();
    }

    @Then("the payment gateway is securely integrated with encrypted transactions")
    public void thePaymentGatewayIsSecurelyIntegratedWithEncryptedTransactions() {
        verifySecurePaymentGatewayIntegration();
    }

    @Given("the user has completed the payment process")
    public void theUserHasCompletedThePaymentProcess() {
        verifyPaymentProcessCompletion();
    }

    @When("the user places the order")
    public void theUserPlacesTheOrder() {
        placeOrder();
    }

    @Then("the payment information is not visible in the confirmation page")
    public void thePaymentInformationIsNotVisibleInTheConfirmationPage() {
        verifyPaymentInfoNotVisible();
    }

    @Given("the user has placed the order")
    public void theUserHasPlacedTheOrder() {
        verifyOrderPlacement();
    }

    @When("the user checks the email confirmation for the order")
    public void theUserChecksTheEmailConfirmationForTheOrder() {
        checkEmailConfirmation();
    }

    @Then("the email confirmation does not include sensitive payment details")
    public void theEmailConfirmationDoesNotIncludeSensitivePaymentDetails() {
        verifyNoSensitiveDetailsInEmail();
    }

    @When("the user checks the browser's local storage")
    public void theUserChecksTheBrowsersLocalStorage() {
        checkBrowserLocalStorage();
    }

    @Then("the payment information is not stored in the browser's local storage")
    public void thePaymentInformationIsNotStoredInTheBrowsersLocalStorage() {
        verifyNoPaymentInfoInLocalStorage();
    }

    @When("an attempt is made to access the payment information through unauthorized means")
    public void anAttemptIsMadeToAccessThePaymentInformationThroughUnauthorizedMeans() {
        attemptUnauthorizedAccess();
    }

    @Then("unauthorized access to payment information is prevented")
    public void unauthorizedAccessToPaymentInformationIsPrevented() {
        verifyUnauthorizedAccessPrevention();
    }

    @When("the encryption strength of the payment information is tested")
    public void theEncryptionStrengthOfThePaymentInformationIsTested() {
        testEncryptionStrength();
    }

    @Then("the payment information is encrypted with industry-standard encryption methods")
    public void thePaymentInformationIsEncryptedWithIndustryStandardEncryptionMethods() {
        verifyIndustryStandardEncryption();
    }

    @When("the system logs are verified")
    public void theSystemLogsAreVerified() {
        verifySystemLogs();
    }

    @Then("the system logs do not show any unauthorized access attempts")
    public void theSystemLogsDoNotShowAnyUnauthorizedAccessAttempts() {
        verifyNoUnauthorizedAccessInLogs();
    }

    @When("the compliance of the payment system with PCI DSS standards is checked")
    public void theComplianceOfThePaymentSystemWithPCIDSSStandardsIsChecked() {
        checkPCIDSSCompliance();
    }

    @Then("the payment system complies with PCI DSS standards")
    public void thePaymentSystemCompliesWithPCIDSSStandards() {
        verifyPCIDSSCompliance();
    }

    @When("the performance of the checkout process is verified")
    public void thePerformanceOfTheCheckoutProcessIsVerified() {
        verifyCheckoutPerformance();
    }

    @Then("the checkout process is smooth and efficient with encrypted payment information")
    public void theCheckoutProcessIsSmoothAndEfficientWithEncryptedPaymentInformation() {
        verifySmoothCheckoutProcess();
    }
}