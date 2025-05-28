import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("the user is on the checkout page", () => {
 CheckoutPage.visit();
});

When("the user enters their location as {string}", (location) => {
 CheckoutPage.enterLocation(location);
});

Then("the system should calculate the tax based on {string}", (location) => {
 CheckoutPage.calculateTax(location);
});

Then("the calculated tax should be {string}", (expectedTax) => {
 CheckoutPage.verifyTax(expectedTax);
});

Given("the user enters their location as {string}", (location) => {
 CheckoutPage.enterLocation(location);
});

When("the system calculates the tax", () => {
 CheckoutPage.calculateTax();
});

Then("the calculated tax should be {string}", (expectedTax) => {
 CheckoutPage.verifyTax(expectedTax);
});

Given("the user initially enters their location as {string}", (location) => {
 CheckoutPage.enterLocation(location);
});

And("the system calculates the tax as {string}", (expectedTax) => {
 CheckoutPage.verifyTax(expectedTax);
});

When("the user changes their location to {string}", (newLocation) => {
 CheckoutPage.changeLocation(newLocation);
});

Then("the system should recalculate the tax as {string}", (newExpectedTax) => {
 CheckoutPage.verifyTax(newExpectedTax);
});

Given("the user enters their location as {string}", (location) => {
 CheckoutPage.enterLocation(location);
});

When("the system calculates the tax", () => {
 CheckoutPage.calculateTax();
});

Then("the system should display an error message {string}", (errorMessage) => {
 CheckoutPage.verifyErrorMessage(errorMessage);
});

Given("the user does not enter any location", () => {
 CheckoutPage.clearLocation();
});

When("the system attempts to calculate the tax", () => {
 CheckoutPage.calculateTax();
});

Then("the system should display an error message {string}", (errorMessage) => {
 CheckoutPage.verifyErrorMessage(errorMessage);
});