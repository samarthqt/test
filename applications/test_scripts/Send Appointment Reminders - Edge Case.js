describe('Send Appointment Reminders - Edge Case', () => {
  const patientId = 'P12345';
  const appointmentDates = ['2023-10-20', '2023-10-21'];

  before(() => {
    cy.visit('/login');
    cy.loginAsPatient(patientId);
  });

  it('should verify scheduled back-to-back appointment details', () => {
    cy.visit('/appointments');
    cy.getAppointmentsForPatient(patientId).should('have.length', 2);
    cy.getAppointmentsForPatient(patientId).each((appointment, index) => {
      expect(appointment.date).to.equal(appointmentDates[index]);
    });
  });

  it('should ensure Appointment Reminders module is active', () => {
    cy.visit('/modules');
    cy.getModuleStatus('Appointment Reminders').should('be.active');
  });

  it('should check system settings for reminder configuration', () => {
    cy.visit('/settings/reminders');
    cy.getReminderConfiguration().should('include', {
      method: 'Email',
      timing: '24 hours'
    });
  });

  it('should trigger reminder process manually', () => {
    cy.visit('/reminders/trigger');
    cy.triggerRemindersForAppointments(patientId, appointmentDates);
    cy.getReminderStatus().should('contain', 'success');
  });

  it('should verify patient receives email reminders', () => {
    cy.visit('/emails');
    cy.getEmailsForPatient(patientId).should('have.length', 2);
    cy.getEmailsForPatient(patientId).each((email, index) => {
      expect(email.subject).to.include(appointmentDates[index]);
    });
  });

  it('should verify reminder logs in the system', () => {
    cy.visit('/logs/reminders');
    cy.getReminderLogsForPatient(patientId).should('have.length', 2);
    cy.getReminderLogsForPatient(patientId).each((log, index) => {
      expect(log.status).to.equal('success');
    });
  });

  after(() => {
    cy.logout();
  });
});