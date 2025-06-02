import { formatDate } from '../utils/dateUtils';

class LoggingPage {

  static visitLoggingConfigPage() {
    cy.visit('/logging/config');
  }

  static verifyLoggingConfigPageDisplayed() {
    cy.get('h1').contains('Logging Configuration').should('be.visible');
  }

  static checkTrackingQueriesSetting() {
    cy.get('#trackingQueries').should('be.checked');
  }

  static verifyTrackingQueriesEnabled() {
    cy.get('#trackingQueries').should('be.checked');
  }

  static executeProductSearchQuery(productName = 'Product Name') {
    cy.get('#searchInput').type(productName);
    cy.get('#searchButton').click();
  }

  static verifyProductSearchExecuted() {
    cy.get('#searchResults').should('be.visible');
  }

  static filterLogsByCurrentDate() {
    cy.get('#dateFilter').select(formatDate(new Date()));
  }

  static verifyLogsForCurrentDate() {
    cy.get('#logs').should('contain', formatDate(new Date()));
  }

  static searchLogEntryForProductSearch(query = 'Product Search Query') {
    cy.get('#logSearch').type(query);
    cy.get('#searchLogButton').click();
  }

  static verifyLogEntryFound(query = 'Product Search Query') {
    cy.get('#logEntries').should('contain', query);
  }

  static checkLogEntryDetails() {
    cy.get('#logEntryDetails').should('be.visible');
  }

  static verifyLogEntryDetailsMatchQuery(productName = 'Product Name') {
    cy.get('#logEntryDetails').should('contain', productName);
  }

  static verifyUserIDInLogEntry(userID = 'User123') {
    cy.get('#userID').should('contain', userID);
  }

  static verifyUserIDLoggedCorrectly(userID = 'User123') {
    cy.get('#userID').should('contain', userID);
  }

  static checkQueryTypeInLogEntry() {
    cy.get('#queryType').should('be.visible');
  }

  static verifyQueryTypeInformation(queryType = 'Search') {
    cy.get('#queryType').should('contain', queryType);
  }

  static examineLogEntryForErrors() {
    cy.get('#logEntryErrors').should('not.exist');
  }

  static verifyNoErrorsOrWarnings() {
    cy.get('#logEntryErrors').should('not.exist');
  }

  static executeAndVerifyDifferentQueryTypes(productName = 'Another Product') {
    cy.get('#searchInput').type(productName);
    cy.get('#searchButton').click();
    cy.get('#logEntries').should('contain', productName);
  }

  static verifyLogEntriesForAllQueryTypes(productName = 'Another Product') {
    cy.get('#logEntries').should('contain', productName);
  }

  static checkUnauthorizedAccessAttempts() {
    cy.get('#unauthorizedAttempts').should('not.exist');
  }

  static verifyNoUnauthorizedAccess() {
    cy.get('#unauthorizedAttempts').should('not.exist');
  }

  static checkLogStorageLocation() {
    cy.get('#logStorage').should('contain', 'Secure Location');
  }

  static verifyLogEntriesStoredSecurely() {
    cy.get('#logStorage').should('contain', 'Secure Location');
  }

  static exportLogEntriesForAudit() {
    cy.get('#exportLogsButton').click();
  }

  static verifyLogEntriesExportable() {
    cy.get('#exportSuccessMessage').should('be.visible');
  }

  static checkLogRetentionPeriod() {
    cy.get('#retentionPeriod').should('contain', '30 days');
  }

  static verifyLogRetentionPeriod() {
    cy.get('#retentionPeriod').should('contain', '30 days');
  }

  static checkLogEntryAccessibility() {
    cy.get('#logAccessibility').should('contain', 'Authorized Only');
  }

  static verifyLogEntryAccessibility() {
    cy.get('#logAccessibility').should('contain', 'Authorized Only');
  }

}

export default LoggingPage;