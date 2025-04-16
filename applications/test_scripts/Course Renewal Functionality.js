describe('Course Renewal Functionality', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const myCoursesPage = new MyCoursesPage();
  const paymentPage = new PaymentPage();

  beforeEach(() => {
    cy.visit('https://course-management-system.com');
  });

  it('should allow user to renew an expired course', () => {
    loginPage.login('U12345', 'password123');
    dashboardPage.verifyDashboard();
    dashboardPage.navigateToMyCourses();

    myCoursesPage.verifyCoursesListed();
    myCoursesPage.selectExpiredCourse('C67890');
    myCoursesPage.viewRenewalOptions();

    myCoursesPage.clickRenewCourseButton();
    paymentPage.enterPaymentDetails('4111111111111111', '12/23', '123');
    paymentPage.confirmPayment();

    myCoursesPage.verifyCourseStatusChanged('C67890', 'Active');
    myCoursesPage.accessRenewedCourseContent('C67890');

    cy.checkEmailForConfirmation('user@example.com', 'Course Renewal Confirmation');
    dashboardPage.logout();
  });
});