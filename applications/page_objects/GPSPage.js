class GPSPage {
  launchApplication() {
    cy.visit('/gps-navigation');
  }

  attemptEmptyStartLocation() {
    cy.get('#start-location').clear();
    cy.get('#plan-route').click();
  }

  verifyStartLocationPrompt() {
    cy.contains('Please enter a valid start location').should('be.visible');
  }

  enterInvalidDestination() {
    cy.get('#destination').type('Invalid Address');
    cy.get('#plan-route').click();
  }

  verifyInvalidAddressError() {
    cy.contains('The address is invalid').should('be.visible');
  }

  initiateRoutePlanningWithInvalidInputs() {
    cy.get('#plan-route').click();
  }

  verifyRoutePlanningPrevention() {
    cy.contains('Please provide valid input data').should('be.visible');
  }

  enterSpecialCharactersInDestination() {
    cy.get('#destination').type('!@#$%^');
    cy.get('#plan-route').click();
  }

  verifySpecialCharacterError() {
    cy.contains('Special characters are not accepted').should('be.visible');
  }

  enterNumericalValueInDestination() {
    cy.get('#destination').type('12345');
    cy.get('#plan-route').click();
  }

  verifyNumericalValueError() {
    cy.contains('Please enter a valid address format').should('be.visible');
  }

  enterDestinationWithoutStartLocation() {
    cy.get('#destination').type('Some Destination');
    cy.get('#plan-route').click();
  }

  verifyStartLocationFirstPrompt() {
    cy.contains('Please enter a start location first').should('be.visible');
  }

  enterValidStartLocation() {
    cy.get('#start-location').type('Valid Start');
  }

  leaveDestinationEmpty() {
    cy.get('#destination').clear();
    cy.get('#plan-route').click();
  }

  verifyDestinationPrompt() {
    cy.contains('Please enter a valid destination').should('be.visible');
  }

  enterUnreachableDestination() {
    cy.get('#destination').type('Unreachable Place');
    cy.get('#plan-route').click();
  }

  verifyUnreachableDestinationMessage() {
    cy.contains('The destination is unreachable').should('be.visible');
  }

  disableInternetConnection() {
    // Simulate no internet connection
  }

  verifyNoInternetError() {
    cy.contains('Real-time traffic updates require an internet connection').should('be.visible');
  }

  enterVeryLongAddress() {
    cy.get('#destination').type('Very Long Address That Exceeds Normal Length');
    cy.get('#plan-route').click();
  }

  verifyLongAddressHandling() {
    cy.contains('Please shorten the address').should('be.visible');
  }

  enterDestinationInDifferentCountry() {
    cy.get('#destination').type('Foreign Country Address');
    cy.get('#plan-route').click();
  }

  verifyUnavailableMapDataMessage() {
    cy.contains('Map data for the selected country is unavailable').should('be.visible');
  }

  enterSameLocationForStartAndDestination() {
    cy.get('#start-location').type('Same Location');
    cy.get('#destination').type('Same Location');
    cy.get('#plan-route').click();
  }

  verifyDifferentLocationPrompt() {
    cy.contains('Please enter different start and destination locations').should('be.visible');
  }

  closeApplicationAbruptly() {
    cy.window().then(win => win.close());
  }

  verifyGracefulClosureHandling() {
    // Verify application handles closure without errors
  }

  reopenApplication() {
    cy.visit('/gps-navigation');
  }

  verifyRetainedValidationMessages() {
    cy.contains('Previous input validation messages').should('be.visible');
  }
}