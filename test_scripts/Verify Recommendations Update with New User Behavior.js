describe('Verify Recommendations Update with New User Behavior', () => {
  before(() => {
    // Assuming user is already logged in
    cy.visit('/home-appliances');
  });

  it('should record user browsing activity in Home Appliances', () => {
    // Simulate browsing activity
    cy.get('.product-category').contains('Home Appliances').click();
    // Verify browsing activity is recorded
    cy.get('.activity-log').should('contain', 'Home Appliances');
  });

  it('should display recommendations on homepage including Home Appliances', () => {
    cy.visit('/homepage');
    cy.get('#recommended-section').scrollIntoView();
    cy.get('#recommended-section').should('be.visible');
    cy.get('#recommended-section .product-item').should('contain', 'Home Appliances');
  });
});