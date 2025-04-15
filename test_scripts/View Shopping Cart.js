describe('Shopping Cart Functionality', () => {
  const loginPage = new LoginPage();
  const homePage = new HomePage();
  const cartPage = new CartPage();

  beforeEach(() => {
    cy.visit('/');
    loginPage.login('validUser', 'validPassword');
    homePage.verifyUserLoggedIn();
  });

  it('should display all products in the shopping cart', () => {
    homePage.navigateToCart();
    cartPage.verifyCartPageDisplayed();
    cartPage.verifyProductsInCart(['101', '102']);
  });

  it('should display correct quantity and price for each product', () => {
    cartPage.verifyProductDetails('101', { quantity: 1, price: 20 });
    cartPage.verifyProductDetails('102', { quantity: 1, price: 30 });
  });

  it('should update the quantity of a product', () => {
    cartPage.updateProductQuantity('101', 2);
    cartPage.verifyProductDetails('101', { quantity: 2, price: 40 });
  });

  it('should remove a product from the cart', () => {
    cartPage.removeProduct('102');
    cartPage.verifyProductNotInCart('102');
  });

  it('should proceed to checkout with remaining products', () => {
    cartPage.proceedToCheckout();
    cartPage.verifyCheckoutPage();
  });
});