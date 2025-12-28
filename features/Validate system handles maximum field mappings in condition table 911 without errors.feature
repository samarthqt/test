Feature: Validate system handles maximum field mappings in condition table 911 without errors

  @TC-296
  Scenario: User navigates to transaction V/07 for maintaining access sequences
    Given the user navigates to transaction "V/07"
    Then the access sequence maintenance screen is displayed

  @TC-296
  Scenario: User searches for and selects access sequence Z002
    Given the access sequence "Z002" exists in the system
    When the user searches for and selects access sequence "Z002"
    Then the access sequence "Z002" is displayed for editing

  @TC-296
  Scenario: User adds condition table 911 to the access sequence
    Given the condition table "911" is created and activated
    When the user adds condition table "911" to the access sequence
    Then the condition table "911" is added to the access sequence

  @TC-296
  Scenario Outline: User defines and validates maximum field mappings for condition table 911
    Given the condition table "911" is added to the access sequence
    When the user defines the maximum number of field mappings with the following fields:
      | Field Name       |
      | Sales Org        |
      | Billing Type     |
      | Attribute 7      |
      | Customer Group   |
      | Material Group   |
    Then the maximum field mappings are defined successfully

  @TC-296
  Scenario: User saves and activates the access sequence Z002
    Given the maximum field mappings are defined for condition table "911"
    When the user saves and activates the access sequence "Z002"
    Then the access sequence "Z002" is saved and activated successfully

  @TC-296
  Scenario: User creates a billing document and tests output determination with maximum field mappings
    Given the access sequence "Z002" is saved and activated with condition table "911"
    When the user creates a billing document and tests output determination
    Then the output determination works correctly with maximum field mappings

  @TC-296
  Scenario: User reviews logs to ensure no errors occurred during the process
    Given the output determination works correctly with maximum field mappings
    When the user reviews the logs
    Then the logs indicate successful processing without errors