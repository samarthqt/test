class MaintenanceApp {
  launch() {
    cy.visit('/');
  }

  navigateToOilChangeAlerts() {
    cy.get('#oilChangeAlertsNav').click();
  }

  submitForm() {
    cy.get('#submitBtn').click();
  }

  verifyVehicleIdError() {
    cy.get('.error').should('contain', 'Enter a valid vehicle ID');
  }

  enterInvalidDateFormat() {
    cy.get('#lastOilChangeDate').type('invalid-date');
  }

  verifyDateError() {
    cy.get('.error').should('contain', 'Invalid date format');
  }

  verifyIncompleteFormError() {
    cy.get('.error').should('contain', 'Complete all required fields');
  }

  enterSpecialCharsInVehicleId() {
    cy.get('#vehicleId').type('!@#$%');
  }

  verifySpecialCharError() {
    cy.get('.error').should('contain', 'No special characters allowed');
  }

  enterNumericVehicleId() {
    cy.get('#vehicleId').type('12345');
  }

  verifyVehicleIdFormatError() {
    cy.get('.error').should('contain', 'Invalid vehicle ID format');
  }

  enterLongVehicleId() {
    cy.get('#vehicleId').type('A'.repeat(51));
  }

  verifyLongVehicleIdError() {
    cy.get('.error').should('contain', 'Vehicle ID too long');
  }

  enterValidVehicleId() {
    cy.get('#vehicleId').type('VALID123');
  }

  enterInvalidVehicleDetails() {
    cy.get('#vehicleId').type('INVALID');
    cy.get('#lastOilChangeDate').type('invalid-date');
  }

  updateVehicleDetails() {
    cy.get('#updateBtn').click();
  }

  verifyInvalidDataError() {
    cy.get('.error').should('contain', 'Invalid data');
  }

  deleteVehicleDetails() {
    cy.get('#deleteBtn').click();
  }

  verifyDeletionConfirmation() {
    cy.get('.confirmation').should('contain', 'Are you sure you want to delete?');
  }

  enterInvalidMileage() {
    cy.get('#mileage').type('invalid-mileage');
  }

  verifyMileageError() {
    cy.get('.error').should('contain', 'Invalid mileage');
  }

  addDuplicateVehicleId() {
    cy.get('#vehicleId').type('DUPLICATE');
  }

  verifyDuplicateVehicleIdError() {
    cy.get('.error').should('contain', 'Vehicle ID already exists');
  }

  closeAbruptly() {
    cy.window().then(win => win.close());
  }

  verifyGracefulClosure() {
    cy.on('window:before:unload', (event) => {
      event.preventDefault();
    });
  }

  reopen() {
    cy.visit('/');
  }

  verifyRetainedValidationMessages() {
    cy.get('.error').should('exist');
  }
}