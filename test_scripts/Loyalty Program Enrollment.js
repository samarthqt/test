describe('Loyalty Program Enrollment Test', () => {
  const username = 'Jane Doe';
  const email = 'jane.doe@example.com';
  let initialPoints = 0;

  before(() => {
    cy.visit('/login');
    cy.login(username, email);
  });

  it('should enroll in the loyalty program and verify initial points', () => {
    cy.visit('/loyalty');
    cy.get('button.enroll-now').click();
    cy.get('button.confirm-enrollment').click();
    cy.get('.points-balance').should('have.text', initialPoints.toString());
  });

  it('should earn points after making a purchase', () => {
    cy.makePurchase();
    cy.get('.points-balance').then(($balance) => {
      const updatedPoints = parseInt($balance.text());
      expect(updatedPoints).to.be.greaterThan(initialPoints);
      initialPoints = updatedPoints;
    });
  });

  it('should verify rewards and redeem a reward', () => {
    cy.get('.rewards-list').should('exist');
    cy.redeemReward();
    cy.get('.points-balance').should('be.lessThan', initialPoints);
  });

  it('should verify redeemed rewards are listed', () => {
    cy.get('.redeemed-rewards').should('contain', 'Reward Name');
  });

  it('should persist loyalty program enrollment after logout', () => {
    cy.logout();
    cy.login(username, email);
    cy.visit('/loyalty');
    cy.get('.enrollment-status').should('contain', 'Enrolled');
  });

  it('should not allow re-enrollment in the loyalty program', () => {
    cy.get('button.enroll-now').should('not.exist');
  });

  it('should verify loyalty program details on mobile', () => {
    cy.viewport('iphone-6');
    cy.visit('/loyalty');
    cy.get('.loyalty-details').should('be.visible');
  });

  it('should function correctly under different network conditions', () => {
    cy.testNetworkConditions();
  });

  it('should receive an email confirmation upon enrollment', () => {
    cy.checkEmailConfirmation();
  });
});