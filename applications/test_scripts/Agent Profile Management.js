describe('Agent Profile Management', () => {
  beforeEach(() => {
    cy.login();
    cy.visit('/user-management');
  });

  it('should navigate to user management module', () => {
    cy.get(UserManagementPage.agentProfileSection).should('exist');
  });

  it('should create a new agent profile', () => {
    cy.get(UserManagementPage.agentProfileSection).click();
    cy.get(AgentProfilePage.nameInput).type('John Doe');
    cy.get(AgentProfilePage.contactInput).type('john.doe@example.com');
    cy.get(AgentProfilePage.listingsInput).type('Listing 1, Listing 2');
    cy.get(AgentProfilePage.submitButton).click();
    cy.get(AgentProfilePage.confirmationMessage).should('contain', 'Profile created successfully');
  });

  it('should edit agent profile contact information', () => {
    cy.get(AgentProfilePage.editProfileButton).click();
    cy.get(AgentProfilePage.contactInput).clear().type('jane.doe@example.com');
    cy.get(AgentProfilePage.saveButton).click();
    cy.get(AgentProfilePage.successMessage).should('contain', 'Profile updated successfully');
  });

  it('should add property listings to agent profile', () => {
    cy.get(AgentProfilePage.addListingsButton).click();
    cy.get(AgentProfilePage.listingsInput).type('New Listing');
    cy.get(AgentProfilePage.saveListingsButton).click();
    cy.get(AgentProfilePage.listingsTable).should('contain', 'New Listing');
  });

  it('should reflect profile changes immediately', () => {
    cy.reload();
    cy.get(AgentProfilePage.contactInfo).should('contain', 'jane.doe@example.com');
  });

  it('should display profile correctly on different devices', () => {
    cy.viewport('iphone-6');
    cy.get(AgentProfilePage.profileContainer).should('be.visible');
    cy.viewport('ipad-2');
    cy.get(AgentProfilePage.profileContainer).should('be.visible');
    cy.viewport('macbook-13');
    cy.get(AgentProfilePage.profileContainer).should('be.visible');
  });

  it('should prompt for missing fields during profile creation', () => {
    cy.get(AgentProfilePage.createProfileButton).click();
    cy.get(AgentProfilePage.submitButton).click();
    cy.get(AgentProfilePage.errorMessage).should('contain', 'Please fill in all required fields');
  });

  it('should validate inputs and display errors for invalid data', () => {
    cy.get(AgentProfilePage.contactInput).type('invalid-email');
    cy.get(AgentProfilePage.submitButton).click();
    cy.get(AgentProfilePage.errorMessage).should('contain', 'Invalid email format');
  });

  it('should prevent duplicate profile creation', () => {
    cy.get(AgentProfilePage.createProfileButton).click();
    cy.get(AgentProfilePage.agentIdInput).type('301');
    cy.get(AgentProfilePage.submitButton).click();
    cy.get(AgentProfilePage.errorMessage).should('contain', 'Agent ID already exists');
  });

  it('should verify user permissions for profile access', () => {
    cy.logout();
    cy.visit('/user-management');
    cy.get(AgentProfilePage.agentProfileSection).should('not.exist');
  });

  it('should restrict access to profile management after logout', () => {
    cy.logout();
    cy.visit('/user-management');
    cy.get(LoginPage.loginPrompt).should('be.visible');
  });

  it('should delete agent profile successfully', () => {
    cy.get(AgentProfilePage.deleteProfileButton).click();
    cy.get(AgentProfilePage.confirmDeleteButton).click();
    cy.get(AgentProfilePage.successMessage).should('contain', 'Profile deleted successfully');
  });

  it('should save and retrieve all profile fields accurately', () => {
    cy.get(AgentProfilePage.nameInput).should('have.value', 'John Doe');
    cy.get(AgentProfilePage.contactInput).should('have.value', 'jane.doe@example.com');
    cy.get(AgentProfilePage.listingsInput).should('contain', 'New Listing');
  });
});