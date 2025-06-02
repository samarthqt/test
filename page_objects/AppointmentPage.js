import { expect } from 'chai';
import { Cypress } from 'cypress';

class AppointmentPage {
    static visitPortal() {
        cy.visit('/appointment-portal');
    }

    static login(username, password) {
        cy.get('#username').type(username);
        cy.get('#password').type(password);
        cy.get('#loginBtn').click();
    }

    static verifyDashboardDisplayed() {
        cy.get('#dashboard').should('be.visible');
    }

    static navigateToBookAppointment() {
        cy.get('#bookAppointmentSection').click();
    }

    static verifyTimeSlotsDisplayed() {
        cy.get('.time-slots').should('be.visible');
    }

    static verifySpecificTimeSlots(slots) {
        slots.forEach(slot => {
            cy.contains(slot).should('exist');
        });
    }

    static selectTimeSlot(slot) {
        cy.contains(slot).click();
    }

    static verifyTimeSlotHighlighted(slot) {
        cy.contains(slot).parent().should('have.class', 'highlighted');
    }

    static clickBookAppointment() {
        cy.get('#bookAppointmentBtn').click();
    }

    static verifyConfirmationDialog() {
        cy.get('#confirmationDialog').should('be.visible');
    }

    static confirmBooking() {
        cy.get('#confirmBookingBtn').click();
    }

    static verifyBookingConfirmed() {
        cy.get('#bookingConfirmed').should('be.visible');
    }

    static verifyConfirmationMessage() {
        cy.get('#confirmationMessage').should('be.visible');
    }

    static verifyAppointmentDetails() {
        cy.get('#appointmentDetails').should('be.visible');
    }

    static verifyNoErrorMessages() {
        cy.get('.error-message').should('not.exist');
    }

    static verifyBookingLogged() {
        // Logic to verify booking is logged
    }

    static verifyTimeSlotUnavailable(slot) {
        cy.contains(slot).should('not.exist');
    }

    static attemptDoubleBooking(slot) {
        cy.contains(slot).click();
        cy.get('#bookAppointmentBtn').click();
    }

    static verifyDoubleBookingPrevented() {
        cy.get('#doubleBookingError').should('be.visible');
    }

    static verifyErrorMessageDisplayed() {
        cy.get('.error-message').should('be.visible');
    }

    static verifyEmailConfirmation() {
        // Logic to verify email confirmation
    }

    static verifySmsConfirmation() {
        // Logic to verify SMS confirmation
    }

    static verifyStatusUpdatedToBooked() {
        // Logic to verify status updated in the system
    }

    static rescheduleOrCancelAppointment() {
        cy.get('#rescheduleOrCancelBtn').click();
    }

    static verifyRescheduleOrCancelSuccess() {
        cy.get('#rescheduleCancelSuccess').should('be.visible');
    }

    static verifySlotsUpdatedAfterCancellation() {
        // Logic to verify slots are updated
    }

    static verifyCanceledSlotAvailableAgain() {
        // Logic to verify canceled slot is available
    }
}

export default AppointmentPage;