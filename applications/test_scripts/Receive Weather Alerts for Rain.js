describe('Weather Alerts for Rain', () => {
  const weatherPage = new WeatherPage();

  before(() => {
    cy.visit('/'); // Visit the application
    weatherPage.enableWeatherAlerts();
  });

  it('should set weather condition to Rain for Seattle, WA', () => {
    weatherPage.setWeatherCondition('Seattle, WA', 'Rain');
    weatherPage.verifyWeatherConditionSet('Seattle, WA', 'Rain');
  });

  it('should trigger weather alert notification process', () => {
    weatherPage.triggerWeatherAlertNotification('Rain');
    weatherPage.verifyWeatherAlertTriggered('Rain');
  });

  it('should receive weather alert notification on user device', () => {
    weatherPage.checkUserDeviceForNotification('Rain');
    weatherPage.verifyNotificationReceived('Rain');
  });
});