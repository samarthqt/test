describe('Participant Demographic Information Test Suite', () => {
  const participantPage = new ParticipantPage();

  before(() => {
    cy.login('validUsername', 'validPassword');
  });

  it('should navigate to Participant Management module', () => {
    participantPage.navigateToParticipantManagement();
    participantPage.verifyParticipantManagementModule();
  });

  it('should add a new participant', () => {
    participantPage.addNewParticipant();
    participantPage.enterParticipantDetails('John Doe', 30, 'Male', 'Caucasian');
    participantPage.submitForm();
    participantPage.verifyConfirmationMessage();
  });

  it('should view participant details', () => {
    participantPage.navigateToViewParticipants();
    participantPage.searchParticipant('John Doe');
    participantPage.verifyParticipantDetails('John Doe', 30, 'Male', 'Caucasian');
  });

  it('should edit participant age', () => {
    participantPage.editParticipant('John Doe');
    participantPage.changeParticipantAge(31);
    participantPage.submitForm();
    participantPage.verifyUpdatedAge('John Doe', 31);
  });

  it('should delete participant', () => {
    participantPage.deleteParticipant('John Doe');
    participantPage.verifyParticipantDeletion('John Doe');
  });

  after(() => {
    cy.logout();
    cy.verifyDatabaseIntegrity();
  });
});