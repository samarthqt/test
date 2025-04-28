Feature: Verify Sign-In with Deactivated Phone Number
Scenario: User attempts to sign-in with a deactivated phone number
Given User's phone number is deactivated in IDP
When User navigates to the sign-in page
Then User is presented with the sign-in page
Scenario: Enter registered email and password
Given User is on the sign-in page
When User enters registered email and password
Then System validates email and password
Scenario: Click on 'Sign In' button
Given User has entered valid credentials
When User clicks on 'Sign In' button
Then System attempts to send OTP
Scenario: Verify system response for deactivated phone number
Given System attempts to send OTP
When Phone number is deactivated
Then System displays error message indicating phone number is deactivated
Scenario: Check for alternative authentication methods
Given Phone number is deactivated
When User attempts to sign-in
Then System suggests alternative authentication methods
Scenario: Attempt to resend OTP
Given Phone number is deactivated
When User attempts to resend OTP
Then System displays consistent error message for failed OTP resend
Scenario: Check system logs for deactivated phone number error
Given Phone number is deactivated
When System logs are checked
Then Logs reflect deactivation error
Scenario: Verify user notification for deactivated phone number
Given Phone number is deactivated
When System sends notification
Then User receives notification about phone number deactivation
Scenario: Test system's fallback mechanism for authentication
Given Phone number is deactivated
When User attempts alternative authentication
Then Fallback mechanism is activated successfully
Scenario: Check system's recovery process post-phone number reactivation
Given Phone number is reactivated
When User attempts to sign-in
Then System resumes normal OTP dispatch post-reactivation
Scenario: Simulate temporary phone number reactivation and test behavior
Given Phone number is temporarily reactivated
When User attempts to sign-in
Then System handles temporary reactivation gracefully
Scenario: Verify system's response time during phone number deactivation
Given Phone number is deactivated
When User attempts to sign-in
Then Response time aligns with expected standards during deactivation
Scenario: Attempt sign-in with incorrect OTP during deactivation
Given Phone number is deactivated
When User enters incorrect OTP
Then System consistently prompts error for incorrect OTP
Scenario: Check user experience feedback for deactivated phone number
Given Phone number is deactivated
When User provides feedback
Then User feedback is captured for service improvement
Scenario: Verify system's ability to handle peak sign-in attempts during deactivation
Given Phone number is deactivated
When Multiple users attempt to sign-in
Then System manages peak attempts without crashing