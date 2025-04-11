import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import BudgetingToolsPage from '../page_objects/BudgetingToolsPage';

const budgetingToolsPage = new BudgetingToolsPage();

Given('the user has a transaction history of more than three months', () => {
  budgetingToolsPage.verifyTransactionHistoryExists();
});

When('the user accesses the budgeting tools in the app', () => {
  budgetingToolsPage.accessBudgetingTools();
});

Then('the user should be able to view categorized spending reports for at least three months', () => {
  budgetingToolsPage.verifySpendingReports();
});

Given('the user has set a monthly spending limit', () => {
  budgetingToolsPage.verifyMonthlySpendingLimitSet();
});

When('the user's spending exceeds the set limit', () => {
  budgetingToolsPage.exceedSpendingLimit();
});

Then('the system should notify the user about exceeding the monthly spending limit', () => {
  budgetingToolsPage.verifySpendingLimitNotification();
});

Given('the user has set at least two financial goals', () => {
  budgetingToolsPage.verifyFinancialGoalsSet();
});

When('the user tracks their financial goals in the app', () => {
  budgetingToolsPage.trackFinancialGoals();
});

Then('the user should be able to view the progress toward at least two financial goals', () => {
  budgetingToolsPage.verifyFinancialGoalsProgress();
});

Given('the user has a history of spending patterns', () => {
  budgetingToolsPage.verifySpendingPatternsExist();
});

When('the user accesses insights and tips in the app', () => {
  budgetingToolsPage.accessInsightsAndTips();
});

Then('the app should provide insights and tips based on the user's spending patterns', () => {
  budgetingToolsPage.verifyInsightsAndTips();
});

Given('the user has financial data in the app', () => {
  budgetingToolsPage.verifyFinancialDataExists();
});

When('the user requests to update and export their financial data', () => {
  budgetingToolsPage.updateAndExportFinancialData();
});

Then('all financial data should be updated in real-time and be exportable for personal records', () => {
  budgetingToolsPage.verifyDataUpdatedAndExportable();
});