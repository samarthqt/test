import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import ProductPage from '../pageObjects/ProductPage';

const productPage = new ProductPage();

Given('the user is on the product page', () => {
  productPage.visitProductPage();
});

When('the user selects {string} from the currency dropdown', (currency) => {
  productPage.selectCurrency(currency);
});

Then('the prices should be displayed in {string}', (currency) => {
  productPage.verifyPricesInCurrency(currency);
});

When('the page is loaded', () => {
  productPage.verifyPageLoaded();
});

Then('the prices should be displayed in the default currency', () => {
  productPage.verifyPricesInDefaultCurrency();
});

When('the user navigates to another product page', () => {
  productPage.navigateToAnotherProductPage();
});

Then('the prices should still be displayed in {string}', (currency) => {
  productPage.verifyPricesInCurrency(currency);
});

When('the user selects an invalid currency from the currency dropdown', () => {
  productPage.selectInvalidCurrency();
});

Then('an error message should be displayed indicating the currency is not supported', () => {
  productPage.verifyInvalidCurrencyErrorMessage();
});

When('the prices are displayed', () => {
  productPage.verifyPricesDisplayed();
});

Then('the conversion rate should be accurate according to the latest exchange rate', () => {
  productPage.verifyConversionRateAccuracy();
});

When('the user logs out and logs back in', () => {
  productPage.logoutAndLogin();
});
