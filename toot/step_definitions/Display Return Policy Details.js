import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import HomePage from "../pages/homePage";
import ProductPage from "../pages/productPage";
import ReturnPolicyPage from "../pages/returnPolicyPage";

Given("I am on the homepage of the e-commerce site", () => {
 HomePage.visit();
});

When("I navigate to the footer section", () => {
 HomePage.scrollToFooter();
});

Then("I should see a link to \"Return Policy\"", () => {
 HomePage.verifyReturnPolicyLink();
});

When("I click on the \"Return Policy\" link in the footer", () => {
 HomePage.clickReturnPolicyLink();
});

Then("I should be redirected to the \"Return Policy\" page", () => {
 ReturnPolicyPage.verifyPage();
});

Then("I should see the return policy details clearly displayed", () => {
 ReturnPolicyPage.verifyDetailsDisplayed();
});

Given("I am on a product page", () => {
 ProductPage.visit();
});

When("I scroll to the bottom of the page", () => {
 ProductPage.scrollToFooter();
});

Given("I am on the \"Return Policy\" page", () => {
 ReturnPolicyPage.visit();
});

Then("I should see information about:", (dataTable) => {
 const topics = dataTable.rawTable.slice(1);
 ReturnPolicyPage.verifyInformationTopics(topics);
});

Given("I am using a mobile device", () => {
 cy.viewport('iphone-x');
});

When("I navigate to the \"Return Policy\" page", () => {
 ReturnPolicyPage.visit();
});

Then("the return policy details should be clearly visible and readable", () => {
 ReturnPolicyPage.verifyMobileVisibility();
});

Then("the page layout should be responsive", () => {
 ReturnPolicyPage.verifyResponsiveLayout();
});

When("I change the site language to Spanish", () => {
 ReturnPolicyPage.changeLanguageToSpanish();
});

Then("the return policy details should be displayed in Spanish", () => {
 ReturnPolicyPage.verifyDetailsInSpanish();
});