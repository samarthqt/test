class ParticipantPage {
  static get emailField() {
    return '#email';
  }

  static get phoneField() {
    return '#phone';
  }
}

class SchedulePage {
  static get scheduledVisits() {
    return '.scheduled-visits';
  }

  static scheduleVisit(date) {
    cy.get('#schedule-date').type(date);
    cy.get('#schedule-button').click();
  }
}

class RemindersPage {
  static get remindersList() {
    return '.reminders-list';
  }
}

export { ParticipantPage, SchedulePage, RemindersPage };