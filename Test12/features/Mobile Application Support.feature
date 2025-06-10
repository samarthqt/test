Feature: Mobile Application Support
@80
Scenario: Application installs and runs on iOS 12 and above
Given the user has an iOS device with version 12 or higher
When the user installs the mobile application
Then the application should install successfully
And the application should run without issues
@80
Scenario: Application installs and runs on Android 8.0 and above
Given the user has an Android device with version 8.0 or higher
When the user installs the mobile application
Then the application should install successfully
And the application should run without issues
@80
Scenario: No functionality issues on supported versions
Given the user has installed the mobile application on a supported version
When the user uses the application
Then there should be no functionality issues
@80
Scenario: Perform regular updates to maintain compatibility
Given the mobile application is installed on a supported version
When a new update is available
Then the application should prompt the user to update
And the update should install successfully
And the application should maintain compatibility
@80
Scenario: Ensure seamless user experience across supported versions
Given the user has installed the mobile application on a supported version
When the user navigates through the application
Then the user experience should be seamless and consistent across all supported versions