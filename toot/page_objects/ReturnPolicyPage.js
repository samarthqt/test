import { Selector } from 'testcafe';

class ReturnPolicyPage {
    static visit() {
        cy.visit('/return-policy');
    }

    static verifyPage() {
        cy.url().should('include', '/return-policy');
    }

    static verifyDetailsDisplayed() {
        cy.get('.return-policy-details').should('be.visible');
    }

    static verifyInformationTopics(topics) {
        topics.forEach(topic => {
            cy.contains(topic).should('be.visible');
        });
    }

    static verifyMobileVisibility() {
        cy.get('.return-policy-details').should('be.visible');
    }

    static verifyResponsiveLayout() {
        cy.get('.responsive-layout').should('exist');
    }

    static changeLanguageToSpanish() {
        cy.get('.language-selector').select('Spanish');
    }

    static verifyDetailsInSpanish() {
        cy.get('.return-policy-details').should('contain', 'Política de devoluciones');
    }

    static verifyHeader() {
        cy.get('h1').should('contain', 'Return Policy');
    }

    static verifyFooterLinks() {
        cy.get('.footer-links').should('be.visible');
    }

    static verifyContactInformation() {
        cy.get('.contact-info').should('be.visible');
    }
}

export default ReturnPolicyPage;