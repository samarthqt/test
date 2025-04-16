describe('Batch Upload of Multiple Property Listings', () => {
  const propertyPage = new PropertyPage();

  before(() => {
    cy.loginAsLandlord();
  });

  it('should navigate to Property Listings section', () => {
    propertyPage.navigateToPropertyListings();
    cy.url().should('include', '/property-listings');
  });

  it('should open file upload dialog', () => {
    propertyPage.clickBatchUploadButton();
    cy.get('input[type="file"]').should('be.visible');
  });

  it('should select and upload CSV/Excel file', () => {
    const fileName = 'property-data.csv';
    propertyPage.selectFile(fileName);
    propertyPage.clickUploadButton();
  });

  it('should monitor upload progress', () => {
    propertyPage.monitorUploadProgress();
    cy.get('.progress-bar').should('have.class', 'complete');
  });

  it('should verify uploaded properties', () => {
    propertyPage.verifyPropertiesListed();
    cy.get('.property-list').should('have.length', propertyPage.getPropertiesCountFromFile('property-data.csv'));
  });

  it('should check for errors', () => {
    cy.get('.error-message').should('not.exist');
  });

  it('should cross-verify uploaded data with original file', () => {
    propertyPage.crossVerifyData('property-data.csv');
  });

  after(() => {
    cy.logout();
  });
});