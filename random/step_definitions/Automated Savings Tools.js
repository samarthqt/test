import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import SavingsToolPage from '../page-objects/SavingsToolPage';

const savingsToolPage = new SavingsToolPage();

Given('a user has a bank account linked to the savings tool', () => {
  savingsToolPage.verifyBankAccountLinked();
});

When('the user sets up a rule to round up purchases', () => {
  savingsToolPage.setupRoundUpRule();
});

Then('the difference should be automatically transferred to the savings account', () => {
  savingsToolPage.verifyAutomaticTransfer();
});

Given('a user has a savings or investment account linked to the savings tool', () => {
  savingsToolPage.verifySavingsInvestmentAccountLinked();
});

When('the user schedules a recurring transfer', () => {
  savingsToolPage.scheduleRecurringTransfer();
});

Then('the specified amount should be transferred at the scheduled intervals', () => {
  savingsToolPage.verifyScheduledTransfer();
});

Given('a user has access to the savings tool', () => {
  savingsToolPage.verifyAccessToSavingsTool();
});

When('the user sets a custom savings goal', () => {
  savingsToolPage.setCustomSavingsGoal();
});

Then('the user should be able to track their progress towards the goal', () => {
  savingsToolPage.verifyGoalTracking();
});

Given('a user has existing budgeting tools linked to the savings tool', () => {
  savingsToolPage.verifyBudgetingToolsLinked();
});

When('the user checks their savings habits', () => {
  savingsToolPage.checkSavingsHabits();
});

Then('the tool should provide insights based on their savings and budgeting data', () => {
  savingsToolPage.verifyInsightsProvided();
});

Given('a user is using the savings tool', () => {
  savingsToolPage.verifyUsingSavingsTool();
});

When('savings transactions occur', () => {
  savingsToolPage.performSavingsTransactions();
});

Then('the tool should ensure data security and privacy compliance', () => {
  savingsToolPage.verifyDataSecurityCompliance();
});

Given('a user has set up savings transactions and goals', () => {
  savingsToolPage.verifySavingsTransactionsAndGoalsSet();
});

When('a savings transaction is successful or a goal is achieved', () => {
  savingsToolPage.verifyTransactionOrGoalSuccess();
});

Then('the user should receive a notification', () => {
  savingsToolPage.verifyNotificationReceived();
});

When('a transaction fails', () => {
  savingsToolPage.simulateTransactionFailure();
});

Then('the tool should handle the error gracefully and notify the user', () => {
  savingsToolPage.verifyErrorHandlingAndNotification();
});

Given('a user wants to manage savings on different platforms', () => {
  savingsToolPage.verifyPlatformAccessibility();
});

When('the user accesses the savings tool', () => {
  savingsToolPage.accessSavingsTool();
});

Then('the tool should be available on both desktop and mobile platforms', () => {
  savingsToolPage.verifyPlatformAvailability();
});

Given('a user with accessibility needs is using the savings tool', () => {
  savingsToolPage.verifyAccessibilityNeeds();
});

When('the user navigates through the tool', () => {
  savingsToolPage.navigateThroughTool();
});

Then('the tool should be accessible and user-friendly for all users', () => {
  savingsToolPage.verifyAccessibilityAndUserFriendliness();
});