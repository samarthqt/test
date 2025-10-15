Feature: Validate system behavior when saving condition table without activation

  @TC-289
  Scenario: User logs into the SAP system with valid credentials
    Given the SAP system is configured and accessible
    When the user logs into the SAP system with valid credentials
    Then the user is successfully logged into the SAP system

  @TC-289
  Scenario: User navigates to the condition table creation screen
    Given the user has appropriate authorization to create condition tables
    When the user navigates to the condition table creation screen via transaction code SE11
    Then the condition table creation screen is displayed

  @TC-289
  Scenario: User creates condition table 911
    Given the user is on the condition table creation screen
    When the user enters the table name "911" and chooses "Create"
    Then the system allows entry to create the condition table

  @TC-289
  Scenario: User defines fields for the condition table
    Given the user is creating condition table "911"
    When the user defines the table fields as Sales Org, Billing Type, and Attribute 7
    Then the fields are added successfully to the table definition

  @TC-289
  Scenario: User saves the condition table without activation
    Given the user has defined fields for condition table "911"
    When the user saves the table definition without activating it
    Then the system displays a warning message indicating the table is not activated

  @TC-289
  Scenario: System prevents use of inactive condition table
    Given the condition table "911" is saved but not activated
    When the user attempts to use the table in the output determination process
    Then the system displays an error message indicating the table is inactive

  @TC-289
  Scenario: User activates the condition table
    Given the condition table "911" is saved but not activated
    When the user activates the condition table using transaction SE11
    Then the condition table is activated successfully

  @TC-289
  Scenario: User verifies the condition table definition
    Given the condition table "911" is activated
    When the user verifies the table definition using transaction SE16
    Then the table structure displays the defined fields correctly

  @TC-289
  Scenario: User populates the condition table with test data
    Given the condition table "911" is activated
    When the user populates the table with test data using transaction VK11
    Then the test data is populated successfully in the condition table

  @TC-289
  Scenario: User links the condition table to an access sequence
    Given the condition table "911" is populated with test data
    When the user links the condition table to an access sequence using transaction code V/07
    Then the condition table "911" is successfully linked to the specified access sequence

  @TC-289
  Scenario: User tests the output determination process
    Given the condition table "911" is linked to an access sequence
    When the user tests the output determination process using transaction code VF01
    Then the output determination works correctly using the condition table

  @TC-289
  Scenario: User verifies logs for errors or warnings
    Given the output determination process has been tested
    When the user verifies the logs for any errors or warnings during the process
    Then no errors or warnings are found in the logs