describe('Verify Call Center Support Availability', () => {
    it('should connect to the support line and receive guidance', () => {
        cy.visit('https://example.com/contact-support');

        // Step 1: Dial the support line number
        cy.get(SupportPage.supportLineNumber).should('contain', '+0987654321');

        // Step 2: Listen to the automated message or hold music
        cy.get(SupportPage.callStatus).should('contain', 'In Queue');

        // Step 3: Wait for the call to be answered
        cy.get(SupportPage.representativeStatus).should('contain', 'Answered');

        // Step 4: Explain the urgent inquiry
        cy.get(SupportPage.inquiryInput).type('Urgent inquiry details');
        cy.get(SupportPage.submitInquiryButton).click();

        // Step 5: Receive guidance or resolution
        cy.get(SupportPage.resolutionMessage).should('contain', 'Guidance or resolution provided');
    });
});