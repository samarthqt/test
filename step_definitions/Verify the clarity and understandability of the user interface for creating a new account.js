import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import LoginPage from '../page_objects/LoginPage';
import AccountCreationPage from '../page_objects/AccountCreationPage';

const loginPage = new LoginPage();
const accountCreationPage = new AccountCreationPage();

Given('I am on the system's login page', () => {
  loginPage.visitLoginPage();
});

When('I enter valid login credentials and click on the \"Login\" button', () => {
  loginPage.enterLoginCredentials();
  loginPage.clickLoginButton();
});

Then('I should be redirected to the account creation page', () => {
  accountCreationPage.verifyOnAccountCreationPage();
});

Then('the account creation page should be well-designed and user-friendly', () => {
  accountCreationPage.verifyPageDesign();
});

Then('it should have clear labels and input fields for required information', () => {
  accountCreationPage.verifyLabelsAndFields();
});

Then('it should provide helpful instructions or tooltips if necessary', () => {
  accountCreationPage.verifyInstructionsOrTooltips();
});

Then('there should be no validation messages or error indicators for incorrect or missing information', () => {
  accountCreationPage.verifyNoValidationMessages();
});

When('I fill in all the required information accurately', () => {
  accountCreationPage.fillRequiredInformation();
});

Then('I should be able to enter all the required information without any issues', () => {
  accountCreationPage.verifyInformationEntry();
});

Then('the layout and design of the page should be consistent and easy to use', () => {
  accountCreationPage.verifyLayoutConsistency();
});

Then('it should make it easy for me to navigate and understand', () => {
  accountCreationPage.verifyEaseOfNavigation();
});

When('I click on the \"Create Account\" button', () => {
  accountCreationPage.clickCreateAccountButton();
});

Then('the system should validate the entered information', () => {
  accountCreationPage.verifyInformationValidation();
});

Then('it should create a new account if all the requirements are met', () => {
  accountCreationPage.verifyAccountCreation();
});

Then('I should see a confirmation message or notification after successful account creation', () => {
  accountCreationPage.verifyConfirmationMessage();
});

Then('I should be redirected to the login page after account creation', () => {
  loginPage.verifyRedirectionAfterAccountCreation();
});

When('I attempt to create an account with invalid or incomplete information', () => {
  accountCreationPage.enterInvalidInformation();
});

Then('the system should display appropriate validation messages or error indicators', () => {
  accountCreationPage.verifyValidationMessages();
});

Then('it should prevent the creation of an account with invalid or incomplete information', () => {
  accountCreationPage.verifyAccountCreationPrevention();
});

Then('there should be restrictions or limitations on the type or format of the information that can be entered', () => {
  accountCreationPage.verifyInputRestrictions();
});

Then('the system should enforce these restrictions or limitations', () => {
  accountCreationPage.verifyRestrictionsEnforcement();
});

When('I try to navigate back or cancel the account creation process', () => {
  accountCreationPage.navigateBackOrCancel();
});

Then('I should be able to do so without any issues', () => {
  accountCreationPage.verifyNavigationOrCancellation();
});

Then('there should be additional features or options available during the account creation process', () => {
  accountCreationPage.verifyAdditionalFeatures();
});

Then('the system should provide these additional features or options', () => {
  accountCreationPage.verifyFeaturesProvision();
});

When('I try to switch between different sections or steps of the account creation process', () => {
  accountCreationPage.switchSectionsOrSteps();
});

Then('I should be able to do so without any issues', () => {
  accountCreationPage.verifySectionSwitching();
});

Then('there should be clear indications of the current step', () => {
  accountCreationPage.verifyCurrentStepIndications();
});

Then('the user interface should be responsive and compatible with different devices and screen sizes', () => {
  accountCreationPage.verifyUIResponsiveness();
});

Then('it should adapt and display properly on different devices and screen sizes', () => {
  accountCreationPage.verifyUIDisplayAdaptation();
});

Then('it should maintain its clarity and understandability', () => {
  accountCreationPage.verifyClarityAndUnderstandability();
});