import { Selector } from 'testcafe';
 
class FindPartnerPage {
    constructor() {
        this.findPartnerButton = '.find-partner-button';
        this.partnerSearchInput = '#partner-search-input';
        this.partnerSearchButton = '#partner-search-button';
        this.partnerResultsList = '.partner-results-list';
    }

    clickFindPartnerButton() {
        cy.get(this.findPartnerButton).click();
    }

    enterSearchCriteria(criteria) {
        cy.get(this.partnerSearchInput).type(criteria);
    }

    clickSearchButton() {
        cy.get(this.partnerSearchButton).click();
    }

    verifyPartnerResultsVisible() {
        cy.get(this.partnerResultsList).should('be.visible');
    }

    getPartnerResults() {
        return cy.get(this.partnerResultsList).children();
    }

    clickFirstPartnerResult() {
        this.getPartnerResults().first().click();
    }
}

export default FindPartnerPage;