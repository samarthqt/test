Feature: Simulate Poor Network Conditions and Verify Application Load Time
@TC-232
Scenario: Simulate 2G network conditions and verify application load time
Given access to the network simulation tool
When I set the network speed to 2G
And I configure network latency to 500ms
And I set packet loss to 10%
And I open the application on the test device
And I attempt to load the homepage of the application
Then I measure the time taken for the application to load the homepage
And I verify if the application does not load within 3 seconds
And I observe any error messages or loading indicators displayed
And I check the application's responsiveness during loading
And I log the results of the network simulation and application load time
And I reset network conditions to normal
@TC-232
Scenario Outline: Repeat test with different network conditions
Given access to the network simulation tool
When I set the network speed to <network_speed>
And I configure network latency to <network_latency>
And I set packet loss to <packet_loss>
And I open the application on the test device
And I attempt to load the homepage of the application
Then I measure the time taken for the application to load the homepage
And I verify if the application does not load within 3 seconds
And I observe any error messages or loading indicators displayed
And I check the application's responsiveness during loading
And I log the results of the network simulation and application load time
And I reset network conditions to normal
And I analyze the impact of each network condition on application load time
And I document any discrepancies or issues found during testing
And I provide recommendations for improving application load time under poor network conditions
Examples:
| network_speed | network_latency | packet_loss |
| 3G            | 300ms           | 5%          |
| 4G            | 100ms           | 1%          |