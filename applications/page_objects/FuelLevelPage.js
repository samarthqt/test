class FuelLevelPage {
  getInterface() {
    return cy.get('.fuel-level-interface');
  }

  getFuelSensorStatus() {
    return cy.get('.fuel-sensor-status');
  }

  getCurrentFuelLevel() {
    return cy.get('.current-fuel-level');
  }

  refuelVehicle() {
    cy.get('.refuel-button').click();
  }

  getFuelConsumptionHistory() {
    return cy.get('.fuel-consumption-history');
  }
}