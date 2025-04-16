class CoursePurchasePage {
    selectCourse(courseName) {
        cy.get('.course-selection').contains(courseName).click();
    }

    selectPaymentMethod(method) {
        cy.get('#payment-method').select(method);
    }

    enterCreditCardDetails(cardNumber, expiryDate, cvv) {
        cy.get('#credit-card-number').type(cardNumber);
        cy.get('#expiry-date').type(expiryDate);
        cy.get('#cvv').type(cvv);
    }

    clickPayNow() {
        cy.get('#pay-now').click();
    }

    verifyExpiredCardErrorMessage() {
        cy.get('.error-message').should('contain', 'credit card is expired');
    }
}