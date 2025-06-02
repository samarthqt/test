import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrderConfirmationPage from "../pages/orderConfirmationPage";

Given("the user has completed a purchase transaction", () => {
 // Assume the purchase transaction is completed
});

When("the user navigates to the order confirmation page", () => {
 OrderConfirmationPage.visit();
});

Then("the order confirmation page is displayed", () => {
 OrderConfirmationPage.verifyPageDisplayed();
});

Then("the order ID is not present", () => {
 OrderConfirmationPage.verifyOrderIdAbsence();
});

Given("the user is on the order confirmation page", () => {
 OrderConfirmationPage.visit();
});

When("the system checks for the order number", () => {
 OrderConfirmationPage.checkOrderNumber();
});

Then("the system provides a message indicating the absence of order number", () => {
 OrderConfirmationPage.verifyOrderNumberAbsenceMessage();
});

When("the system checks for the shipping address", () => {
 OrderConfirmationPage.checkShippingAddress();
});

Then("the system provides a message indicating the absence of shipping address", () => {
 OrderConfirmationPage.verifyShippingAddressAbsenceMessage();
});

When("the system checks for items purchased", () => {
 OrderConfirmationPage.checkItemsPurchased();
});

Then("the system provides a message indicating the absence of items purchased", () => {
 OrderConfirmationPage.verifyItemsPurchasedAbsenceMessage();
});

When("the system checks for missing information", () => {
 OrderConfirmationPage.checkMissingInformation();
});

Then("error messages or alerts are displayed for missing information", () => {
 OrderConfirmationPage.verifyMissingInformationErrors();
});

When("the system checks the page layout", () => {
 OrderConfirmationPage.checkPageLayout();
});

Then("the page layout is clear and information is easily readable despite missing data", () => {
 OrderConfirmationPage.verifyPageLayoutIntact();
});

When("the system checks for the total amount", () => {
 OrderConfirmationPage.checkTotalAmount();
});

Then("the total amount is not displayed", () => {
 OrderConfirmationPage.verifyTotalAmountAbsence();
});

Then("a message explains the reason", () => {
 OrderConfirmationPage.verifyTotalAmountAbsenceMessage();
});

When("the system checks for the estimated delivery date", () => {
 OrderConfirmationPage.checkEstimatedDeliveryDate();
});

Then("the system provides a message indicating the absence of an estimated delivery date", () => {
 OrderConfirmationPage.verifyEstimatedDeliveryDateAbsenceMessage();
});

When("the system checks for payment method details", () => {
 OrderConfirmationPage.checkPaymentMethodDetails();
});

Then("the system provides a message indicating the absence of payment method details", () => {
 OrderConfirmationPage.verifyPaymentMethodDetailsAbsenceMessage();
});

When("the system checks for customer support contact information", () => {
 OrderConfirmationPage.checkCustomerSupportContactInformation();
});

Then("customer support contact information is displayed", () => {
 OrderConfirmationPage.verifyCustomerSupportContactInformationDisplayed();
});

When("the system checks for a link to track the order", () => {
 OrderConfirmationPage.checkOrderTrackingLink();
});

Then("the system provides a message indicating the absence of tracking information", () => {
 OrderConfirmationPage.verifyOrderTrackingLinkAbsenceMessage();
});

When("the system checks the print option", () => {
 OrderConfirmationPage.checkPrintOption();
});

Then("the print option is disabled or provides a message about missing data", () => {
 OrderConfirmationPage.verifyPrintOptionDisabledOrMessage();
});

When("the system checks the email option", () => {
 OrderConfirmationPage.checkEmailOption();
});

Then("the email option is disabled or provides a message about missing data", () => {
 OrderConfirmationPage.verifyEmailOptionDisabledOrMessage();
});

When("the system checks for promotional offers or discounts", () => {
 OrderConfirmationPage.checkPromotionalOffersOrDiscounts();
});

Then("promotional offers or discounts are displayed if applicable", () => {
 OrderConfirmationPage.verifyPromotionalOffersOrDiscountsDisplayed();
});

Then("a message explains the missing order details", () => {
 OrderConfirmationPage.verifyPromotionalOffersOrDiscountsMessage();
});

When("the system checks for missing order confirmation details", () => {
 OrderConfirmationPage.checkMissingOrderConfirmationDetails();
});

Then("the system logs an error for auditing purposes", () => {
 OrderConfirmationPage.verifyErrorLoggedForMissingDetails();
});