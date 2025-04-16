describe('Product Reviews Edge Cases', () => {
  beforeEach(() => {
    cy.login('user202', 'password'); // Assuming a custom command for login
    cy.visit('/product/101'); // Navigate to the product page
  });

  it('should submit a review with maximum allowed characters', () => {
    const maxReviewText = 'A'.repeat(5000);
    cy.get(ReviewPage.reviewTextArea).type(maxReviewText);
    cy.get(ReviewPage.ratingInput).select('5');
    cy.get(ReviewPage.submitButton).click();
    cy.get(ReviewPage.reviewSection).should('contain.text', maxReviewText);
  });

  it('should reject a review with rating above the maximum limit', () => {
    cy.get(ReviewPage.reviewTextArea).type('Great product!');
    cy.get(ReviewPage.ratingInput).select('6');
    cy.get(ReviewPage.submitButton).click();
    cy.get(ReviewPage.errorMessage).should('be.visible').and('contain.text', 'Rating must be between 1 and 5');
  });

  it('should submit a review with maximum rating', () => {
    cy.get(ReviewPage.reviewTextArea).type('A'.repeat(5000));
    cy.get(ReviewPage.ratingInput).select('5');
    cy.get(ReviewPage.submitButton).click();
    cy.get(ReviewPage.reviewSection).should('contain.text', 'A'.repeat(5000));
  });

  it('should submit a review with a very short text', () => {
    cy.get(ReviewPage.reviewTextArea).type('A');
    cy.get(ReviewPage.ratingInput).select('5');
    cy.get(ReviewPage.submitButton).click();
    cy.get(ReviewPage.reviewSection).should('contain.text', 'A');
  });

  it('should maintain performance levels for large text submissions', () => {
    const largeText = 'A'.repeat(5000);
    cy.get(ReviewPage.reviewTextArea).type(largeText);
    cy.get(ReviewPage.ratingInput).select('5');
    cy.get(ReviewPage.submitButton).click();
    cy.get(ReviewPage.reviewSection).should('contain.text', largeText);
    // Optionally, add performance assertions here
  });
});