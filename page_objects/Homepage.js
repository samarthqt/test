class Homepage {
  getBanner() {
    return cy.get('#B123');
  }

  getBannerContent() {
    return this.getBanner().find('.banner-content');
  }

  dismissBanner() {
    this.getBanner().find('.dismiss-button').click();
  }
}