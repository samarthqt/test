describe('Course Purchase via PayPal', () => {
    const coursePurchasePage = new CoursePurchasePage();
    const paypalLoginPage = new PaypalLoginPage();
    const coursePlatformPage = new CoursePlatformPage();

    beforeEach(() => {
        cy.visit('/course-purchase');
    });

    it('should allow user to purchase course using PayPal', () => {
        coursePurchasePage.selectCourse('High Course');
        coursePurchasePage.selectPaymentMethod('PayPal');

        paypalLoginPage.login('user@example.com', 'securepassword');
        paypalLoginPage.confirmPayment();

        coursePlatformPage.verifyPaymentConfirmation();
    });
});