import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AccountDashboardPage from "../pages/accountDashboardPage";

Given("the customer has purchased an Achieve access code", () => {
 // Assume this step is setup in the background or precondition
});

And("the purchase was made more than 14 days ago", () => {
 // Assume this step is setup in the background or precondition
});

And("the customer logs in to the BFW store with their account", () => {
 AccountDashboardPage.login();
});

Then("the customer's account dashboard is displayed", () => {
 AccountDashboardPage.verifyDashboardDisplayed();
});

When("the customer navigates to the 'Order Details' section", () => {
 AccountDashboardPage.navigateToOrderDetails();
});

Then("order details are displayed with a list of recent purchases", () => {
 AccountDashboardPage.verifyOrderDetailsDisplayed();
});

And("the customer selects the order with ID 87654", () => {
 AccountDashboardPage.selectOrderById('87654');
});

Then("order details for order ID 87654 are displayed", () => {
 AccountDashboardPage.verifyOrderDetailsForId('87654');
});

And("the access code ACH54321 is shown", () => {
 AccountDashboardPage.verifyAccessCodeDisplayed('ACH54321');
});

When("the customer attempts to click on the 'Initiate Return' button for the Achieve access code", () => {
 AccountDashboardPage.attemptToInitiateReturn();
});

Then("the 'Initiate Return' button is disabled or not present", () => {
 AccountDashboardPage.verifyInitiateReturnButtonDisabled();
});

And("the customer is notified that the return period has expired", () => {
 AccountDashboardPage.verifyReturnPeriodExpiredNotification();
});