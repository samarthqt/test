class LecturePage {
  navigateToLectureSection() {
    cy.get('#lecture-section').click();
  }

  verifyLectureSlidesList() {
    cy.get('.lecture-slides-list').should('be.visible');
  }

  openAndViewLectureSlides() {
    cy.get('.lecture-slide').each(($el) => {
      cy.wrap($el).click();
      cy.get('.slide-content').should('be.visible');
      cy.go('back');
    });
  }

  verifyLectureVideosList() {
    cy.get('.lecture-videos-list').should('be.visible');
  }

  playLectureVideos() {
    cy.get('.lecture-video').each(($el) => {
      cy.wrap($el).click();
      cy.get('.video-player').should('be.visible');
      cy.wrap($el).find('.stop-button').click();
    });
  }

  verifyAccessToSlidesAndVideos() {
    this.verifyLectureSlidesList();
    this.verifyLectureVideosList();
  }

  verifyContentRelevance() {
    cy.get('.lecture-content').should('contain', 'game learning objectives');
  }

  checkLectureSection() {
    cy.get('#lecture-section').click();
  }

  confirmContentAvailability() {
    cy.get('.content-availability').should('contain', 'All required content is available');
  }

  notifyMissingContent() {
    cy.get('.content-notification').should('contain', 'Some content is missing');
  }
}

export default LecturePage;