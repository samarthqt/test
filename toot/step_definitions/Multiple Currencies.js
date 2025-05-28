import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductPage from "../pages/productPage";

Given("the user is on the product page", () => {
 ProductPage.visit();
});

When("the user selects {string} from the currency dropdown", (currency) => {
 ProductPage.selectCurrency(currency);
});

Then("the prices should be displayed in {string}", (currency) => {
 ProductPage.verifyPricesInCurrency(currency);
});

When("the page is loaded", () => {
 ProductPage.verifyPageLoaded();
});

Then("the prices should be displayed in the default currency", () => {
 ProductPage.verifyPricesInDefaultCurrency();
});

When("the user navigates to another product page", () => {
 ProductPage.navigateToAnotherProductPage();
});

Then("the prices should still be displayed in {string}", (currency) => {
 ProductPage.verifyPricesInCurrency(currency);
});

When("the user selects an invalid currency from the currency dropdown", () => {
 ProductPage.selectInvalidCurrency();
});

Then("an error message should be displayed indicating the currency is not supported", () => {
 ProductPage.verifyInvalidCurrencyError();
});

When("the prices are displayed", () => {
 ProductPage.verifyPricesDisplayed();
});

Then("the conversion rate should be accurate according to the latest exchange rate", () => {
 ProductPage.verifyConversionRateAccuracy();
});

When("the user logs out and logs back in", () => {
 ProductPage.logoutAndLogin();
});
