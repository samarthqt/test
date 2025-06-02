Feature: Verify Integration with Cloud Services
@TC-253
Scenario: Successful login to the cloud service portal
Given the user has valid credentials for the cloud service portal
When the user logs in to the cloud service portal
Then the user is successfully logged into the cloud service portal
@TC-253
Scenario: Navigate to resource management section
Given the user is logged into the cloud service portal
When the user navigates to the resource management section
Then the resource management section is displayed with options for creating and managing resources
@TC-253
Scenario: Create a new virtual machine resource
Given the user is in the resource management section
When the user selects "Create New Resource" and chooses "Virtual Machine" as the resource type
Then options for configuring a new virtual machine are displayed
@TC-253
Scenario: Configure virtual machine with region and instance count
Given the options for configuring a new virtual machine are displayed
When the user enters region as "US-East-1" and instance count as "5"
Then the region and instance count are correctly set for the new virtual machine
@TC-253
Scenario: Configure additional settings for virtual machine
Given the region and instance count are set for the new virtual machine
When the user configures additional settings such as security groups and network settings
Then additional settings are configured successfully
@TC-253
Scenario: Submit configuration to create resources
Given the virtual machine configuration is complete
When the user submits the configuration
Then the resources are created successfully and listed under resource management
@TC-253
Scenario: Verify resource allocation and utilization metrics
Given the resources are created
When the user verifies resource allocation and utilization metrics
Then resource allocation and utilization metrics are displayed accurately
@TC-253
Scenario: Check for integration errors or warnings
Given the resources are created
When the user checks for any integration errors or warnings
Then no integration errors or warnings are present
@TC-253
Scenario: Monitor API calls and responses
Given the resources are created
When the user accesses the API dashboard
Then the API dashboard displays real-time data of API calls and responses
@TC-253
Scenario: Verify data synchronization between local and cloud resources
Given the resources are created
When the user verifies data synchronization between the local system and cloud resources
Then data synchronization occurs seamlessly without any discrepancies
@TC-253
Scenario: Test automatic scaling up of resources
Given predefined scaling rules are set
When the conditions for scaling up are met
Then resources scale up automatically as per the predefined rules
@TC-253
Scenario: Test automatic scaling down of resources
Given predefined scaling rules are set
When the conditions for scaling down are met
Then resources scale down automatically as per the predefined rules
@TC-253
Scenario: Simulate failure in resource creation and observe error handling
Given the user attempts to create a resource
When a failure in resource creation is simulated
Then error handling mechanisms are triggered, and appropriate error messages are displayed
@TC-253
Scenario: Verify resource deletion process
Given the resources are created
When the user deletes a resource
Then the resources are deleted successfully from the cloud service portal
@TC-253
Scenario: Log out from the cloud service portal
Given the user is logged into the cloud service portal
When the user logs out
Then the user is logged out successfully