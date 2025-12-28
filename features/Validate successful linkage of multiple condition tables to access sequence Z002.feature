Feature: Validate successful linkage of multiple condition tables to access sequence Z002

  @TC-298
  Scenario: User logs into the SAP system
    Given the user has authorized credentials
    When the user logs into the SAP system
    Then the user successfully logs into the system

  @TC-298
  Scenario: User navigates to transaction V/07 for maintaining access sequences
    Given the user is logged into the SAP system
    When the user navigates to transaction V/07
    Then the transaction V/07 screen is displayed

  @TC-298
  Scenario: User selects access sequence Z002 for editing
    Given the user is on the transaction V/07 screen
    When the user selects access sequence Z002 for editing
    Then access sequence Z002 is opened for editing

  @TC-298
  Scenario: User adds condition tables to the access sequence
    Given the user is editing access sequence Z002
    When the user adds condition table 911 and other relevant tables to the access sequence
    Then the condition tables are added to the access sequence successfully

  @TC-298
  Scenario: User defines sequence order and field mappings for all tables
    Given the user has added condition tables to the access sequence
    When the user defines the sequence order and field mappings for all tables
    Then the sequence order and field mappings are defined correctly

  @TC-298
  Scenario: User saves changes made to the access sequence
    Given the user has defined the sequence order and field mappings
    When the user saves the changes made to the access sequence
    Then the changes are saved successfully

  @TC-298
  Scenario: User activates the updated access sequence Z002
    Given the user has saved the changes made to the access sequence
    When the user activates the updated access sequence Z002
    Then the access sequence Z002 is activated without errors

  @TC-298
  Scenario: User creates a test billing document utilizing access sequence Z002
    Given the user has activated the updated access sequence Z002
    When the user creates a test billing document that will utilize access sequence Z002
    Then the billing document is created successfully

  @TC-298
  Scenario: User triggers output determination for the test billing document
    Given the user has created a test billing document
    When the user triggers output determination for the test billing document
    Then the output determination process is executed

  @TC-298
  Scenario: User verifies correct condition table is referenced
    Given the user has triggered output determination for the test billing document
    When the user verifies the condition table referenced based on the defined sequence
    Then condition table 911 is referenced correctly

  @TC-298
  Scenario: User confirms ZPDT output determination works as expected
    Given the user has verified the correct condition table is referenced
    When the user confirms that ZPDT output determination prioritizes tables based on the defined sequence
    Then ZPDT output determination works as expected without errors

  @TC-298
  Scenario: User checks for performance or functionality issues
    Given the user has confirmed ZPDT output determination works as expected
    When the user checks for any performance or functionality issues during the determination process
    Then no performance or functionality issues are observed