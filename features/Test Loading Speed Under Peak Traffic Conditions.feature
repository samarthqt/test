Feature: Test Loading Speed Under Peak Traffic Conditions
@TC-233
Scenario: Verify application loading speed under peak traffic conditions
Given access to the traffic simulation tool
When I set the user count to 10,000
And configure server load to 80%
And open the application on the test device
And attempt to load the homepage of the application
Then measure the time taken for the application to load the homepage
And verify if the application loads within 3 seconds
And observe any error messages or loading indicators displayed
And check the application's responsiveness during loading
And log the results of the traffic simulation and application load time
And reset traffic conditions to normal
@TC-233
Scenario Outline: Repeat test with different traffic conditions
Given access to the traffic simulation tool
When I set the user count to <user_count>
And configure server load to 80%
And open the application on the test device
And attempt to load the homepage of the application
Then measure the time taken for the application to load the homepage
And verify if the application loads within 3 seconds
And observe any error messages or loading indicators displayed
And check the application's responsiveness during loading
And log the results of the traffic simulation and application load time
And reset traffic conditions to normal
And analyze the impact of each traffic condition on application load time
And document any discrepancies or issues found during testing
And provide recommendations for maintaining application load speed under peak traffic conditions
And ensure the application performs optimally under simulated peak traffic conditions
Examples:
| user_count |
| 5,000      |
| 15,000     |