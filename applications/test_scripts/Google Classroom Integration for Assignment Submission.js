describe('Google Classroom Integration for Assignment Submission', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const assignmentsPage = new AssignmentsPage();
  const googleAuthPage = new GoogleAuthPage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('should allow students to submit assignments via Google Classroom', () => {
    loginPage.login('U67890', 'password');
    dashboardPage.verifyDashboard();

    dashboardPage.goToAssignments();
    assignmentsPage.verifyAssignmentsList();

    assignmentsPage.selectAssignment('A12345');
    assignmentsPage.verifyAssignmentDetails();

    assignmentsPage.submitViaGoogleClassroom();
    googleAuthPage.authenticateIfNeeded('google_user', 'google_pass');

    assignmentsPage.selectGoogleClassroomCourse('Course Name');
    assignmentsPage.confirmSubmission();
    assignmentsPage.verifySubmissionConfirmation();
  });

  afterEach(() => {
    dashboardPage.logout();
  });
});