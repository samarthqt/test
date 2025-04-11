import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import LoyaltyProgramPage from '../pageObjects/LoyaltyProgramPage';

const loyaltyProgramPage = new LoyaltyProgramPage();

Given('the user is logged into their account', () => {
  // Implement login functionality here
  cy.login();
});

Given('the user is on the User Account page', () => {
  loyaltyProgramPage.visitUserAccountPage();
});

When('the user opts to join the Loyalty Program', () => {
  loyaltyProgramPage.joinLoyaltyProgram();
});

Then('the user should be successfully enrolled in the Loyalty Program', () => {
  loyaltyProgramPage.verifyEnrollmentSuccess();
});

Then('the user should receive a confirmation message', () => {
  loyaltyProgramPage.verifyConfirmationMessage();
});

Given('the user is enrolled in the Loyalty Program', () => {
  // Assume user is already enrolled
});

When('the user makes a purchase', () => {
  loyaltyProgramPage.makePurchase();
});

Then('the user should earn loyalty points for the purchase', () => {
  loyaltyProgramPage.verifyPointsEarned();
});

Then('the points should be reflected in the user's account', () => {
  loyaltyProgramPage.verifyPointsInAccount();
});

Given('the user has accumulated loyalty points', () => {
  // Assume user has points
});

When('the user chooses to redeem points for a discount', () => {
  loyaltyProgramPage.redeemPointsForDiscount();
});

Then('the discount should be applied to the user's purchase', () => {
  loyaltyProgramPage.verifyDiscountApplied();
});

Then('the redeemed points should be deducted from the user's account', () => {
  loyaltyProgramPage.verifyPointsDeducted();
});

When('the user navigates to the Loyalty section of their account', () => {
  loyaltyProgramPage.navigateToLoyaltySection();
});

Then('the user should see their current loyalty points balance', () => {
  loyaltyProgramPage.verifyPointsBalance();
});

When('there are new rewards or discounts available', () => {
  loyaltyProgramPage.checkNewRewardsOrDiscounts();
});

Then('the user should receive a notification about the new offers', () => {
  loyaltyProgramPage.verifyNotificationReceived();
});

When('the user opts to leave the Loyalty Program', () => {
  loyaltyProgramPage.leaveLoyaltyProgram();
});

Then('the user should be successfully unenrolled from the Loyalty Program', () => {
  loyaltyProgramPage.verifyUnenrollmentSuccess();
});