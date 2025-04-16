describe('Asset History Log Viewing', () => {
    const assetId = 'A123';
    const userId = 'U456';
    const validUsername = 'validUser';
    const validPassword = 'validPassword';

    before(() => {
        cy.visit('/login');
        cy.get('#username').type(validUsername);
        cy.get('#password').type(validPassword);
        cy.get('button[type=submit]').click();
        cy.url().should('include', '/dashboard');
    });

    it('should navigate to Asset Management module', () => {
        cy.get('nav').contains('Asset Management').click();
        cy.url().should('include', '/asset-management');
    });

    it('should access the History Log sub-module', () => {
        cy.get('nav').contains('History Log').click();
        cy.url().should('include', '/asset-management/history-log');
    });

    it('should retrieve and display asset details', () => {
        cy.get('#searchField').type(assetId);
        cy.get('#searchButton').click();
        cy.get('#assetDetails').should('contain', assetId);
    });

    it('should view detailed asset lifecycle events', () => {
        cy.get(`#viewHistoryButton-${assetId}`).click();
        cy.get('#historyLog').should('be.visible');
        cy.get('#historyLog').find('.event').each(($el) => {
            cy.wrap($el).should('contain', 'Timestamp');
        });
    });

    it('should verify the accuracy of displayed data', () => {
        cy.get('#historyLog').find('.event').each(($el, index) => {
            cy.wrap($el).invoke('text').then((text) => {
                expect(text).to.equal(knownRecords[index]);
            });
        });
    });

    it('should export the history log to a CSV file', () => {
        cy.get('#exportCsvButton').click();
        cy.readFile('cypress/downloads/asset-history.csv').should('exist');
    });

    it('should verify contents of exported CSV file', () => {
        cy.readFile('cypress/downloads/asset-history.csv').then((csv) => {
            expect(csv).to.contain('Asset ID,Event,Timestamp');
            expect(csv).to.contain(assetId);
        });
    });

    after(() => {
        cy.get('#logoutButton').click();
        cy.url().should('include', '/login');
    });
});