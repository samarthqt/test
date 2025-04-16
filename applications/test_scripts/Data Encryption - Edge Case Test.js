describe('TC-199 161 Data Encryption - Edge Case Test', () => {
    const userId = '67890';
    const maxSizeData = '...'; // Assume this is the maximum size data string

    before(() => {
        cy.createUserData(userId, maxSizeData).then(response => {
            expect(response.status).to.eq(200);
        });
    });

    it('should encrypt the maximum size data without performance degradation', () => {
        cy.encryptData(userId, maxSizeData).then(response => {
            expect(response.status).to.eq(200);
            cy.wrap(response.duration).should('be.lt', 2000); // Assuming 2000ms as threshold
        });
    });

    it('should decrypt the data correctly and ensure integrity', () => {
        cy.decryptData(userId).then(decryptedData => {
            expect(decryptedData).to.eq(maxSizeData);
        });
    });

    it('should monitor system performance during encryption and decryption', () => {
        cy.monitorPerformance().then(performanceMetrics => {
            expect(performanceMetrics.cpuUsage).to.be.lt(80); // Assuming 80% as threshold
            expect(performanceMetrics.memoryUsage).to.be.lt(75); // Assuming 75% as threshold
        });
    });

    after(() => {
        cy.deleteUserData(userId).then(response => {
            expect(response.status).to.eq(200);
        });
    });
});