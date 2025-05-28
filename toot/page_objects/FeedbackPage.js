import { Selector } from 'testcafe';

class FeedbackPage {
    static visitHomepage() {
        cy.visit('/homepage');
    }

    static completePurchase() {
        cy.get('#completePurchase').click();
    }

    static navigateToCustomerService() {
        cy.get('#customerService').click();
    }

    static verifyFeedbackOption() {
        cy.get('#feedbackOption').should('be.visible');
    }

    static visitFeedbackForm() {
        cy.visit('/feedback-form');
    }

    static enterFeedbackComments(comments) {
        cy.get('#feedbackComments').type(comments);
    }

    static submitFeedbackForm() {
        cy.get('#submitFeedback').click();
    }

    static verifyFeedbackSubmissionSuccess() {
        cy.get('#feedbackSuccessMessage').should('be.visible');
    }

    static verifyFeedbackSubmissionError() {
        cy.get('#feedbackErrorMessage').should('be.visible');
    }

    static submitFeedbackFormWithoutComments() {
        cy.get('#submitFeedback').click();
    }

    static verifyPromptToEnterComments() {
        cy.get('#promptEnterComments').should('be.visible');
    }

    static submitPreviousFeedback() {
        cy.get('#submitPreviousFeedback').click();
    }

    static navigateToFeedbackHistory() {
        cy.get('#feedbackHistory').click();
    }

    static verifyFeedbackHistoryList() {
        cy.get('#feedbackHistoryList').should('be.visible');
    }

    static visitFeedbackHistoryPage() {
        cy.visit('/feedback-history');
    }

    static selectFeedbackEntry() {
        cy.get('#feedbackEntry').click();
    }

    static editFeedbackComments(newComments) {
        cy.get('#feedbackComments').clear().type(newComments);
    }

    static submitUpdatedFeedbackForm() {
        cy.get('#submitUpdatedFeedback').click();
    }

    static verifyFeedbackUpdateSuccess() {
        cy.get('#feedbackUpdateSuccessMessage').should('be.visible');
    }
}

export default FeedbackPage;