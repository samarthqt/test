Feature: Verify the mobile version loads within 3 seconds on iOS 12+ and Android 8.0+ devices
@TC-231
Scenario: Verify application loading time on iOS device
Given an unlocked iPhone X device with iOS 12
And normal network conditions with 100Mbps speed
When the user navigates to the application home page on the mobile browser
And starts a timer as the page begins loading
Then the application loads within 3 seconds
@TC-231
Scenario: Verify application loading time on Android device
Given an Android 8.0+ device
And normal network conditions with 100Mbps speed
When the user navigates to the application home page on the mobile browser
And starts a timer as the page begins loading
Then the application loads within 3 seconds
@TC-231
Scenario: Verify application functionality post-loading
Given the application is loaded on a mobile device
Then all application features are functional
@TC-231
Scenario: Check for errors in mobile browser console
Given the application is loaded on a mobile device
Then no errors are present in the mobile browser console
@TC-231
Scenario: Verify application layout and design post-loading
Given the application is loaded on a mobile device
Then the application layout and design appear correctly
@TC-231
Scenario: Test application loading under reduced network conditions
Given slightly reduced network conditions
When the user navigates to the application home page on the mobile browser
Then the application still loads within 3 seconds
@TC-231
Scenario: Ensure efficient loading during repeated access
Given the application is accessed repeatedly
Then repeated access does not affect loading time
@TC-231
Scenario: Check for performance degradation during peak hours
Given peak hour conditions
When the user navigates to the application home page on the mobile browser
Then no performance degradation is observed
@TC-231
Scenario: Verify system logs loading times for analysis
Given the application is loaded on a mobile device
Then loading times are logged accurately for all devices
@TC-231
Scenario: Ensure consistent loading times across updates
Given the application has been updated
When the user navigates to the application home page on the mobile browser
Then loading times remain consistent
@TC-231
Scenario: Test application loading with various mobile browsers
Given various mobile browsers are used
When the user navigates to the application home page on the mobile browser
Then the application loads within 3 seconds on all tested mobile browsers
@TC-231
Scenario: Ensure the application is optimized for mobile performance
Given the application is loaded on a mobile device
Then the application is optimized and loads efficiently on mobile devices