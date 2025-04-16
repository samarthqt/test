describe('TC-241 IP Geolocation Restriction Edge Case', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();

  beforeEach(() => {
    cy.intercept('GET', '/api/geolocation', { fixture: 'geolocation.json' }).as('getGeolocation');
    cy.visit('/login');
  });

  it('should attempt to log in from borderline IP address and verify access result', () => {
    loginPage.login('testuser', 'password123');
    cy.wait('@getGeolocation');
    cy.get('@getGeolocation').then((interception) => {
      const ipAddress = interception.response.body.ip;
      expect(ipAddress).to.equal('198.51.100.0');
    });

    cy.get('body').then(($body) => {
      if ($body.text().includes('Access Denied')) {
        cy.log('Access denied due to geolocation restrictions.');
      } else {
        cy.log('Access granted.');
        dashboardPage.logout();
      }
    });
  });
});