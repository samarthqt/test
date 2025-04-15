describe('TC-35 Display Return Policy on Product Page', () => {
  it('should display return policy details on the product page', () => {
    const productPage = new ProductPage();
    productPage.visitProductPage('987654');
    productPage.getReturnPolicySection().should('be.visible');
    productPage.getReturnPolicySection().should('contain', 'clear return policy details');
  });
});