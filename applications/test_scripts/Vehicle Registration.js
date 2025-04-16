describe('Vehicle Registration Test Suite', () => {
  it('should allow users to register their vehicle', () => {
    const vehicleRegistrationPage = new VehicleRegistrationPage();
    vehicleRegistrationPage.navigateToPage();
    vehicleRegistrationPage.enterMake('Toyota');
    vehicleRegistrationPage.enterModel('Corolla');
    vehicleRegistrationPage.enterVIN('1HGCM82633A123456');
    vehicleRegistrationPage.enterRegistrationNumber('ABC123');
    vehicleRegistrationPage.clickRegisterVehicleButton();
    vehicleRegistrationPage.verifyRegistrationConfirmation();
    vehicleRegistrationPage.verifyVehicleDetailsInAccount('Toyota', 'Corolla', '1HGCM82633A123456', 'ABC123');
  });
});