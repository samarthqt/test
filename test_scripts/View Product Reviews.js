describe('View Product Reviews', () => {
  it('should allow users to view product reviews', () => {
    const productPage = new ProductPage();
    productPage.visitProductPage('987654');
    productPage.scrollToReviewsSection();
    productPage.verifyUserReviewsPresence();
  });
});