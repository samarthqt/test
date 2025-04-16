describe('Early Access to Sales', () => {
  const loginPage = new LoginPage();
  const salesPage = new SalesPage();
  const loyaltyPage = new LoyaltyPage();
  
  beforeEach(() => {
    cy.visit('/');
  });

  it('should show early access sales for Customer A', () => {
    loginPage.loginAs('CustomerA');
    salesPage.verifyEarlyAccessVisible();
  });

  it('should show early access sales for Customer B', () => {
    loginPage.loginAs('CustomerB');
    salesPage.verifyEarlyAccessVisible();
  });

  it('should not show early access sales for Customer A during non-sale periods', () => {
    loginPage.loginAs('CustomerA');
    salesPage.verifyNoEarlyAccessVisible();
  });

  it('should not show early access sales for Customer B during non-sale periods', () => {
    loginPage.loginAs('CustomerB');
    salesPage.verifyNoEarlyAccessVisible();
  });

  it('should allow Customer A to purchase items during early access', () => {
    loginPage.loginAs('CustomerA');
    salesPage.purchaseItemWithDiscount();
  });

  it('should allow Customer B to purchase items during early access', () => {
    loginPage.loginAs('CustomerB');
    salesPage.purchaseItemWithDiscount();
  });

  it('should expire early access for Customer A after sale period ends', () => {
    loginPage.loginAs('CustomerA');
    salesPage.verifyNoEarlyAccessVisible();
  });

  it('should expire early access for Customer B after sale period ends', () => {
    loginPage.loginAs('CustomerB');
    salesPage.verifyNoEarlyAccessVisible();
  });

  it('should lose early access privileges for Customer A after opting out', () => {
    loginPage.loginAs('CustomerA');
    loyaltyPage.optOut();
    salesPage.verifyNoEarlyAccessVisible();
  });

  it('should lose early access privileges for Customer B after opting out', () => {
    loginPage.loginAs('CustomerB');
    loyaltyPage.optOut();
    salesPage.verifyNoEarlyAccessVisible();
  });

  it('should regain early access privileges for Customer A after re-enrolling', () => {
    loginPage.loginAs('CustomerA');
    loyaltyPage.reEnroll();
    salesPage.verifyEarlyAccessVisible();
  });

  it('should regain early access privileges for Customer B after re-enrolling', () => {
    loginPage.loginAs('CustomerB');
    loyaltyPage.reEnroll();
    salesPage.verifyEarlyAccessVisible();
  });

  it('should maintain early access functionality during peak sales periods', () => {
    loginPage.loginAs('CustomerA');
    salesPage.verifyEarlyAccessResponsive();
  });

  it('should deliver early access notifications to Customer A', () => {
    loginPage.loginAs('CustomerA');
    salesPage.verifyNotificationReceived();
  });

  it('should deliver early access notifications to Customer B', () => {
    loginPage.loginAs('CustomerB');
    salesPage.verifyNotificationReceived();
  });
});