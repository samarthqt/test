describe('Add Product to Cart', () => {
    const productPage = new ProductPage();
    const cartPage = new CartPage();

    it('should allow users to add a smartphone to the cart', () => {
        // Step 1: Navigate to the product page for 'Smartphone'
        productPage.visit();
        productPage.verifyProductPage('Smartphone High');

        // Step 2: Select quantity '1'
        productPage.selectQuantity(1);

        // Step 3: Click on 'Add to Cart' button
        productPage.addToCart();

        // Step 4: Navigate to the cart page
        cartPage.visit();
        cartPage.verifyProductInCart('Smartphone', 1);
    });
});