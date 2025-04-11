Feature: Product Review System
Scenario: Customers rate products using a star system
Given a customer is logged into the system
When the customer views a product page
Then the customer should see an option to rate the product using a star system
Scenario: Customers leave text reviews for products
Given a customer is logged into the system
When the customer views a product page
Then the customer should see an option to leave a text review for the product
Scenario: Admins moderate reviews by approving them
Given an admin is logged into the system
When the admin views the list of pending reviews
And the admin approves a review
Then the review should be marked as approved and visible on the product page
Scenario: Admins moderate reviews by deleting them
Given an admin is logged into the system
When the admin views the list of pending reviews
And the admin deletes a review
Then the review should be removed from the system and not visible on the product page
Scenario: Notifications inform customers of review submissions
Given a customer submits a review for a product
Then the customer should receive a notification confirming the submission
Scenario: Reviews are displayed on product pages
Given a product has customer reviews
When a user views the product page
Then the user should see all approved reviews displayed on the product page
Scenario: Input validation ensures correct data format for reviews
Given a customer is submitting a review
When the review data is in an incorrect format
Then the system should display an error message indicating the format issue
Scenario: Error messages are displayed for invalid review submissions
Given a customer is submitting a review
When the review submission is invalid
Then the system should display an error message explaining the reason for invalid submission
Scenario: Logging tracks review submissions and moderation actions
Given a customer submits a review or an admin moderates a review
Then the system should log the action with relevant details for auditing purposes