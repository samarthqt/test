describe('Rent Price Comparison for Similar Properties', () => {
    const propertyManagement = new PropertyManagement();

    before(() => {
        cy.visit('/login');
        propertyManagement.loginAsTenant();
    });

    it('should navigate to the Price Comparison section', () => {
        propertyManagement.navigateToPriceComparison();
        propertyManagement.verifyPriceComparisonSectionDisplayed();
    });

    it('should search for properties in Downtown', () => {
        propertyManagement.enterLocation('Downtown');
        propertyManagement.verifyPropertiesDisplayedInLocation('Downtown');
    });

    it('should select property P123 and compare prices', () => {
        propertyManagement.selectPropertyById('P123');
        propertyManagement.verifyPropertyDetailsDisplayed('P123');
        propertyManagement.clickComparePrices();
        propertyManagement.verifyComparablePropertiesList();
    });

    it('should verify property P124 is listed as comparable', () => {
        propertyManagement.verifyPropertyListedAsComparable('P124');
    });

    it('should check rent prices for comparable properties', () => {
        propertyManagement.checkRentPricesForComparableProperties();
    });

    it('should verify additional features in comparison', () => {
        propertyManagement.verifyAdditionalFeaturesInComparison();
    });

    it('should repeat comparison for a different property', () => {
        propertyManagement.selectDifferentPropertyAndCompare();
        propertyManagement.verifyCorrectComparablePropertiesForNewSelection();
    });

    it('should provide a summary of average rent prices', () => {
        propertyManagement.verifySummaryOfAverageRentPrices();
    });

    after(() => {
        propertyManagement.logout();
    });
});