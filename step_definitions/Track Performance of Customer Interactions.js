Given('I am logged in to the system as a Customer Service Representative', () => {
  cy.loginAsCustomerServiceRep();
});

And('I am directed to the dashboard', () => {
  cy.verifyDashboardPage();
});

When('I navigate to the Performance Tracking section', () => {
  cy.navigateToPerformanceTracking();
});

Then('the Performance Tracking page should be displayed', () => {
  cy.verifyPerformanceTrackingPage();
});

When('I select the desired date range for performance tracking', () => {
  cy.selectDateRange();
});

Then('the system should allow me to select a date range for performance tracking', () => {
  cy.verifyDateRangeSelection();
});

When('I view the performance metrics for customer interactions', () => {
  cy.viewPerformanceMetrics();
});

Then('the system should display the performance metrics for customer interactions based on the selected date range', () => {
  cy.verifyPerformanceMetricsDisplay();
});

When('I filter the performance metrics by specific criteria', () => {
  cy.filterPerformanceMetrics();
});

Then('the system should allow me to filter the performance metrics by specific criteria and display the filtered results', () => {
  cy.verifyFilteredMetricsDisplay();
});

When('I sort the performance metrics in ascending and descending order based on different columns', () => {
  cy.sortPerformanceMetrics();
});

Then('the system should allow me to sort the performance metrics in ascending and descending order', () => {
  cy.verifyMetricsSorting();
});

When('I export the performance metrics to a CSV file for further analysis', () => {
  cy.exportMetricsToCSV();
});

Then('the system should allow me to export the performance metrics to a CSV file', () => {
  cy.verifyCSVExport();
});

When('I view detailed information for a specific customer interaction', () => {
  cy.viewInteractionDetails();
});

Then('the system should display the detailed information for the selected customer interaction', () => {
  cy.verifyInteractionDetailsDisplay();
});

When('I add notes or comments to a customer interaction for future reference', () => {
  cy.addNotesToInteraction();
});

Then('the system should allow me to add notes or comments to a customer interaction', () => {
  cy.verifyNotesAddition();
});

When('I edit the notes or comments for a customer interaction and save the changes', () => {
  cy.editNotesInteraction();
});

Then('the system should allow me to edit the notes or comments for a customer interaction and save the changes', () => {
  cy.verifyNotesEditing();
});

When('I delete a customer interaction', () => {
  cy.deleteInteraction();
});

Then('the system should allow me to delete a customer interaction', () => {
  cy.verifyInteractionDeletion();
});

And('the interaction should no longer be displayed in the performance metrics', () => {
  cy.verifyInteractionNotDisplayed();
});

When('I generate performance reports for customer interactions based on different criteria', () => {
  cy.generatePerformanceReports();
});

Then('the system should allow me to generate performance reports for customer interactions', () => {
  cy.verifyReportGeneration();
});

When('I verify that the performance metrics and reports are accurate and up to date', () => {
  cy.verifyMetricsAndReportsAccuracy();
});

Then('the performance metrics and reports should accurately reflect the customer interactions and be up to date', () => {
  cy.verifyMetricsAndReportsUpToDate();
});

When('I logout from the system', () => {
  cy.logout();
});

Then('I should be successfully logged out and directed to the login page', () => {
  cy.verifyLogout();
});