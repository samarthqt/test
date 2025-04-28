Feature: Verify Real-Time Profanity Filter Updates
Scenario: Ensure profanity filter updates are reflected in real-time across all pages
Given I have access to the sign-up and profile update pages
And I am logged in as an administrator
When I navigate to the admin panel for profanity filter updates
Then the admin panel is accessible
When I add a new profane word "ProfaneWord" to the filter list
Then the word is added to the profanity filter
When I navigate to the sign-up page
Then the sign-up page is displayed
When I enter "ProfaneWord" in the First Name field
Then an error message is displayed for the profane word
When I remove the profane word from the filter list in the admin panel
Then the word is removed from the profanity filter
When I refresh the sign-up page
Then the sign-up page is refreshed
When I enter "ProfaneWord" in the First Name field again
Then the First Name field accepts input without errors
When I complete the sign-up process
Then account creation is confirmed, and the user is redirected to the welcome page
When I navigate to the profile update page
Then the profile update page is displayed
When I attempt to update the First Name to "ProfaneWord"
Then an error message is displayed if the word is still in the filter
When I remove the word from the filter in real-time
Then the word is removed from the filter
When I refresh the profile update page
Then the profile update page is refreshed
When I update the First Name to "ProfaneWord"
Then the First Name field accepts input without errors
When I save the profile changes
Then the profile is updated successfully
Then I verify that the profanity filter updates are reflected in real-time across all pages
And profanity filter updates are consistent across all pages