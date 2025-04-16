describe('Social Media Sharing of Achievements', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const achievementsPage = new AchievementsPage();
  const socialMediaPage = new SocialMediaPage();

  before(() => {
    cy.visit('/');
  });

  it('should log in and navigate to dashboard', () => {
    loginPage.login('user@example.com', 'password123');
    dashboardPage.verifyDashboard();
  });

  it('should navigate to Achievements section', () => {
    dashboardPage.goToAchievements();
    achievementsPage.verifyAchievementsList();
  });

  it('should share course completion on Facebook', () => {
    achievementsPage.selectCourse('C101');
    achievementsPage.shareOnSocialMedia();
    socialMediaPage.selectPlatform('Facebook');
    socialMediaPage.enterMessage('Completed the course!');
    socialMediaPage.postAchievement();
    socialMediaPage.verifyPostConfirmation();
  });

  it('should share course completion on LinkedIn', () => {
    achievementsPage.shareOnSocialMedia();
    socialMediaPage.selectPlatform('LinkedIn');
    socialMediaPage.enterMessage('Completed the course!');
    socialMediaPage.postAchievement();
    socialMediaPage.verifyPostConfirmation();
  });

  it('should share course completion on Twitter', () => {
    achievementsPage.shareOnSocialMedia();
    socialMediaPage.selectPlatform('Twitter');
    socialMediaPage.enterMessage('Completed the course!');
    socialMediaPage.postAchievement();
    socialMediaPage.verifyPostConfirmation();
  });

  after(() => {
    dashboardPage.logout();
  });
});