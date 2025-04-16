describe('Daily Data Backup Test Suite', () => {
  const backupPage = new BackupPage();

  before(() => {
    cy.visit('/backup');
  });

  it('Access the backup configuration settings', () => {
    backupPage.accessBackupSettings();
    backupPage.verifyBackupSettingsDisplay();
  });

  it('Verify backup system is operational', () => {
    backupPage.verifyBackupSystemOperational();
  });

  it('Initiate a manual backup', () => {
    backupPage.initiateManualBackup();
    backupPage.verifyManualBackupSuccess();
  });

  it('Check the backup log for manual backup entry', () => {
    backupPage.checkBackupLog();
  });

  it('Simulate a data change and verify in next scheduled backup', () => {
    backupPage.simulateDataChange();
    backupPage.verifyDataChangeInNextBackup();
  });

  it('Verify integrity of backed-up data', () => {
    backupPage.verifyDataIntegrity();
  });

  it('Test notification of backup completion', () => {
    backupPage.testBackupCompletionNotification();
  });

  it('Ensure backups occur without interruption under high load', () => {
    backupPage.testBackupUnderHighLoad();
  });

  it('Check backup system handles large data volumes', () => {
    backupPage.verifyLargeDataVolumeBackup();
  });

  it('Verify data restoration from backups', () => {
    backupPage.verifyDataRestoration();
  });

  it('Test backup system for multiple users', () => {
    backupPage.testMultipleUsersBackup();
  });

  it('Ensure backup schedules are customizable', () => {
    backupPage.verifyCustomizableSchedules();
  });

  it('Check for system alerts on backup failure', () => {
    backupPage.verifySystemAlertsOnFailure();
  });

  it('Verify recovery from failed backup attempt', () => {
    backupPage.verifyRecoveryFromFailedBackup();
  });

  it('Test storage space management', () => {
    backupPage.verifyStorageSpaceManagement();
  });
});