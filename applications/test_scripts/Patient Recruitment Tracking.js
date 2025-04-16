describe('Patient Recruitment Tracking', () => {
  const loginPage = new LoginPage();
  const homePage = new HomePage();
  const recruitmentPage = new RecruitmentPage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('should log in and track recruitment progress', () => {
    loginPage.login('validUsername', 'validPassword');
    homePage.verifyHomePage();

    homePage.navigateToRecruitmentModule();
    recruitmentPage.verifyRecruitmentTrackingScreen();

    recruitmentPage.selectRecruitment('RCT001');
    recruitmentPage.verifyRecruitmentDetails();

    recruitmentPage.verifyParticipantCount(100);
    recruitmentPage.verifyDemographics(['Age', 'Gender']);

    recruitmentPage.generateRecruitmentReport();
    recruitmentPage.verifyReportGenerated();

    homePage.logout();
    loginPage.verifyLogout();
  });
});