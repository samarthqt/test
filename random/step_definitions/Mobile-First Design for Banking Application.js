import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import BankingAppPage from '../page_objects/BankingAppPage';

const bankingAppPage = new BankingAppPage();

Given('the user has a smartphone with internet access', () => {
  // Assuming internet access is always available for testing purposes
});

When('the user opens the banking application', () => {
  bankingAppPage.openApp();
});

Then('the application should load within 3 seconds', () => {
  bankingAppPage.verifyAppLoadTime(3000);
});

Given('the user is logged into the banking application on a smartphone', () => {
  bankingAppPage.login();
});

When('the user navigates to the account section', () => {
  bankingAppPage.navigateToAccountSection();
});

Then('the user should be able to check balances in 1-2 steps', () => {
  bankingAppPage.verifyCheckBalancesSteps();
});

When('the user selects the transfer funds option', () => {
  bankingAppPage.selectTransferFundsOption();
});

Then('the user should be able to complete the transfer in 1-2 steps', () => {
  bankingAppPage.verifyTransferFundsSteps();
});

When('the user selects the pay bills option', () => {
  bankingAppPage.selectPayBillsOption();
});

Then('the user should be able to complete the payment in 1-2 steps', () => {
  bankingAppPage.verifyPayBillsSteps();
});

Given('the user accesses the banking application on different devices', () => {
  // This step assumes device switching is handled externally
});

When('the application is viewed on a tablet or desktop', () => {
  bankingAppPage.viewOnTabletOrDesktop();
});

Then('the design should be responsive and adapt to the screen size', () => {
  bankingAppPage.verifyResponsiveDesign();
});

Given('the user is using the banking application on a smartphone', () => {
  // Already logged in and using the app on a smartphone
});

When('the user navigates through the application', () => {
  bankingAppPage.navigateThroughApp();
});

Then('the user interface should be intuitive with clear navigation and a minimal learning curve', () => {
  bankingAppPage.verifyIntuitiveUI();
});

When('the user accesses various functionalities', () => {
  bankingAppPage.accessVariousFunctionalities();
});

Then('all functionalities available on the desktop version should be accessible on the mobile version', () => {
  bankingAppPage.verifyAllFunctionalitiesAccessible();
});