Feature: Validate error handling for saving access sequence without activation

  @TC-295
  Scenario: User navigates to the access sequence maintenance screen
    Given the user navigates to transaction "V/07" for maintaining access sequences
    Then the access sequence maintenance screen is displayed

  @TC-295
  Scenario: User searches for and selects an access sequence
    Given the access sequence "Z002" exists in the system
    When the user searches for and selects access sequence "Z002"
    Then the access sequence "Z002" is displayed for editing

  @TC-295
  Scenario: User adds a condition table to the access sequence
    Given the condition table "911" exists with field mapping "Sales Org, Billing Type, Attribute 7"
    When the user adds condition table "911" to the access sequence "Z002"
    Then the condition table "911" is added to the access sequence

  @TC-295
  Scenario: User defines field mapping for the condition table
    Given the condition table "911" is added to the access sequence "Z002"
    When the user defines the field mapping for condition table "911" as "Sales Org, Billing Type, Attribute 7"
    Then the field mapping is defined successfully

  @TC-295
  Scenario: User saves changes to the access sequence without activating it
    Given the user has defined field mapping for condition table "911" in access sequence "Z002"
    When the user saves the changes to access sequence "Z002" without activating it
    Then the changes are saved successfully, but the access sequence is not activated

  @TC-295
  Scenario: User attempts to use the access sequence without activation
    Given the access sequence "Z002" is saved without activation
    When the user attempts to use the access sequence "Z002" in a billing scenario
    Then the system displays an error message indicating that the access sequence is not activated

  @TC-295
  Scenario: User activates the access sequence and retries the billing scenario
    Given the access sequence "Z002" is saved without activation
    When the user activates the access sequence "Z002"
    And the user retries the billing scenario
    Then the billing scenario works correctly after activation