class FitnessClassesPage {
  navigateToFitnessClassesSection() {
    cy.get('nav').contains('Fitness Classes').click();
  }

  selectYogaClassType() {
    cy.get('.class-type').contains('Yoga').click();
  }

  chooseClassScheduledForMondayAt7AM() {
    cy.get('.class-schedule').contains('Monday 7 AM').click();
  }

  joinSelectedClass() {
    cy.get('button').contains('Join').click();
  }

  verifyVideoAndAudioFunctionality() {
    cy.get('video').should('be.visible');
    cy.get('audio').should('be.visible');
  }
}

export default FitnessClassesPage;