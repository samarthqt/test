import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductComparisonPage from "../pages/productComparisonPage";

Given("I am on the product comparison page", () => {
 ProductComparisonPage.visit();
});

When("I select two similar products to compare", () => {
 ProductComparisonPage.selectProducts(2);
});

Then("I should see a side-by-side comparison of the products' features", () => {
 ProductComparisonPage.verifySideBySideComparison();
});

Then("I should see the price difference between the two products", () => {
 ProductComparisonPage.verifyPriceDifference();
});

When("I select multiple similar products to compare", () => {
 ProductComparisonPage.selectMultipleProducts();
});

Then("I should see the price differences among the selected products", () => {
 ProductComparisonPage.verifyPriceDifferences();
});

When("I do not select any products to compare", () => {
 ProductComparisonPage.verifyNoSelection();
});

Then("I should see a message indicating that no products have been selected for comparison", () => {
 ProductComparisonPage.verifyNoSelectionMessage();
});

When("I select products with different attributes to compare", () => {
 ProductComparisonPage.selectDifferentAttributeProducts();
});

Then("I should see the attributes that are not comparable highlighted or noted", () => {
 ProductComparisonPage.verifyNonComparableAttributes();
});

When("I select products with similar prices to compare", () => {
 ProductComparisonPage.selectSimilarPriceProducts();
});

Then("I should see a message indicating that the prices are similar", () => {
 ProductComparisonPage.verifySimilarPriceMessage();
});

When("I select a product from the comparison list", () => {
 ProductComparisonPage.selectProductFromList();
});

Then("I should be able to view detailed information about the selected product", () => {
 ProductComparisonPage.verifyDetailedProductInformation();
});

Given("I have selected products for comparison", () => {
 ProductComparisonPage.verifyProductsSelected();
});

When("I choose to reset the comparison selection", () => {
 ProductComparisonPage.resetSelection();
});

Then("all selected products should be deselected", () => {
 ProductComparisonPage.verifyDeselection();
});

Then("the comparison page should be reset to its initial state", () => {
 ProductComparisonPage.verifyPageReset();
});