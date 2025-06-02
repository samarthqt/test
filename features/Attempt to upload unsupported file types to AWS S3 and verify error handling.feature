Feature: Attempt to upload unsupported file types to AWS S3 and verify error handling
@TC-316
Scenario: Log in to AWS S3 and navigate to the specified bucket
Given I have an AWS S3 account configured
When I log in to the AWS S3 account
And I navigate to the bucket named "example-bucket"
Then I should be successfully logged in and navigated to the "example-bucket"
@TC-316
Scenario: Attempt to upload an unsupported file type to AWS S3
Given I am in the "example-bucket" on AWS S3
When I attempt to upload the unsupported file type "test_file.exe"
Then the upload attempt should fail
And I should see an error message 'Unsupported file type'
@TC-316
Scenario: Check AWS S3 logs for entries related to the failed upload attempt
Given an upload attempt of "test_file.exe" has failed
When I check the AWS S3 logs
Then the logs should contain entries for the failed upload attempt
And the expected error message should be 'Unsupported file type'
@TC-316
Scenario: Verify access permissions for the AWS S3 bucket
Given I am in the "example-bucket" on AWS S3
When I verify the access permissions
Then the access permissions should be correctly configured to prevent unsupported file uploads
@TC-316
Scenario: Test upload attempts using different unsupported file types
Given I am in the "example-bucket" on AWS S3
When I attempt to upload unsupported file types "bat", "dll", and "sys"
Then each upload attempt should fail with an appropriate error message
@TC-316
Scenario: Simulate network latency during upload attempts
Given I am in the "example-bucket" on AWS S3
When I simulate network latency during the upload attempts
Then the upload attempts should remain unsuccessful under network latency
@TC-316
Scenario: Evaluate user experience for unsupported file type errors
Given I encounter unsupported file type errors
When I evaluate the user experience
Then the feedback should indicate clear communication of unsupported file type errors
@TC-316
Scenario: Assess the application's documentation regarding unsupported file type handling
Given I have access to the application's documentation
When I assess the documentation regarding unsupported file type handling
Then the documentation should provide clear guidelines on handling unsupported file type errors
@TC-316
Scenario: Check for automated alerts triggered by unsupported file type errors
Given unsupported file type errors occur
When I check for automated alerts
Then automated alerts should be sent to the support team
@TC-316
Scenario: Verify the application's retry mechanism for unsupported file type errors
Given unsupported file type errors occur
When I verify the application's retry mechanism
Then the application should not retry unsupported file type uploads
@TC-316
Scenario: Test application behavior with different AWS regions
Given I use different AWS regions for unsupported file type uploads
When I test the application behavior
Then the application should display consistent error handling across AWS regions
@TC-316
Scenario: Attempt to upload a large unsupported file type
Given I am in the "example-bucket" on AWS S3
When I attempt to upload a large unsupported file type
Then the upload attempt should fail with an appropriate error message
@TC-316
Scenario: Check browser console for unsupported file type-related errors
Given I encounter unsupported file type-related errors
When I check the browser console
Then the console should display unsupported file type errors
@TC-316
Scenario: Test application behavior with different browser versions
Given I use different browser versions for unsupported file type uploads
When I test the application behavior
Then the application should display consistent error handling across browser versions
@TC-316
Scenario: Verify the application's security measures for preventing unsupported file type uploads
Given I am in the "example-bucket" on AWS S3
When I verify the application's security measures
Then the security measures should effectively prevent unsupported file type uploads