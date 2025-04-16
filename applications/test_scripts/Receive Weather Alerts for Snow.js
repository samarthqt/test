describe('Weather Alerts for Snow', () => {
  const weatherPage = new WeatherPage();

  beforeEach(() => {
    cy.visit('/weather');
    weatherPage.enableWeatherAlerts();
  });

  it('should receive weather alerts for snow conditions', () => {
    weatherPage.setWeatherCondition('New York, NY', 'Snow');
    weatherPage.triggerWeatherAlertNotification();
    weatherPage.verifyWeatherAlertNotification('Snow');
  });
});