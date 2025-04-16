describe('TC-367 278 Video Quality Adjustment Based on Bandwidth', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const videoSettingsPage = new VideoSettingsPage();
  const videoPlayerPage = new VideoPlayerPage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('should log in to the Content Delivery system', () => {
    loginPage.login('U54321', 'password');
    dashboardPage.verifyDashboard();
  });

  it('should navigate to the Video Settings section', () => {
    dashboardPage.navigateToVideoSettings();
    videoSettingsPage.verifyVideoSettings();
  });

  it('should select a video and start playback', () => {
    videoSettingsPage.selectVideo('V98765');
    videoPlayerPage.verifyPlayback();
  });

  it('should observe automatic video quality adjustment', () => {
    videoPlayerPage.verifyQualityAdjustment(5);
  });

  it('should manually change the video quality', () => {
    videoPlayerPage.changeQuality('720p');
    videoPlayerPage.verifyManualQualityChange('720p');
  });

  it('should simulate bandwidth drop to 1 Mbps', () => {
    videoPlayerPage.simulateBandwidth(1);
    videoPlayerPage.verifyQualityAdjustment(1);
  });

  it('should simulate bandwidth increase to 10 Mbps', () => {
    videoPlayerPage.simulateBandwidth(10);
    videoPlayerPage.verifyQualityAdjustment(10);
  });

  it('should check for quality change notification', () => {
    videoPlayerPage.verifyQualityNotification();
  });

  it('should log out from the system', () => {
    dashboardPage.logout();
    loginPage.verifyLogout();
  });
});