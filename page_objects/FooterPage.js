class FooterPage {
  scrollToFooter() {
    cy.scrollTo('bottom');
  }

  footerLinks() {
    return cy.get('footer');
  }

  clickReturnPolicyLink() {
    this.footerLinks().contains('Return Policy').click();
  }
}