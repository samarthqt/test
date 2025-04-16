describe('Leaderboard Display for Top Students', () => {
  beforeEach(() => {
    cy.login('student');
    cy.visit('/dashboard');
  });

  it('should display leaderboard for course C002', () => {
    cy.navigateToLeaderboard('C002');
    cy.get('.leaderboard').should('be.visible');
  });

  it('should display students ranked by quiz scores', () => {
    cy.get('.leaderboard .quiz-rankings').should('be.sorted', { descending: true });
  });

  it('should display students ranked by assignment grades', () => {
    cy.get('.leaderboard .assignment-rankings').should('be.sorted', { descending: true });
  });

  it('should update leaderboard when new scores are added', () => {
    cy.addNewScore('student1', 95);
    cy.get('.leaderboard').should('contain', 'student1').and('be.sorted', { descending: true });
  });

  it('should prevent guest users from accessing the leaderboard', () => {
    cy.logout();
    cy.visit('/leaderboard');
    cy.get('.login-prompt').should('be.visible');
  });

  it('should not display duplicate student entries', () => {
    cy.get('.leaderboard .student-entry').each(($el, index, $list) => {
      expect($list).to.have.lengthOf(new Set($list.toArray()).size);
    });
  });

  it('should display ties correctly', () => {
    cy.get('.leaderboard .tie').should('have.length.greaterThan', 0);
  });

  it('should prevent unauthorized manipulation of rankings', () => {
    cy.attemptUnauthorizedChange();
    cy.get('.leaderboard').should('not.contain', 'unauthorized change');
  });

  it('should be accessible from different devices', () => {
    cy.viewport('iphone-6');
    cy.get('.leaderboard').should('be.visible');
    cy.viewport('ipad-2');
    cy.get('.leaderboard').should('be.visible');
  });

  it('should provide filtering options by student name or ID', () => {
    cy.get('.filter-input').type('student1');
    cy.get('.leaderboard').should('contain', 'student1');
  });

  it('should display message for courses with no students', () => {
    cy.visit('/leaderboard/C003');
    cy.get('.no-students-message').should('be.visible');
  });

  it('should be accessible for students with disabilities', () => {
    cy.get('.leaderboard').should('have.attr', 'aria-label');
  });

  it('should be exportable to a CSV file', () => {
    cy.get('.export-csv-button').click();
    cy.verifyDownload('leaderboard.csv');
  });

  it('should refresh automatically at a set interval', () => {
    cy.clock();
    cy.tick(30000); // 30 seconds
    cy.get('.leaderboard').should('be.updated');
  });
});