describe('Emergency Contact Integration - Add and Update', () => {
  beforeEach(() => {
    cy.login('patient123', 'password'); // Assuming login command is defined
    cy.visit('/patient-profile/12345');
  });

  it('should add a new emergency contact', () => {
    const emergencyContactsPage = new EmergencyContactsPage();
    emergencyContactsPage.navigateToEmergencyContacts();
    emergencyContactsPage.clickAddNewContact();
    emergencyContactsPage.enterContactName('John Doe');
    emergencyContactsPage.enterContactPhone('555-1234');
    emergencyContactsPage.selectRelationship('Brother');
    emergencyContactsPage.clickSaveButton();
    emergencyContactsPage.verifyContactInList('John Doe', '555-1234');
  });

  it('should update an existing emergency contact', () => {
    const emergencyContactsPage = new EmergencyContactsPage();
    emergencyContactsPage.selectContactFromList('John Doe');
    emergencyContactsPage.updateContactPhone('555-5678');
    emergencyContactsPage.clickUpdateButton();
    emergencyContactsPage.verifyContactInList('John Doe', '555-5678');
  });

  it('should persist contact data after logout and login', () => {
    cy.logout();
    cy.login('patient123', 'password');
    cy.visit('/patient-profile/12345');
    const emergencyContactsPage = new EmergencyContactsPage();
    emergencyContactsPage.verifyContactInList('John Doe', '555-5678');
  });

  it('should not allow duplicate contact entries', () => {
    const emergencyContactsPage = new EmergencyContactsPage();
    emergencyContactsPage.clickAddNewContact();
    emergencyContactsPage.enterContactName('John Doe');
    emergencyContactsPage.enterContactPhone('555-5678');
    emergencyContactsPage.selectRelationship('Brother');
    emergencyContactsPage.clickSaveButton();
    emergencyContactsPage.verifyDuplicateEntryError();
  });

  it('should require a phone number to save a contact', () => {
    const emergencyContactsPage = new EmergencyContactsPage();
    emergencyContactsPage.clickAddNewContact();
    emergencyContactsPage.enterContactName('Jane Smith');
    emergencyContactsPage.clickSaveButton();
    emergencyContactsPage.verifyPhoneNumberRequiredError();
  });

  it('should validate phone number format', () => {
    const emergencyContactsPage = new EmergencyContactsPage();
    emergencyContactsPage.clickAddNewContact();
    emergencyContactsPage.enterContactName('Jane Smith');
    emergencyContactsPage.enterContactPhone('invalid-phone');
    emergencyContactsPage.clickSaveButton();
    emergencyContactsPage.verifyInvalidPhoneNumberError();
  });

  it('should allow multiple emergency contacts', () => {
    const emergencyContactsPage = new EmergencyContactsPage();
    emergencyContactsPage.clickAddNewContact();
    emergencyContactsPage.enterContactName('Alice Johnson');
    emergencyContactsPage.enterContactPhone('555-6789');
    emergencyContactsPage.selectRelationship('Sister');
    emergencyContactsPage.clickSaveButton();
    emergencyContactsPage.verifyContactInList('Alice Johnson', '555-6789');
  });
});