class BackupPage {
  accessBackupSettings() {
    cy.get('#backup-settings').click();
  }

  verifyBackupSettingsDisplay() {
    cy.get('#schedule-info').should('be.visible');
    cy.get('#location-info').should('be.visible');
  }

  verifyBackupSystemOperational() {
    cy.get('#system-status').should('contain', 'active');
  }

  initiateManualBackup() {
    cy.get('#manual-backup').click();
  }

  verifyManualBackupSuccess() {
    cy.get('#backup-status').should('contain', 'success');
  }

  checkBackupLog() {
    cy.get('#backup-log').should('contain', 'Manual backup completed');
  }

  simulateDataChange() {
    cy.get('#data-change').click();
  }

  verifyDataChangeInNextBackup() {
    cy.get('#next-backup-log').should('contain', 'Data change captured');
  }

  verifyDataIntegrity() {
    cy.get('#data-integrity').should('contain', 'matches original');
  }

  testBackupCompletionNotification() {
    cy.get('#notification').should('contain', 'Backup completed');
  }

  testBackupUnderHighLoad() {
    cy.get('#high-load-test').click();
    cy.get('#backup-status').should('contain', 'success');
  }

  verifyLargeDataVolumeBackup() {
    cy.get('#large-volume-test').click();
    cy.get('#backup-status').should('contain', 'success');
  }

  verifyDataRestoration() {
    cy.get('#restore-data').click();
    cy.get('#restore-status').should('contain', 'success');
  }

  testMultipleUsersBackup() {
    cy.get('#multi-user-test').click();
    cy.get('#backup-status').should('contain', 'success');
  }

  verifyCustomizableSchedules() {
    cy.get('#customize-schedule').click();
    cy.get('#schedule-status').should('contain', 'customized');
  }

  verifySystemAlertsOnFailure() {
    cy.get('#simulate-failure').click();
    cy.get('#alert-status').should('contain', 'alert sent');
  }

  verifyRecoveryFromFailedBackup() {
    cy.get('#retry-failed-backup').click();
    cy.get('#backup-status').should('contain', 'success');
  }

  verifyStorageSpaceManagement() {
    cy.get('#storage-management').click();
    cy.get('#storage-status').should('contain', 'optimized');
  }
}