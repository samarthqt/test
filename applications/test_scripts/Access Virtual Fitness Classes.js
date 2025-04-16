describe('Virtual Fitness Classes Access', () => {
  beforeEach(() => {
    cy.visit('https://health-tools-app.com');
    cy.login('patient13579', 'validPassword');
  });

  it('should allow patient to access and join a virtual yoga class', () => {
    const fitnessClassesPage = new FitnessClassesPage();

    fitnessClassesPage.navigateToFitnessClassesSection();
    fitnessClassesPage.selectYogaClassType();
    fitnessClassesPage.chooseClassScheduledForMondayAt7AM();
    fitnessClassesPage.joinSelectedClass();
    fitnessClassesPage.verifyVideoAndAudioFunctionality();
  });
});