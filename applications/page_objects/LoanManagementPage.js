class LoanManagementPage {
    navigateToLoanManagement() {
        cy.url().should('include', '/loan-management');
    }

    selectRepayLoanOption() {
        cy.get('#repay-loan-option').click();
        cy.get('#repayment-form').should('be.visible');
    }

    enterRepaymentAmount(amount) {
        cy.get('#repayment-amount').type(amount);
        cy.get('#repayment-amount').should('have.value', amount);
    }

    selectPaymentMethod(method) {
        cy.get('#payment-method').select(method);
        cy.get('#payment-method').should('have.value', method);
    }

    proceedWithPayment() {
        cy.get('#proceed-payment-button').click();
    }

    verifyPaymentConfirmation(amount) {
        cy.get('#payment-confirmation').should('contain.text', `Your payment of ${amount} has been successfully processed`);
    }

    checkUpdatedLoanBalance(amount) {
        cy.get('#loan-balance').invoke('text').then((text) => {
            const initialBalance = parseFloat(text.replace('$', ''));
            const expectedBalance = initialBalance - parseFloat(amount);
            cy.get('#loan-balance').should('contain.text', `$${expectedBalance}`);
        });
    }
}