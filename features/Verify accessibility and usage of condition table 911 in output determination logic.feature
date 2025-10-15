Feature: Verify accessibility and usage of condition table 911 in output determination logic

  @TC-493
  Scenario: User logs into the SAP system
    Given user has valid credentials
    When user logs into the SAP system
    Then user is successfully logged into the SAP system

  @TC-493
  Scenario: User navigates to the output determination configuration screen
    Given user is logged into the SAP system
    When user navigates to the output determination configuration screen
    Then the output determination configuration screen is displayed

  @TC-493
  Scenario: Verify inclusion of condition table 911 in the output determination schema
    Given user is on the output determination configuration screen
    When user verifies the inclusion of condition table 911 in the schema
    Then condition table 911 is included in the schema

  @TC-493
  Scenario Outline: Create a test billing document with specified parameters
    Given user is on the billing document creation screen
    When user creates a test billing document with Sales Org "<Sales Org>", Billing Type "<Billing Type>", and Attribute 7 "<Attribute 7>"
    Then the test billing document is created successfully

    Examples:
      | Sales Org | Billing Type | Attribute 7 |
      | 1000      | F2           | ZPDT        |

  @TC-493
  Scenario: Trigger the output determination process for the billing document
    Given user has created a test billing document
    When user triggers the output determination process for the billing document
    Then the output determination process is triggered successfully

  @TC-493
  Scenario: Monitor the system log for the output determination process
    Given the output determination process has been triggered
    When user monitors the system log for the output determination process
    Then the system log shows the output determination process details

  @TC-493
  Scenario: Verify access to condition table 911 during the process
    Given the output determination process is ongoing
    When user verifies access to condition table 911 during the process
    Then condition table 911 is accessed successfully

  @TC-493
  Scenario: Validate the usage of data from condition table 911 in output determination logic
    Given condition table 911 is accessed during the process
    When user validates the usage of data from condition table 911 in the output determination logic
    Then the output determination logic uses the data correctly

  @TC-493
  Scenario: Check the output generated for the billing document
    Given the output determination logic has completed
    When user checks the output generated for the billing document
    Then the output is generated successfully and matches the expected results

  @TC-493
  Scenario: Verify the accuracy of the output fields
    Given the output is generated for the billing document
    When user verifies the accuracy of the output fields
    Then the output fields are accurate and match the condition table data

  @TC-493
  Scenario: Validate the linkage between billing document and output determination results
    Given the output determination process is complete
    When user validates the linkage between the billing document and the output determination results
    Then the linkage is correct and consistent

  @TC-493
  Scenario: Ensure no errors or warnings are logged in the process
    Given the output determination process is complete
    When user checks the system log for errors or warnings
    Then no errors or warnings are logged