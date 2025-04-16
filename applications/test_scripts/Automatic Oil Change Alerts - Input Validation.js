describe('Automatic Oil Change Alerts - Input Validation', () => {
  const maintenanceApp = new MaintenanceApp();

  beforeEach(() => {
    maintenanceApp.launch();
  });

  it('should prompt for valid vehicle ID when left empty', () => {
    maintenanceApp.navigateToOilChangeAlerts();
    maintenanceApp.submitForm();
    maintenanceApp.verifyVehicleIdError();
  });

  it('should show error for invalid date format', () => {
    maintenanceApp.navigateToOilChangeAlerts();
    maintenanceApp.enterInvalidDateFormat();
    maintenanceApp.submitForm();
    maintenanceApp.verifyDateError();
  });

  it('should prevent form submission with incomplete details', () => {
    maintenanceApp.navigateToOilChangeAlerts();
    maintenanceApp.submitForm();
    maintenanceApp.verifyIncompleteFormError();
  });

  it('should not accept special characters in vehicle ID', () => {
    maintenanceApp.navigateToOilChangeAlerts();
    maintenanceApp.enterSpecialCharsInVehicleId();
    maintenanceApp.submitForm();
    maintenanceApp.verifySpecialCharError();
  });

  it('should prompt for valid vehicle ID format when numeric', () => {
    maintenanceApp.navigateToOilChangeAlerts();
    maintenanceApp.enterNumericVehicleId();
    maintenanceApp.submitForm();
    maintenanceApp.verifyVehicleIdFormatError();
  });

  it('should truncate or prompt for long vehicle ID', () => {
    maintenanceApp.navigateToOilChangeAlerts();
    maintenanceApp.enterLongVehicleId();
    maintenanceApp.submitForm();
    maintenanceApp.verifyLongVehicleIdError();
  });

  it('should prompt for valid date when last oil change date is empty', () => {
    maintenanceApp.navigateToOilChangeAlerts();
    maintenanceApp.enterValidVehicleId();
    maintenanceApp.submitForm();
    maintenanceApp.verifyDateError();
  });

  it('should prevent updating with invalid data', () => {
    maintenanceApp.navigateToOilChangeAlerts();
    maintenanceApp.enterInvalidVehicleDetails();
    maintenanceApp.updateVehicleDetails();
    maintenanceApp.verifyInvalidDataError();
  });

  it('should prompt for confirmation before deletion', () => {
    maintenanceApp.navigateToOilChangeAlerts();
    maintenanceApp.deleteVehicleDetails();
    maintenanceApp.verifyDeletionConfirmation();
  });

  it('should show error for invalid mileage value', () => {
    maintenanceApp.navigateToOilChangeAlerts();
    maintenanceApp.enterInvalidMileage();
    maintenanceApp.submitForm();
    maintenanceApp.verifyMileageError();
  });

  it('should show error for duplicate vehicle IDs', () => {
    maintenanceApp.navigateToOilChangeAlerts();
    maintenanceApp.addDuplicateVehicleId();
    maintenanceApp.submitForm();
    maintenanceApp.verifyDuplicateVehicleIdError();
  });

  it('should handle abrupt closure gracefully', () => {
    maintenanceApp.closeAbruptly();
    maintenanceApp.verifyGracefulClosure();
  });

  it('should retain validation messages on reopening', () => {
    maintenanceApp.reopen();
    maintenanceApp.verifyRetainedValidationMessages();
  });
});