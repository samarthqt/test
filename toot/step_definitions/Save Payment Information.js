import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import PaymentInfoPage from "../pages/paymentInfoPage";

Given("the user is logged into their account", () => {
 // Assume user is logged in
});

Given("the user is on the Payment Info page", () => {
 PaymentInfoPage.visit();
});

Given("the user enters valid payment details", (dataTable) => {
 const paymentDetails = dataTable.rowsHash();
 PaymentInfoPage.enterPaymentDetails(paymentDetails);
});

Given("the user enters invalid payment details", (dataTable) => {
 const paymentDetails = dataTable.rowsHash();
 PaymentInfoPage.enterPaymentDetails(paymentDetails);
});

Given("the user enters incomplete payment details", (dataTable) => {
 const paymentDetails = dataTable.rowsHash();
 PaymentInfoPage.enterPaymentDetails(paymentDetails);
});

Given("the user has previously saved payment information", () => {
 // Assume payment info is saved
});

When("the user saves the payment information", () => {
 PaymentInfoPage.savePaymentInfo();
});

When("the user attempts to save the payment information", () => {
 PaymentInfoPage.savePaymentInfo();
});

When("the user updates the payment details", (dataTable) => {
 const paymentDetails = dataTable.rowsHash();
 PaymentInfoPage.enterPaymentDetails(paymentDetails);
});

When("the user saves the updated payment information", () => {
 PaymentInfoPage.savePaymentInfo();
});

When("the user opts to delete the saved payment information", () => {
 PaymentInfoPage.deletePaymentInfo();
});

Then("the payment information should be saved securely", () => {
 PaymentInfoPage.verifyPaymentSaved();
});

Then("a confirmation message \"Payment information saved successfully.\" should be displayed", () => {
 PaymentInfoPage.verifyConfirmationMessage("Payment information saved successfully.");
});

Then("an error message \"Invalid payment details. Please check and try again.\" should be displayed", () => {
 PaymentInfoPage.verifyErrorMessage("Invalid payment details. Please check and try again.");
});

Then("the payment information should not be saved", () => {
 PaymentInfoPage.verifyPaymentNotSaved();
});

Then("an error message \"Please fill in all required fields.\" should be displayed", () => {
 PaymentInfoPage.verifyErrorMessage("Please fill in all required fields.");
});

Then("the updated payment information should be saved securely", () => {
 PaymentInfoPage.verifyPaymentSaved();
});

Then("a confirmation message \"Payment information updated successfully.\" should be displayed", () => {
 PaymentInfoPage.verifyConfirmationMessage("Payment information updated successfully.");
});

Then("the payment information should be removed", () => {
 PaymentInfoPage.verifyPaymentRemoved();
});

Then("a confirmation message \"Payment information deleted successfully.\" should be displayed", () => {
 PaymentInfoPage.verifyConfirmationMessage("Payment information deleted successfully.");
});