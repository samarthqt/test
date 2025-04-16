describe('TC-239 192 IP Geolocation Restriction Positive Scenario', () => {
  const loginPage = new LoginPage();
  const homePage = new HomePage();
  const restrictedIP = '192.168.1.1';
  const unrestrictedIP = '192.168.1.2';

  it('should deny access from restricted IP address', () => {
    cy.intercept('GET', '/login', (req) => {
      req.headers['x-forwarded-for'] = restrictedIP;
    }).as('loginAttempt');

    loginPage.visit();
    loginPage.submitLogin();

    cy.wait('@loginAttempt');
    loginPage.getErrorMessage().should('contain', 'Access restricted based on your location');
  });

  it('should grant access from unrestricted IP address', () => {
    cy.intercept('GET', '/login', (req) => {
      req.headers['x-forwarded-for'] = unrestrictedIP;
    }).as('loginAttempt');

    loginPage.visit();
    loginPage.submitLogin();

    cy.wait('@loginAttempt');
    homePage.getWelcomeMessage().should('contain', 'Welcome');
  });

  it('should log out successfully', () => {
    homePage.logout();
    loginPage.getLoginButton().should('be.visible');
  });
});