Feature: Verify Product Ratings and Reviews Submission
@TC-151
Scenario: Verify that customers can submit ratings and reviews for purchased products
Given a customer account with purchased products
When the customer logs in to the account
Then the customer account login is successful
@TC-151
Scenario: Navigate to the order history page
Given the customer is logged in
When the customer navigates to the order history page
Then the order history page displays all purchased products
@TC-151
Scenario: Select a purchased product to review
Given the order history page is displayed
When the customer selects a purchased product to review
Then the product details page opens successfully
@TC-151
Scenario: Locate the ratings and reviews section
Given the product details page is open
When the customer locates the ratings and reviews section
Then the ratings and reviews section is visible
@TC-151
Scenario: Submit a rating
Given the ratings and reviews section is visible
When the customer submits a rating by selecting the desired number of stars
Then the rating submission is successful
@TC-151
Scenario: Enter and submit a review text
Given the ratings and reviews section is visible
When the customer enters a review text in the provided field
And submits the review
Then the review submission is successful
@TC-151
Scenario: Verify submitted rating and review display
Given the customer has submitted a rating and review
When viewing the product page
Then the submitted rating and review are visible on the product page
@TC-151
Scenario: Edit or delete a review
Given the customer has submitted a review
When the customer attempts to edit or delete the review
Then the review can be edited or deleted by the customer
@TC-151
Scenario: Prevent duplicate reviews
Given the customer has submitted a review
When the customer attempts to submit a duplicate review
Then the system prevents submission of duplicate reviews
@TC-151
Scenario: Handle inappropriate language in reviews
Given the customer is submitting a review
When the review contains inappropriate language
Then the system flags or rejects reviews with inappropriate language
@TC-151
Scenario: Verify correct timestamps on reviews
Given the customer has submitted a review
When viewing the review
Then the review displays correct timestamps
@TC-151
Scenario: Notification for review submissions
Given the customer has submitted a review
When the review submission is successful
Then the system sends notifications for successful review submissions
@TC-151
Scenario: Visibility of submitted reviews to other users
Given the customer has submitted a review
When other users view the product page
Then the submitted reviews are visible to other users
@TC-151
Scenario: Test moderation tools for managing reviews
Given reviews have been submitted
When using the system's moderation tools
Then moderation tools allow management of submitted reviews