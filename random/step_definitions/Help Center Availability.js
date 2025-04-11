describe('Help Center Availability', () => {
  beforeEach(() => {
    cy.visit('/main-menu');
  });

  it('should access the help center from the main menu', () => {
    cy.get('button[aria-label="Help Center"]').click();
    cy.url().should('include', '/help-center');
  });

  it('FAQs should cover common user queries', () => {
    cy.visit('/help-center');
    cy.get('.faqs-section').should('contain', '90% of common user queries');
  });

  it('Troubleshooting guides should be comprehensive and up-to-date', () => {
    cy.visit('/help-center');
    cy.get('.troubleshooting-guides-section').should('contain', 'comprehensive and up-to-date');
  });

  it('Searching FAQs and guides using keywords', () => {
    cy.visit('/help-center');
    cy.get('input[aria-label="Search FAQs and guides"]').type('keywords');
    cy.get('.search-results').should('contain', 'relevant to the keywords');
  });

  it('Help center should be responsive and load within 2 seconds', () => {
    cy.get('button[aria-label="Help Center"]').click();
    cy.get('.help-center').should('be.visible');
    cy.get('.help-center').should('have.css', 'transition-duration', '2s');
  });
});