describe('Quiz Time Limit Functionality', () => {
  const loginPage = new LoginPage();
  const assessmentsPage = new AssessmentsPage();
  const quizPage = new QuizPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log in as a user with User ID 12345', () => {
    loginPage.login('12345');
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to the Assessments module', () => {
    assessmentsPage.navigateToAssessments();
    cy.url().should('include', '/assessments');
  });

  it('should select the quiz with Quiz ID QZ001', () => {
    assessmentsPage.selectQuiz('QZ001');
    quizPage.verifyQuizDetails('30 minutes');
  });

  it('should start the quiz and verify the countdown timer', () => {
    quizPage.startQuiz();
    quizPage.verifyCountdownTimer('30:00');
  });

  it('should complete the quiz within the time limit', () => {
    quizPage.completeQuiz();
    quizPage.verifyQuizSubmission();
  });

  it('should verify that the results are recorded', () => {
    quizPage.verifyResultsRecorded();
  });
});