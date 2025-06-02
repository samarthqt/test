import { wrap } from 'cypress'; 
class AdminDashboardPage { 
  static login(username, password) { 
    cy.visit('/login'); 
    cy.get('#username').type(username); 
    cy.get('#password').type(password); 
    cy.get('#loginBtn').click(); 
  } 
  
  static navigateToDashboard() { 
    cy.get('#adminDashboard').click(); 
  } 
  
  static verifyDashboardOptions() { 
    cy.get('#reviewModerationOptions').should('be.visible'); 
  } 
  
  static checkReviewsAvailable() { 
    cy.get('#reviewsList').should('exist'); 
  } 
  
  static selectReviewsSection() { 
    cy.get('#reviewsSection').click(); 
  } 
  
  static verifyReviewListOptions() { 
    cy.get('#reviewOptions').should('contain', 'Approve'); 
    cy.get('#reviewOptions').should('contain', 'Edit'); 
    cy.get('#reviewOptions').should('contain', 'Delete'); 
  } 
  
  static verifyReviewContent(reviewId, content) { 
    cy.get(`#review-${reviewId}`).should('contain', content); 
  } 
  
  static selectReviewById(reviewId) { 
    cy.get(`#review-${reviewId}`).click(); 
  } 
  
  static verifyReviewDetails() { 
    cy.get('#reviewDetails').should('be.visible'); 
  } 
  
  static setCredentials(username, password) { 
    wrap({ username, password }).as('adminCredentials'); 
  } 
  
  static approveReview(reviewId) { 
    cy.get(`#approve-${reviewId}`).click(); 
  } 
  
  static verifyReviewStatus(reviewId, status) { 
    cy.get(`#review-${reviewId}`).should('contain', status); 
  } 
  
  static editReviewContent(reviewId, newContent) { 
    cy.get(`#edit-${reviewId}`).click(); 
    cy.get('#reviewContent').clear().type(newContent); 
    cy.get('#saveChanges').click(); 
  } 
  
  static verifyReviewDeleted(reviewId) { 
    cy.get(`#review-${reviewId}`).should('not.exist'); 
  } 
  
  static verifyAuditLog(reviewId) { 
    cy.get('#auditLog').click(); 
    cy.get(`#audit-${reviewId}`).should('be.visible'); 
  } 
  
  static verifyAuditLogEntries(reviewId) { 
    cy.get(`#audit-${reviewId}`).should('contain', 'Approved'); 
    cy.get(`#audit-${reviewId}`).should('contain', 'Edited'); 
    cy.get(`#audit-${reviewId}`).should('contain', 'Deleted'); 
  } 
  
  static logout() { 
    cy.get('#logoutBtn').click(); 
  } 
  
  static verifyLogoutRedirect() { 
    cy.url().should('include', '/login'); 
  } 
  
  static verifyUpdatedReviewList() { 
    cy.get('#reviewsList').should('be.visible'); 
  } 
  
  static editNonExistentReview(reviewId) { 
    cy.get(`#edit-${reviewId}`).click(); 
  } 
  
  static verifyNonExistentReviewError() { 
    cy.get('.errorMessage').should('contain', 'Review does not exist'); 
  } 
  
  static deleteReviewNotOwned(reviewId) { 
    cy.get(`#delete-${reviewId}`).click(); 
  } 
  
  static verifyAuthorizationError() { 
    cy.get('.errorMessage').should('contain', 'Authorization error'); 
  } 
  
  static bulkApproveReviews() { 
    cy.get('#bulkApproveBtn').click(); 
  } 
  
  static verifyBulkApprovalStatus() { 
    cy.get('.bulkApprovalStatus').should('contain', 'Approved'); 
  } 
  
  static verifyMobileAccessibility() { 
    cy.viewport('iphone-x'); 
    cy.get('#adminTools').should('be.visible'); 
  } 
  
  static verifyMobileFunctionality() { 
    cy.get('#adminTools').should('be.enabled'); 
  } 
  
  static testPerformanceUnderLoad() { 
    cy.get('#performanceTest').click(); 
  } 
  
  static verifyPerformanceUnderLoad() { 
    cy.get('.performanceMetrics').should('contain', 'Responsive'); 
  } 
  
  static makeChangesAsAdmin() { 
    cy.get('#changeSettings').click(); 
  } 
  
  static verifyRealTimeSynchronization() { 
    cy.get('.syncStatus').should('contain', 'Synchronized'); 
  } 
} 

export default AdminDashboardPage;