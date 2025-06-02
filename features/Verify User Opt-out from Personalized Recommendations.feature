Feature: Verify User Opt-out from Personalized Recommendations
@TC-49
Scenario: User logs in and navigates to opt-out of personalized recommendations
Given a user account with personalized recommendations enabled
When the user logs in to the account
Then the user is directed to the dashboard
@TC-49
Scenario: Access account settings to opt-out
Given the user is on the dashboard
When the user navigates to the account settings page
Then the user is able to access the account settings page
@TC-49
Scenario: Locate and select opt-out option
Given the user is on the account settings page
When the user locates the personalized recommendation settings
Then settings for personalized recommendations are visible
And the user selects the option to opt out of personalized recommendations
Then the option to opt out is selectable
@TC-49
Scenario: Save changes to opt-out settings
Given the user has selected the opt-out option
When the user saves the changes to the settings
Then changes are saved successfully with a confirmation message
@TC-49
Scenario: Verify changes after logging back in
Given the user has saved the opt-out changes
When the user logs out and logs back in
Then changes persist after logging back in
@TC-49
Scenario: Attempt to access personalized recommendations post opt-out
Given the user has opted out of personalized recommendations
When the user attempts to access personalized recommendations
Then personalized recommendations are no longer displayed
@TC-49
Scenario: Check notifications regarding opt-out
Given the user has opted out of personalized recommendations
When the user checks for notifications regarding the opt-out
Then notification confirms successful opt-out
@TC-49
Scenario: Review privacy policy for opt-out information
Given the user wants to understand opt-out procedures
When the user reviews the privacy policy for opt-out information
Then privacy policy outlines opt-out procedures clearly
@TC-49
Scenario: Re-enable personalized recommendations
Given the user has opted out of personalized recommendations
When the user wants to re-enable personalized recommendations
Then the user can re-enable recommendations at any time
@TC-49
Scenario: Test opt-out feature on different devices
Given the user has opted out of personalized recommendations
When the user tests the opt-out feature on different devices
Then the opt-out feature works consistently across devices
@TC-49
Scenario: Check system logs for opt-out actions
Given the user has opted out of personalized recommendations
When the user checks the system logs for opt-out actions
Then logs accurately reflect the opt-out action
@TC-49
Scenario: Verify no residual personalized data post opt-out
Given the user has opted out of personalized recommendations
When the user checks for residual personalized data post opt-out
Then no personalized data is used or displayed
@TC-49
Scenario: Test user experience post opt-out
Given the user has opted out of personalized recommendations
When the user experiences the system post opt-out
Then user experience remains unaffected aside from recommendation changes
@TC-49
Scenario: Assess system performance after multiple opt-outs
Given multiple users have opted out of personalized recommendations
When the system performance is assessed
Then system performance remains stable regardless of opt-out volume