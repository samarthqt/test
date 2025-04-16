describe('User Participation in Discussion Forums', () => {
    const loginPage = new LoginPage();
    const dashboardPage = new DashboardPage();
    const coursePage = new CoursePage();
    const forumPage = new ForumPage();

    before(() => {
        cy.visit('/login');
    });

    it('should log in and navigate to the course', () => {
        loginPage.login('user123', 'pass123');
        dashboardPage.verifyDashboard();
        dashboardPage.navigateToCourse('Intro to Testing');
    });

    it('should access the discussion forums and post a question', () => {
        coursePage.navigateToDiscussionForums();
        forumPage.selectForumTopic('Testing Strategies');
        forumPage.postQuestion('What are the best testing strategies?');
    });

    it('should reply to the posted question', () => {
        forumPage.replyToQuestion('Use a combination of automated and manual testing.');
    });

    after(() => {
        dashboardPage.logout();
    });
});