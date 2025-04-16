class VehicleRegistrationPage {
  navigateToPage() {
    cy.visit('/vehicle-registration');
  }

  enterMake(make) {
    cy.get('#make-field').type(make);
  }

  enterModel(model) {
    cy.get('#model-field').type(model);
  }

  enterVIN(vin) {
    cy.get('#vin-field').type(vin);
  }

  enterRegistrationNumber(registrationNumber) {
    cy.get('#registration-field').type(registrationNumber);
  }

  clickRegisterVehicleButton() {
    cy.get('#register-button').click();
  }

  verifyRegistrationConfirmation() {
    cy.get('.confirmation-message').should('contain', 'Vehicle registered successfully');
  }

  verifyVehicleDetailsInAccount(make, model, vin, registrationNumber) {
    cy.get('.account-vehicle-details').should('contain', make)
      .and('contain', model)
      .and('contain', vin)
      .and('contain', registrationNumber);
  }
}