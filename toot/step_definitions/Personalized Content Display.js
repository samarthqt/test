import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import PersonalizedContentPage from "../pages/personalizedContentPage";

Given("the user is logged into the application", () => {
 PersonalizedContentPage.login();
});

Given("the user has previously interacted with specific categories", () => {
 PersonalizedContentPage.setUserCategories();
});

When("the user visits the homepage", () => {
 PersonalizedContentPage.visitHomepage();
});

Then("personalized banners related to those categories should be displayed", () => {
 PersonalizedContentPage.verifyPersonalizedBanners();
});

Given("the user has a history of purchasing specific types of products", () => {
 PersonalizedContentPage.setPurchaseHistory();
});

When("the user navigates to the promotions page", () => {
 PersonalizedContentPage.visitPromotionsPage();
});

Then("promotions related to the user's purchase history should be displayed", () => {
 PersonalizedContentPage.verifyPersonalizedPromotions();
});

Given("the user has no recorded behavior data", () => {
 PersonalizedContentPage.clearUserBehaviorData();
});

Then("default banners and promotions should be displayed", () => {
 PersonalizedContentPage.verifyDefaultContent();
});

Given("the user has interacted with new categories", () => {
 PersonalizedContentPage.updateUserCategories();
});

Then("the personalized banners should reflect the new interactions", () => {
 PersonalizedContentPage.verifyUpdatedBanners();
});

Given("the user is not logged into the application", () => {
 PersonalizedContentPage.logout();
});

Then("only default banners and promotions should be displayed", () => {
 PersonalizedContentPage.verifyDefaultContentForUnauthenticated();
});