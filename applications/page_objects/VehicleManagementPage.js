class VehicleManagementPage {
  login(username, password) {
    cy.get('#username').type(username);
    cy.get('#password').type(password);
    cy.get('#loginButton').click();
  }

  navigateToVehicleProfiles() {
    cy.get('#vehicleProfiles').click();
  }

  selectVehicle(vehicleId) {
    cy.get(`#vehicle-${vehicleId}`).click();
  }

  checkNotificationSettings() {
    return cy.get('#notificationSettings');
  }

  simulateVehicleAge(vehicleId, age) {
    cy.request('POST', '/simulate-age', { vehicleId, age });
  }

  checkNotificationCenter() {
    return cy.get('#notificationCenter');
  }

  checkSystemLogs() {
    return cy.request('GET', '/system-logs');
  }

  logout() {
    cy.get('#logoutButton').click();
  }
}

export default new VehicleManagementPage();