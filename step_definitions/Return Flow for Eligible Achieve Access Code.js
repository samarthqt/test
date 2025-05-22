import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ReturnFlowPage from "../pages/returnFlowPage";

Given("the customer has purchased an Achieve access code", () => {
 // Assume the purchase is verified
});

Given("the purchase was made within the last 14 days", () => {
 // Assume the purchase date is checked
});

When("the customer logs in to the BFW store with their account", () => {
 ReturnFlowPage.login();
});

Then("the customer's account dashboard is displayed", () => {
 ReturnFlowPage.verifyDashboardDisplayed();
});

Given("the customer is logged in", () => {
 // Assume the customer is logged in
});

When("the customer navigates to the 'Order Details' section", () => {
 ReturnFlowPage.navigateToOrderDetails();
});

Then("order details are displayed with a list of recent purchases", () => {
 ReturnFlowPage.verifyOrderDetailsDisplayed();
});

Given("the customer is on the 'Order Details' section", () => {
 // Assume the customer is on the order details section
});

When("the customer selects the order with ID 98765", () => {
 ReturnFlowPage.selectOrderById("98765");
});

Then("order details for order ID 98765 are displayed", () => {
 ReturnFlowPage.verifySelectedOrderDetails("98765");
});

Given("the customer is viewing order details for order ID 98765", () => {
 // Assume the customer is viewing specific order details
});

When("the customer clicks on the 'Initiate Return' button for the Achieve access code", () => {
 ReturnFlowPage.initiateReturnForAchieveCode();
});

Then("the 'Initiate Return' form is displayed", () => {
 ReturnFlowPage.verifyInitiateReturnFormDisplayed();
});

Given("the 'Initiate Return' form is displayed", () => {
 // Assume the form is displayed
});

When("the customer completes the return form with required details and submits", () => {
 ReturnFlowPage.completeAndSubmitReturnForm();
});

Then("the return request is submitted successfully", () => {
 ReturnFlowPage.verifyReturnRequestSubmitted();
});

Given("the return request is submitted", () => {
 // Assume the request is submitted
});

When("the refund is processed by Braintree", () => {
 ReturnFlowPage.processRefundByBraintree();
});

Then("the refund is processed immediately", () => {
 ReturnFlowPage.verifyRefundProcessed();
});

Given("the refund is processed", () => {
 // Assume the refund is processed
});

When("the customer checks their email", () => {
 ReturnFlowPage.checkCustomerEmail();
});

Then("the customer receives a confirmation email from Braintree", () => {
 ReturnFlowPage.verifyConfirmationEmailReceived();
});

Given("the return request is submitted", () => {
 // Assume the request is submitted
});

When("the daily return request email is sent to CX", () => {
 ReturnFlowPage.sendDailyReturnRequestEmailToCX();
});

Then("order details are present in the daily return request email to CX", () => {
 ReturnFlowPage.verifyOrderDetailsInEmailToCX();
});

Given("the daily return request email is sent to CX", () => {
 // Assume the email is sent
});

When("the CX system is checked for the return request", () => {
 ReturnFlowPage.checkCXSystemForReturnRequest();
});

Then("CX receives the return request and takes appropriate action", () => {
 ReturnFlowPage.verifyCXActionOnReturnRequest();
});

Given("the return request is processed", () => {
 // Assume the request is processed
});

When("the access code was redeemed", () => {
 ReturnFlowPage.checkAccessCodeRedeemed();
});

Then("access to the Achieve course is revoked", () => {
 ReturnFlowPage.verifyAccessRevoked();
});

Given("the return request is processed", () => {
 // Assume the request is processed
});

When("the access code was not redeemed", () => {
 ReturnFlowPage.checkAccessCodeNotRedeemed();
});

Then("the access code is zeroed out and can no longer be used", () => {
 ReturnFlowPage.verifyAccessCodeZeroedOut();
});

Given("the return request is processed", () => {
 // Assume the request is processed
});

When("the refund is completed", () => {
 ReturnFlowPage.verifyRefundCompleted();
});

Then("the access code is invalid for accessing the Achieve course", () => {
 ReturnFlowPage.verifyAccessCodeInvalidPostRefund();
});