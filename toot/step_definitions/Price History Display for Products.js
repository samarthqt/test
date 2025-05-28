import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductPricingPage from "../pages/productPricingPage";

Given("a user is on the product pricing page", () => {
 ProductPricingPage.visit();
});

Given("a product with a known price history", () => {
 ProductPricingPage.selectProductWithPriceHistory();
});

Given("a product has had price changes over time", () => {
 ProductPricingPage.selectProductWithDiscounts();
});

Given("a product with no recorded price history", () => {
 ProductPricingPage.selectProductWithoutPriceHistory();
});

Given("a user with accessibility needs", () => {
 ProductPricingPage.enableAccessibilityFeatures();
});

When("the user views the product details", () => {
 ProductPricingPage.viewProductDetails();
});

When("the user views the price history", () => {
 ProductPricingPage.viewPriceHistory();
});

When("the user interacts with the price history graph or list", () => {
 ProductPricingPage.interactWithPriceHistory();
});

When("the user accesses the price history feature", () => {
 ProductPricingPage.accessPriceHistoryFeature();
});

When("the user applies a date range filter", () => {
 ProductPricingPage.applyDateRangeFilter();
});

Then("the price history of the product should be displayed", () => {
 ProductPricingPage.verifyPriceHistoryDisplayed();
});

Then("the user should be able to see historical prices and dates", () => {
 ProductPricingPage.verifyHistoricalPricesAndDatesVisible();
});

Then("the user should be able to identify periods of discounts", () => {
 ProductPricingPage.verifyDiscountPeriodsIdentifiable();
});

Then("a message should be displayed stating \"No price history available\"", () => {
 ProductPricingPage.verifyNoPriceHistoryMessage();
});

Then("the price history should be displayed in a chronological order", () => {
 ProductPricingPage.verifyPriceHistoryChronologicalOrder();
});

Then("each entry should show the date and price", () => {
 ProductPricingPage.verifyDateAndPriceInEachEntry();
});

Then("the user should be able to hover over points to see exact prices and dates", () => {
 ProductPricingPage.verifyHoverFunctionality();
});

Then("the feature should be compatible with screen readers", () => {
 ProductPricingPage.verifyScreenReaderCompatibility();
});

Then("all elements should have appropriate labels for accessibility", () => {
 ProductPricingPage.verifyAccessibilityLabels();
});

Then("only the price history within the selected date range should be displayed", () => {
 ProductPricingPage.verifyFilteredPriceHistoryDisplayed();
});