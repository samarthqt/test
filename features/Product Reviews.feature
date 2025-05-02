Feature: Product Reviews
Scenario: Submit a product review
Given a user is logged in
When the user navigates to a product page
And the user clicks on "Write a Review"
And the user enters a review title and description
And the user selects a rating for the product
And the user submits the review
Then the review should be saved and displayed on the product page
Scenario: View product reviews
Given a user is on a product page
When the user scrolls to the reviews section
Then the user should see a list of reviews for the product
And each review should display the reviewer's name, rating, title, and description
Scenario: Validate review submission without login
Given a user is not logged in
When the user navigates to a product page
And the user attempts to submit a review
Then the user should be prompted to log in or register
Scenario: Validate review submission without rating
Given a user is logged in
When the user navigates to a product page
And the user clicks on "Write a Review"
And the user enters a review title and description
And the user submits the review without selecting a rating
Then the user should see an error message indicating that a rating is required
Scenario: Validate review submission without title
Given a user is logged in
When the user navigates to a product page
And the user clicks on "Write a Review"
And the user enters a description and selects a rating
And the user submits the review without entering a title
Then the user should see an error message indicating that a title is required
Scenario: Validate review submission without description
Given a user is logged in
When the user navigates to a product page
And the user clicks on "Write a Review"
And the user enters a title and selects a rating
And the user submits the review without entering a description
Then the user should see an error message indicating that a description is required
Scenario: Edit a submitted review
Given a user is logged in
And the user has previously submitted a review
When the user navigates to the product page
And the user clicks on "Edit Review"
And the user updates the review title, description, or rating
And the user submits the changes
Then the updated review should be saved and displayed on the product page
Scenario: Delete a submitted review
Given a user is logged in
And the user has previously submitted a review
When the user navigates to the product page
And the user clicks on "Delete Review"
Then the review should be removed from the product page