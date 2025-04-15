class LoginPage {
  static login(username, password) {
    cy.get('#username').type(username);
    cy.get('#password').type(password);
    cy.get('#loginButton').click();
  }
}

class DashboardPage {
  static navigateToAnalytics() {
    cy.get('#analyticsNav').click();
  }
}

class AnalyticsPage {
  static verifySalesData(expectedData) {
    cy.get('#salesData').invoke('text').then((actualData) => {
      expect(actualData.trim()).to.equal(expectedData);
    });
  }
}