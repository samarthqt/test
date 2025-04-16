class EmailSubscriptionPage {
  enterEmail(email) {
    cy.get('input[type="email"]').type(email);
  }

  clickSubscribe() {
    cy.get('button#subscribe').click();
  }

  verifySubscriptionSuccess() {
    cy.get('.confirmation-message').should('contain', 'successful subscription');
  }

  checkEmailInbox(email) {
    // This function would ideally use an API or service to check the inbox
    // Simulating the check here as a placeholder
    cy.log(`Checking inbox for ${email}`);
  }
}