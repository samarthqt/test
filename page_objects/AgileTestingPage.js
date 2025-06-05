import 'cypress-xpath';

class AgileTestingPage {
  navigateToAgileTesting() {
    cy.get('a[href=/agile-testing]').click();
  }

  clickGetFreeTrial() {
    cy.get('button:contains(Get Free Trial)').click();
  }

  clickLearnMore(section) {
    const sections = {
      scaleAgile: 0,
      explorerTesting: 1,
      distributedTeam: 2
    };
    cy.get('button:contains(Learn More)').eq(sections[section]).click();
  }

  verifyPageTitle(expectedTitle) {
    cy.title().should('eq', expectedTitle);
  }

  verifyElementVisible(selector) {
    cy.xpath(selector).should('be.visible');
  }

  verifyTextContent(selector, expectedText) {
    cy.xpath(selector).should('contain.text', expectedText);
  }
}

export default AgileTestingPage;
