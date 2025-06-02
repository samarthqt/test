import { Given, Then } from "cypress-cucumber-preprocessor/steps";
import FilterPage from "../pages/filterPage";

Given("I open the application in a desktop browser", () => {
 FilterPage.visitDesktop();
});

Then("the application should load successfully", () => {
 FilterPage.verifyAppLoad();
});

Given("I navigate to the product listing page on a desktop browser", () => {
 FilterPage.navigateToProductListingDesktop();
});

Then("the product listing page should display correctly", () => {
 FilterPage.verifyProductListingDisplay();
});

Given("I locate the filter section on the desktop interface", () => {
 FilterPage.locateFilterSectionDesktop();
});

Then("filters should be visible and clearly labeled", () => {
 FilterPage.verifyFiltersVisibilityAndLabeling();
});

Given("I access the application on a mobile browser", () => {
 FilterPage.visitMobile();
});

Then("the application should load successfully on mobile", () => {
 FilterPage.verifyAppLoadMobile();
});

Given("I navigate to the product listing page on mobile", () => {
 FilterPage.navigateToProductListingMobile();
});

Then("the product listing page should display correctly on mobile", () => {
 FilterPage.verifyProductListingDisplayMobile();
});

Given("I locate the filter section on the mobile interface", () => {
 FilterPage.locateFilterSectionMobile();
});

Then("filters should be visible and clearly labeled on mobile", () => {
 FilterPage.verifyFiltersVisibilityAndLabelingMobile();
});

Given("I access the filter section", () => {
 FilterPage.accessFilterSection();
});

Then("filters should be accessible with one click or tap", () => {
 FilterPage.verifyFiltersAccessibility();
});

Given("I resize the browser window on desktop", () => {
 FilterPage.resizeBrowserWindowDesktop();
});

Then("filter labels should adjust correctly to different screen sizes", () => {
 FilterPage.verifyFilterLabelsResponsivenessDesktop();
});

Given("I view the filter labels on different mobile screen sizes", () => {
 FilterPage.viewFilterLabelsMobileScreens();
});

Then("filter labels should adjust correctly on different mobile screen sizes", () => {
 FilterPage.verifyFilterLabelsResponsivenessMobile();
});

Given("I use keyboard shortcuts to access filters on desktop", () => {
 FilterPage.useKeyboardShortcutsDesktop();
});

Then("filters should be accessible using keyboard shortcuts", () => {
 FilterPage.verifyKeyboardShortcutsAccessibility();
});

Given("I use voice commands to access filters on mobile", () => {
 FilterPage.useVoiceCommandsMobile();
});

Then("filters should be accessible using voice commands", () => {
 FilterPage.verifyVoiceCommandsAccessibility();
});

Given("I view the filter labels", () => {
 FilterPage.viewFilterLabels();
});

Then("filter labels should not overlap with other UI elements", () => {
 FilterPage.verifyNoOverlapWithUIElements();
});

Given("I check the filter labels in different lighting conditions on mobile", () => {
 FilterPage.checkFilterLabelsLightingConditionsMobile();
});

Then("filter labels should be readable in different lighting conditions", () => {
 FilterPage.verifyFilterLabelsReadabilityLightingConditionsMobile();
});

Given("I apply filters on both platforms", () => {
 FilterPage.applyFiltersBothPlatforms();
});

Then("filters should be applied correctly on both desktop and mobile", () => {
 FilterPage.verifyFiltersApplicationBothPlatforms();
});

Given("I reset the filters after application", () => {
 FilterPage.resetFiltersAfterApplication();
});

Then("filters should reset correctly after application", () => {
 FilterPage.verifyFiltersReset();
});