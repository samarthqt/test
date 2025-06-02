import { expect } from 'chai';
import { Cypress } from 'cypress';

class SystemMonitorPage {
  static checkResourceUtilization() {
    cy.get('.resource-utilization').should('be.visible');
  }

  static verifyResourceUtilizationLimits() {
    cy.get('.resource-utilization').invoke('text').then((text) => {
      const utilization = parseFloat(text);
      expect(utilization).to.be.lessThan(80);
    });
  }

  static monitorPerformanceMetrics() {
    cy.get('.performance-metrics').should('be.visible');
  }

  static verifyPerformanceEfficiency() {
    cy.get('.performance-metrics').invoke('text').then((text) => {
      const efficiency = parseFloat(text);
      expect(efficiency).to.be.greaterThan(90);
    });
  }

  static generateErrorLogs() {
    cy.get('.error-logs').click();
    cy.get('.logs-output').should('be.visible');
  }

  static verifyNoCriticalErrors() {
    cy.get('.logs-output').invoke('text').then((text) => {
      expect(text).not.to.include('CRITICAL');
    });
  }

  static sendNotifications() {
    cy.get('.send-notifications').click();
    cy.get('.notification-status').should('contain', 'Sent');
  }

  static verifyUserNotification() {
    cy.get('.notification-status').invoke('text').then((text) => {
      expect(text).to.equal('Sent');
    });
  }

  static attemptRecovery() {
    cy.get('.attempt-recovery').click();
    cy.get('.recovery-status').should('contain', 'Success');
  }

  static verifyRecoveryWithoutDataLoss() {
    cy.get('.recovery-status').invoke('text').then((text) => {
      expect(text).to.equal('Success');
      cy.get('.data-integrity').should('contain', 'Intact');
    });
  }

  static handleConcurrentUploads() {
    cy.get('.upload-button').click();
    cy.get('.upload-status').should('contain', 'In Progress');
  }

  static verifyConcurrentUploadEfficiency() {
    cy.get('.upload-status').invoke('text').then((text) => {
      expect(text).to.equal('Completed');
      cy.get('.upload-time').invoke('text').then((time) => {
        const uploadTime = parseFloat(time);
        expect(uploadTime).to.be.lessThan(5);
      });
    });
  }
}

export default SystemMonitorPage;