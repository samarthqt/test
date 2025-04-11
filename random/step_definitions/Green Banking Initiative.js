Given('the user is logged into the banking app', () => {
  cy.login();
});

When('the user navigates to the Green Banking Initiative section', () => {
  cy.visitGreenBankingInitiative();
});

Then('the user should see their carbon footprint related to banking activities', () => {
  cy.get('#carbonFootprint').should('be.visible');
});

Then('the user should see loan options specifically for eco-friendly projects or purchases', () => {
  cy.get('#ecoFriendlyLoans').should('be.visible');
});

Then('the user should see educational resources on sustainable banking practices', () => {
  cy.get('#educationalResources').should('be.visible');
});

When('the user is on the home page', () => {
  cy.visitHomePage();
});

Then('the Green Banking Initiative should be prominently featured and easily accessible', () => {
  cy.get('#greenBankingFeature').should('be.visible');
});

Given('the user has initiated actions to reduce their carbon footprint', () => {
  cy.initiateCarbonReductionActions();
});

When('the user checks their notifications', () => {
  cy.checkNotifications();
});

Then('the user should be notified of their progress in reducing their carbon footprint', () => {
  cy.get('#carbonReductionProgress').should('be.visible');
});

Given('there is a data tracking error in the carbon footprint calculation', () => {
  cy.simulateDataTrackingError();
});

When('the user checks their carbon footprint', () => {
  cy.checkCarbonFootprint();
});

Then('the user should be informed of the issue and the error should be handled gracefully', () => {
  cy.get('#errorNotification').should('be.visible');
});

Given('the user is using existing banking features', () => {
  cy.useExistingBankingFeatures();
});

When('the user accesses the Green Banking Initiative', () => {
  cy.accessGreenBankingInitiative();
});

Then('the transition should be seamless and integrated with existing features', () => {
  cy.get('#seamlessIntegration').should('be.visible');
});

Given('the user is using the banking app on desktop or mobile', () => {
  cy.useBankingAppOnDesktopOrMobile();
});

Then('the feature should be user-friendly and accessible on both platforms', () => {
  cy.get('#userFriendlyFeature').should('be.visible');
});

Given('the banking app includes the Green Banking Initiative', () => {
  cy.includeGreenBankingInitiative();
});

When('the feature is used by the user', () => {
  cy.useFeature();
});

Then('it should comply with all regulatory requirements related to green banking initiatives', () => {
  cy.get('#regulatoryCompliance').should('be.visible');
});