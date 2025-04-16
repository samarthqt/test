class CourseProgressPage {
  verifyPageLoaded() {
    cy.get('.course-progress-header').should('contain', 'Course Progress');
  }

  selectCourse(courseName) {
    cy.get('.enrolled-courses-list').contains(courseName).click();
  }

  verifyCourseDetailsDisplayed(courseName) {
    cy.get('.course-details-header').should('contain', courseName);
  }

  verifyProgressCalculationEdgeCases() {
    cy.get('.progress-percentage').then(($percentage) => {
      const progress = parseFloat($percentage.text());
      expect(progress).to.be.oneOf([0, 100]);
    });
  }
}