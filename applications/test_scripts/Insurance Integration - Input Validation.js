describe('Insurance Management System - Input Validation', () => {
  const insurancePage = new InsurancePage();

  beforeEach(() => {
    insurancePage.launchApplication();
  });

  it('Should prompt for valid policy number when left empty', () => {
    insurancePage.navigateToAddInsurance();
    insurancePage.submitForm();
    insurancePage.verifyPolicyNumberPrompt();
  });

  it('Should display error for invalid provider name with special characters', () => {
    insurancePage.navigateToAddInsurance();
    insurancePage.enterProviderName('!@#$%^&*');
    insurancePage.submitForm();
    insurancePage.verifyProviderNameError();
  });

  it('Should prevent form submission with incomplete details', () => {
    insurancePage.navigateToAddInsurance();
    insurancePage.submitForm();
    insurancePage.verifyFormSubmissionPrevention();
  });

  it('Should prompt for valid provider name format with numerical value', () => {
    insurancePage.navigateToAddInsurance();
    insurancePage.enterProviderName('12345');
    insurancePage.submitForm();
    insurancePage.verifyProviderNameFormatPrompt();
  });

  it('Should handle very long policy number exceeding character limit', () => {
    insurancePage.navigateToAddInsurance();
    insurancePage.enterPolicyNumber('12345678901234567890');
    insurancePage.verifyPolicyNumberTruncation();
  });

  it('Should prompt for provider name when field is left empty', () => {
    insurancePage.navigateToAddInsurance();
    insurancePage.enterPolicyNumber('12345');
    insurancePage.submitForm();
    insurancePage.verifyProviderNamePrompt();
  });

  it('Should prevent updating insurance details with invalid data', () => {
    insurancePage.navigateToUpdateInsurance();
    insurancePage.enterInvalidInsuranceData();
    insurancePage.submitForm();
    insurancePage.verifyUpdatePrevention();
  });

  it('Should prompt for confirmation before deletion', () => {
    insurancePage.navigateToInsuranceDetails();
    insurancePage.deleteInsuranceWithoutConfirmation();
    insurancePage.verifyDeletionConfirmationPrompt();
  });

  it('Should display error for invalid coverage type', () => {
    insurancePage.navigateToAddInsurance();
    insurancePage.enterInvalidCoverageType();
    insurancePage.submitForm();
    insurancePage.verifyCoverageTypeError();
  });

  it('Should display message for duplicate policy numbers', () => {
    insurancePage.navigateToAddInsurance();
    insurancePage.enterDuplicatePolicyNumber();
    insurancePage.submitForm();
    insurancePage.verifyDuplicatePolicyNumberMessage();
  });

  it('Should handle abrupt application closure gracefully', () => {
    insurancePage.closeApplicationAbruptly();
    insurancePage.verifyGracefulClosure();
  });

  it('Should retain input validation messages after reopening', () => {
    insurancePage.reopenApplication();
    insurancePage.verifyRetainedValidationMessages();
  });

  it('Should log out successfully without errors', () => {
    insurancePage.logout();
    insurancePage.verifySuccessfulLogout();
  });
});