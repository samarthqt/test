describe('Live Video Session Participation', () => {
  const dashboardPage = new DashboardPage();
  const liveSessionPage = new LiveSessionPage();

  before(() => {
    cy.visit('/login');
    cy.login('user12345', 'password');
    cy.url().should('include', '/dashboard');
  });

  it('should display upcoming live sessions', () => {
    dashboardPage.navigateToLiveSessions();
    liveSessionPage.verifyUpcomingSessionsDisplayed();
  });

  it('should display session details', () => {
    liveSessionPage.selectSession('Dynamics 365 Advanced Topics');
    liveSessionPage.verifySessionDetails('2023-11-05');
  });

  it('should join and participate in the session', () => {
    liveSessionPage.joinSession();
    liveSessionPage.verifyVideoStream();
    liveSessionPage.participateInChat('Hello, everyone!');
    liveSessionPage.engageInQnA('What is the main topic today?');
    liveSessionPage.verifyAudioVideoQuality();
  });

  it('should log session participation', () => {
    liveSessionPage.checkSystemLogs();
  });

  it('should receive email notification', () => {
    liveSessionPage.verifyEmailNotification();
  });

  it('should leave and rejoin session', () => {
    liveSessionPage.leaveSession();
    liveSessionPage.rejoinSession();
  });

  it('should check session recording', () => {
    liveSessionPage.verifySessionRecording();
  });

  it('should adhere to session duration', () => {
    liveSessionPage.verifySessionDuration();
  });

  it('should validate chat and Q&A features', () => {
    liveSessionPage.validateChatAndQnA();
  });

  it('should check for errors during session', () => {
    liveSessionPage.checkForErrors();
  });

  it('should ensure session participation meets criteria', () => {
    liveSessionPage.verifyParticipationCriteria();
  });
});