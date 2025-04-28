Feature: Simulate Resource Exhaustion During Sign-In
Scenario: Check error message delivery when simulating resource exhaustion during sign-in
Given the user has access to the sign-in page
And tools to simulate resource exhaustion are available
When the user navigates to the sign-in page
Then the sign-in page is displayed
When the user enters "validuser@example.com" in the email field
Then the email is entered in the field
When the user enters "ValidPassword123" in the password field
Then the password is entered in the field
When the user simulates resource exhaustion on the server
Then resources are exhausted successfully
When the user clicks on the "Sign In" button
Then the system processes the request under resource constraints
When the user observes the error message displayed
Then an error message indicating server resource exhaustion is displayed
When the user verifies that the error message is aligned with server handling standards
Then the error message is clear, concise, and meets server handling standards
When the user checks if the system recovers gracefully from resource exhaustion
Then the system recovers gracefully without any data loss
When the user verifies that the sign-in button is disabled after the error message
Then the sign-in button is disabled
When the user checks if the error message is logged in the system
Then the error message is logged in the system for auditing
When the user attempts to sign in again after resource recovery
Then the system allows sign-in after resources are restored
When the user verifies if the error message disappears after resource recovery
Then the error message disappears after resource recovery
When the user checks if the email field retains the entered email after the error
Then the email field retains the entered email
When the user tries simulating resource exhaustion with different parameters and observes
Then the system displays an appropriate error message for various exhaustion scenarios
When the user verifies system behavior when switching to another page and returning to sign-in
Then the error message remains consistent upon returning