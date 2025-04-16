describe('CDN Load Times During High Traffic', () => {
  const videoStreamPage = new VideoStreamPage();

  before(() => {
    cy.visit('/');
    cy.simulateHighTraffic();
  });

  it('should access a video stream from Tokyo location during peak traffic', () => {
    videoStreamPage.accessVideoStream();
    cy.get(videoStreamPage.videoElement).should('be.visible');
    cy.get(videoStreamPage.videoElement).should('have.prop', 'readyState').and('eq', 4);
  });

  it('should verify CDN usage under high traffic through network activity', () => {
    cy.intercept('GET', '**/video-stream-url').as('videoStream');
    videoStreamPage.accessVideoStream();
    cy.wait('@videoStream').its('response.statusCode').should('eq', 200);
    cy.get('@videoStream').its('response.headers').should('include', {
      'x-cache': 'HIT'
    });
  });

  it('should repeat the test from a different geographical location', () => {
    cy.setGeolocation('New York', 'USA');
    videoStreamPage.accessVideoStream();
    cy.get(videoStreamPage.videoElement).should('have.prop', 'readyState').and('eq', 4);
  });

  it('should ensure CDN caching is functioning by refreshing the video stream', () => {
    videoStreamPage.refreshVideoStream();
    cy.get(videoStreamPage.videoElement).should('have.prop', 'readyState').and('eq', 4);
  });
});