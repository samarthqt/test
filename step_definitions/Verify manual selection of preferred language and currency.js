import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import UserSettingsPage from "../pages/userSettingsPage";
import HomePage from "../pages/homePage";

Given("the user is logged into the application", () => {
 UserSettingsPage.login();
});

When("the user navigates to the user settings page", () => {
 UserSettingsPage.visit();
});

Then("the user settings page is displayed", () => {
 UserSettingsPage.verifyPageDisplayed();
});

Then("language options are available: English, Spanish, French", () => {
 UserSettingsPage.verifyLanguageOptions();
});

Then("currency options are available: USD, EUR, GBP", () => {
 UserSettingsPage.verifyCurrencyOptions();
});

Given("the language dropdown is visible", () => {
 UserSettingsPage.verifyLanguageDropdownVisible();
});

When("the user selects 'Spanish' from the language dropdown", () => {
 UserSettingsPage.selectLanguage('Spanish');
});

Then("the language is set to Spanish", () => {
 UserSettingsPage.verifyLanguageSetTo('Spanish');
});

Then("the currency dropdown is visible", () => {
 UserSettingsPage.verifyCurrencyDropdownVisible();
});

When("the user selects 'EUR' from the currency dropdown", () => {
 UserSettingsPage.selectCurrency('EUR');
});

Then("the currency is set to EUR", () => {
 UserSettingsPage.verifyCurrencySetTo('EUR');
});

And("the user saves the changes", () => {
 UserSettingsPage.saveChanges();
});

Then("the changes are saved successfully", () => {
 UserSettingsPage.verifyChangesSaved();
});

When("the user refreshes the page", () => {
 cy.reload();
});

Then("the settings remain unchanged", () => {
 UserSettingsPage.verifySettingsUnchanged();
});

Then("the language is Spanish", () => {
 UserSettingsPage.verifyLanguageIs('Spanish');
});

Then("the currency is EUR", () => {
 UserSettingsPage.verifyCurrencyIs('EUR');
});

When("the user navigates to the home page", () => {
 HomePage.visit();
});

Then("the home page is displayed in Spanish", () => {
 HomePage.verifyPageDisplayedInLanguage('Spanish');
});

Then("prices are shown in EUR", () => {
 HomePage.verifyPricesShownIn('EUR');
});

When("checking products listed on the page", () => {
 HomePage.checkProducts();
});

Then("product prices are displayed in EUR", () => {
 HomePage.verifyProductPricesIn('EUR');
});

When("the user accesses the help section", () => {
 HomePage.accessHelpSection();
});

Then("the help section is displayed in Spanish", () => {
 HomePage.verifyHelpSectionInLanguage('Spanish');
});

When("the user logs out and logs back in", () => {
 UserSettingsPage.logoutAndLogin();
});

Then("the language and currency settings persist", () => {
 UserSettingsPage.verifySettingsPersist();
});

When("the user switches to 'French' and 'GBP'", () => {
 UserSettingsPage.switchLanguageAndCurrency('French', 'GBP');
});

Then("the language is set to French", () => {
 UserSettingsPage.verifyLanguageSetTo('French');
});

Then("the currency is set to GBP", () => {
 UserSettingsPage.verifyCurrencySetTo('GBP');
});

When("the user repeats navigation steps to verify changes", () => {
 UserSettingsPage.repeatNavigationSteps();
});

Then("all pages display in French", () => {
 UserSettingsPage.verifyAllPagesInLanguage('French');
});

Then("prices are shown in GBP", () => {
 UserSettingsPage.verifyPricesShownIn('GBP');
});

When("checking if notifications are in the selected language", () => {
 UserSettingsPage.checkNotificationsLanguage();
});

Then("notifications are displayed in French", () => {
 UserSettingsPage.verifyNotificationsInLanguage('French');
});

When("the user attempts to change settings back to default", () => {
 UserSettingsPage.revertSettingsToDefault();
});

Then("settings revert to default language and currency", () => {
 UserSettingsPage.verifySettingsRevertedToDefault();
});