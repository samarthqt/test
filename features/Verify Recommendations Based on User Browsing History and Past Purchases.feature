Feature: Verify Recommendations Based on User Browsing History and Past Purchases
@TC-41
Scenario: Verify personalized recommendations are displayed on the homepage
Given a user account with browsing history of Electronics and Books
And a purchase history of Smartphone and Fiction Novel
When the user logs into the application
And navigates to the homepage
Then the homepage should display personalized recommendations including electronics and books related items
@TC-41
Scenario: Verify recommendations on product page based on browsing history
Given the user is on the homepage
When the user navigates to the product page of a recently browsed category
Then the product page should display related recommendations based on browsing history
@TC-41
Scenario: Verify recommendations related to past purchases
Given the user is on the homepage
When the user checks the recommendations section
Then recommendations should include accessories for the smartphone and similar genre novels
@TC-41
Scenario: Update recommendations after adding a new item to browsing history
Given the user is on the homepage
When the user adds a camera to the browsing history
And refreshes the homepage recommendations
Then recommendations should update to include camera-related products
@TC-41
Scenario: Verify recommendations after a new purchase
Given the user has purchased a camera lens
When the user checks the recommendations section
Then recommendations should include accessories for the camera lens
@TC-41
Scenario: Verify consistency of recommendations after re-login
Given the user logs out and logs back into the application
Then the user should see consistent recommendations with updated browsing and purchase history
@TC-41
Scenario: Verify recommendations on other sections of the application
Given the user is logged in
When the user checks recommendations on the deals page
Then recommendations should align with user history across different sections
@TC-41
Scenario: Verify recommendations after clearing browsing history
Given the user clears their browsing history
When the user checks the recommendations section
Then recommendations should adjust to focus more on purchase history
@TC-41
Scenario: Verify recommendations after deleting a past purchase
Given the user deletes a past purchase from the history
When the user checks the recommendations section
Then recommendations should adjust, removing items related to the deleted purchase
@TC-41
Scenario: Verify recommendations for different user profiles
Given different user profiles with unique browsing and purchase histories
When the user logs into each profile
Then recommendations should be personalized and accurate for each user profile