describe('Quiz Time Limit Exceeded', () => {
  const assessmentsPage = new AssessmentsPage();
  const quizPage = new QuizPage();

  before(() => {
    cy.login('12345');
  });

  it('Navigate to Assessments module', () => {
    assessmentsPage.visit();
  });

  it('Select and start the quiz', () => {
    assessmentsPage.selectQuiz('QZ001');
    quizPage.startQuiz();
  });

  it('Verify system response after time limit exceeded', () => {
    quizPage.waitForTimeLimit();
    quizPage.verifyTimeExceededResponse();
  });

  it('Check if results are recorded', () => {
    quizPage.verifyResultsRecorded();
  });
});