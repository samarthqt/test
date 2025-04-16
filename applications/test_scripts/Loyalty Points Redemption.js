describe('Loyalty Points Redemption', () => {
 it('should allow users to redeem loyalty points for discounts or rewards', () => {
 cy.visit('/login');
 const loginPage = new LoginPage();
 loginPage.enterUsername('54321');
 loginPage.enterPassword('validPassword');
 loginPage.submit();
 cy.url().should('include', '/dashboard');
 const dashboardPage = new DashboardPage();
 dashboardPage.navigateToLoyaltyProgram();
 dashboardPage.getLoyaltyPoints().should('contain', '200');
 dashboardPage.selectRedeemPointsOption();
 dashboardPage.getRedemptionOptions().should('contain', '$20');
 dashboardPage.chooseReward('$20');
 dashboardPage.getUpdatedPointsBalance().should('be.lessThan', '200');
 dashboardPage.verifyRewardApplied().should('be.visible');
 });
});