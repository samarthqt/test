Feature: Live Tracking for Shipments

  @TC-2
  Scenario: View live tracking information with real-time updates
    Given the user is logged into the system
    And shipment data is available in the system
    When the user navigates to the live tracking page
    Then the live tracking page is displayed

  @TC-2
  Scenario: Enter Shipment ID to view tracking details
    Given the user is on the live tracking page
    When the user enters the Shipment ID "54321" in the tracking field
    Then live tracking details for ID "54321" are displayed

  @TC-2
  Scenario: Check current location of the shipment
    Given live tracking details for Shipment ID "54321" are displayed
    When the user checks the current location of the shipment
    Then the current location is displayed on the map

  @TC-2
  Scenario: Simulate change in shipment location
    Given the current location is displayed on the map
    When a change in shipment location is simulated
    Then the location updates in real-time on the map

  @TC-2
  Scenario: Verify estimated delivery time
    Given live tracking details for Shipment ID "54321" are displayed
    When the user verifies the estimated delivery time
    Then the estimated delivery time is displayed accurately

  @TC-2
  Scenario: Refresh the page
    Given live tracking details for Shipment ID "54321" are displayed
    When the page is refreshed
    Then live tracking information remains consistent

  @TC-2
  Scenario: Log out and log back in
    Given live tracking details for Shipment ID "54321" are displayed
    When the user logs out and logs back in
    Then live tracking information remains available

  @TC-2
  Scenario: Check notification settings for live tracking updates
    Given live tracking details for Shipment ID "54321" are displayed
    When the user checks the notification settings for live tracking updates
    Then notifications are enabled for live tracking updates

  @TC-2
  Scenario: Simulate network issue and update location
    Given live tracking details for Shipment ID "54321" are displayed
    When a network issue is simulated and location update is attempted
    Then the system handles the issue gracefully and retries the update

  @TC-2
  Scenario: Verify tracking history log
    Given live tracking details for Shipment ID "54321" are displayed
    When the user verifies the tracking history log
    Then the log contains all location updates with timestamps

  @TC-2
  Scenario: Check for error messages during location updates
    Given live tracking details for Shipment ID "54321" are displayed
    When the user checks for any error messages during location updates
    Then no error messages are displayed

  @TC-2
  Scenario: Update location from a different device
    Given live tracking details for Shipment ID "54321" are displayed
    When location update is attempted from a different device
    Then location updates are synchronized across devices

  @TC-2
  Scenario: Verify live tracking on a mobile device
    Given live tracking details for Shipment ID "54321" are displayed
    When the user verifies the live tracking on a mobile device
    Then tracking is consistent with the desktop view

  @TC-2
  Scenario: Check live tracking after a system reboot
    Given live tracking details for Shipment ID "54321" are displayed
    When the system is rebooted
    Then tracking information remains available

  @TC-2
  Scenario: Verify accuracy of the live tracking system
    Given live tracking details for Shipment ID "54321" are displayed
    When the user verifies the accuracy of the live tracking system
    Then live tracking information is accurate and reliable
