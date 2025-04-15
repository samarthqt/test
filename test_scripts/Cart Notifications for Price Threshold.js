describe('Cart Notifications for Price Threshold', () => {
    const loginPage = new LoginPage();
    const homePage = new HomePage();
    const productCatalogPage = new ProductCatalogPage();
    const cartPage = new CartPage();

    beforeEach(() => {
        cy.visit('/');
        loginPage.login('validUser', 'validPassword');
        homePage.verifyHomePage();
    });

    it('should not trigger notification for cart value below $200', () => {
        homePage.navigateToProductCatalog();
        productCatalogPage.addProductsToCartBelowThreshold(200);
        cartPage.verifyNoNotification();
    });

    it('should trigger notification when cart value exceeds $200', () => {
        homePage.navigateToProductCatalog();
        productCatalogPage.addProductsToCartBelowThreshold(200);
        cartPage.verifyNoNotification();
        productCatalogPage.addProductsToExceedThreshold(200);
        cartPage.verifyNotificationTriggered();
        cartPage.verifyNotificationContent();
    });

    it('should remove notification when cart value falls below $200', () => {
        homePage.navigateToProductCatalog();
        productCatalogPage.addProductsToExceedThreshold(200);
        cartPage.verifyNotificationTriggered();
        cartPage.removeProductsToFallBelowThreshold(200);
        cartPage.verifyNotificationRemoved();
    });

    afterEach(() => {
        homePage.logout();
    });
});