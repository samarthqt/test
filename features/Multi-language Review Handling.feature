Feature: Multi-language Review Handling
@TC-154
Scenario: Submit a review in Spanish
Given the system supports multiple languages
When a review is submitted in Spanish with content 'Producto excelente!'
Then the review is accepted and displayed correctly in Spanish
@TC-154
Scenario: Submit a review in French
Given the system supports multiple languages
When a review is submitted in French with content 'Produit exceptionnel!'
Then the review is accepted and displayed correctly in French
@TC-154
Scenario: Submit a review in Italian
Given the system supports multiple languages
When a review is submitted in Italian with content 'Ottimo prodotto!'
Then the review is accepted and displayed correctly in Italian
@TC-154
Scenario: Navigate to the admin dashboard and access reviews
Given admin credentials are 'admin_user' and 'secure_password'
When the admin navigates to the dashboard
Then reviews are listed with language indicators
@TC-154
Scenario: Approve a review submitted in Spanish
Given the admin is on the review moderation page
When the admin approves a review submitted in Spanish
Then the review status changes to 'Approved' and is visible to users
@TC-154
Scenario: Edit a review submitted in French to correct grammar
Given the admin is on the review moderation page
When the admin edits a review submitted in French
Then the review content is updated successfully
@TC-154
Scenario: Delete a review submitted in Italian
Given the admin is on the review moderation page
When the admin deletes a review submitted in Italian
Then the review is removed from the system and no longer visible
@TC-154
Scenario: Detect inappropriate content in multiple languages
Given the system supports multiple languages
When a review with inappropriate content is submitted
Then the system flags inappropriate content regardless of language
@TC-154
Scenario: Process simultaneous reviews in different languages
Given the system supports multiple languages
When reviews are submitted simultaneously in different languages
Then the system processes and displays reviews without errors
@TC-154
Scenario: Log out from the admin account
Given the admin is logged in
When the admin logs out
Then the admin is redirected to the login page
@TC-154
Scenario: Log back into the admin account and navigate to multilingual reviews
Given the admin is on the login page
When the admin logs back in
Then the admin can access multilingual reviews with updated list
@TC-154
Scenario: Submit a review in an unsupported language
Given the system supports multiple languages
When a review is submitted in an unsupported language
Then the system displays an error message indicating unsupported language
@TC-154
Scenario: Check system response to mixed-language reviews
Given the system supports multiple languages
When a mixed-language review is submitted
Then the system processes mixed-language reviews correctly
@TC-154
Scenario: Display language-specific characters correctly
Given the system supports multiple languages
When a review with language-specific characters is submitted
Then all characters are displayed correctly without encoding issues
@TC-154
Scenario: Filter reviews by language
Given the admin is on the review moderation page
When the admin filters reviews by language
Then the admin can view reviews based on language selection