describe('Mobile Responsiveness Testing', () => {
    const mobileDevices = [
        { name: 'iPhone 12', width: 390, height: 844 },
        { name: 'Samsung Galaxy S21', width: 360, height: 800 }
    ];

    beforeEach(() => {
        cy.visit('/');
    });

    mobileDevices.forEach(device => {
        it(`should load correctly on ${device.name}`, () => {
            cy.viewport(device.width, device.height);
            cy.get('body').should('be.visible');
        });
    });

    it('should navigate to homepage correctly', () => {
        cy.get('nav').contains('Home').click();
        cy.url().should('include', '/home');
    });

    it('should perform a product search', () => {
        cy.get('input[placeholder="Search..."]').type('Product Name{enter}');
        cy.get('.search-results').should('be.visible');
    });

    it('should add a product to the cart', () => {
        cy.get('.product-item').first().click();
        cy.get('button.add-to-cart').click();
        cy.get('.cart').should('contain', '1 item');
    });

    it('should proceed to checkout', () => {
        cy.get('.cart').click();
        cy.get('button.checkout').click();
        cy.url().should('include', '/checkout');
    });

    it('should fill in shipping details', () => {
        cy.get('input[name="shipping-name"]').type('John Doe');
        cy.get('input[name="shipping-address"]').type('123 Main St');
        cy.get('input[name="shipping-city"]').type('Anytown');
    });

    it('should select a payment method', () => {
        cy.get('select[name="payment-method"]').select('Credit Card');
    });

    it('should submit the order', () => {
        cy.get('button.submit-order').click();
        cy.get('.order-confirmation').should('be.visible');
    });

    it('should adjust to different screen orientations', () => {
        cy.viewport(360, 800);
        cy.get('body').should('be.visible');
        cy.viewport(800, 360);
        cy.get('body').should('be.visible');
    });

    it('should log out from the user account', () => {
        cy.get('.user-menu').click();
        cy.get('button.logout').click();
        cy.url().should('include', '/login');
    });
});