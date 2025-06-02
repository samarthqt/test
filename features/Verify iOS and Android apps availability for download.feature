Feature: Verify iOS and Android apps availability for download
@TC-273
Scenario: Verify iOS app availability and installation
Given I have access to the iOS App Store on an iOS device
When I open the iOS App Store
Then the iOS App Store opens successfully
And I search for the application using its name
Then the application appears in the search results
When I select the application from the search results
Then the application details page is displayed
And I verify the application's download button is available
Then the download button is present and clickable
When I initiate the download of the application
Then the download starts successfully without errors
And I install the application once download completes
Then the application installs successfully and is accessible
@TC-273
Scenario: Verify Android app availability and installation
Given I have access to the Google Play Store on an Android device
When I open the Google Play Store
Then the Google Play Store opens successfully
And I search for the application using its name
Then the application appears in the search results
When I select the application from the search results
Then the application details page is displayed
And I verify the application's download button is available
Then the download button is present and clickable
When I initiate the download of the application
Then the download starts successfully without errors
And I install the application once download completes
Then the application installs successfully and is accessible
@TC-273
Scenario: Verify application launch and initial setup on both devices
Given the application is installed on both iOS and Android devices
When I open the application on both iOS and Android devices
Then the application launches successfully on both devices
And I verify the application's initial setup screens are displayed
Then the initial setup screens appear correctly
When I complete the initial setup process on both devices
Then the setup completes successfully without errors