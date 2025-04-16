describe('TC-330 252 Video Playback Smoothness', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const coursePage = new CoursePage();
  const videoPlayer = new VideoPlayer();

  before(() => {
    cy.visit('/');
  });

  it('should log in and navigate to course with video content', () => {
    loginPage.login('videouser', 'videopass');
    dashboardPage.verifyDashboard();
    dashboardPage.selectCourseWithVideo();
    coursePage.verifyCoursePage();
  });

  it('should play, pause, rewind, and fast-forward the video', () => {
    coursePage.playVideo('Course Introduction');
    videoPlayer.verifyVideoPlaying();
    videoPlayer.pauseVideo();
    videoPlayer.verifyVideoPaused();
    videoPlayer.rewindVideo(10);
    videoPlayer.verifyVideoPlaying();
    videoPlayer.fastForwardVideo(15);
    videoPlayer.verifyVideoPlaying();
  });

  after(() => {
    dashboardPage.logout();
  });
});