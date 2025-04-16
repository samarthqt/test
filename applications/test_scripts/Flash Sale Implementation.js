describe('Flash Sale Implementation', () => {
  const homepage = new Homepage();
  const productPage = new ProductPage();
  const cartPage = new CartPage();
  const checkoutPage = new CheckoutPage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('Verify flash sale banner on homepage', () => {
    homepage.verifyFlashSaleBanner();
  });

  it('Navigate to product page during flash sale time and verify discounted price', () => {
    productPage.navigateToProductPage(101);
    productPage.verifyDiscountedPrice(20);
  });

  it('Add product to shopping cart and verify discounted price', () => {
    productPage.addToCart();
    cartPage.verifyDiscountedPrice(20);
  });

  it('Proceed to checkout and verify discounted price', () => {
    cartPage.proceedToCheckout();
    checkoutPage.verifyDiscountedPriceAndTotal();
  });

  it('Complete purchase during flash sale time', () => {
    checkoutPage.completePurchase();
    checkoutPage.verifyOrderCompletion();
  });
});