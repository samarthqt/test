import { expect } from 'chai';
import { Selector } from 'testcafe';

class EmailNotificationPage {
  constructor() {
    this.emailNotificationSettings = Selector('#emailNotificationSettings');
    this.ticketIDDisplay = Selector('#ticketIDDisplay');
    this.notificationStatus = Selector('#notificationStatus');
    this.responseStatus = Selector('#responseStatus');
    this.emailInbox = Selector('#emailInbox');
    this.emailNotification = Selector('#emailNotification');
    this.emailReceived = Selector('#emailReceived');
    this.openEmailBtn = Selector('#openEmailBtn');
    this.emailContent = Selector('#emailContent');
    this.senderEmail = Selector('#senderEmail');
    this.emailSubject = Selector('#emailSubject');
    this.supportLink = Selector('#supportLink');
    this.deliveryTime = Selector('#deliveryTime');
    this.spamFolder = Selector('#spamFolder');
    this.emailAttachments = Selector('#emailAttachments');
    this.emailClients = Selector('#emailClients');
    this.replyBtn = Selector('#replyBtn');
    this.replyStatus = Selector('#replyStatus');
  }

  async verifyEmailNotificationSettings() {
    await expect(this.emailNotificationSettings.checked).ok();
  }

  async verifyTicketID(ticketID) {
    await expect(this.ticketIDDisplay.innerText).contains(ticketID);
  }

  async verifyEmailNotificationSent() {
    await expect(this.notificationStatus.innerText).contains('Sent');
  }

  async verifySupportTeamResponse() {
    await expect(this.responseStatus.innerText).contains('Responded');
  }

  async checkEmailInbox() {
    await this.emailInbox.click();
  }

  async verifyEmailNotificationReceived() {
    await expect(this.emailNotification.exists).ok();
  }

  async verifyEmailReceived() {
    await expect(this.emailReceived.visible).ok();
  }

  async openEmail() {
    await this.openEmailBtn.click();
  }

  async verifyEmailContentDetails() {
    await expect(this.emailContent.innerText).contains('Support Response Details');
  }

  async checkSenderEmailAddress() {
    await expect(this.senderEmail.innerText).contains('support@example.com');
  }

  async verifySenderEmailAddress() {
    await expect(this.senderEmail.innerText).eql('support@example.com');
  }

  async checkEmailSubjectLine() {
    await this.emailSubject.click();
  }

  async verifyEmailSubjectLineRelevance() {
    await expect(this.emailSubject.innerText).contains('Support Request Response');
  }

  async checkEmailContent() {
    await this.emailContent.click();
  }

  async verifyEmailLinkToSupportRequest() {
    await expect(this.supportLink.exists).ok();
  }

  async verifyEmailDeliveryTime() {
    await expect(this.deliveryTime.innerText).within(0, 5);
  }

  async verifyEmailFormatting() {
    await expect(this.emailContent.innerText).match(/^[\s\S]*$/);
  }

  async checkSpamFolder() {
    await this.spamFolder.click();
  }

  async verifyEmailNotSpam() {
    await expect(this.spamFolder.innerText).notContains('emailNotification');
  }

  async verifyNoDuplicateEmails() {
    await expect(this.emailNotification.count).eql(1);
  }

  async verifyEmailAttachments() {
    await expect(this.emailAttachments.exists).notOk();
  }

  async openEmailOnDifferentClients() {
    await this.emailClients.click();
  }

  async verifyEmailAccessibilityOnClients() {
    await expect(this.emailContent.innerText).match(/^[\s\S]*$/);
  }

  async replyToEmail() {
    await this.replyBtn.click();
  }

  async verifyReplyDirectedToSupportTeam() {
    await expect(this.replyStatus.innerText).contains('Directed to Support Team');
  }
}

export default EmailNotificationPage;