describe('Reminder for Back-to-back Visits', () => {
  const participantId = 'P004';
  const email = 'participant2@example.com';
  const phone = '0987654321';

  before(() => {
    cy.visit('/login');
    cy.login('admin', 'password');
  });

  it('Verify participant contact information', () => {
    cy.visit(`/participants/${participantId}`);
    cy.get(ParticipantPage.emailField).should('have.value', email);
    cy.get(ParticipantPage.phoneField).should('have.value', phone);
  });

  it('Schedule back-to-back follow-up visits', () => {
    cy.visit(`/participants/${participantId}/schedule`);
    cy.scheduleVisit('2023-10-15');
    cy.scheduleVisit('2023-10-16');
    cy.get(SchedulePage.scheduledVisits).should('contain', '2023-10-15');
    cy.get(SchedulePage.scheduledVisits).should('contain', '2023-10-16');
  });

  it('Check reminders for the first visit', () => {
    cy.visit(`/participants/${participantId}/reminders`);
    cy.get(RemindersPage.remindersList).should('contain', '2023-10-15');
  });

  it('Check reminders for the second visit', () => {
    cy.visit(`/participants/${participantId}/reminders`);
    cy.get(RemindersPage.remindersList).should('contain', '2023-10-16');
  });

  after(() => {
    cy.logout();
  });
});