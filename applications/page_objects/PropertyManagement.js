class PropertyManagement {
    loginAsTenant() {
        cy.get('#username').type('tenantUser');
        cy.get('#password').type('tenantPass');
        cy.get('#loginButton').click();
        cy.url().should('include', '/dashboard');
    }

    navigateToPriceComparison() {
        cy.get('#menuPriceComparison').click();
    }

    verifyPriceComparisonSectionDisplayed() {
        cy.get('#priceComparisonSection').should('be.visible');
    }

    enterLocation(location) {
        cy.get('#locationSearchField').type(location);
        cy.get('#searchButton').click();
    }

    verifyPropertiesDisplayedInLocation(location) {
        cy.get('.property-list').should('contain', location);
    }

    selectPropertyById(propertyId) {
        cy.get(`[data-property-id="${propertyId}"]`).click();
    }

    verifyPropertyDetailsDisplayed(propertyId) {
        cy.get('.property-details').should('contain', propertyId);
    }

    clickComparePrices() {
        cy.get('#comparePricesButton').click();
    }

    verifyComparablePropertiesList() {
        cy.get('.comparable-properties-list').should('be.visible');
    }

    verifyPropertyListedAsComparable(propertyId) {
        cy.get('.comparable-properties-list').should('contain', propertyId);
    }

    checkRentPricesForComparableProperties() {
        cy.get('.comparable-properties-list .rent-price').each(price => {
            expect(price).to.not.be.empty;
        });
    }

    verifyAdditionalFeaturesInComparison() {
        cy.get('.comparable-properties-list').should('contain', 'bedrooms').and('contain', 'bathrooms');
    }

    selectDifferentPropertyAndCompare() {
        cy.get('.property-list .property-item').eq(1).click();
        this.clickComparePrices();
    }

    verifyCorrectComparablePropertiesForNewSelection() {
        cy.get('.comparable-properties-list').should('be.visible');
    }

    verifySummaryOfAverageRentPrices() {
        cy.get('#averageRentSummary').should('be.visible');
    }

    logout() {
        cy.get('#logoutButton').click();
        cy.url().should('include', '/login');
    }
}