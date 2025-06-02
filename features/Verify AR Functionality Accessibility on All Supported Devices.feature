Feature: Verify AR Functionality Accessibility on All Supported Devices
@TC-369
Scenario: Log in to the application on a supported device
Given the user is on a supported device
When the user logs into the application
Then the user is logged in successfully
And the main menu is displayed
@TC-369
Scenario: Navigate to the AR feature section of the application
Given the user has access to the application with AR functionality
When the user navigates to the AR feature section
Then the AR feature interface is displayed
And options to explore AR content are available
@TC-369
Scenario: Select a product to view in AR mode
Given the user is on the AR feature interface
When the user selects a product to view in AR mode
Then the product is displayed in AR mode without any issues
@TC-369
Scenario: Interact with the AR model
Given a product is displayed in AR mode
When the user interacts with the AR model by rotating or zooming
Then the AR model responds to interactions smoothly
@TC-369
Scenario Outline: Test AR functionality on different supported device models
Given the application with AR functionality is accessible
When the user tests AR functionality on <device_model>
Then AR functionality is consistent across all supported devices
Examples:
| device_model |
| Device Model 1 |
| Device Model 2 |
| Device Model 3 |
@TC-369
Scenario: Verify the clarity and resolution of the AR model on each device
Given the AR model is displayed
When the user checks the clarity and resolution of the AR model
Then the AR model is clear and has high resolution on all devices
@TC-369
Scenario: Check for any lag or performance issues during AR interactions
Given the user is interacting with the AR model
When the user observes the performance during interactions
Then no lag or performance issues are observed
@TC-369
Scenario: Attempt to access AR functionality on an unsupported device
Given the user is on an unsupported device
When the user attempts to access AR functionality
Then an appropriate error message is displayed
And access is denied
@TC-369
Scenario: Test AR functionality under different lighting conditions
Given the user is using AR functionality
When the user tests AR under varied lighting conditions
Then AR functionality performs well under varied lighting conditions
@TC-369
Scenario: Verify the application's response when AR functionality is disabled
Given AR functionality is disabled
When the user attempts to access AR features
Then the application provides a clear message indicating AR is disabled
@TC-369
Scenario: Ensure AR content is updated and accurate on all devices
Given the user accesses AR content
When the user checks the content across devices
Then AR content is consistent and up-to-date across devices
@TC-369
Scenario: Check compatibility of AR functionality with the latest OS updates on devices
Given the user is using a device with the latest OS updates
When the user accesses AR functionality
Then AR functionality remains compatible with the latest OS updates
@TC-369
Scenario: Document any device-specific issues or inconsistencies found
Given the user is testing AR functionality
When the user finds any device-specific issues or inconsistencies
Then detailed documentation of issues with device-specific recommendations is provided
@TC-369
Scenario: Conclude the test with an evaluation of device support coverage
Given the user has completed testing AR functionality
When the user evaluates device support coverage
Then a comprehensive report on device support and AR functionality accessibility is generated
@TC-369
Scenario: Provide feedback and suggestions for improving AR accessibility
Given the user has tested AR functionality
When the user provides feedback and suggestions for improvement
Then feedback and improvement suggestions are documented