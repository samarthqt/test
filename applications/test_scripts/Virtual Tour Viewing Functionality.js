describe('Virtual Tour Viewing Functionality', () => {
  before(() => {
    cy.login('user001');
  });

  it('should navigate to the Property Management module', () => {
    cy.visit('/property-management');
    cy.url().should('include', '/property-management');
  });

  it('should select a property with a virtual tour available', () => {
    cy.get(PropertyPage.virtualTourButton).should('be.visible');
  });

  it('should view the virtual tour', () => {
    cy.get(PropertyPage.virtualTourButton).click();
    cy.get(VirtualTourPage.tourInterface).should('be.visible');
  });

  it('should ensure high video quality and smooth playback', () => {
    cy.get(VirtualTourPage.videoQuality).should('have.class', 'high-quality');
    cy.get(VirtualTourPage.bufferingIndicator).should('not.exist');
  });

  it('should interact with tour controls', () => {
    cy.get(VirtualTourPage.pauseButton).click();
    cy.get(VirtualTourPage.playButton).click();
    cy.get(VirtualTourPage.navigateButton).click();
  });

  it('should view the tour in full screen', () => {
    cy.get(VirtualTourPage.fullScreenButton).click();
    cy.get(VirtualTourPage.fullScreenIndicator).should('be.visible');
  });

  it('should exit full screen mode', () => {
    cy.get(VirtualTourPage.exitFullScreenButton).click();
    cy.get(VirtualTourPage.fullScreenIndicator).should('not.exist');
  });

  it('should replay the virtual tour', () => {
    cy.get(VirtualTourPage.replayButton).click();
    cy.get(VirtualTourPage.tourInterface).should('be.visible');
  });

  it('should verify no loading indicators during the tour', () => {
    cy.get(VirtualTourPage.bufferingIndicator).should('not.exist');
  });

  it('should test on different devices', () => {
    cy.viewport('macbook-15');
    cy.get(VirtualTourPage.tourInterface).should('be.visible');
    cy.viewport('iphone-x');
    cy.get(VirtualTourPage.tourInterface).should('be.visible');
    cy.viewport('ipad-2');
    cy.get(VirtualTourPage.tourInterface).should('be.visible');
  });

  it('should adapt to low bandwidth', () => {
    cy.setNetworkConditions('low');
    cy.get(VirtualTourPage.tourInterface).should('be.visible');
    cy.get(VirtualTourPage.bufferingIndicator).should('not.exist');
  });

  it('should handle no tour available', () => {
    cy.visit('/property/102');
    cy.get(PropertyPage.noTourMessage).should('be.visible');
  });

  it('should restrict access to logged-in users', () => {
    cy.logout();
    cy.visit('/property-management');
    cy.get(LoginPage.loginPrompt).should('be.visible');
  });

  it('should ensure tour content is up-to-date', () => {
    cy.visit('/property-management/101');
    cy.get(PropertyPage.propertyDetails).should('contain', 'Latest Details');
  });

  it('should restrict access after logout', () => {
    cy.logout();
    cy.visit('/property-management/101');
    cy.get(LoginPage.loginPrompt).should('be.visible');
  });
});