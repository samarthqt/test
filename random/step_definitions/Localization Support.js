import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import LocalizationPage from '../pageObjects/LocalizationPage';

const localizationPage = new LocalizationPage();

Given('the user opens the application', () => {
  localizationPage.openApplication();
});

When('the application detects the user's location', () => {
  localizationPage.detectUserLocation();
});

Then('the application should automatically set the language and currency according to the user's region', () => {
  localizationPage.verifyAutoLanguageAndCurrency();
});

Given('the user is on the settings page', () => {
  localizationPage.navigateToSettings();
});

When('the user selects a different language', () => {
  localizationPage.selectDifferentLanguage();
});

When('the user selects a different currency', () => {
  localizationPage.selectDifferentCurrency();
});

Then('the application should update to the selected language and currency', () => {
  localizationPage.verifyUpdatedLanguageAndCurrency();
});

Given('the application is set to a specific language', () => {
  localizationPage.setSpecificLanguage();
});

When('the user navigates through the application', () => {
  localizationPage.navigateThroughApplication();
});

Then('all content should be accurately translated and displayed correctly in the selected language', () => {
  localizationPage.verifyContentTranslation();
});

Given('the application supports currency conversion', () => {
  localizationPage.supportsCurrencyConversion();
});

When('a day has passed', () => {
  localizationPage.dayPassed();
});

Then('the application should update the currency conversion rates', () => {
  localizationPage.updateCurrencyRates();
});

Given('the application supports multiple languages and currencies', () => {
  localizationPage.supportsMultipleLanguagesAndCurrencies();
});

When('localization tests are performed', () => {
  localizationPage.performLocalizationTests();
});

Then('the application should pass all tests ensuring accuracy and functionality in different regions and languages', () => {
  localizationPage.verifyLocalizationTests();
});