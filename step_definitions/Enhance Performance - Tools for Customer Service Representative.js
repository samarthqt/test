import { ToolsPage } from '../pageObjects/ToolsPage';

const toolsPage = new ToolsPage();

Given('the user is logged in to the system as a Customer Service Representative', () => {
  cy.loginAsCSR();
});

When('the user navigates to the Tools section', () => {
  toolsPage.navigateToToolsSection();
});

Then('the user should be able to access the Tools section without any issues', () => {
  toolsPage.verifyToolsSectionAccessible();
});

Given('the user is in the Tools section', () => {
  toolsPage.verifyInToolsSection();
});

Then('the user should see the following tools:', (dataTable) => {
  toolsPage.verifyPresenceOfTools(dataTable);
});

When('the user clicks on the Knowledge Base tool', () => {
  toolsPage.accessKnowledgeBaseTool();
});

Then('the user should be able to access the Knowledge Base tool and view relevant articles and information', () => {
  toolsPage.verifyKnowledgeBaseAccessible();
});

Given('the user is in the Knowledge Base tool', () => {
  toolsPage.verifyInKnowledgeBaseTool();
});

When('the user performs a search for a specific topic', () => {
  toolsPage.performSearchInKnowledgeBase('specific topic');
});

Then('the user should be able to find relevant articles and information based on the search query', () => {
  toolsPage.verifySearchResults();
});

When('the user clicks on the Call Recording tool', () => {
  toolsPage.accessCallRecordingTool();
});

Then('the user should be able to access the Call Recording tool and listen to recorded calls', () => {
  toolsPage.verifyCallRecordingAccessible();
});

Given('the user is in the Call Recording tool', () => {
  toolsPage.verifyInCallRecordingTool();
});

When('the user selects a recorded call and plays it', () => {
  toolsPage.playRecordedCall();
});

Then('the user should be able to play the selected recorded call without any issues', () => {
  toolsPage.verifyRecordedCallPlayed();
});

When('the user clicks on the Customer Feedback tool', () => {
  toolsPage.accessCustomerFeedbackTool();
});

Then('the user should be able to access the Customer Feedback tool and view feedback from customers', () => {
  toolsPage.verifyCustomerFeedbackAccessible();
});

Given('the user is in the Customer Feedback tool', () => {
  toolsPage.verifyInCustomerFeedbackTool();
});

When('the user reviews the customer feedback and ratings', () => {
  toolsPage.reviewCustomerFeedbackAndRatings();
});

Then('the user should be able to view the feedback and ratings provided by customers', () => {
  toolsPage.verifyFeedbackAndRatingsVisible();
});

When('the user clicks on the Performance Metrics tool', () => {
  toolsPage.accessPerformanceMetricsTool();
});

Then('the user should be able to access the Performance Metrics tool and view performance statistics', () => {
  toolsPage.verifyPerformanceMetricsAccessible();
});

Given('the user is in the Performance Metrics tool', () => {
  toolsPage.verifyInPerformanceMetricsTool();
});

When('the user reviews the performance metrics', () => {
  toolsPage.reviewPerformanceMetrics();
});

Then('the user should be able to view the performance metrics and analyze their own performance', () => {
  toolsPage.verifyPerformanceMetricsVisible();
});

When('the user performs a task using the available tools', () => {
  toolsPage.performTaskUsingTools();
});

Then('the user should be able to perform the task and see the expected results', () => {
  toolsPage.verifyTaskPerformedSuccessfully();
});

Given('the user is using the tools', () => {
  toolsPage.verifyUsingTools();
});

When('the user verifies the accuracy of the tools' data', () => {
  toolsPage.verifyToolsDataAccuracy();
});

Then('the data provided by the tools should be accurate and up-to-date', () => {
  toolsPage.verifyDataIsAccurate();
});

Given('the user is logged in to the system', () => {
  cy.login();
});

When('the user logs out from the system', () => {
  cy.logout();
});

Then('the user should be successfully logged out from the system', () => {
  cy.verifyLogoutSuccessful();
});

Given('the user is not logged in', () => {
  cy.verifyNotLoggedIn();
});

When('the user tries to access the Tools section', () => {
  toolsPage.tryAccessToolsSection();
});

Then('the user should not be able to access the Tools section without proper authentication', () => {
  toolsPage.verifyUnauthorizedAccessDenied();
});