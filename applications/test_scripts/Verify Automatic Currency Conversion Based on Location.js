describe('Verify Automatic Currency Conversion Based on Location', () => {
  beforeEach(() => {
    cy.visit('/login');
  });

  it('should display account balance in EUR when logged in from France', () => {
    const loginPage = new LoginPage();
    const dashboardPage = new DashboardPage();

    // Simulate logging in from France
    cy.setGeolocation('FR');

    // Log into the user account
    loginPage.enterUsername('testuser');
    loginPage.enterPassword('password123');
    loginPage.submit();

    // Verify the account balance is displayed in EUR
    dashboardPage.getBalanceCurrency().should('contain', 'EUR');
  });
});