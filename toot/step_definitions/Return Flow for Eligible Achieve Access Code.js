import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ReturnFlowPage from "../pages/returnFlowPage";

Given("a customer has purchased an Achieve access code", () => {
 ReturnFlowPage.verifyPurchase();
});

Given("the purchase was made within the last 14 days", () => {
 ReturnFlowPage.checkPurchaseDate();
});

When("the customer logs in to the BFW store with their account", () => {
 ReturnFlowPage.login();
});

Then("the customer's account dashboard is displayed", () => {
 ReturnFlowPage.verifyDashboard();
});

Given("the customer is logged in", () => {
 ReturnFlowPage.verifyLoggedIn();
});

When("the customer navigates to the 'Order Details' section", () => {
 ReturnFlowPage.navigateToOrderDetails();
});

Then("order details are displayed with a list of recent purchases", () => {
 ReturnFlowPage.verifyOrderList();
});

Given("the order details are displayed", () => {
 ReturnFlowPage.verifyOrderDetailsDisplayed();
});

When("the customer selects the order with ID 98765", () => {
 ReturnFlowPage.selectOrder("98765");
});

Then("order details for order ID 98765 are displayed", () => {
 ReturnFlowPage.verifyOrderDetails("98765");
});

Given("the order details for order ID 98765 are displayed", () => {
 ReturnFlowPage.verifyOrderDetails("98765");
});

When("the customer clicks on the 'Initiate Return' button for the Achieve access code", () => {
 ReturnFlowPage.clickInitiateReturn();
});

Then("the 'Initiate Return' form is displayed", () => {
 ReturnFlowPage.verifyInitiateReturnForm();
});

Given("the 'Initiate Return' form is displayed", () => {
 ReturnFlowPage.verifyInitiateReturnForm();
});

When("the customer completes the return form with required details and submits", () => {
 ReturnFlowPage.submitReturnForm();
});

Then("the return request is submitted successfully", () => {
 ReturnFlowPage.verifyReturnSubmission();
});

Given("the return request is submitted", () => {
 ReturnFlowPage.verifyReturnSubmission();
});

When("the refund is processed by Braintree", () => {
 ReturnFlowPage.processRefund();
});

Then("the refund is processed immediately by Braintree", () => {
 ReturnFlowPage.verifyRefundProcessing();
});

Given("the refund is processed", () => {
 ReturnFlowPage.verifyRefundProcessing();
});

When("the customer checks their email for confirmation", () => {
 ReturnFlowPage.checkEmailConfirmation();
});

Then("the customer receives a confirmation email from Braintree", () => {
 ReturnFlowPage.verifyEmailReceived();
});

Given("the return request is submitted", () => {
 ReturnFlowPage.verifyReturnSubmission();
});

When("verifying the order details in the daily return request email to CX", () => {
 ReturnFlowPage.verifyOrderDetailsInEmail();
});

Then("order details are present in the daily return request email to CX", () => {
 ReturnFlowPage.verifyOrderDetailsInEmail();
});

Given("the return request is submitted", () => {
 ReturnFlowPage.verifyReturnSubmission();
});

When("checking the CX system for the return request", () => {
 ReturnFlowPage.checkCXSystem();
});

Then("CX receives the return request and takes appropriate action", () => {
 ReturnFlowPage.verifyCXAction();
});

Given("the return request is processed", () => {
 ReturnFlowPage.verifyRefundProcessing();
});

When("verifying access to the Achieve course", () => {
 ReturnFlowPage.verifyCourseAccess();
});

Then("access to the Achieve course is revoked if the access code was redeemed", () => {
 ReturnFlowPage.verifyAccessRevoked("Redeemed");
});

Then("access code is zeroed out if not redeemed", () => {
 ReturnFlowPage.verifyAccessZeroedOut("Not Redeemed");
});

Then("access code cannot be used post-refund", () => {
 ReturnFlowPage.verifyAccessCodePostRefund();
});