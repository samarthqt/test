describe('30-Day Return Policy', () => {
  const loginPage = new LoginPage();
  const orderHistoryPage = new OrderHistoryPage();
  const returnRequestPage = new ReturnRequestPage();

  before(() => {
    cy.visit('/login');
  });

  it('should allow user to request a return within 30 days', () => {
    loginPage.login('validUser', 'validPassword');
    cy.url().should('include', '/dashboard');

    orderHistoryPage.navigateToOrderHistory();
    orderHistoryPage.selectOrder('112233');

    returnRequestPage.clickRequestReturn();
    returnRequestPage.fillReturnForm('Defective Product');
    returnRequestPage.submitReturnForm();

    cy.contains('Return request is submitted successfully').should('be.visible');

    cy.task('checkEmail', 'user@example.com').then((email) => {
      expect(email.subject).to.include('Return Request Confirmation');
      expect(email.body).to.include('Your return request for order 112233 has been received');
    });
  });
});