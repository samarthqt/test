describe('Product Search by Category', () => {
  before(() => {
    // Assuming user is already logged in
    cy.visit('/');
  });

  it('should display the homepage with category menu', () => {
    const homepage = new HomePage();
    homepage.verifyCategoryMenuVisible();
  });

  it('should select Electronics category and verify Samsung Galaxy S21 is listed', () => {
    const homepage = new HomePage();
    const categoryPage = homepage.selectCategory('Electronics');
    categoryPage.verifyProductIsListed('Samsung Galaxy S21');
  });
});