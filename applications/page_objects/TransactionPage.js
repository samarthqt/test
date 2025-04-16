class TransactionPage {
    makeTransaction(amount) {
        cy.get('#transaction-amount-input').type(amount);
        cy.get('#submit-transaction').click();
    }
}

class NotificationPage {
    verifyNotification(expectedMessage) {
        cy.get('#notification-message').should('contain', expectedMessage);
    }
}