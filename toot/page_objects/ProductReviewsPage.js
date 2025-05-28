import { expect } from 'chai'; 
import { should } from 'chai'; 
import { cy } from 'cypress'; 

class ProductReviewsPage { 
  static visit() { 
    cy.visit('/product-page'); 
  } 
  
  static ensureUserIsLoggedIn() { 
    // Logic to ensure the user is logged in 
  } 
  
  static ensureUserIsNotLoggedIn() { 
    // Logic to ensure the user is not logged in 
  } 
  
  static goToReviewsSection() { 
    cy.get('#reviews-section').scrollIntoView(); 
  } 
  
  static clickWriteReview() { 
    cy.get('#write-review-btn').click(); 
  } 
  
  static enterReviewTitle(title) { 
    cy.get('#review-title').type(title); 
  } 
  
  static enterReviewDescription(description) { 
    cy.get('#review-description').type(description); 
  } 
  
  static selectRating(stars) { 
    cy.get(`.star-rating input[value=${stars}]`).check(); 
  } 
  
  static submitReview() { 
    cy.get('#submit-review-btn').click(); 
  } 
  
  static attemptToWriteReview() { 
    cy.get('#write-review-btn').click(); 
  } 
  
  static verifyReviewSubmissionSuccess() { 
    cy.get('.success-message').should('be.visible'); 
  } 
  
  static verifyReviewVisible(reviewText) { 
    cy.get('.review-list').should('contain', reviewText); 
  } 
  
  static verifyListOfReviewsVisible() { 
    cy.get('.review-list').should('be.visible'); 
  } 
  
  static verifyReviewDetailsVisible() { 
    cy.get('.review-list .review-item').each(($el) => { 
      cy.wrap($el).should('contain', 'Reviewer Name'); 
      cy.wrap($el).should('contain', 'Review Title'); 
      cy.wrap($el).should('contain', 'Review Description'); 
      cy.wrap($el).should('contain', 'Rating'); 
      cy.wrap($el).should('contain', 'Date of Submission'); 
    }); 
  } 
  
  static verifyLoginOrRegisterPrompt() { 
    cy.get('.login-register-prompt').should('be.visible'); 
  } 
  
  static verifyReviewDescriptionError() { 
    cy.get('.error-message').should('contain', 'Review description is required'); 
  } 
  
  static verifyReviewTitleError() { 
    cy.get('.error-message').should('contain', 'Review title is required'); 
  } 
  
  static checkForDuplicateReviews() { 
    cy.get('.review-list .review-item').then(($items) => { 
      const reviewTitles = []; 
      $items.each((index, item) => { 
        const title = cy.wrap(item).find('.review-title').text(); 
        reviewTitles.push(title); 
      }); 
      expect(new Set(reviewTitles).size).to.equal(reviewTitles.length); 
    }); 
  } 
} 

export default ProductReviewsPage;