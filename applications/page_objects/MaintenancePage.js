class MaintenancePage {
  verifyMainScreen() {
    cy.contains('Main Maintenance Screen').should('be.visible');
  }

  navigateToOilChangeAlerts() {
    cy.get('button').contains('Oil Change Alerts').click();
  }

  navigateToNotificationHistory() {
    cy.get('button').contains('Notification History').click();
  }

  logout() {
    cy.get('button').contains('Logout').click();
  }

  login() {
    cy.get('button').contains('Login').click();
  }

  verifyNotificationSettings() {
    cy.contains('Notification Settings').should('be.visible');
  }
}

class OilChangeAlertsPage {
  verifyDashboard() {
    cy.contains('Oil Change Alerts Dashboard').should('be.visible');
  }

  enterVehicleID(vehicleID) {
    cy.get('input[name="vehicleId"]').type(vehicleID);
  }

  setLastOilChangeDate(date) {
    cy.get('input[name="lastOilChangeDate"]').type(date);
  }

  setCurrentMileage(mileage) {
    cy.get('input[name="currentMileage"]').type(mileage);
  }

  submitDetails() {
    cy.get('button').contains('Submit').click();
  }

  verifyConfirmation() {
    cy.contains('Vehicle details saved').should('be.visible');
  }

  simulateMileageThreshold() {
    cy.get('button').contains('Simulate Mileage Threshold').click();
  }

  simulateTimeThreshold() {
    cy.get('button').contains('Simulate Time Threshold').click();
  }

  verifyNotificationContent() {
    cy.contains('Notification: Oil Change Required').should('be.visible');
  }

  acknowledgeNotification() {
    cy.get('button').contains('Acknowledge').click();
  }
}

class NotificationHistoryPage {
  verifyNotificationInHistory() {
    cy.contains('Acknowledged Notification').should('be.visible');
  }
}