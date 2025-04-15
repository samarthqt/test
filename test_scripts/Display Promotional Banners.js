describe('Promotional Banners Test Suite', () => {
  const homepage = new Homepage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('should display promotional banners on the homepage', () => {
    homepage.getBanner().should('be.visible');
  });

  it('should verify the presence of a promotional banner at the top', () => {
    homepage.getBanner().should('have.attr', 'id', 'B123');
  });

  it('should check the content of the banner for accuracy', () => {
    homepage.getBannerContent().should('contain', 'Discount').and('contain', 'Valid for 1 week');
  });

  it('should ensure the banner is clickable and redirects correctly', () => {
    homepage.getBanner().click();
    cy.url().should('include', '/promotion-page');
  });

  it('should test banner display across different devices', () => {
    cy.viewport('iphone-6');
    homepage.getBanner().should('be.visible');

    cy.viewport('ipad-2');
    homepage.getBanner().should('be.visible');

    cy.viewport('macbook-15');
    homepage.getBanner().should('be.visible');
  });

  it('should validate banner rotation', () => {
    homepage.getBanner().should('have.attr', 'data-rotation', 'true');
  });

  it('should check banner update or removal after promotion expires', () => {
    cy.clock();
    cy.tick(604800000); // Fast forward 1 week
    homepage.getBanner().should('not.exist');
  });

  it('should verify banner visibility to different user roles', () => {
    cy.login('guest');
    homepage.getBanner().should('be.visible');

    cy.login('registered');
    homepage.getBanner().should('be.visible');
  });

  it('should test banner loading time', () => {
    cy.window().then((win) => {
      const performance = win.performance;
      const loadTime = performance.timing.domContentLoadedEventEnd - performance.timing.navigationStart;
      expect(loadTime).to.be.lessThan(2000);
    });
  });

  it('should ensure banner design aligns with website theme', () => {
    homepage.getBanner().should('have.css', 'background-color', 'rgb(255, 255, 255)');
  });

  it('should check banner visibility in different sections', () => {
    cy.visit('/section1');
    homepage.getBanner().should('be.visible');

    cy.visit('/section2');
    homepage.getBanner().should('be.visible');
  });

  it('should validate banner accessibility', () => {
    homepage.getBanner().should('have.attr', 'aria-label');
  });

  it('should test banner interaction with other elements', () => {
    cy.get('.popup').should('not.exist');
    homepage.getBanner().click();
    cy.get('.popup').should('exist');
  });

  it('should verify analytics tracking for banner clicks', () => {
    cy.intercept('POST', '/analytics').as('analytics');
    homepage.getBanner().click();
    cy.wait('@analytics').its('response.statusCode').should('eq', 200);
  });

  it('should check if the banner can be dismissed', () => {
    homepage.dismissBanner();
    homepage.getBanner().should('not.exist');
  });
});