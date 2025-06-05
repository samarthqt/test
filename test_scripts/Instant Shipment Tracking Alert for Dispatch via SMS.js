describe('Integration & APIs Section', () => {
  const integrationPage = new IntegrationPage();

  beforeEach(() => {
    cy.visit('/integration');
  });

  it('should click on the content button', () => {
    integrationPage.getContentButton().click();
    cy.url().should('include', '/integration/content');
  });

  it('should click on the learn more button', () => {
    integrationPage.getLearnMoreButton().click();
    cy.url().should('include', '/integration/learn-more');
  });
});