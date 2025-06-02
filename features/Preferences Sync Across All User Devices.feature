Feature: Preferences Sync Across All User Devices
@TC-40
Scenario: Verify preferences sync across multiple devices
Given a user account with preferences set
And multiple devices registered to the user account
When the user logs into Device 1 using user credentials
Then the user is successfully logged in
And preferences on Device 1 are set to Dark Mode ON, Notifications OFF
@TC-40
Scenario: Verify preferences on Device 2 match those on Device 1
Given Device 2 is registered to the user account
When the user logs into Device 2 using the same user credentials
Then the user is successfully logged in
And preferences on Device 2 match those on Device 1: Dark Mode ON, Notifications OFF
@TC-40
Scenario: Change preference on Device 1 and verify sync on Device 2
Given the user is logged into Device 1
When the user changes preference on Device 1 to Dark Mode OFF
And refreshes preferences on Device 2
Then preference changes are reflected on Device 2: Dark Mode OFF
@TC-40
Scenario: Change notifications setting on Device 2 and verify sync on Device 1
Given the user is logged into Device 2
When the user changes notifications setting on Device 2 to ON
And refreshes preferences on Device 1
Then preference changes are reflected on Device 1: Notifications ON
@TC-40
Scenario: Logout and verify preferences after logging back in
Given the user is logged into Device 1
When the user logs out from Device 1
And logs back into Device 1
Then the user is successfully logged in with updated preferences
And preferences are consistent with last changes: Dark Mode OFF, Notifications ON
@TC-40
Scenario: Verify preferences after logging back into Device 2
Given the user is logged into Device 2
When the user logs out from Device 2
And logs back into Device 2
Then the user is successfully logged in with updated preferences
And preferences are consistent with last changes: Dark Mode OFF, Notifications ON
@TC-40
Scenario: Repeat preference change and sync process for additional devices
Given additional devices are registered to the user account
When the user repeats the preference change and sync process
Then preferences are consistently synced across all registered devices