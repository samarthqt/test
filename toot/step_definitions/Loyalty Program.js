import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LoyaltyProgramPage from "../pages/loyaltyProgramPage";

Given("the user is logged into their account", () => {
 LoyaltyProgramPage.ensureLoggedIn();
});

Given("the user is on the User Account page", () => {
 LoyaltyProgramPage.visitUserAccountPage();
});

When("the user opts to join the Loyalty Program", () => {
 LoyaltyProgramPage.joinLoyaltyProgram();
});

Then("the user should be successfully enrolled in the Loyalty Program", () => {
 LoyaltyProgramPage.verifyEnrollmentSuccess();
});

Then("the user should receive a confirmation message", () => {
 LoyaltyProgramPage.verifyConfirmationMessage();
});

Given("the user is enrolled in the Loyalty Program", () => {
 LoyaltyProgramPage.ensureEnrolledInLoyaltyProgram();
});

When("the user makes a purchase", () => {
 LoyaltyProgramPage.makePurchase();
});

Then("the user should earn loyalty points for the purchase", () => {
 LoyaltyProgramPage.verifyPointsEarned();
});

Then("the points should be reflected in the user's account", () => {
 LoyaltyProgramPage.verifyPointsInAccount();
});

Given("the user has accumulated loyalty points", () => {
 LoyaltyProgramPage.ensurePointsAccumulated();
});

When("the user chooses to redeem points for a discount", () => {
 LoyaltyProgramPage.redeemPointsForDiscount();
});

Then("the discount should be applied to the user's purchase", () => {
 LoyaltyProgramPage.verifyDiscountApplied();
});

Then("the redeemed points should be deducted from the user's account", () => {
 LoyaltyProgramPage.verifyPointsDeducted();
});

When("the user navigates to the Loyalty section of their account", () => {
 LoyaltyProgramPage.navigateToLoyaltySection();
});

Then("the user should see their current loyalty points balance", () => {
 LoyaltyProgramPage.verifyPointsBalance();
});

When("there are new rewards or discounts available", () => {
 LoyaltyProgramPage.checkNewRewardsOrDiscounts();
});

Then("the user should receive a notification about the new offers", () => {
 LoyaltyProgramPage.verifyNotificationReceived();
});

When("the user opts to leave the Loyalty Program", () => {
 LoyaltyProgramPage.leaveLoyaltyProgram();
});

Then("the user should be successfully unenrolled from the Loyalty Program", () => {
 LoyaltyProgramPage.verifyUnenrollmentSuccess();
});

Then("the user should receive a confirmation message", () => {
 LoyaltyProgramPage.verifyUnenrollmentConfirmationMessage();
});