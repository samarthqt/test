describe('Social Media Product Sharing', () => {
  const productPage = new ProductPage();
  const facebookPage = new FacebookPage();
  const instagramPage = new InstagramPage();

  before(() => {
    cy.login('test_user');
  });

  it('should share product page on Facebook', () => {
    productPage.visitProductPage(12345);
    productPage.clickShareButton();
    productPage.selectShareOption('Facebook');
    facebookPage.loginIfNeeded('test_user');
    facebookPage.confirmShare();
    facebookPage.verifyShareSuccess();
  });

  it('should share product page on Instagram', () => {
    productPage.visitProductPage(12345);
    productPage.clickShareButton();
    productPage.selectShareOption('Instagram');
    instagramPage.loginIfNeeded('test_user');
    instagramPage.confirmShare();
    instagramPage.verifyShareSuccess();
  });
});