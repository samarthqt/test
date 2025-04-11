class CartPage {
    setPriceThreshold(threshold) {
        // Set the threshold value in the application
        cy.get('#price-threshold').clear().type(threshold);
    }

    setCurrentTotalPrice(currentTotal) {
        // Update the current total price in the application
        cy.get('#current-total').clear().type(currentTotal);
    }

    addItem(itemPrice) {
        // Add an item with the specified price
        cy.get('#add-item-price').clear().type(itemPrice);
        cy.get('#add-item-button').click();
    }

    removeItem(itemPrice) {
        // Remove an item with the specified price
        cy.get('#remove-item-price').clear().type(itemPrice);
        cy.get('#remove-item-button').click();
    }

    checkNotification(type) {
        // Check for the notification based on type
        const message = type === 'exceeded' ? 'exceeded the threshold' : 'now below the threshold';
        cy.get('#notification').should('contain', message);
    }

    checkNoNotification() {
        // Ensure no notification is shown
        cy.get('#notification').should('not.exist');
    }

    checkSingleNotification() {
        // Check that only one notification is shown
        cy.get('#notification').should('contain', 'exceeded the threshold');
        cy.get('#notification-count').should('have.text', '1');
    }
}

export default CartPage;