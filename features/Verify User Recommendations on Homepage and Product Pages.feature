Feature: Verify User Recommendations on Homepage and Product Pages
@TC-43
Scenario: Verify user can view recommendations on the homepage
Given a user account with browsing and purchase history
When the user logs into the application
Then the user is successfully logged in
And the homepage is displayed with personalized recommendations including electronics and fashion items
@TC-43
Scenario: Verify recommendations on electronics product page
Given the user is on the homepage
When the user navigates to a product page of an electronics item
Then the product page displays related accessories recommendations
And the recommendations are relevant to the electronics item
@TC-43
Scenario: Verify recommendations on fashion product page
Given the user is on the homepage
When the user navigates to a product page of a fashion item
Then the product page displays related fashion accessories recommendations
And the recommendations are relevant to the fashion item
@TC-43
Scenario: Add item from recommendations to cart
Given the user is on a product page with recommendations
When the user adds an item from the recommendations to the cart
Then the item is successfully added to the cart
@TC-43
Scenario: Verify updated recommendations after adding item to cart
Given the user has added an item to the cart
When the user checks the recommendations
Then the recommendations adjust to include complementary items
@TC-43
Scenario: Verify recommendations consistency after re-login
Given the user logs out of the application
When the user logs back into the application
Then the user is successfully logged in with updated recommendations
And the recommendations remain consistent with browsing and purchase behavior
@TC-43
Scenario: Verify recommendations on other sections of the application
Given the user is logged into the application
When the user checks recommendations on other sections of the application (e.g., deals page)
Then the recommendations align with user history across different sections
@TC-43
Scenario: Verify recommendations after clearing browsing history
Given the user clears browsing history
When the user checks recommendations
Then the recommendations adjust to focus more on purchase history
@TC-43
Scenario: Verify recommendations after deleting a past purchase
Given the user deletes a past purchase from the history
When the user checks recommendations
Then the recommendations adjust, removing items related to the deleted purchase
@TC-43
Scenario: Verify recommendations for different user profiles
Given different user profiles with browsing and purchase history
When the recommendation verification process is repeated for each user profile
Then the recommendations are personalized and accurate for each user profile