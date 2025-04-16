describe('Transaction Alert Notification', () => {
    const transactionPage = new TransactionPage();
    const notificationPage = new NotificationPage();

    beforeEach(() => {
        cy.visit('/login');
        cy.login('user@example.com', 'password123');
    });

    it('should trigger an alert notification for transactions over the threshold', () => {
        transactionPage.makeTransaction(500);
        notificationPage.verifyNotification('A transaction of $500 has been made on your account, exceeding your set threshold of $300');
    });
});