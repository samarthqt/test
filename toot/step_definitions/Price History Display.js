import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductPricingPage from "../pages/productPricingPage";

Given("the user is on the product pricing page", () => {
 ProductPricingPage.visit();
});

Given("the user selects a product", () => {
 ProductPricingPage.selectProduct();
});

Given("the user selects a product with no price history", () => {
 ProductPricingPage.selectProductNoHistory();
});

When("the user requests the price history", () => {
 ProductPricingPage.requestPriceHistory();
});

When("the user requests price history for multiple products", () => {
 ProductPricingPage.requestMultipleProductsHistory();
});

When("the price history is displayed", () => {
 ProductPricingPage.verifyPriceHistoryDisplayed();
});

Then("the system should display the historical pricing of the selected product", () => {
 ProductPricingPage.verifyPriceHistory();
});

Then("the historical pricing should be shown in a chronological order", () => {
 ProductPricingPage.verifyChronologicalOrder();
});

Then("each entry should include the date and price", () => {
 ProductPricingPage.verifyDateAndPriceIncluded();
});

Then("the user should be able to identify periods of discounts", () => {
 ProductPricingPage.verifyDiscountPeriods();
});

Then("the system should display the historical pricing for each selected product", () => {
 ProductPricingPage.verifyMultipleProductsHistory();
});

Then("the system should inform the user that no historical pricing is available", () => {
 ProductPricingPage.verifyNoPriceHistoryMessage();
});

Then("the system should provide the historical pricing data with low priority", () => {
 ProductPricingPage.verifyLowPriorityData();
});

Then("the system performance should not be impacted", () => {
 ProductPricingPage.verifySystemPerformance();
});