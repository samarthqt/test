Feature: Measure Downtime During Scheduled Maintenance
@TC-258
Scenario: Initiate scheduled maintenance as per plan
Given the scheduled maintenance plan is documented
When maintenance is initiated
Then maintenance should begin at the scheduled time
And the maintenance window should be 2 hours
@TC-258
Scenario: Monitor system downtime during maintenance
Given service level agreements are defined
When monitoring system downtime during maintenance
Then downtime should be within the allowed limit as per SLA
And the service level agreement should ensure 99.9% uptime
@TC-258
Scenario: Verify user notifications prior to maintenance
Given users need to be notified about maintenance
When notifications are sent to users
Then users should receive timely notifications regarding maintenance
And notifications should be sent 24 hours prior
@TC-258
Scenario: Check system logs for maintenance activities
Given system logs are required for maintenance activities
When checking system logs
Then logs should accurately reflect maintenance activities and downtime
And backup systems should be active
@TC-258
Scenario: Assess system performance metrics post-maintenance
Given system performance needs to be assessed post-maintenance
When evaluating performance metrics
Then performance metrics should indicate system recovery and stability
And downtime allowance should be 0.1%
@TC-258
Scenario: Evaluate backup system activation during maintenance
Given backup systems are needed during maintenance
When evaluating backup system activation
Then backup systems should activate to minimize downtime
@TC-258
Scenario: Review compliance with SLA uptime requirements
Given SLA uptime requirements are defined
When reviewing compliance
Then system uptime should meet SLA requirements
@TC-258
Scenario: Test user access and functionality post-maintenance
Given maintenance has been completed
When testing user access and functionality
Then users should regain access and functionality promptly after maintenance
@TC-258
Scenario: Check alert notifications during maintenance
Given alerts are necessary during maintenance
When checking alert notifications
Then alerts should be sent to system administrators regarding maintenance status
@TC-258
Scenario: Validate downtime reporting accuracy
Given downtime reporting is required
When validating downtime reporting
Then downtime reporting should be accurate and reflect actual events
@TC-258
Scenario: Assess system recovery time post-maintenance
Given system recovery time needs to be assessed
When assessing recovery time post-maintenance
Then recovery time should be within acceptable limits
@TC-258
Scenario: Verify data integrity during maintenance
Given data integrity is crucial during maintenance
When verifying data integrity
Then data integrity should be preserved with no loss
@TC-258
Scenario: Simulate recovery from maintenance state
Given the system needs to recover from maintenance state
When simulating recovery
Then the system should return to normal operation without issues
@TC-258
Scenario: Check adherence to maintenance schedule
Given the maintenance schedule is planned
When checking adherence
Then maintenance should adhere to the planned schedule
@TC-258
Scenario: Evaluate user feedback post-maintenance
Given user feedback is important post-maintenance
When evaluating user feedback
Then users should report minimal disruption and satisfactory service