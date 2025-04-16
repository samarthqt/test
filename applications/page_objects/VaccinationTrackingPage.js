class VaccinationTrackingPage {
    visit() {
        cy.visit('/vaccination-tracking');
    }

    selectChild(childId) {
        cy.get('#childSelect').select(childId);
    }

    verifyVaccinationSchedule(vaccine) {
        cy.get('#vaccinationSchedule').should('contain', vaccine);
    }

    verifyUpcomingVaccineDetails(vaccine, dueDate) {
        cy.get('#upcomingVaccines').should('contain', vaccine).and('contain', dueDate);
    }

    checkReminderSettings() {
        cy.get('#reminderSettings').should('contain', 'SMS notifications enabled');
    }

    simulateDueDateArrival(date) {
        cy.simulateDate(date);
    }

    verifyReminderInNotificationHistory(vaccine) {
        cy.get('#notificationHistory').should('contain', `${vaccine} reminder sent`);
    }
}