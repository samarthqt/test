Feature: Mobile Compatibility
@59
Scenario: Verify mobile web version responsiveness
Given the application is accessed via a mobile web browser
Then the web version should be fully responsive
@59
Scenario: Verify dedicated app support for iOS and Android versions
Given the user has an iOS device running iOS 12 or later
And the user has an Android device running Android 8.0 or later
Then the dedicated apps should be supported on these devices
@59
Scenario: Verify app features mirror desktop functionality
Given the user accesses the app on a mobile device
Then the app features should mirror those available on the desktop version
@59
Scenario: Verify seamless functionality of push notifications
Given the user has installed the mobile app
When a push notification is sent
Then the notification should be received seamlessly
@59
Scenario: Verify apps availability in app stores
Given the user searches for the app in the iOS App Store
And the user searches for the app in the Google Play Store
Then the app should be available in both app stores
@59
Scenario: Verify mobile performance matches desktop
Given the user accesses the app on a mobile device
Then the performance should match that of the desktop version
@59
Scenario: Validate mobile experience through user testing
Given user testing is conducted on the mobile app
Then the mobile experience should be validated as satisfactory
@59
Scenario: Verify intuitive navigation on mobile
Given the user accesses the app on a mobile device
Then the navigation should be intuitive
@59
Scenario: Verify offline functionality support
Given the user accesses the app without an internet connection
Then the app should support offline functionality
@59
Scenario: Verify regular updates are pushed to app stores
Given the app is listed in the app stores
Then updates should be regularly pushed to the app stores