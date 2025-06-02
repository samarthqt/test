Feature: Test System Response Under Resource Exhaustion
@TC-254
Scenario: Simulate high CPU usage on virtual machines
Given configured auto-scaling policies
When CPU usage exceeds the threshold on virtual machines
Then auto-scaling policies are triggered
@TC-254
Scenario: Monitor system response through resource monitoring tools
Given access to monitoring tools
When monitoring system response
Then system response is logged accurately showing resource exhaustion
@TC-254
Scenario: Verify auto-scaling triggers and new resource allocation
Given a CPU threshold of 90% and a memory threshold of 80%
When auto-scaling triggers are activated
Then new resources are allocated as per policy
@TC-254
Scenario: Check system stability post auto-scaling
Given auto-scaling policy is enabled
When new resources are allocated
Then system stabilizes maintaining performance
@TC-254
Scenario: Simulate high memory usage on virtual machines
Given configured auto-scaling policies
When memory usage exceeds the threshold on virtual machines
Then auto-scaling policies are triggered
@TC-254
Scenario: Verify system logs for resource exhaustion events
Given access to system logs
When checking logs for resource exhaustion events
Then logs display accurate timestamps and details
@TC-254
Scenario: Test system response to simultaneous CPU and memory exhaustion
Given simultaneous CPU and memory exhaustion
When system response is tested
Then system handles exhaustion effectively, maintaining performance
@TC-254
Scenario: Simulate failure in auto-scaling triggers
Given auto-scaling triggers fail
When failure is logged
Then fallback mechanisms are activated
@TC-254
Scenario: Verify notification alerts for resource exhaustion
Given resource exhaustion occurs
When notification alerts are checked
Then alerts are sent to administrators detailing exhaustion
@TC-254
Scenario: Test manual intervention processes for resource management
Given resource exhaustion
When manual intervention processes are executed
Then processes resolve resource exhaustion successfully
@TC-254
Scenario: Check system performance metrics post resource exhaustion resolution
Given resource exhaustion is resolved
When checking system performance metrics
Then metrics return to normal indicating successful resolution
@TC-254
Scenario: Simulate network latency and observe system response
Given network latency occurs
When observing system response
Then system response is logged showing impact on resource management
@TC-254
Scenario: Verify rollback mechanisms for failed auto-scaling events
Given a failed auto-scaling event
When rollback mechanisms are activated
Then system is restored to pre-exhaustion state
@TC-254
Scenario: Test system response to unexpected resource spikes
Given unexpected resource spikes occur
When system response is tested
Then system handles spikes effectively, maintaining resource availability
@TC-254
Scenario: Log out from the monitoring tools
Given user is logged into monitoring tools
When logging out
Then user is logged out successfully