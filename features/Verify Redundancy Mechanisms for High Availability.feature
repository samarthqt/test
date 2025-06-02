Feature: Verify Redundancy Mechanisms for High Availability
@TC-256
Scenario: Simulate normal operations on primary server
Given redundancy type is Failover High
And access to redundancy monitoring tools is available
When normal operations are simulated on the primary server
Then the primary server operates normally, maintaining high availability
@TC-256
Scenario: Monitor redundancy mechanisms during normal operations
Given the primary server is Server A
When redundancy mechanisms are monitored during normal operations
Then redundancy mechanisms are active, ensuring high availability
@TC-256
Scenario: Simulate failure on primary server
Given the backup server is Server B
When failure is simulated on the primary server
Then failover mechanisms activate, switching operations to the backup server
@TC-256
Scenario: Verify system stability post failover
Given the failover policy is enabled
When system stability is verified post failover
Then the system stabilizes with the backup server, maintaining high availability
@TC-256
Scenario: Check system logs for failover events
When system logs are checked for failover events
Then system logs display accurate timestamps and details of failover events
@TC-256
Scenario: Test system response to simultaneous server failures
When system response is tested to simultaneous server failures
Then the system handles simultaneous failures effectively, maintaining high availability
@TC-256
Scenario: Simulate failure in redundancy mechanisms
When failure is simulated in redundancy mechanisms
Then the failure is logged, and fallback mechanisms are activated
@TC-256
Scenario: Verify notification alerts for redundancy issues
When notification alerts are verified for redundancy issues
Then notification alerts are sent to administrators, detailing redundancy issues
@TC-256
Scenario: Test manual intervention processes for redundancy management
When manual intervention processes are tested for redundancy management
Then manual intervention processes are executed successfully, resolving redundancy issues
@TC-256
Scenario: Check system performance metrics post redundancy resolution
When system performance metrics are checked post redundancy resolution
Then system performance metrics return to normal, indicating successful resolution
@TC-256
Scenario: Simulate network latency and observe system response
When network latency is simulated and system response is observed
Then system response is logged, showing impact of network latency on redundancy
@TC-256
Scenario: Verify rollback mechanisms for failed failover events
When rollback mechanisms are verified for failed failover events
Then rollback mechanisms are activated, restoring the system to pre-failure state
@TC-256
Scenario: Test system response to unexpected redundancy spikes
When system response is tested to unexpected redundancy spikes
Then the system handles unexpected spikes effectively, maintaining high availability
@TC-256
Scenario: Log out from the redundancy monitoring tools
When logging out from the redundancy monitoring tools
Then the user is logged out successfully