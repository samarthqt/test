import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import HomePage from "../pages/homePage";

Given("the user is on the homepage of the e-commerce website", () => {
 HomePage.visit();
});

When("the user visits the homepage", () => {
 HomePage.visit();
});

Then("the promotional banner for current sales and discounts should be displayed prominently", () => {
 HomePage.verifyPromotionalBannerDisplayed();
});

Given("the promotional banner is displayed on the homepage", () => {
 HomePage.verifyPromotionalBannerDisplayed();
});

When("the user views the promotional banner", () => {
 HomePage.viewPromotionalBanner();
});

Then("the banner should display accurate information about current sales and discounts", () => {
 HomePage.verifyBannerInformation();
});

Given("a new promotional campaign is launched", () => {
 HomePage.launchNewCampaign();
});

Then("the promotional banner should be updated with the new sales and discounts information", () => {
 HomePage.verifyUpdatedBannerInformation();
});

When("the user clicks on the promotional banner", () => {
 HomePage.clickPromotionalBanner();
});

Then("the user should be redirected to the promotions page with details of the current sales and discounts", () => {
 cy.url().should("include", "/promotions");
});

Given("the user accesses the website on a desktop, tablet, or mobile device", () => {
 HomePage.accessOnDifferentDevices();
});

When("the promotional banner is displayed", () => {
 HomePage.verifyPromotionalBannerDisplayed();
});

Then("the banner should be responsive and display properly on the device being used", () => {
 HomePage.verifyBannerResponsiveness();
});

When("the user navigates through the homepage", () => {
 HomePage.navigateThroughHomepage();
});

Then("the banner should not obstruct the view of other important content or functionalities", () => {
 HomePage.verifyBannerDoesNotObstruct();
});