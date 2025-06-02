import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductPage from "../pages/productPage";
import CheckoutPage from "../pages/checkoutPage";

Given("I navigate to a product page priced in USD", () => {
 ProductPage.visit();
});

Then("the product page is displayed with USD pricing", () => {
 ProductPage.verifyUSDPrice();
});

When("I select EUR as the currency", () => {
 ProductPage.selectCurrency('EUR');
});

Then("the product price is converted to EUR", () => {
 ProductPage.verifyPriceConversion('EUR');
});

Given("the conversion rate fluctuation data for USD to EUR", () => {
 ProductPage.getConversionRateData('EUR');
});

Then("the converted price matches the expected value based on the current rate", () => {
 ProductPage.verifyExpectedPrice('EUR');
});

When("I simulate a high fluctuation in conversion rate", () => {
 ProductPage.simulateRateFluctuation('EUR');
});

Then("the system updates the conversion rate accordingly", () => {
 ProductPage.verifyRateUpdate('EUR');
});

When("I re-select EUR as the currency", () => {
 ProductPage.reselectCurrency('EUR');
});

Then("the product price reflects the updated EUR conversion rate", () => {
 ProductPage.verifyUpdatedPrice('EUR');
});

When("I select GBP as the currency", () => {
 ProductPage.selectCurrency('GBP');
});

Then("the product price is converted to GBP", () => {
 ProductPage.verifyPriceConversion('GBP');
});

Given("the conversion rate fluctuation data for USD to GBP", () => {
 ProductPage.getConversionRateData('GBP');
});

Then("the converted price matches the expected value based on the current rate", () => {
 ProductPage.verifyExpectedPrice('GBP');
});

When("I simulate another fluctuation in conversion rate", () => {
 ProductPage.simulateRateFluctuation('GBP');
});

Then("the system updates the conversion rate accordingly", () => {
 ProductPage.verifyRateUpdate('GBP');
});

When("I re-select GBP as the currency", () => {
 ProductPage.reselectCurrency('GBP');
});

Then("the product price reflects the updated GBP conversion rate", () => {
 ProductPage.verifyUpdatedPrice('GBP');
});

When("I check for any discrepancies in conversion calculations", () => {
 ProductPage.checkForDiscrepancies();
});

Then("no discrepancies are found and the conversion is accurate", () => {
 ProductPage.verifyNoDiscrepancies();
});

When("I navigate to checkout with the selected currency", () => {
 CheckoutPage.navigateWithCurrency();
});

Then("the checkout page displays prices in the selected currency", () => {
 CheckoutPage.verifyPricesInSelectedCurrency();
});

Then("the final price at checkout matches the expected conversion rate", () => {
 CheckoutPage.verifyFinalPrice();
});

When("I simulate rapid conversion rate changes during checkout", () => {
 CheckoutPage.simulateRapidRateChanges();
});

Then("the system handles rate changes without errors", () => {
 CheckoutPage.verifyRateChangeHandling();
});

When("I complete the purchase", () => {
 CheckoutPage.completePurchase();
});

Then("the purchase completes successfully with accurate pricing", () => {
 CheckoutPage.verifySuccessfulPurchase();
});

When("I review transaction logs for conversion accuracy", () => {
 CheckoutPage.reviewTransactionLogs();
});

Then("the transaction logs confirm accurate conversion rates", () => {
 CheckoutPage.verifyTransactionLogs();
});