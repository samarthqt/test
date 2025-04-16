describe('CDN Integration Test Suite', () => {
  const productPage = new ProductPage();

  before(() => {
    cy.visit('https://example.com');
  });

  it('should access the application from New York without delays', () => {
    cy.location('city').should('eq', 'New York');
    cy.url().should('include', 'example.com');
  });

  it('should navigate to a product page and load images within expected time', () => {
    productPage.navigateToProductPage();
    productPage.imagesLoadWithinExpectedTime();
  });

  it('should verify CDN usage through network activity', () => {
    cy.intercept('GET', '**/images/**', (req) => {
      expect(req.headers['x-cdn']).to.exist;
    });
  });

  it('should repeat steps from a different location and verify consistent load times', () => {
    cy.visit('https://example.com');
    productPage.navigateToProductPage();
    productPage.imagesLoadWithinExpectedTime();
  });

  it('should ensure CDN caching is functioning by refreshing the page', () => {
    cy.reload();
    productPage.cachedContentShowsReducedLoadTimes();
  });
});