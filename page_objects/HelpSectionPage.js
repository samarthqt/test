import { Selector } from 'testcafe';

class page_objects/HelpSectionPage.js {
  static visit() {
    cy.visit('/help');
  }

  static verifyPageDisplayedInSpanish() {
    cy.get('#helpSectionPage').should('contain', 'Ayuda');
  }

  static verifyPageDisplayedInEnglish() {
    cy.get('#helpSectionPage').should('contain', 'Help');
  }

  static clickContactUsLink() {
    cy.get('#contactUsLink').click();
  }

  static verifyContactUsPage() {
    cy.url().should('include', '/contact-us');
    cy.get('h1').should('contain', 'Contact Us');
  }

  static searchHelpTopics(topic) {
    cy.get('#helpSearchInput').type(topic);
    cy.get('#helpSearchButton').click();
  }

  static verifySearchResultsDisplayed() {
    cy.get('#searchResults').should('be.visible');
  }

  static selectHelpTopic(topic) {
    cy.get('.helpTopic').contains(topic).click();
  }

  static verifyHelpTopicContentDisplayed(topic) {
    cy.get('#helpContent').should('contain', topic);
  }
}

export default page_objects/HelpSectionPage.js;