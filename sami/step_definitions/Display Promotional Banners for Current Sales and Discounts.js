import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import HomePage from '../pageObjects/HomePage';

const homePage = new HomePage();

Given('the user is on the homepage of the e-commerce website', () => {
  homePage.visitHomepage();
});

When('the user visits the homepage', () => {
  homePage.visitHomepage();
});

Then('the promotional banner for current sales and discounts should be displayed prominently', () => {
  homePage.verifyPromotionalBannerDisplayed();
});

Given('the promotional banner is displayed on the homepage', () => {
  homePage.verifyPromotionalBannerDisplayed();
});

When('the user views the promotional banner', () => {
  homePage.viewPromotionalBanner();
});

Then('the banner should display accurate information about current sales and discounts', () => {
  homePage.verifyPromotionalBannerInfo();
});

Given('a new promotional campaign is launched', () => {
  homePage.launchNewPromotionalCampaign();
});

When('the user clicks on the promotional banner', () => {
  homePage.clickPromotionalBanner();
});

Then('the user should be redirected to the promotions page with details of the current sales and discounts', () => {
  homePage.verifyRedirectionToPromotionsPage();
});

Given('the user accesses the website on a desktop, tablet, or mobile device', () => {
  homePage.accessOnDifferentDevices();
});

When('the promotional banner is displayed', () => {
  homePage.verifyPromotionalBannerDisplayed();
});

Then('the banner should be responsive and display properly on the device being used', () => {
  homePage.verifyBannerResponsiveness();
});

When('the user navigates through the homepage', () => {
  homePage.navigateThroughHomepage();
});

Then('the banner should not obstruct the view of other important content or functionalities', () => {
  homePage.verifyBannerNonObstruction();
});