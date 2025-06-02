import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LoginPage from "../pages/loginPage";
import SettingsPage from "../pages/settingsPage";

Given("the user is on the login page", () => {
 LoginPage.visit();
});

When("the user logs in with valid credentials", () => {
 LoginPage.enterCredentials();
 LoginPage.submit();
});

Then("the user should be logged in successfully", () => {
 cy.url().should("include", "/dashboard");
});

Then("the application should detect the user's region", () => {
 cy.get("body").should("have.attr", "data-region");
});

Given("the user is logged into the application", () => {
 LoginPage.visit();
 LoginPage.enterCredentials();
 LoginPage.submit();
});

When("the user navigates to the settings section", () => {
 SettingsPage.navigateToSettings();
});

Then("the user should be able to access the settings section without errors", () => {
 cy.url().should("include", "/settings");
});

When("the region is detected", () => {
 cy.get("body").should("have.attr", "data-region");
});

Then("the language should be automatically set to the user's regional language", () => {
 cy.get("html").should("have.attr", "lang");
});

Then("the currency should be automatically set to the user's regional currency", () => {
 cy.get("body").should("contain", "Currency:");
});

Then("the UI should display all text and currency values in the correct language and currency", () => {
 cy.get("body").should("contain", "Currency:");
});

Then("no error messages should be displayed related to language or currency settings", () => {
 cy.get(".error-message").should("not.exist");
});

When("the user changes language or currency settings during the session", () => {
 SettingsPage.changeLanguageAndCurrency();
});

Then("the changes should be reflected immediately", () => {
 cy.get("body").should("contain", "New Currency:");
});

When("region detection fails", () => {
 cy.intercept('GET', '/region', { statusCode: 500 }).as('getRegionFail');
 cy.wait('@getRegionFail');
});

Then("the system should revert to default language and currency settings", () => {
 cy.get("body").should("contain", "Default Currency:");
});

When("the user makes a purchase", () => {
 cy.get("#purchaseButton").click();
});

Then("logs should accurately reflect the language and currency settings during the transaction", () => {
 cy.get("#transactionLog").should("contain", "Currency:");
});

Then("the system should comply with all relevant regional regulations regarding language and currency settings", () => {
 cy.get("body").should("contain", "Compliant");
});

When("the user selects unsupported language or currency settings", () => {
 SettingsPage.selectUnsupportedSettings();
});

Then("the system should display an error message", () => {
 cy.get(".error-message").should("exist");
});

When("the user navigates to language and currency settings", () => {
 SettingsPage.navigateToLanguageAndCurrencySettings();
});

Then("the user should be able to manually adjust language and currency settings", () => {
 SettingsPage.adjustSettings();
});

Then("the UI should clearly display information about language and currency settings and options", () => {
 cy.get("#settingsInfo").should("exist");
});

When("the user adjusts language and currency settings", () => {
 SettingsPage.adjustSettings();
});

Then("no security vulnerabilities should be exposed", () => {
 cy.get("#securityCheck").should("contain", "Secure");
});

When("the user accesses the application from different devices and browsers", () => {
 cy.viewport('iphone-6');
 cy.visit('/');
 cy.viewport('macbook-15');
 cy.visit('/');
});

Then("language and currency settings should be consistent across all supported devices and browsers", () => {
 cy.get("body").should("contain", "Currency:");
});