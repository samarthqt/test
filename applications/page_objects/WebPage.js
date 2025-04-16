class WebPage {
  navigateSections() {
    cy.get('#section1').should('be.visible').click();
    cy.get('#section2').should('be.visible').click();
    cy.get('#section3').should('be.visible').click();
  }
}

class IOSPage {
  navigateSections() {
    cy.get('#section1').should('be.visible').click();
    cy.get('#section2').should('be.visible').click();
    cy.get('#section3').should('be.visible').click();
  }
}

class AndroidPage {
  navigateSections() {
    cy.get('#section1').should('be.visible').click();
    cy.get('#section2').should('be.visible').click();
    cy.get('#section3').should('be.visible').click();
  }
}