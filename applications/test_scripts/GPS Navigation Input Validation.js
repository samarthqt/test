describe('GPS Navigation Input Validation', () => {
  const gpsPage = new GPSPage();

  beforeEach(() => {
    gpsPage.launchApplication();
  });

  it('should prompt for valid start location when empty', () => {
    gpsPage.attemptEmptyStartLocation();
    gpsPage.verifyStartLocationPrompt();
  });

  it('should display error for invalid destination address', () => {
    gpsPage.enterInvalidDestination();
    gpsPage.verifyInvalidAddressError();
  });

  it('should prevent route planning with invalid inputs', () => {
    gpsPage.initiateRoutePlanningWithInvalidInputs();
    gpsPage.verifyRoutePlanningPrevention();
  });

  it('should not accept special characters in destination', () => {
    gpsPage.enterSpecialCharactersInDestination();
    gpsPage.verifySpecialCharacterError();
  });

  it('should prompt for valid address when numerical value entered', () => {
    gpsPage.enterNumericalValueInDestination();
    gpsPage.verifyNumericalValueError();
  });

  it('should prompt for start location when entering destination', () => {
    gpsPage.enterDestinationWithoutStartLocation();
    gpsPage.verifyStartLocationFirstPrompt();
  });

  it('should prompt for valid destination when empty', () => {
    gpsPage.enterValidStartLocation();
    gpsPage.leaveDestinationEmpty();
    gpsPage.verifyDestinationPrompt();
  });

  it('should indicate unreachable destination', () => {
    gpsPage.enterUnreachableDestination();
    gpsPage.verifyUnreachableDestinationMessage();
  });

  it('should display error for no internet connection', () => {
    gpsPage.disableInternetConnection();
    gpsPage.verifyNoInternetError();
  });

  it('should handle very long address input', () => {
    gpsPage.enterVeryLongAddress();
    gpsPage.verifyLongAddressHandling();
  });

  it('should indicate unavailable map data for different country', () => {
    gpsPage.enterDestinationInDifferentCountry();
    gpsPage.verifyUnavailableMapDataMessage();
  });

  it('should prompt for different start and destination locations', () => {
    gpsPage.enterSameLocationForStartAndDestination();
    gpsPage.verifyDifferentLocationPrompt();
  });

  it('should handle abrupt application closure gracefully', () => {
    gpsPage.closeApplicationAbruptly();
    gpsPage.verifyGracefulClosureHandling();
  });

  it('should retain previous input validation messages on reopening', () => {
    gpsPage.reopenApplication();
    gpsPage.verifyRetainedValidationMessages();
  });
});