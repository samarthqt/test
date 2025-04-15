describe('Product Subscription Setup', () => {
    before(() => {
        // Assuming user is already logged in
        cy.visit('/product-subscription');
    });

    it('should allow user to subscribe to Monthly Coffee Subscription', () => {
        const subscriptionPage = new SubscriptionPage();

        // Step 1: Navigate to the product subscription section
        subscriptionPage.verifyOnSubscriptionPage();

        // Step 2: Select the 'Monthly Coffee Subscription' product
        subscriptionPage.selectProduct('Monthly Coffee Subscription');

        // Step 3: Choose 'Monthly' as the delivery frequency
        subscriptionPage.selectDeliveryFrequency('Monthly');

        // Step 4: Select 'Credit Card' as the payment method
        subscriptionPage.selectPaymentMethod('Credit Card');

        // Step 5: Click on the 'Subscribe' button
        subscriptionPage.clickSubscribeButton();

        // Step 6: Verify the subscription details in the user's account
        subscriptionPage.verifySubscriptionDetails('Monthly Coffee Subscription', 'Monthly', 'Credit Card');
    });
});