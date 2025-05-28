import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("I am on the checkout page", () => {
 CheckoutPage.visitCheckout();
});

When("I enter my delivery location as {string}", (location) => {
 CheckoutPage.enterDeliveryLocation(location);
});

Then("I should see the following shipping options", (dataTable) => {
 const options = dataTable.hashes();
 options.forEach(option => {
 CheckoutPage.verifyShippingOption(option.OptionName, option.DeliverySpeed, option.Availability);
 });
 CheckoutPage.verifyOptionsSortedBySpeed();
});

Given("I have entered my delivery location as {string}", (location) => {
 CheckoutPage.enterDeliveryLocation(location);
});

When("I choose {string}", (shippingOption) => {
 CheckoutPage.selectShippingOption(shippingOption);
});

Then("the selected shipping option should be {string}", (shippingOption) => {
 CheckoutPage.verifySelectedShippingOption(shippingOption);
});

Then("the estimated delivery date should be updated accordingly", () => {
 CheckoutPage.verifyEstimatedDeliveryDate();
});

Then("I should see a message indicating {string}", (message) => {
 CheckoutPage.verifyUnavailableShippingMessage(message);
});

Then("I should only see the following available options", (dataTable) => {
 const options = dataTable.hashes();
 options.forEach(option => {
 CheckoutPage.verifyAvailableShippingOption(option.OptionName, option.DeliverySpeed);
 });
});

Then("the shipping cost should be calculated based on the selected option", () => {
 CheckoutPage.verifyShippingCostCalculation();
});

Then("the total cost should reflect the added shipping cost", () => {
 CheckoutPage.verifyTotalCostWithShipping();
});

When("I proceed to checkout without selecting a shipping option", () => {
 CheckoutPage.proceedToCheckoutWithoutSelection();
});

Then("{string} should be selected by default", (defaultOption) => {
 CheckoutPage.verifyDefaultShippingOption(defaultOption);
});