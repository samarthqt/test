Feature: Performance Testing with 11,000 Concurrent Users
@TC-235
Scenario: Test the system with 11,000 concurrent users and verify performance metrics
Given access to the application under test
When I access the user simulation tool
And I set the concurrent user count to 11,000
Then the concurrent user count is set to 11,000
And monitor server CPU usage during the test
Then server CPU usage is monitored
And server CPU usage is 85%
When I open the application on the test device
Then the application is opened
When I attempt to perform various operations such as login, navigation, and data retrieval
Then operations are attempted
And measure the response time for each operation
Then response time is measured
And verify if performance metrics exceed acceptable limits
Then performance metrics exceed acceptable limits
And observe any error messages or performance issues
Then error messages or performance issues are observed
And check the application's responsiveness during the test
Then application is unresponsive during the test
And log the results of the user simulation and application performance
Then results are logged
When I reset user simulation conditions to normal
Then user simulation conditions are reset
And repeat the test with different user counts (e.g., 9,000 users, 13,000 users)
Then test is repeated with different user counts
And analyze the impact of each user count on application performance
Then impact analysis is completed
And document any discrepancies or issues found during testing
Then discrepancies or issues are documented
And provide recommendations for improving application performance under high user load
Then recommendations are provided
And ensure the application performs optimally despite exceeding acceptable limits
Then application performance is suboptimal