import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import PatientPage from '../page_objects/PatientPage';

const patientPage = new PatientPage();

Given('a patient is logged into the system', () => {
  patientPage.login();
});

When('the patient grants access to their medical records to a healthcare provider', () => {
  patientPage.grantAccessToProvider();
});

Then('the healthcare provider should have access to the patient's medical records', () => {
  patientPage.verifyProviderAccess(true);
});

When('the patient revokes access to their medical records from a healthcare provider', () => {
  patientPage.revokeAccessFromProvider();
});

Then('the healthcare provider should no longer have access to the patient's medical records', () => {
  patientPage.verifyProviderAccess(false);
});

Given('patient medical records are stored on the blockchain', () => {
  patientPage.verifyRecordsOnBlockchain();
});

When('a record is added to the blockchain', () => {
  patientPage.addRecordToBlockchain();
});

Then('the record should be immutable and maintain data integrity', () => {
  patientPage.verifyRecordImmutability();
});

Given('the system is logging all access attempts', () => {
  patientPage.verifyLoggingEnabled();
});

When('an unauthorized access attempt is made to a patient's medical records', () => {
  patientPage.simulateUnauthorizedAccess();
});

Then('the patient should be notified of the unauthorized access attempt', () => {
  patientPage.verifyUnauthorizedAccessNotification();
});

Given('the system is handling patient medical records', () => {
  patientPage.verifySystemHandlingRecords();
});

Then('the system must comply with healthcare data regulations such as HIPAA', () => {
  patientPage.verifyComplianceWithRegulations();
});

Given('a healthcare provider has been authorized to access patient medical records', () => {
  patientPage.authorizeProviderAccess();
});

When('the provider accesses the records', () => {
  patientPage.providerAccessRecords();
});

Then('the data sharing should be secure', () => {
  patientPage.verifySecureDataSharing();
});

When('the patient wants to manage data access permissions', () => {
  patientPage.manageDataAccessPermissions();
});

Then('the system should provide a user-friendly interface for managing these permissions', () => {
  patientPage.verifyUserFriendlyInterface();
});

Given('the system is processing data transactions', () => {
  patientPage.verifyDataTransactionProcessing();
});

When('a transaction is completed', () => {
  patientPage.completeTransaction();
});

Then('an audit trail should be available for that transaction', () => {
  patientPage.verifyAuditTrail();
});

Given('the system is operating under expected load conditions', () => {
  patientPage.verifySystemLoadConditions();
});

When('multiple users access the system simultaneously', () => {
  patientPage.simulateMultipleUserAccess();
});

Then('the system should perform efficiently without degradation', () => {
  patientPage.verifySystemPerformance();
});

Then('all data must be encrypted', () => {
  patientPage.verifyDataEncryption();
});

Given('a user performs an action that results in an error', () => {
  patientPage.performErrorProneAction();
});

Then('the system should handle the error gracefully and provide meaningful feedback to the user', () => {
  patientPage.verifyErrorHandlingAndFeedback();
});