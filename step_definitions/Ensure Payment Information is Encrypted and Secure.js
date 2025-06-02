import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import PaymentPage from "../pages/paymentPage";

Given("the user is logged into the application", () => {
 PaymentPage.login();
});

When("the user navigates to the shopping cart", () => {
 PaymentPage.navigateToCart();
});

Then("the shopping cart is displayed with all added items", () => {
 PaymentPage.verifyCartItems();
});

Given("the user has items in the shopping cart", () => {
 PaymentPage.verifyCartHasItems();
});

When("the user proceeds to the checkout page", () => {
 PaymentPage.proceedToCheckout();
});

Then("the checkout page is displayed with the order summary", () => {
 PaymentPage.verifyCheckoutPage();
});

Given("the checkout page is displayed", () => {
 PaymentPage.verifyCheckoutPage();
});

When("the user selects 'Credit Card' as the payment option", () => {
 PaymentPage.selectCreditCardPayment();
});

Then("the credit card payment form is displayed", () => {
 PaymentPage.verifyCreditCardForm();
});

Given("the credit card payment form is displayed", () => {
 PaymentPage.verifyCreditCardForm();
});

When("the user enters valid credit card details", () => {
 PaymentPage.enterCreditCardDetails();
});

Then("the system accepts the card details and proceeds to the next step", () => {
 PaymentPage.verifyCardDetailsAcceptance();
});

Given("the user has entered valid credit card details", () => {
 PaymentPage.verifyCardDetailsAcceptance();
});

When("the user inspects the network requests", () => {
 PaymentPage.inspectNetworkRequests();
});

Then("the card details are encrypted in the network requests", () => {
 PaymentPage.verifyEncryptedCardDetails();
});

Given("the user is on the checkout page", () => {
 PaymentPage.verifyCheckoutPage();
});

When("the user verifies the security certificate", () => {
 PaymentPage.verifySecurityCertificate();
});

Then("the checkout page has a valid security certificate", () => {
 PaymentPage.verifyValidSecurityCertificate();
});

Given("the user is on the checkout page", () => {
 PaymentPage.verifyCheckoutPage();
});

When("the user confirms the payment gateway integration", () => {
 PaymentPage.confirmPaymentGatewayIntegration();
});

Then("the payment gateway is securely integrated with encrypted transactions", () => {
 PaymentPage.verifySecurePaymentGatewayIntegration();
});

Given("the user has completed the payment process", () => {
 PaymentPage.verifyPaymentCompletion();
});

When("the user places the order", () => {
 PaymentPage.placeOrder();
});

Then("the payment information is not visible in the confirmation page", () => {
 PaymentPage.verifyNoVisiblePaymentInfo();
});

Given("the user has placed the order", () => {
 PaymentPage.verifyOrderPlacement();
});

When("the user checks the email confirmation for the order", () => {
 PaymentPage.checkEmailConfirmation();
});

Then("the email confirmation does not include sensitive payment details", () => {
 PaymentPage.verifyNoSensitiveDetailsInEmail();
});

Given("the user has placed the order", () => {
 PaymentPage.verifyOrderPlacement();
});

When("the user checks the browser's local storage", () => {
 PaymentPage.checkLocalStorage();
});

Then("the payment information is not stored in the browser's local storage", () => {
 PaymentPage.verifyNoPaymentInfoInLocalStorage();
});

Given("the user has placed the order", () => {
 PaymentPage.verifyOrderPlacement();
});

When("an attempt is made to access the payment information through unauthorized means", () => {
 PaymentPage.attemptUnauthorizedAccess();
});

Then("unauthorized access to payment information is prevented", () => {
 PaymentPage.verifyUnauthorizedAccessPrevention();
});

Given("the user has placed the order", () => {
 PaymentPage.verifyOrderPlacement();
});

When("the encryption strength of the payment information is tested", () => {
 PaymentPage.testEncryptionStrength();
});

Then("the payment information is encrypted with industry-standard encryption methods", () => {
 PaymentPage.verifyIndustryStandardEncryption();
});

Given("the user has placed the order", () => {
 PaymentPage.verifyOrderPlacement();
});

When("the system logs are verified", () => {
 PaymentPage.verifySystemLogs();
});

Then("the system logs do not show any unauthorized access attempts", () => {
 PaymentPage.verifyNoUnauthorizedAccessInLogs();
});

Given("the user has placed the order", () => {
 PaymentPage.verifyOrderPlacement();
});

When("the compliance of the payment system with PCI DSS standards is checked", () => {
 PaymentPage.checkPCIDSSCompliance();
});

Then("the payment system complies with PCI DSS standards", () => {
 PaymentPage.verifyPCIDSSCompliance();
});

Given("the user has placed the order", () => {
 PaymentPage.verifyOrderPlacement();
});

When("the performance of the checkout process is verified", () => {
 PaymentPage.verifyCheckoutPerformance();
});

Then("the checkout process is smooth and efficient with encrypted payment information", () => {
 PaymentPage.verifySmoothCheckoutProcess();
});