describe('Reminder System Failure', () => {
  const participantId = 'P003';
  const incorrectEmail = 'incorrect_email';
  const incorrectPhone = '0000000000';

  before(() => {
    cy.visit('/participant/' + participantId);
  });

  it('should verify participant contact information is incorrect', () => {
    const participantPage = new ParticipantPage();
    participantPage.getEmail().should('have.value', incorrectEmail);
    participantPage.getPhone().should('have.value', incorrectPhone);
  });

  it('should schedule a follow-up visit', () => {
    const participantPage = new ParticipantPage();
    participantPage.scheduleFollowUpVisit();
    participantPage.getFollowUpStatus().should('contain', 'Scheduled');
  });

  it('should log error for incorrect email format', () => {
    const reminderPage = new ReminderPage();
    reminderPage.sendEmailReminder();
    reminderPage.getEmailErrorLog().should('contain', 'incorrect email format');
  });

  it('should log error for invalid phone number', () => {
    const reminderPage = new ReminderPage();
    reminderPage.sendSMSReminder();
    reminderPage.getSMSErrorLog().should('contain', 'invalid phone number');
  });
});