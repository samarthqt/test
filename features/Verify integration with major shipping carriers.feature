Feature: Verify integration with major shipping carriers
@TC-202
Scenario: Admin logs in and accesses carrier integration settings
Given the admin is logged in using valid credentials
When the admin is redirected to the dashboard
And the admin accesses the 'Carrier Integration' settings
Then the system displays the available carrier integration settings
@TC-202
Scenario: Verify presence of FedEx and UPS in integrated carriers list
Given the admin is on the 'Carrier Integration' settings page
When the admin checks the list of integrated carriers
Then FedEx and UPS are listed as integrated carriers
@TC-202
Scenario: View tracking details for an order shipped with FedEx
Given an order with Order ID 67890 has been shipped using FedEx
When the admin selects the order and views its tracking details
Then the tracking details for FedEx are displayed correctly
And the tracking number is FED12345
@TC-202
Scenario: View tracking details for an order shipped with UPS
Given an order with Order ID 67890 has been shipped using UPS
When the admin selects the order and views its tracking details
Then the tracking details for UPS are displayed correctly
And the tracking number is UPS67890
@TC-202
Scenario: Fetch real-time tracking updates from FedEx
Given the system is integrated with FedEx
When the system fetches real-time tracking updates
Then the updates from FedEx are fetched and displayed accurately
@TC-202
Scenario: Fetch real-time tracking updates from UPS
Given the system is integrated with UPS
When the system fetches real-time tracking updates
Then the updates from UPS are fetched and displayed accurately
@TC-202
Scenario: Handle tracking update failure from FedEx API
Given the system is integrated with FedEx
When a tracking update failure occurs from the FedEx API
Then the system handles the failure gracefully
And retries fetching updates
@TC-202
Scenario: Handle tracking update failure from UPS API
Given the system is integrated with UPS
When a tracking update failure occurs from the UPS API
Then the system handles the failure gracefully
And retries fetching updates
@TC-202
Scenario: Response to invalid tracking numbers from FedEx
Given the system is integrated with FedEx
When an invalid tracking number is entered
Then the system displays a user-friendly error message for invalid FedEx tracking numbers
@TC-202
Scenario: Response to invalid tracking numbers from UPS
Given the system is integrated with UPS
When an invalid tracking number is entered
Then the system displays a user-friendly error message for invalid UPS tracking numbers
@TC-202
Scenario: Performance when fetching tracking information from both carriers simultaneously
Given the system is integrated with both FedEx and UPS
When tracking information is fetched from both carriers simultaneously
Then the system efficiently handles requests without performance degradation
@TC-202
Scenario: Logging of API requests and responses for auditing purposes
Given the system is integrated with both FedEx and UPS
When API requests and responses occur
Then they are logged accurately for auditing purposes
@TC-202
Scenario: Switch carriers for an order and update tracking information
Given an order is shipped with a carrier
When the admin switches the carrier for the order
Then the system successfully updates the tracking information
@TC-202
Scenario: Verify accuracy of carrier-specific tracking information displayed to users
Given tracking information is fetched from a carrier
When the information is displayed to users
Then it is accurate and matches the carrier data