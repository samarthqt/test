import { expect } from 'chai';
import { Selector } from 'testcafe';

class ConsentPage {
  constructor() {
    this.userStatus = Selector('#userStatus');
    this.consentFormStatus = Selector('#consentFormStatus');
    this.collectDataBtn = Selector('#collectDataBtn');
    this.dataCollectionStatus = Selector('#dataCollectionStatus');
    this.consentStatus = Selector('#consentStatus');
    this.attemptCollectionBtn = Selector('#attemptCollectionBtn');
    this.errorMessage = Selector('#errorMessage');
    this.userDataCollectionBtn = Selector('#userDataCollectionBtn');
    this.userNotification = Selector('#userNotification');
    this.processDataBtn = Selector('#processDataBtn');
    this.dataProcessingStatus = Selector('#dataProcessingStatus');
    this.recordEventBtn = Selector('#recordEventBtn');
    this.auditTrail = Selector('#auditTrail');
    this.attemptCollectionOrProcessingBtn = Selector('#attemptCollectionOrProcessingBtn');
    this.systemLogs = Selector('#systemLogs');
    this.accessDataBtn = Selector('#accessDataBtn');
    this.accessStatus = Selector('#accessStatus');
    this.userProfile = Selector('#userProfile');
    this.profileConsentStatus = Selector('#profileConsentStatus');
    this.consentRequirement = Selector('#consentRequirement');
    this.checkConsentStatusBtn = Selector('#checkConsentStatusBtn');
    this.systemNotification = Selector('#systemNotification');
    this.enableFeaturesBtn = Selector('#enableFeaturesBtn');
    this.featuresStatus = Selector('#featuresStatus');
    this.settings = Selector('#settings');
    this.consentSection = Selector('#consentSection');
    this.consentPrompt = Selector('#consentPrompt');
    this.repeatedAttemptsBtn = Selector('#repeatedAttemptsBtn');
    this.systemResponse = Selector('#systemResponse');
    this.repeatedAttemptsWithoutConsentBtn = Selector('#repeatedAttemptsWithoutConsentBtn');
    this.multipleNotifications = Selector('#multipleNotifications');
    this.bypassConsentBtn = Selector('#bypassConsentBtn');
    this.bypassStatus = Selector('#bypassStatus');
    this.unauthorizedAccess = Selector('#unauthorizedAccess');
  }

  async verifyUserActive(userId) {
    await expect(this.userStatus.innerText).contains(userId);
  }

  async verifyConsentNotSubmitted() {
    await expect(this.consentFormStatus.innerText).contains('Not Submitted');
  }

  async attemptDataCollectionWithoutConsent() {
    await this.collectDataBtn.click();
  }

  async verifyDataCollectionBlocked() {
    await expect(this.dataCollectionStatus.innerText).contains('Blocked');
  }

  async verifyConsentStatusNotGiven() {
    await expect(this.consentStatus.innerText).contains('Not Given');
  }

  async systemAttemptsDataCollection() {
    await this.attemptCollectionBtn.click();
  }

  async verifyErrorMessageForMissingConsent() {
    await expect(this.errorMessage.innerText).contains('Missing Consent');
  }

  async attemptUserDataCollection() {
    await this.userDataCollectionBtn.click();
  }

  async verifyUserNotificationForBlockedDataCollection() {
    await expect(this.userNotification.innerText).contains('Blocked Data Collection');
  }

  async verifyConsentNotProvided() {
    await expect(this.consentStatus.innerText).contains('Not Provided');
  }

  async attemptDataProcessing() {
    await this.processDataBtn.click();
  }

  async verifyDataProcessingBlocked() {
    await expect(this.dataProcessingStatus.innerText).contains('Blocked');
  }

  async systemRecordsEvent() {
    await this.recordEventBtn.click();
  }

  async verifyAuditTrailForBlockedDataCollection() {
    await expect(this.auditTrail.innerText).contains('Blocked Data Collection');
  }

  async systemAttemptsDataCollectionOrProcessing() {
    await this.attemptCollectionOrProcessingBtn.click();
  }

  async verifyLogsForMissingConsentError() {
    await expect(this.systemLogs.innerText).contains('Missing Consent Error');
  }

  async attemptDataAccess() {
    await this.accessDataBtn.click();
  }

  async verifyAccessDenied() {
    await expect(this.accessStatus.innerText).contains('Denied');
  }

  async accessUserProfile() {
    await this.userProfile.click();
  }

  async checkConsentStatusInProfile() {
    await expect(this.profileConsentStatus.innerText).contains('Not Given');
  }

  async verifyConsentRequired() {
    await expect(this.consentRequirement.innerText).contains('Required');
  }

  async systemChecksConsentStatus() {
    await this.checkConsentStatusBtn.click();
  }

  async verifySystemNotificationForConsentRequirement() {
    await expect(this.systemNotification.innerText).contains('Consent Requirement');
  }

  async attemptToEnableDataProcessingFeatures() {
    await this.enableFeaturesBtn.click();
  }

  async verifyFeaturesDisabled() {
    await expect(this.featuresStatus.innerText).contains('Disabled');
  }

  async accessSettings() {
    await this.settings.click();
  }

  async checkConsentSectionVisibility() {
    await expect(this.consentSection.visible).ok();
  }

  async verifyConsentSectionPromptsUser() {
    await expect(this.consentPrompt.innerText).contains('Provide Consent');
  }

  async systemRepeatedlyAttemptsDataCollection() {
    await this.repeatedAttemptsBtn.click();
  }

  async verifySystemConsistentlyBlocksDataCollection() {
    await expect(this.systemResponse.innerText).contains('Consistently Blocked');
  }

  async systemRepeatedlyAttemptsDataCollectionWithoutConsent() {
    await this.repeatedAttemptsWithoutConsentBtn.click();
  }

  async verifyMultipleNotificationsForConsentRequirement() {
    await expect(this.multipleNotifications.innerText).contains('Consent Requirement');
  }

  async attemptToBypassConsentRequirement() {
    await this.bypassConsentBtn.click();
  }

  async verifyBypassAttemptsUnsuccessful() {
    await expect(this.bypassStatus.innerText).contains('Unsuccessful');
  }

  async verifyUnauthorizedAccessAttempts() {
    await expect(this.unauthorizedAccess.exists).ok();
  }

  async verifyAuditTrailRecordsUnauthorizedAccess() {
    await expect(this.auditTrail.innerText).contains('Unauthorized Access');
  }
}

export default ConsentPage;