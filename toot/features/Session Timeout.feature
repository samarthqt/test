Feature: Session Timeout
""
Scenario: Automatically log users out after a period of inactivity
Given a user is logged into their account
When the user remains inactive for a specified period
Then the user should be automatically logged out
""
Scenario: User receives a warning before session timeout
Given a user is logged into their account
And the user is inactive
When the session is about to timeout
Then the user should receive a warning notification
""
Scenario: User remains logged in with activity
Given a user is logged into their account
When the user performs any activity within the session
Then the session timeout should be reset
""
Scenario: User is redirected to login page after timeout
Given a user is logged into their account
And the user is inactive for a specified period
When the session times out
Then the user should be redirected to the login page
""
Scenario: User session timeout configuration is adjustable
Given a system administrator accesses the session settings
When the administrator adjusts the session timeout duration
Then the new session timeout duration should be applied to all user accounts
""
Scenario: User session timeout does not affect other sessions
Given a user is logged into their account on multiple devices
And the user is inactive on one device
When the session times out on that device
Then the user should remain logged in on the other devices
```
```gherkin
TCID:35