Feature: Product Reviews
""
As a user, I want to be able to submit and view product reviews so that I can share my opinions and read others' feedback on products.
""
Background:
Given the user is on the product page
""
Scenario: Submit a product review
Given the user is logged in
When the user navigates to the product reviews section
"    And the user clicks on ""Write a Review"""
"    And the user enters a review title ""Great Product"""
"    And the user enters a review description ""I really enjoyed using this product. Highly recommend!"""
And the user selects a rating of 5 stars
And the user submits the review
Then the review should be successfully submitted
And the review should be visible under the product reviews section
""
Scenario: View product reviews
Given the user is on the product page
When the user navigates to the product reviews section
Then the user should see a list of reviews for the product
And each review should display the reviewer's name, review title, review description, rating, and date of submission
""
Scenario: Submit a product review without logging in
Given the user is not logged in
When the user navigates to the product reviews section
And the user attempts to write a review
Then the user should be prompted to log in or register
""
Scenario: Submit a product review with missing information
Given the user is logged in
When the user navigates to the product reviews section
"    And the user clicks on ""Write a Review"""
"    And the user enters a review title ""Incomplete Review"""
And the user leaves the review description empty
And the user selects a rating of 3 stars
And the user submits the review
Then the user should see an error message indicating that the review description is required
```
```gherkin
TCID:18