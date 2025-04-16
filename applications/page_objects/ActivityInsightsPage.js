class ActivityInsightsPage {
    navigateToActivityInsights() {
        cy.get('#activityInsightsNav').click();
    }

    verifyActivityInsightsOptionsDisplayed() {
        cy.get('#activityOptions').should('be.visible');
    }

    selectGraphicalRepresentationOption() {
        cy.get('#viewGraphicalTrends').click();
    }

    verifyGraphicalRepresentationDisplayed() {
        cy.get('#graphicalTrends').should('be.visible');
    }

    verifyAccuracyOfGraphicalData() {
        cy.get('#graphicalTrends').then(($graph) => {
            // Add logic to verify the accuracy of the graph data
            expect($graph).to.contain('Expected Trend');
            expect($graph).to.contain('Expected Peak');
            expect($graph).to.contain('Expected Pattern');
        });
    }
}