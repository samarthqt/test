describe('Consent to Share Data Test Suite', () => {
  before(() => {
    // Assuming login is handled before tests
    cy.login('P002');
  });

  it('should navigate to Data Sharing module and give consent', () => {
    const dataSharingPage = new DataSharingPage();
    const myConsentsPage = new MyConsentsPage();

    // Step 1: Navigate to the 'Data Sharing' module
    dataSharingPage.visit();
    dataSharingPage.verifyMainPageDisplayed();

    // Step 2: Select 'Consent to Share Data'
    dataSharingPage.selectConsentToShareData();
    dataSharingPage.verifyConsentFormDisplayed();

    // Step 3: Enter Research Institution ID 'R001'
    dataSharingPage.enterResearchInstitutionID('R001');
    dataSharingPage.verifyResearchInstitutionDetailsDisplayed();

    // Step 4: Select 'Yes' for consent
    dataSharingPage.selectConsentYes();

    // Step 5: Click 'Submit'
    dataSharingPage.submitConsent();
    dataSharingPage.verifyConfirmationMessage();

    // Step 6: Navigate to 'My Consents' page
    myConsentsPage.visit();
    myConsentsPage.verifyMyConsentsPageDisplayed();

    // Step 7: Verify the consent for Research Institution ID 'R001' is listed
    myConsentsPage.verifyConsentListed('R001');
  });
});