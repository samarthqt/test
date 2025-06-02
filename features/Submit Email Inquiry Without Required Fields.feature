Feature: Submit Email Inquiry Without Required Fields
@TC-101
Scenario: Attempt to submit an email inquiry without filling in the required fields
Given I am logged into the user account using valid credentials
And I navigate to the email inquiry form section of the application
When I attempt to submit the form without filling in the required fields
Then the system displays an error message indicating missing required fields
And the error message clearly specifies which fields are required
And form submission is blocked until required fields are completed
@TC-101
Scenario: Submit the form with only some required fields filled
Given I am on the email inquiry form
When I attempt to submit the form with only some required fields filled
Then the system displays an error for remaining missing fields
And the missing fields are highlighted for user attention
@TC-101
Scenario: Check system logs for form submission attempts
Given I have attempted to submit the form without required fields
Then no errors are logged in the system
And submission attempts are recorded as expected
@TC-101
Scenario: Submit the form with all required fields filled
Given I am on the email inquiry form
When I fill in all required fields
And I submit the form
Then the form submission is successful
@TC-101
Scenario: Submit the form using invalid data in required fields
Given I am on the email inquiry form
When I fill in the required fields with invalid data
And I submit the form
Then the system displays validation errors for invalid data
@TC-101
Scenario: Submit the form with optional fields left blank
Given I am on the email inquiry form
When I fill in all required fields and leave optional fields blank
And I submit the form
Then the form submission is successful
@TC-101
Scenario: Verify user notifications for successful inquiry submission
Given I have successfully submitted an inquiry
Then I receive a confirmation notification
@TC-101
Scenario: Submit multiple inquiries in quick succession
Given I am on the email inquiry form
When I submit multiple inquiries in quick succession
Then the system handles multiple submissions without errors
@TC-101
Scenario: Check system logs for incomplete form submission attempts
Given I have attempted to submit an incomplete form
Then user attempts are logged correctly in the system
@TC-101
Scenario: Verify system performance during form submission
Given I am on the email inquiry form
When I submit the form
Then the system performance is consistent regardless of submission attempts