class VehiclePage {
  navigateToVehicleProfiles() {
    cy.get('#vehicleProfilesLink').click();
  }

  verifyVehicleListIsVisible() {
    cy.get('#vehicleList').should('be.visible');
  }

  selectVehicleById(vehicleId) {
    cy.get(`#vehicle-${vehicleId}`).click();
  }

  verifyVehicleDetailsDisplayed() {
    cy.get('#vehicleDetails').should('be.visible');
  }

  verifyNotificationSettingsEnabled() {
    cy.get('#notificationSettings').should('have.class', 'enabled');
  }

  simulateVehicleAge(age) {
    cy.get('#simulateAge').type(age);
    cy.get('#triggerNotification').click();
  }
}

class NotificationPage {
  verifyNotificationTriggered() {
    cy.get('#notificationAlert').should('be.visible');
  }

  checkNotificationCenter() {
    cy.get('#notificationCenter').click();
  }

  verifyNotificationPresent() {
    cy.get('#notificationList').should('contain', 'Vehicle has reached 5 years of age');
  }

  verifyNotificationContent() {
    cy.get('#notificationContent').should('contain', 'Vehicle age milestone').and('contain', 'suggests potential part replacements');
  }
}