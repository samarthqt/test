describe('Expired Credit Card Test', () => {
    const coursePurchasePage = new CoursePurchasePage();

    beforeEach(() => {
        cy.visit('/course-purchase');
    });

    it('should display error for expired credit card', () => {
        coursePurchasePage.selectCourse('High Course');
        coursePurchasePage.selectPaymentMethod('Credit Card');
        coursePurchasePage.enterCreditCardDetails('4111111111111111', '01/21', '123');
        coursePurchasePage.clickPayNow();
        coursePurchasePage.verifyExpiredCardErrorMessage();
    });
});