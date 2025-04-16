describe('Automated Reminder for Follow-up Visits', () => {
  const participantId = 'P002';
  const email = 'participant@example.com';
  const phone = '1234567890';

  beforeEach(() => {
    cy.visit('/login');
    cy.loginAsAdmin();
  });

  it('should verify participant contact information', () => {
    cy.visit(`/participants/${participantId}`);
    cy.getParticipantPage().verifyContactInformation(email, phone);
  });

  it('should schedule a follow-up visit', () => {
    cy.visit(`/participants/${participantId}/schedule`);
    cy.getSchedulePage().scheduleFollowUpVisit();
  });

  it('should send an email reminder for the follow-up visit', () => {
    cy.getEmailService().checkEmailReminder(email);
  });

  it('should send an SMS reminder for the follow-up visit', () => {
    cy.getSmsService().checkSmsReminder(phone);
  });
});