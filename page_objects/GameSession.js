class GameSession {
  givenPlayerIsInGameSession() {
    cy.visit('/game-session');
    cy.contains('Active Game Session').should('be.visible');
  }

  whenPlayerPerformsAction() {
    cy.get('.action-button').click();
  }

  thenSystemProvidesImmediateFeedback() {
    cy.get('.feedback-message').should('contain', 'Immediate Feedback');
  }

  givenPlayerHasReceivedFeedback() {
    cy.get('.feedback-message').should('be.visible');
  }

  whenPlayerAnalyzesFeedback() {
    cy.get('.feedback-details').click();
  }

  thenPlayerAdjustsStrategy() {
    cy.get('.strategy-adjustment').should('be.visible');
  }

  givenPlayerReceivesFeedback() {
    cy.get('.feedback-message').should('be.visible');
  }

  whenPlayerReviewsFeedback() {
    cy.get('.feedback-details').click();
  }

  thenFeedbackIsAccurateAndClear() {
    cy.get('.feedback-message').should('contain', 'Accurate and Clear');
  }

  givenPlayerIsInContinuousSession() {
    cy.visit('/continuous-game-session');
    cy.contains('Continuous Gameplay Session').should('be.visible');
  }

  whenPlayerPerformsMultipleActions() {
    cy.get('.action-button').click({ multiple: true });
  }

  thenSystemProvidesContinuousFeedback() {
    cy.get('.feedback-loop').should('be.visible');
  }

  givenPlayerReceivesFeedbackAndAdjusts() {
    cy.get('.feedback-message').should('be.visible');
    cy.get('.strategy-adjustment').should('be.visible');
  }

  whenPlayerImplementsChanges() {
    cy.get('.implement-changes-button').click();
  }

  thenPerformanceShowsImprovement() {
    cy.get('.performance-improvement').should('be.visible');
  }

  givenMultiplePlayersInSession() {
    cy.visit('/multi-player-session');
    cy.contains('Multiple Players').should('be.visible');
  }

  whenEachPlayerPerformsActions() {
    cy.get('.action-button').click({ multiple: true });
  }

  thenSystemProvidesIndividualFeedback() {
    cy.get('.individual-feedback').should('be.visible');
  }
}

module.exports = new GameSession();