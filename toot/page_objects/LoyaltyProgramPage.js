import { should } from 'chai'; 
class LoyaltyProgramPage { 
  static ensureLoggedIn() { 
    cy.get('#account-status').should('contain', 'Logged In'); 
  } 
  
  static visitUserAccountPage() { 
    cy.visit('/user-account'); 
  } 
  
  static joinLoyaltyProgram() { 
    cy.get('#join-loyalty-program').click(); 
  } 
  
  static verifyEnrollmentSuccess() { 
    cy.get('#enrollment-status').should('contain', 'Enrolled'); 
  } 
  
  static verifyConfirmationMessage() { 
    cy.get('#confirmation-message').should('be.visible').and('contain', 'Successfully enrolled'); 
  } 
  
  static ensureEnrolledInLoyaltyProgram() { 
    cy.get('#loyalty-status').should('contain', 'Enrolled'); 
  } 
  
  static makePurchase() { 
    cy.get('#make-purchase').click(); 
  } 
  
  static verifyPointsEarned() { 
    cy.get('#points-earned').should('be.visible').and('contain', 'Points Earned'); 
  } 
  
  static verifyPointsInAccount() { 
    cy.get('#points-balance').should('contain', 'Updated Balance'); 
  } 
  
  static ensurePointsAccumulated() { 
    cy.get('#points-balance').should('be.greaterThan', 0); 
  } 
  
  static redeemPointsForDiscount() { 
    cy.get('#redeem-points').click(); 
  } 
  
  static verifyDiscountApplied() { 
    cy.get('#discount-status').should('contain', 'Discount Applied'); 
  } 
  
  static verifyPointsDeducted() { 
    cy.get('#points-balance').should('contain', 'Deducted'); 
  } 
  
  static navigateToLoyaltySection() { 
    cy.get('#loyalty-section').click(); 
  } 
  
  static verifyPointsBalance() { 
    cy.get('#current-points-balance').should('be.visible'); 
  } 
  
  static checkNewRewardsOrDiscounts() { 
    cy.get('#new-rewards').should('exist'); 
  } 
  
  static verifyNotificationReceived() { 
    cy.get('#notification').should('contain', 'New Offers Available'); 
  } 
  
  static leaveLoyaltyProgram() { 
    cy.get('#leave-loyalty-program').click(); 
  } 
  
  static verifyUnenrollmentSuccess() { 
    cy.get('#unenrollment-status').should('contain', 'Not Enrolled'); 
  } 
  
  static verifyUnenrollmentConfirmationMessage() { 
    cy.get('#confirmation-message').should('be.visible').and('contain', 'Successfully unenrolled'); 
  } 
} 

export default LoyaltyProgramPage;