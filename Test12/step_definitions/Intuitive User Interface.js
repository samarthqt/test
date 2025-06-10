import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import HomePage from "../pages/homePage";
import ProductListingPage from "../pages/productListingPage";
import NavigationPage from "../pages/navigationPage";
import SearchPage from "../pages/searchPage";
import FeedbackPage from "../pages/feedbackPage";
import AccessibilityPage from "../pages/accessibilityPage";
import ResponsivePage from "../pages/responsivePage";
import ErrorPage from "../pages/errorPage";
import UserTestingPage from "../pages/userTestingPage";
import DesignReviewPage from "../pages/designReviewPage";

Given("the user is on the homepage", () => {
 HomePage.visit();
});

When("the user views the product categories", () => {
 HomePage.viewCategories();
});

Then("the categories should be clearly labeled", () => {
 HomePage.verifyCategoriesLabel();
});

Given("the user is on the product listing page", () => {
 ProductListingPage.visit();
});

When("the user applies a filter", () => {
 ProductListingPage.applyFilter();
});

Then("the filter should be easy to apply", () => {
 ProductListingPage.verifyFilterEase();
});

Then("the results should update responsively", () => {
 ProductListingPage.verifyResponsiveResults();
});

Given("the user is on any page of the application", () => {
 NavigationPage.visitAnyPage();
});

When("the user navigates to another page", () => {
 NavigationPage.navigateToAnotherPage();
});

Then("the navigation should be consistent across all pages", () => {
 NavigationPage.verifyConsistentNavigation();
});

When("the user enters a search query", () => {
 SearchPage.enterSearchQuery();
});

Then("the search results should be relevant", () => {
 SearchPage.verifyRelevantResults();
});

Then("the results should be returned quickly", () => {
 SearchPage.verifyQuickResults();
});

Given("the application has received user feedback", () => {
 FeedbackPage.receiveFeedback();
});

When("the feedback is reviewed", () => {
 FeedbackPage.reviewFeedback();
});

Then("the feedback should be incorporated into the UI design", () => {
 FeedbackPage.verifyFeedbackIncorporation();
});

Given("the user is using assistive technologies", () => {
 AccessibilityPage.useAssistiveTech();
});

When("the user interacts with the application", () => {
 AccessibilityPage.interactWithApp();
});

Then("the application should meet accessibility standards", () => {
 AccessibilityPage.verifyAccessibilityStandards();
});

Given("the user is using a device with different screen sizes", () => {
 ResponsivePage.useDifferentScreenSizes();
});

When("the user views the application", () => {
 ResponsivePage.viewApplication();
});

Then("the UI should be responsive to different screen sizes", () => {
 ResponsivePage.verifyUIResponsiveness();
});

Given("the user performs an invalid action", () => {
 ErrorPage.performInvalidAction();
});

When("the error message is displayed", () => {
 ErrorPage.displayErrorMessage();
});

Then("the error message should be clear", () => {
 ErrorPage.verifyClearErrorMessage();
});

Then("the error message should be actionable", () => {
 ErrorPage.verifyActionableErrorMessage();
});

Given("user testing is conducted", () => {
 UserTestingPage.conductUserTesting();
});

When("the user tests the application navigation", () => {
 UserTestingPage.testNavigation();
});

Then("the navigation should be validated for ease of use", () => {
 UserTestingPage.verifyNavigationEase();
});

Given("the application design is reviewed", () => {
 DesignReviewPage.reviewDesign();
});

When("the design is compared with branding guidelines", () => {
 DesignReviewPage.compareWithBranding();
});

Then("the design should align with branding guidelines", () => {
 DesignReviewPage.verifyDesignAlignment();
});