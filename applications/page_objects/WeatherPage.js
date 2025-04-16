class WeatherPage {
  enableWeatherAlerts() {
    cy.get('#enable-alerts').click();
  }

  setWeatherCondition(location, condition) {
    cy.get('#location-input').type(location);
    cy.get('#condition-select').select(condition);
    cy.get('#set-condition').click();
  }

  verifyWeatherConditionSet(location, condition) {
    cy.get('#current-location').should('have.text', location);
    cy.get('#current-condition').should('have.text', condition);
  }

  triggerWeatherAlertNotification(condition) {
    cy.get('#trigger-alert').click();
  }

  verifyWeatherAlertTriggered(condition) {
    cy.get('#alert-status').should('have.text', `Alert triggered for ${condition}`);
  }

  checkUserDeviceForNotification(condition) {
    cy.get('#device-notifications').click();
  }

  verifyNotificationReceived(condition) {
    cy.get('#notification-list').should('contain.text', `Weather alert: ${condition}`);
  }
}