Feature: 2FA Setup Process on Multiple Devices and Platforms
To verify the user-friendly and intuitive setup process for 2FA across different devices and platforms.
@TC-249
Scenario: Set up 2FA via SMS on a desktop device
Given a user account with 2FA not yet set up
When the user logs in to the application on a desktop device
Then the user is successfully logged in and directed to the dashboard
When the user navigates to the account security settings
Then the security settings page is displayed, showing 2FA options
When the user selects the option to enable 2FA
Then the user is prompted to choose a 2FA method
When the user chooses to receive 2FA codes via SMS
Then the user is prompted to enter their mobile number
When the user enters a valid mobile number and submits
Then a verification code is sent to the provided mobile number
When the user enters the received verification code
Then 2FA setup is completed successfully, and confirmation is displayed
@TC-249
Scenario: Verify 2FA functionality on a smartphone
Given 2FA is set up via SMS
When the user logs out and attempts to log in again on a smartphone
Then the user is prompted for a 2FA code after entering their credentials
When the user enters the correct 2FA code
Then the user is successfully logged in on the smartphone
@TC-249
Scenario: Verify 2FA functionality on a tablet
Given 2FA is set up via SMS
When the user repeats the login and 2FA process on a tablet
Then the user is successfully logged in on the tablet after entering the 2FA code
@TC-249
Scenario: Verify 2FA status across all devices
Given 2FA is set up via SMS
When the user navigates to account settings
Then 2FA is shown as enabled on all devices
@TC-249
Scenario: Disable 2FA from one of the devices
Given 2FA is set up via SMS
When the user attempts to disable 2FA from one of the devices
Then the user is prompted to enter a confirmation code sent to the registered mobile number
When the user enters the correct confirmation code to disable 2FA
Then 2FA is successfully disabled, and confirmation is displayed
@TC-249
Scenario: Enable 2FA using an authenticator app
Given 2FA is disabled
When the user enables 2FA again using an authenticator app
Then the user is prompted to scan a QR code with the authenticator app
When the user scans the QR code and enters the generated code from the authenticator app
Then 2FA setup is completed with the authenticator app, and confirmation is displayed
@TC-249
Scenario: Verify 2FA functionality with authenticator app across all devices
Given 2FA is set up with an authenticator app
When the user attempts to log in on all devices
Then the user is able to log in on all devices using the authenticator app for 2FA