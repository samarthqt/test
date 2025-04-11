Given('the user is logged into their account', () => {
  cy.login();
});

Given('the user has completed a purchase', () => {
  cy.completePurchase();
});

Given('the user navigates to the "Order History" page', () => {
  cy.visitOrderHistory();
});

When('the user selects a completed purchase', () => {
  cy.selectCompletedPurchase();
});

When('the user clicks on "Leave a Review"', () => {
  cy.clickLeaveReview();
});

Then('the user should be presented with a review form', () => {
  cy.verifyReviewForm();
});

When('the user enters a rating between 1 and 5 stars', () => {
  cy.enterRating(5);
});

When('the user writes a comment in the feedback section', () => {
  cy.enterFeedback('Great product!');
});

When('the user submits the review', () => {
  cy.submitReview();
});

Then('the review should be saved and displayed under the product', () => {
  cy.verifyReviewSaved();
});

Given('the user has already submitted a review for a product', () => {
  cy.submitInitialReview();
});

When('the user navigates to the product page', () => {
  cy.visitProductPage();
});

When('the user clicks on "Edit Review"', () => {
  cy.clickEditReview();
});

Then('the user should be able to modify the rating and feedback', () => {
  cy.modifyReview();
});

When('the user submits the updated review', () => {
  cy.submitUpdatedReview();
});

Then('the updated review should replace the previous review', () => {
  cy.verifyUpdatedReview();
});

When('the user clicks on "Delete Review"', () => {
  cy.clickDeleteReview();
});

Then('the user should be prompted to confirm the deletion', () => {
  cy.verifyDeletePrompt();
});

When('the user confirms the deletion', () => {
  cy.confirmDeletion();
});

Then('the review should be removed from the product page', () => {
  cy.verifyReviewRemoved();
});

Given('the user is on a product page', () => {
  cy.visitProductPage();
});

When('the product has existing reviews', () => {
  cy.checkExistingReviews();
});

Then('the user should be able to see the average rating', () => {
  cy.verifyAverageRating();
});

Then('the user should be able to read individual reviews', () => {
  cy.verifyIndividualReviews();
});

Given('the user is browsing a product page', () => {
  cy.browseProductPage();
});

When('the user tries to leave a review without purchasing the product', () => {
  cy.attemptLeaveReviewWithoutPurchase();
});

Then('the user should be notified that only verified purchasers can leave reviews', () => {
  cy.verifyPurchaseNotification();
});