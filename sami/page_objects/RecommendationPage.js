class RecommendationPage {
  visit() {
    cy.visit('/recommendations');
  }

  verifyPersonalizedRecommendations() {
    cy.get('.recommendation-personalized').should('be.visible');
  }

  verifyRecommendationsBasedOnHistory() {
    cy.get('.recommendation-history').should('contain', 'Based on your past behavior');
  }

  verifyDefaultRecommendations() {
    cy.get('.recommendation-default').should('be.visible');
  }

  verifyRecommendationsBasedOnPopularity() {
    cy.get('.recommendation-popular').should('contain', 'Popular products');
  }

  viewPersonalizedRecommendations() {
    this.visit();
    this.verifyPersonalizedRecommendations();
  }

  interactWithRecommendedProduct() {
    cy.get('.recommended-product').first().click();
  }

  verifyUpdatedRecommendations() {
    cy.get('.recommendation-updated').should('be.visible');
  }

  verifyRecommendationsReflectRecentInteraction() {
    cy.get('.recommendation-recent').should('contain', 'Reflects your recent interaction');
  }

  verifyVarietyOfRecommendations() {
    cy.get('.recommendation-variety').should('be.visible');
  }

  verifyRecommendationsReflectInterests() {
    cy.get('.recommendation-interests').should('contain', 'Reflects your interests');
  }

  verifyNoRecommendationsMessage() {
    cy.get('.no-recommendations').should('contain', 'No recommendations available');
  }

  verifySuggestionsForGeneratingRecommendations() {
    cy.get('.recommendation-suggestions').should('contain', 'Browse popular products');
  }
}

export default RecommendationPage;