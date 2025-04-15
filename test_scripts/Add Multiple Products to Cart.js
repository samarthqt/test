describe('Add Multiple Products to Cart', () => {
  const smartphonePage = new SmartphonePage();
  const headphonesPage = new HeadphonesPage();
  const cartPage = new CartPage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('should add multiple different products to the shopping cart', () => {
    // Add Smartphone
    smartphonePage.navigateToSmartphone();
    smartphonePage.selectQuantity(1);
    smartphonePage.addToCart();

    // Add Headphones
    headphonesPage.navigateToHeadphones();
    headphonesPage.selectQuantity(2);
    headphonesPage.addToCart();

    // Verify products in cart
    cartPage.navigateToCart();
    cartPage.verifyProductInCart('Smartphone', 1);
    cartPage.verifyProductInCart('Headphones', 2);
  });
});