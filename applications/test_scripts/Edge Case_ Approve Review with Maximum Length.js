describe('Approve Review with Maximum Length', () => {
  beforeEach(() => {
    cy.visit('/login');
    cy.loginAsModerator();
  });

  it('should approve a review with maximum allowable length', () => {
    const reviewId = 105;
    const reviewContent = 'A'.repeat(5000);

    cy.visit('/dashboard');
    cy.get('.nav-menu').contains('Review Moderation').click();
    cy.url().should('include', '/review-moderation');

    cy.get('.review-list').contains(reviewId).click();
    cy.get('.review-details').should('contain', reviewContent);

    cy.get('.approve-button').click();
    cy.get('.confirmation-message').should('contain', 'Review Approved');

    cy.visit(`/product-page/${reviewId}`);
    cy.get('.customer-reviews').should('contain', reviewContent);
  });
});