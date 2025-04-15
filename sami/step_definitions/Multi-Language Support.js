import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import LanguagePage from '../page_objects/LanguagePage';

const languagePage = new LanguagePage();

Given('the user is on the homepage', () => {
  cy.visit('/');
});

When('the user selects {string} from the language dropdown', (language) => {
  languagePage.selectLanguage(language);
});

Then('the site should display content in {string}', (language) => {
  languagePage.verifyContentLanguage(language);
});

Then('the site should display content in English by default', () => {
  languagePage.verifyDefaultLanguage();
});

Given('the user selects {string} from the language dropdown', (language) => {
  languagePage.selectLanguage(language);
});

And('the user navigates to another page', () => {
  languagePage.navigateToAnotherPage();
});

Then('the site should continue to display content in Spanish', () => {
  languagePage.verifyContentLanguage('Spanish');
});

When('the user navigates to the {string} page', (pageName) => {
  languagePage.navigateToPage(pageName);
});

Then('the {string} page should display content in French', (pageName) => {
  languagePage.verifyPageContentLanguage(pageName, 'French');
});

Then('the language dropdown should be visible', () => {
  languagePage.verifyLanguageDropdownVisibility();
});

When('the user refreshes the page', () => {
  cy.reload();
});

Then('the site should continue to display content in German', () => {
  languagePage.verifyContentLanguage('German');
});