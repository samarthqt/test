describe('Cross-Platform Compatibility with Unsupported Browser', () => {
  beforeEach(() => {
    cy.visit('https://yourapplicationurl.com', {
      onBeforeLoad(win) {
        Object.defineProperty(win.navigator, 'userAgent', {
          value: 'Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)',
        });
      },
    });
  });

  it('should display unsupported browser message on application load', () => {
    const unsupportedPage = new UnsupportedPage();
    unsupportedPage.getUnsupportedMessage().should('be.visible').and('contain', 'unsupported browser');
  });

  it('should show limited functionality message when accessing various sections', () => {
    const unsupportedPage = new UnsupportedPage();
    unsupportedPage.navigateToSection('section1');
    unsupportedPage.getLimitedFunctionalityMessage().should('be.visible').and('contain', 'use a supported browser');
  });
});