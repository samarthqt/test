Feature: Client Address and Courier Scheduling
""
Scenario: Client provides address details
Given the client is on the address entry page
"    When the client enters their address ""123 Main St, Springfield"""
"    And the client enters the addressee's address ""456 Elm St, Shelbyville"""
Then the system should accept both addresses
""
Scenario: Client prints the parcel label
Given the client has entered both their address and the addressee's address
When the client selects the option to print the label
Then the system should generate a label with the provided addresses
And the label should be ready for printing
""
Scenario: Client schedules a courier visit
Given the client has printed the parcel label
When the client selects the option to schedule a courier
"    And the client chooses a convenient time ""3:00 PM on 10/25/2023"""
Then the system should confirm the courier visit at the selected time
""
Scenario: Client completes the courier scheduling process
Given the client has scheduled a courier visit
When the client reviews the courier visit details
And the client confirms the courier scheduling
Then the system should display a confirmation message
And the courier visit should be listed in the client's scheduled deliveries
```