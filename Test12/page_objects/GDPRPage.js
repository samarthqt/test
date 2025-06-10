import { should } from 'chai';
import 'cypress';

class GDPRPage {

  static visitApplication() {
    cy.visit('/application');
  }

  static storeUserData() {
    cy.get('#storeUserData').click();
  }

  static verifyDataStorageCompliance() {
    cy.get('#dataCompliance').should('contain', 'GDPR compliant');
  }

  static processUserData() {
    cy.get('#processUserData').click();
  }

  static verifyDataProcessingCompliance() {
    cy.get('#processingCompliance').should('contain', 'GDPR compliant');
  }

  static accessUserData() {
    cy.get('#accessUserData').click();
  }

  static verifyDataAccessCompliance() {
    cy.get('#accessCompliance').should('contain', 'GDPR compliant');
  }

  static accessUserAccount() {
    cy.visit('/user/account');
  }

  static navigateToPrivacySettings() {
    cy.get('#privacySettings').click();
  }

  static displayPrivacyRightsInformation() {
    cy.get('#privacyRights').should('be.visible');
  }

  static informDataUsage() {
    cy.get('#dataUsageInfo').should('be.visible');
  }

  static verifyApplicationOperational() {
    cy.get('#applicationStatus').should('contain', 'operational');
  }

  static scheduleImpactAssessment() {
    cy.get('#scheduleAssessment').click();
  }

  static conductRegularAssessment() {
    cy.get('#regularAssessment').should('be.visible');
  }

  static documentAndReviewResults() {
    cy.get('#assessmentResults').should('be.visible');
  }

  static navigateToConsentManagement() {
    cy.get('#consentManagement').click();
  }

  static provideConsentManagementTools() {
    cy.get('#consentTools').should('be.visible');
  }

  static manageUserConsent() {
    cy.get('#manageConsent').click();
  }
}

export default GDPRPage;