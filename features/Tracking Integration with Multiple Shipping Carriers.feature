Feature: Tracking Integration with Multiple Shipping Carriers
@TC-214
Scenario: Verify that tracking integration supports multiple shipping carriers
Given the tracking system is integrated with multiple carriers
@TC-214
Scenario: Verify selection of Carrier A (FedEx)
When I select Carrier A from the carrier list
Then Carrier A is selected
@TC-214
Scenario: Verify retrieval of tracking information for Carrier A
Given Carrier A API keys are configured
When I enter a valid tracking number for Carrier A
Then Tracking information is retrieved successfully
@TC-214
Scenario: Verify selection of Carrier B (UPS)
When I select Carrier B from the carrier list
Then Carrier B is selected
@TC-214
Scenario: Verify retrieval of tracking information for Carrier B
Given Carrier B API keys are configured
When I enter a valid tracking number for Carrier B
Then Tracking information is retrieved successfully
@TC-214
Scenario: Verify selection of Carrier C (DHL)
When I select Carrier C from the carrier list
Then Carrier C is selected
@TC-214
Scenario: Verify retrieval of tracking information for Carrier C
Given Carrier C API keys are configured
When I enter a valid tracking number for Carrier C
Then Tracking information is retrieved successfully
@TC-214
Scenario: Verify handling of invalid tracking numbers for Carrier A
When I enter an invalid tracking number for Carrier A
Then System displays an error message for invalid tracking numbers
@TC-214
Scenario: Verify handling of invalid tracking numbers for Carrier B
When I enter an invalid tracking number for Carrier B
Then System displays an error message for invalid tracking numbers
@TC-214
Scenario: Verify handling of invalid tracking numbers for Carrier C
When I enter an invalid tracking number for Carrier C
Then System displays an error message for invalid tracking numbers
@TC-214
Scenario: Simulate carrier service outage for Carrier A
When Carrier A experiences a service outage
Then System displays a service outage message for Carrier A
@TC-214
Scenario: Simulate carrier service outage for Carrier B
When Carrier B experiences a service outage
Then System displays a service outage message for Carrier B
@TC-214
Scenario: Simulate carrier service outage for Carrier C
When Carrier C experiences a service outage
Then System displays a service outage message for Carrier C
@TC-214
Scenario: Verify system performance during high load
When the system handles multiple carrier requests
Then System remains stable and responsive
@TC-214
Scenario: Verify display of carrier-specific tracking details
When tracking information is retrieved
Then Carrier-specific tracking details are displayed
@TC-214
Scenario: Verify system integration with new carriers
When a new carrier is integrated into the system
Then System can integrate with new carriers successfully