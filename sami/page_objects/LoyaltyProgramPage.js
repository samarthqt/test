class LoyaltyProgramPage {
  visitUserAccountPage() {
    cy.visit('/user-account');
  }

  joinLoyaltyProgram() {
    cy.get('.join-loyalty-program-btn').click();
  }

  verifyEnrollmentSuccess() {
    cy.get('.enrollment-success').should('be.visible');
  }

  verifyConfirmationMessage() {
    cy.get('.confirmation-message').should('contain', 'You have successfully joined the Loyalty Program');
  }

  makePurchase() {
    cy.get('.purchase-btn').click();
  }

  verifyPointsEarned() {
    cy.get('.loyalty-points-earned').should('be.visible');
  }

  verifyPointsInAccount() {
    cy.get('.account-loyalty-points').should('contain', 'Points');
  }

  redeemPointsForDiscount() {
    cy.get('.redeem-points-btn').click();
  }

  verifyDiscountApplied() {
    cy.get('.discount-applied').should('be.visible');
  }

  verifyPointsDeducted() {
    cy.get('.points-deducted').should('be.visible');
  }

  navigateToLoyaltySection() {
    cy.get('.loyalty-section-link').click();
  }

  verifyPointsBalance() {
    cy.get('.loyalty-points-balance').should('be.visible');
  }

  checkNewRewardsOrDiscounts() {
    // Assume a function to simulate checking for new rewards
  }

  verifyNotificationReceived() {
    cy.get('.notification').should('contain', 'New rewards or discounts available');
  }

  leaveLoyaltyProgram() {
    cy.get('.leave-loyalty-program-btn').click();
  }

  verifyUnenrollmentSuccess() {
    cy.get('.unenrollment-success').should('be.visible');
  }
}

export default LoyaltyProgramPage;