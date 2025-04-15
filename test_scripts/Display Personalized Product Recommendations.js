describe('Personalized Product Recommendations', () => {
    before(() => {
        cy.login(); // Assuming a custom command for login
    });

    it('should display personalized product recommendations based on user behavior', () => {
        const homepage = new HomePage();
        homepage.visit();
        homepage.verifyHomePageDisplayed();

        homepage.scrollToRecommendedSection();
        homepage.verifyRecommendedSectionVisible();

        homepage.verifyRecommendations(['Electronics', 'Books']);

        homepage.clickRecommendedProduct();
        homepage.verifyProductDetailPage();
    });
});