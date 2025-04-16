class AppointmentPage {
  visit() {
    cy.visit('/appointments');
  }

  getAppointmentsForPatient(patientId) {
    return cy.get(`.appointment[data-patient-id="${patientId}"]`);
  }
}

class ModulePage {
  visit() {
    cy.visit('/modules');
  }

  getModuleStatus(moduleName) {
    return cy.get(`.module[data-name="${moduleName}"]`).should('have.class', 'active');
  }
}

class SettingsPage {
  visit() {
    cy.visit('/settings/reminders');
  }

  getReminderConfiguration() {
    return cy.get('.reminder-config');
  }
}

class ReminderPage {
  visit() {
    cy.visit('/reminders/trigger');
  }

  triggerRemindersForAppointments(patientId, appointmentDates) {
    appointmentDates.forEach(date => {
      cy.get(`.trigger[data-patient-id="${patientId}"][data-date="${date}"]`).click();
    });
  }

  getReminderStatus() {
    return cy.get('.reminder-status');
  }
}

class EmailPage {
  visit() {
    cy.visit('/emails');
  }

  getEmailsForPatient(patientId) {
    return cy.get(`.email[data-patient-id="${patientId}"]`);
  }
}

class LogPage {
  visit() {
    cy.visit('/logs/reminders');
  }

  getReminderLogsForPatient(patientId) {
    return cy.get(`.log[data-patient-id="${patientId}"]`);
  }
}

class LoginPage {
  visit() {
    cy.visit('/login');
  }

  loginAsPatient(patientId) {
    cy.get('#patient-id').type(patientId);
    cy.get('#login-button').click();
  }
}

class Logout {
  logout() {
    cy.get('#logout-button').click();
  }
}