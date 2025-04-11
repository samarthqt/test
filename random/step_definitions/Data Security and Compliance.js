import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import DataSecurityPage from '../page_objects/DataSecurityPage';

const dataSecurityPage = new DataSecurityPage();

Given('the system handles sensitive data including passwords and payment details', () => {
  dataSecurityPage.verifySensitiveDataHandling();
});

When('data is transmitted or stored', () => {
  dataSecurityPage.transmitOrStoreData();
});

Then('the data must be encrypted using SSL/TLS protocols', () => {
  dataSecurityPage.checkDataEncryption();
});

Given('the system processes personal data', () => {
  dataSecurityPage.verifyPersonalDataProcessing();
});

When('GDPR regulations are applicable', () => {
  dataSecurityPage.checkGDPRApplicability();
});

Then('the system must comply with GDPR regulations for data protection', () => {
  dataSecurityPage.ensureGDPRCompliance();
});

Given('users interact with the system', () => {
  dataSecurityPage.userInteraction();
});

When('data usage policies are presented', () => {
  dataSecurityPage.presentDataUsagePolicies();
});

Then('users must be informed about data usage', () => {
  dataSecurityPage.informUsersAboutDataUsage();
});

And('consent must be obtained from users', () => {
  dataSecurityPage.obtainUserConsent();
});

Given('the system is operational', () => {
  dataSecurityPage.verifySystemOperational();
});

When('security audits are scheduled', () => {
  dataSecurityPage.scheduleSecurityAudits();
});

Then('regular security audits must be conducted', () => {
  dataSecurityPage.conductRegularSecurityAudits();
});

And('compliance with data protection standards must be ensured', () => {
  dataSecurityPage.ensureComplianceWithStandards();
});

Given('users access their accounts', () => {
  dataSecurityPage.userAccountAccess();
});

When('additional security is desired', () => {
  dataSecurityPage.additionalSecurityDesired();
});

Then('two-factor authentication (2FA) must be available', () => {
  dataSecurityPage.ensure2FAAvailable();
});

And('2FA should be optional for users', () => {
  dataSecurityPage.ensure2FAOptional();
});