Feature: User Reviews
""
As a user of the e-commerce platform,
I want to be able to leave reviews and feedback on my purchase experience,
So that I can share my opinions and help other customers make informed decisions.
""
Background:
Given the user is logged into their account
And the user has completed a purchase
""
Scenario: Leave a review for a completed purchase
"    Given the user navigates to the ""Order History"" page"
When the user selects a completed purchase
"    And the user clicks on ""Leave a Review"""
Then the user should be presented with a review form
When the user enters a rating between 1 and 5 stars
And the user writes a comment in the feedback section
And the user submits the review
Then the review should be saved and displayed under the product
""
Scenario: Edit an existing review
Given the user has already submitted a review for a product
When the user navigates to the product page
"    And the user clicks on ""Edit Review"""
Then the user should be able to modify the rating and feedback
When the user submits the updated review
Then the updated review should replace the previous review
""
Scenario: Delete a review
Given the user has already submitted a review for a product
When the user navigates to the product page
"    And the user clicks on ""Delete Review"""
Then the user should be prompted to confirm the deletion
When the user confirms the deletion
Then the review should be removed from the product page
""
Scenario: View reviews for a product
Given the user is on a product page
When the product has existing reviews
Then the user should be able to see the average rating
And the user should be able to read individual reviews
""
Scenario: Attempt to leave a review without completing a purchase
Given the user is browsing a product page
When the user tries to leave a review without purchasing the product
Then the user should be notified that only verified purchasers can leave reviews
```