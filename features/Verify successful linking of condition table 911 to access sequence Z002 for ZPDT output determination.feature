Feature: Verify successful linking of condition table 911 to access sequence Z002 for ZPDT output determination

  @TC-291
  Scenario: Ensure access sequence Z002 exists and is displayed for editing
    Given the user navigates to the access sequence maintenance screen
    When the user searches for access sequence "Z002"
    Then access sequence "Z002" is displayed for editing

  @TC-291
  Scenario: Ensure condition table 911 is added to access sequence Z002
    Given the user is on the access sequence maintenance screen for "Z002"
    When the user adds condition table "911" to the access sequence
    Then condition table "911" is added to the access sequence successfully

  @TC-291
  Scenario: Ensure field mapping is defined for condition table 911
    Given condition table "911" is added to access sequence "Z002"
    When the user defines field mapping for "Sales Org", "Billing Type", and "Attribute 7"
    Then the field mapping is defined successfully

  @TC-291
  Scenario: Ensure sequence order is set for condition table 911
    Given field mapping is defined for condition table "911"
    When the user sets the sequence order for condition table "911" within access sequence "Z002"
    Then the sequence order is set correctly

  @TC-291
  Scenario: Ensure changes to access sequence Z002 are saved
    Given the sequence order is set for condition table "911"
    When the user saves the changes to access sequence "Z002"
    Then the changes are saved successfully

  @TC-291
  Scenario: Ensure access sequence Z002 is activated
    Given the changes to access sequence "Z002" are saved
    When the user activates access sequence "Z002"
    Then access sequence "Z002" is activated successfully

  @TC-291
  Scenario: Ensure ZPDT output determination references condition table 911
    Given access sequence "Z002" is activated
    When the user creates a billing document
    Then ZPDT output determination references condition table "911" as expected

  @TC-291
  Scenario: Ensure output records are derived based on field mapping
    Given ZPDT output determination references condition table "911"
    When the user verifies output records based on "Sales Org", "Billing Type", and "Attribute 7"
    Then the output records are derived correctly

  @TC-291
  Scenario: Validate ZPDT output determination in a billing scenario
    Given output records are derived correctly
    When the user executes a billing scenario
    Then ZPDT output determination works correctly in the billing scenario

  @TC-291
  Scenario: Confirm linkage and output determination in document flow
    Given ZPDT output determination works correctly in the billing scenario
    When the user reviews the document flow
    Then the document flow shows correct linkage and output determination

  @TC-291
  Scenario: Document results and confirm successful linkage
    Given the document flow shows correct linkage and output determination
    When the user documents the test results
    Then the successful linkage of condition table "911" to access sequence "Z002" is confirmed