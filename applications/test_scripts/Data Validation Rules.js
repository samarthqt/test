describe('Data Validation Rules Test Suite', () => {
  const loginPage = new LoginPage();
  const validationPage = new ValidationPage();

  before(() => {
    cy.visit('/');
    loginPage.login('validUser', 'validPassword');
  });

  it('should navigate to the Validation module', () => {
    validationPage.navigateToValidationModule();
    validationPage.verifyValidationModuleDisplayed();
  });

  it('should define a validation rule for Participant Age', () => {
    validationPage.selectDefineValidationRule();
    validationPage.enterValidationRule('Participant Age', 'Age must be between 18 and 65');
    validationPage.saveValidationRule();
  });

  it('should apply the validation rule to incoming trial data', () => {
    validationPage.applyValidationRuleToData();
    validationPage.verifyDataCompliance();
  });

  it('should reject invalid participant age entries', () => {
    validationPage.enterParticipantAge(17);
    validationPage.verifyErrorMessage();
    validationPage.enterParticipantAge(66);
    validationPage.verifyErrorMessage();
  });

  it('should accept a valid participant age entry', () => {
    validationPage.enterParticipantAge(30);
    validationPage.verifySuccessfulEntry();
  });

  it('should generate a report of validation errors', () => {
    validationPage.generateValidationErrorReport();
    validationPage.verifyErrorReportGenerated();
  });

  after(() => {
    loginPage.logout();
    loginPage.verifyLoggedOut();
    loginPage.reLogin('validUser', 'validPassword');
    validationPage.verifyValidationRulesAccessible();
  });
});