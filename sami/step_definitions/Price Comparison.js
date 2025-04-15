import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import ProductComparisonPage from '../pageObjects/ProductComparisonPage';

const productComparisonPage = new ProductComparisonPage();

Given('I am on the product comparison page', () => {
  productComparisonPage.visitComparisonPage();
});

When('I select two similar products to compare', () => {
  productComparisonPage.selectSimilarProducts(2);
});

When('I select multiple similar products to compare', () => {
  productComparisonPage.selectSimilarProducts(3);
});

When('I do not select any products to compare', () => {
  productComparisonPage.clearProductSelection();
});

When('I select products with different attributes to compare', () => {
  productComparisonPage.selectDifferentAttributeProducts();
});

When('I select products with similar prices to compare', () => {
  productComparisonPage.selectSimilarPriceProducts();
});

When('I select a product from the comparison list', () => {
  productComparisonPage.selectProductFromList();
});

When('I choose to reset the comparison selection', () => {
  productComparisonPage.resetComparisonSelection();
});

Then('I should see a side-by-side comparison of the products' features', () => {
  productComparisonPage.verifySideBySideComparison();
});

Then('I should see the price difference between the two products', () => {
  productComparisonPage.verifyPriceDifference();
});

Then('I should see the price differences among the selected products', () => {
  productComparisonPage.verifyPriceDifferences();
});

Then('I should see a message indicating that no products have been selected for comparison', () => {
  productComparisonPage.verifyNoProductsSelectedMessage();
});

Then('I should see the attributes that are not comparable highlighted or noted', () => {
  productComparisonPage.verifyNonComparableAttributes();
});

Then('I should see a message indicating that the prices are similar', () => {
  productComparisonPage.verifySimilarPricesMessage();
});

Then('I should be able to view detailed information about the selected product', () => {
  productComparisonPage.verifyDetailedProductInformation();
});

Then('all selected products should be deselected', () => {
  productComparisonPage.verifyProductsDeselected();
});

Then('the comparison page should be reset to its initial state', () => {
  productComparisonPage.verifyPageReset();
});