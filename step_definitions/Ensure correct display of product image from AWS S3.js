import { Given, Then } from "cypress-cucumber-preprocessor/steps";
import ProductPage from "../pages/productPage";

Given("I access the product page with ID {int}", (id) => {
 ProductPage.visit(id);
});

Then("the product page loads successfully", () => {
 ProductPage.verifyPageLoad();
});

Given("the product image URL is {string}", (url) => {
 ProductPage.setImageUrl(url);
});

Then("the image URL is correct and accessible", () => {
 ProductPage.verifyImageUrl();
});

Given("I am on the product page with ID {int}", (id) => {
 ProductPage.visit(id);
});

Then("the image is displayed without distortion", () => {
 ProductPage.verifyImageDisplay();
});

Given("I refresh the product page with ID {int}", (id) => {
 ProductPage.refreshPage(id);
});

Then("the image remains displayed correctly", () => {
 ProductPage.verifyImagePersistence();
});

Given("the product image is stored on AWS S3", () => {
 ProductPage.verifyImageStorage();
});

Then("image retrieval is successful without errors", () => {
 ProductPage.verifyImageRetrieval();
});

Then("the image display is consistent across all browsers", () => {
 ProductPage.verifyImageConsistency();
});

Given("I access the product page with ID {int} on a mobile device", (id) => {
 ProductPage.visitMobile(id);
});

Then("the image is displayed correctly on mobile", () => {
 ProductPage.verifyImageOnMobile();
});

Given("the product image URL is stored in the database", () => {
 ProductPage.verifyImageUrlInDatabase();
});

Then("the database entry matches the displayed image URL", () => {
 ProductPage.verifyDatabaseEntry();
});

Given("the product image is cached", () => {
 ProductPage.verifyImageCaching();
});

Then("the image is cached correctly for faster loading", () => {
 ProductPage.verifyCachingMechanism();
});

Given("high traffic conditions", () => {
 ProductPage.simulateHighTraffic();
});

Then("image retrieval remains consistent without delays", () => {
 ProductPage.verifyRetrievalUnderTraffic();
});

Given("the image retrieval process", () => {
 ProductPage.initiateImageRetrieval();
});

Then("no unexpected notifications are triggered", () => {
 ProductPage.verifyNoNotifications();
});

Given("network latency conditions", () => {
 ProductPage.simulateNetworkLatency();
});

Then("the image is displayed correctly despite network latency", () => {
 ProductPage.verifyDisplayUnderLatency();
});

Given("product updates are made", () => {
 ProductPage.applyProductUpdates();
});

Then("the image remains displayed correctly after updates", () => {
 ProductPage.verifyPostUpdateDisplay();
});

Given("AWS S3 permissions settings", () => {
 ProductPage.verifyS3Permissions();
});

Then("the image is displayed correctly regardless of AWS S3 permissions", () => {
 ProductPage.verifyDisplayWithPermissions();
});

Given("different screen resolutions", () => {
 ProductPage.setScreenResolutions();
});

Then("the image is displayed correctly with various resolutions", () => {
 ProductPage.verifyDisplayWithResolutions();
});