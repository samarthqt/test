describe('User Registration', () => {
  const registrationPage = new RegistrationPage();

  beforeEach(() => {
    cy.visit('/register');
  });

  it('should register a new user with valid information', () => {
    registrationPage.enterEmail('newuser@example.com');
    registrationPage.enterPassword('New@123');
    registrationPage.enterFullName('New User');
    registrationPage.enterPhoneNumber('1234567890');
    registrationPage.clickRegister();
    cy.contains('Confirmation message').should('be.visible');
    cy.verifyEmailSent('newuser@example.com');
  });

  it('should display error for duplicate email', () => {
    registrationPage.enterEmail('existinguser@example.com');
    registrationPage.enterPassword('New@123');
    registrationPage.enterFullName('Existing User');
    registrationPage.enterPhoneNumber('0987654321');
    registrationPage.clickRegister();
    cy.contains('Error: Duplicate email').should('be.visible');
  });

  it('should display error for invalid email format', () => {
    registrationPage.enterEmail('invalid-email');
    registrationPage.enterPassword('New@123');
    registrationPage.enterFullName('Invalid Email User');
    registrationPage.enterPhoneNumber('1234567890');
    registrationPage.clickRegister();
    cy.contains('Error: Invalid email format').should('be.visible');
  });

  it('should display error for weak password', () => {
    registrationPage.enterEmail('weakpassword@example.com');
    registrationPage.enterPassword('123');
    registrationPage.enterFullName('Weak Password User');
    registrationPage.enterPhoneNumber('1234567890');
    registrationPage.clickRegister();
    cy.contains('Error: Weak password').should('be.visible');
  });

  it('should validate input fields', () => {
    registrationPage.verifyInputValidations();
  });

  it('should log registration process for audit', () => {
    registrationPage.enterEmail('auditlog@example.com');
    registrationPage.enterPassword('New@123');
    registrationPage.enterFullName('Audit Log User');
    registrationPage.enterPhoneNumber('1234567890');
    registrationPage.clickRegister();
    cy.verifyAuditLog('auditlog@example.com');
  });

  it('should adhere to security standards', () => {
    registrationPage.verifySecurityStandards();
  });

  it('should allow registration from multiple devices', () => {
    cy.registerFromMultipleDevices('multideviceuser@example.com');
  });

  it('should integrate with other authentication modules', () => {
    registrationPage.verifyIntegrationWithAuthModules();
  });
});