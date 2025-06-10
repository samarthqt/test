import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ARPage from "../pages/arPage";

Given("a user is on the product page", () => {
 ARPage.visitProductPage();
});

When("the product supports AR try-on", () => {
 ARPage.checkARSupport();
});

Then("the AR feature should be accessible", () => {
 ARPage.verifyARFeatureAccessible();
});

Given("a user is using the AR try-on feature", () => {
 ARPage.accessARFeature();
});

When("the user views the product in AR", () => {
 ARPage.viewProductInAR();
});

Then("the virtual try-on should be realistic and accurate", () => {
 ARPage.verifyRealismAndAccuracy();
});

Given("a user is on the AR try-on interface", () => {
 ARPage.openARInterface();
});

When("the user interacts with the AR controls", () => {
 ARPage.interactWithARControls();
});

Then("the interface should be intuitive and easy to navigate", () => {
 ARPage.verifyInterfaceIntuitiveness();
});

Given("a user is using the AR feature", () => {
 ARPage.useARFeature();
});

When("the user navigates through the AR experience", () => {
 ARPage.navigateARExperience();
});

Then("the system performance should be optimized for a smooth experience", () => {
 ARPage.verifySystemPerformance();
});

Given("a user encounters an issue with the AR feature", () => {
 ARPage.encounterIssue();
});

When("the user seeks troubleshooting support", () => {
 ARPage.seekTroubleshootingSupport();
});

Then("the system should provide adequate troubleshooting support for AR feature issues", () => {
 ARPage.verifyTroubleshootingSupport();
});