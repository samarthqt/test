import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductPage from "../pages/productPage";

Given("the retail application is open on a desktop browser", () => {
 ProductPage.openDesktopBrowser();
});

Given("the retail application is open on a mobile browser", () => {
 ProductPage.openMobileBrowser();
});

When("I navigate to the product catalog section", () => {
 ProductPage.navigateToCatalog();
});

When("I navigate to the product catalog section on mobile", () => {
 ProductPage.navigateToCatalogMobile();
});

Then("the product catalog is displayed on the desktop screen", () => {
 ProductPage.verifyCatalogDisplayedDesktop();
});

Then("the product catalog is displayed on the mobile screen", () => {
 ProductPage.verifyCatalogDisplayedMobile();
});

When("I select a product from the catalog", () => {
 ProductPage.selectProduct();
});

When("I select the same product from the catalog on mobile", () => {
 ProductPage.selectProductMobile();
});

Then("the product details page is displayed with product information", () => {
 ProductPage.verifyProductDetailsDisplayed();
});

Then("the product details page is displayed with product information on mobile", () => {
 ProductPage.verifyProductDetailsDisplayedMobile();
});

Then("product name, description, price, and image are visible and correctly displayed on the desktop", () => {
 ProductPage.verifyProductDetailsDesktop();
});

Then("product name, description, price, and image are visible and correctly displayed on the mobile", () => {
 ProductPage.verifyProductDetailsMobile();
});

Given("the product details are visible on both desktop and mobile platforms", () => {
 ProductPage.verifyProductDetailsVisibleOnBothPlatforms();
});

Then("there are no discrepancies; product details are consistent across platforms", () => {
 ProductPage.verifyConsistencyAcrossPlatforms();
});

Given("the product details page is displayed on mobile", () => {
 ProductPage.verifyProductDetailsPageMobile();
});

When("I rotate the mobile device", () => {
 ProductPage.rotateMobileDevice();
});

Then("the product details page adjusts correctly to landscape and portrait orientations", () => {
 ProductPage.verifyResponsiveDesign();
});

Given("the product details page is displayed on both desktop and mobile", () => {
 ProductPage.verifyProductDetailsPageOnBothPlatforms();
});

Then("the product details page loads within acceptable time limits on both platforms", () => {
 ProductPage.verifyLoadingTime();
});

When("I click on the 'Add to Cart' button", () => {
 ProductPage.clickAddToCart();
});

Then("the 'Add to Cart' button functions correctly on both platforms", () => {
 ProductPage.verifyAddToCartFunctionality();
});

Then("the product image displays correctly without distortion on both desktop and mobile", () => {
 ProductPage.verifyProductImageDisplay();
});

Then("no error messages or broken links are present on the product details page", () => {
 ProductPage.verifyNoErrorsOrBrokenLinks();
});

When("I share product details via social media links", () => {
 ProductPage.shareProductDetails();
});

Then("product details can be shared successfully via social media links on both desktop and mobile", () => {
 ProductPage.verifySocialMediaSharing();
});