describe('Digital Rental Contract Creation and Signing', () => {
  const rentalContractPage = new RentalContractPage();

  beforeEach(() => {
    cy.visit('/rental-contract-creation');
  });

  it('should create and digitally sign rental contracts', () => {
    rentalContractPage.enterPropertyAddress('123 Main St, Springfield');
    rentalContractPage.enterContractTerms('12 months, $1200/month');
    rentalContractPage.selectTenant('User A: John Doe');
    rentalContractPage.selectLandlord('User B: Jane Smith');
    rentalContractPage.generateContract();
    rentalContractPage.reviewContractForAccuracy();
    rentalContractPage.initiateSigningProcess('User A');
    rentalContractPage.signContract('User A');
    rentalContractPage.initiateSigningProcess('User B');
    rentalContractPage.signContract('User B');
    rentalContractPage.verifySignatures();
    rentalContractPage.saveSignedContract();
    rentalContractPage.sendConfirmationEmail();
    rentalContractPage.logout();
  });
});